package bkap.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.BrandsDTO;
import bkap.entities.CategoriesDTO;
import bkap.entities.Product_imagesDTO;
import bkap.entities.ProductsDTO;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@RequestMapping(value = { "/listProducts" })
	public String listProducts(Model model) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getList");
		String data = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<ProductsDTO>> listtype = new GenericType<List<ProductsDTO>>() {
		};
		List<ProductsDTO> list = gson.fromJson(data, listtype.getType());

		model.addAttribute("list", list);

		return "admin/pages/product/listProducts";
	}
	
	@RequestMapping(value = { "/searchProduct" })
	public String searchProduct(@RequestParam("Name") String name,Model model) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/searchByName/"+name);
		String data = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<ProductsDTO>> listtype = new GenericType<List<ProductsDTO>>() {
		};
		List<ProductsDTO> list = gson.fromJson(data, listtype.getType());

		model.addAttribute("list", list);

		return "admin/pages/product/listProducts";
	}

	@RequestMapping(value = { "/createProduct" })
	public String createProduct(Model model) {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
		String category = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<CategoriesDTO>> listtypecategory = new GenericType<List<CategoriesDTO>>() {
		};
		List<CategoriesDTO> categories = gson.fromJson(category, listtypecategory.getType());

		WebResource WebResource = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
		String brand = WebResource.get(String.class);
		GenericType<List<BrandsDTO>> listtypebrand = new GenericType<List<BrandsDTO>>() {
		};
		List<CategoriesDTO> brands = gson.fromJson(brand, listtypebrand.getType());

		ProductsDTO product = new ProductsDTO();

		model.addAttribute("brand", brands);
		model.addAttribute("category", categories);
		model.addAttribute("product", product);

		return "admin/pages/product/insertProduct";
	}

	@RequestMapping(value = { "/insertProduct" })
	public String insertProduct(@Valid @ModelAttribute("product") ProductsDTO product, BindingResult result,
			@RequestParam("image") MultipartFile multipartFile, @RequestParam("images") MultipartFile[] multipartFiles,
			RedirectAttributes redirAttrs, Model model, HttpServletRequest request) {

		Client client = Client.create();
		Gson gson = new Gson();
		Date date = new Date();

		boolean checkImage = true;
		if (multipartFile.getOriginalFilename().length() == 0) {
			model.addAttribute("ImageNull", "image is not null !!");
			checkImage = false;
		}

		boolean checkDiscount = true;
		if (product.getPrice() < product.getDiscount()) {
			model.addAttribute("discount", " Discount must be less than the price");
			checkDiscount = false;
		}

		if (result.hasErrors() == true || checkImage == false || checkDiscount == false) {
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
			String category = webResource.get(String.class);
			GenericType<List<CategoriesDTO>> listtypecategory = new GenericType<List<CategoriesDTO>>() {
			};
			List<CategoriesDTO> categories = gson.fromJson(category, listtypecategory.getType());

			WebResource WebResource = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
			String brand = WebResource.get(String.class);
			GenericType<List<BrandsDTO>> listtypebrand = new GenericType<List<BrandsDTO>>() {
			};
			List<CategoriesDTO> brands = gson.fromJson(brand, listtypebrand.getType());
			model.addAttribute("brand", brands);
			model.addAttribute("category", categories);
			model.addAttribute("product", product);

			return "admin/pages/product/insertProduct";
		} else {
			String path = request.getServletContext().getRealPath("resources/image");
			File file = new File(path);
			File dest = new File(file.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
			if (!dest.exists()) {
				try {
					Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			product.setCreatedAt(date);
			product.setImageUrl(multipartFile.getOriginalFilename());
			String data = gson.toJson(product);
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/insert");
			ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, data);
			String re = clientResponse.getEntity(String.class);
			ProductsDTO dto = gson.fromJson(re, ProductsDTO.class);
			if (dto != null) {
				if (multipartFiles.length != 1) {
					for (MultipartFile multipartFile2 : multipartFiles) {
						File dest1 = new File(file.getAbsolutePath() + "/" + multipartFile2.getOriginalFilename());
						if (!dest1.exists()) {
							try {
								Files.write(dest1.toPath(), multipartFile2.getBytes(), StandardOpenOption.CREATE);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						Product_imagesDTO product_imagesDTO = new Product_imagesDTO(0, dto.getProId(),
								multipartFile2.getOriginalFilename());
						String data2 = gson.toJson(product_imagesDTO);
						WebResource webResource2 = client
								.resource("http://localhost:8080/WebService/rest/product_imageService/insert");
						ClientResponse clientResponse1 = webResource2.type("application/json")
								.post(ClientResponse.class, data2);
						String re1 = clientResponse1.getEntity(String.class);
						boolean c = gson.fromJson(re1, boolean.class);
					}
				}
				redirAttrs.addFlashAttribute("success", "Successfully added new");
				return "redirect:/admin/listProducts";
			} else {
				redirAttrs.addFlashAttribute("errors", "Add failed");
				return "redirect:/admin/listProducts";
			}
		}
	}

	@RequestMapping(value = { "/getByIdProduct" })
	public String getByIdProduct(@RequestParam("ProId") Integer id, Model model) {
		Client client = Client.create();
		Client client1 = new Client();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
		String category = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<CategoriesDTO>> listtypecategory = new GenericType<List<CategoriesDTO>>() {
		};
		List<CategoriesDTO> categories = gson.fromJson(category, listtypecategory.getType());

		WebResource WebResource1 = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
		String brand = WebResource1.get(String.class);
		GenericType<List<BrandsDTO>> listtypebrand = new GenericType<List<BrandsDTO>>() {
		};
		List<CategoriesDTO> brands = gson.fromJson(brand, listtypebrand.getType());

		WebResource WebResource3 = client
				.resource("http://localhost:8080/WebService/rest/product_imageService/getByProId/" + id);
		String product_image = WebResource3.get(String.class);
		GenericType<List<BrandsDTO>> listtypeproduct_image = new GenericType<List<BrandsDTO>>() {
		};
		List<Product_imagesDTO> product_imagesDTOs = gson.fromJson(product_image, listtypeproduct_image.getType());

		WebResource webResource2 = client1
				.resource("http://localhost:8080/WebService/rest/productService/getById/" + id);
		String data = webResource2.get(String.class);
		ProductsDTO productsDTO = gson.fromJson(data, ProductsDTO.class);

		model.addAttribute("productimages", product_imagesDTOs);
		model.addAttribute("product", productsDTO);
		model.addAttribute("brand", brands);
		model.addAttribute("category", categories);

		return "admin/pages/product/updateProduct";
	}

	@RequestMapping(value = { "/updateProduct" })
	public String updateProduct(@Valid @ModelAttribute("product") ProductsDTO product, BindingResult result,
			@RequestParam("image") MultipartFile multipartFile, @RequestParam("images") MultipartFile[] multipartFiles,
			RedirectAttributes redirAttrs, Model model, HttpServletRequest request) {

		Client client = Client.create();
		Gson gson = new Gson();
		Date date = new Date();

		boolean checkDiscount = true;
		if (product.getPrice() < product.getDiscount()) {
			model.addAttribute("discount", " Discount must be less than the price");
			checkDiscount = false;
		}
		if (result.hasErrors() == true || checkDiscount == false) {
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
			String category = webResource.get(String.class);
			GenericType<List<CategoriesDTO>> listtypecategory = new GenericType<List<CategoriesDTO>>() {
			};
			List<CategoriesDTO> categories = gson.fromJson(category, listtypecategory.getType());

			WebResource WebResource1 = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
			String brand = WebResource1.get(String.class);
			GenericType<List<BrandsDTO>> listtypebrand = new GenericType<List<BrandsDTO>>() {
			};
			List<CategoriesDTO> brands = gson.fromJson(brand, listtypebrand.getType());

			WebResource WebResource3 = client.resource(
					"http://localhost:8080/WebService/rest/product_imageService/getByProId/" + product.getProId());
			String product_image = WebResource3.get(String.class);
			GenericType<List<BrandsDTO>> listtypeproduct_image = new GenericType<List<BrandsDTO>>() {
			};
			List<Product_imagesDTO> product_imagesDTOs = gson.fromJson(product_image, listtypeproduct_image.getType());

			model.addAttribute("productimages", product_imagesDTOs);
			model.addAttribute("brand", brands);
			model.addAttribute("category", categories);
			model.addAttribute("product", product);

			return "admin/pages/product/updateProduct";
		} else {

			if (multipartFile.getOriginalFilename().length() != 0) {
				String path = request.getServletContext().getRealPath("resources/image");
				File file = new File(path);
				File dest = new File(file.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
				if (!dest.exists()) {
					try {
						Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				product.setImageUrl(multipartFile.getOriginalFilename());
			} else {
				product.setImageUrl(product.getImageUrl());
			}
			String data = gson.toJson(product);
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/update");
			ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, data);
			String re = clientResponse.getEntity(String.class);
			boolean bt = gson.fromJson(re, boolean.class);
			if (bt) {
				if (multipartFiles.length != 1) {
					WebResource webResource1 = client.resource(
							"http://localhost:8080/WebService/rest/product_imageService/delete/" + product.getProId());
					String data1 = webResource1.type("application/json").delete(String.class);
					boolean bl = gson.fromJson(data1, boolean.class);
					if (bl) {
						for (MultipartFile multipartFile2 : multipartFiles) {
							String path = request.getServletContext().getRealPath("resources/image");
							File file = new File(path);
							File dest1 = new File(file.getAbsolutePath() + "/" + multipartFile2.getOriginalFilename());
							if (!dest1.exists()) {
								try {
									Files.write(dest1.toPath(), multipartFile2.getBytes(), StandardOpenOption.CREATE);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							Product_imagesDTO product_imagesDTO = new Product_imagesDTO(0, product.getProId(),
									multipartFile2.getOriginalFilename());
							String data2 = gson.toJson(product_imagesDTO);
							WebResource webResource2 = client
									.resource("http://localhost:8080/WebService/rest/product_imageService/insert");
							ClientResponse clientResponse1 = webResource2.type("application/json")
									.post(ClientResponse.class, data2);
							String re1 = clientResponse1.getEntity(String.class);
							boolean c = gson.fromJson(re1, boolean.class);
						}

						redirAttrs.addFlashAttribute("success", "Update Successfully");
						return "redirect:/admin/listProducts";
					}
					redirAttrs.addFlashAttribute("errors", "Update Successfully");
					return "redirect:/admin/listProducts";
				} 
				redirAttrs.addFlashAttribute("success", "Update Successfully");
				return "redirect:/admin/listProducts";
			} else {
				redirAttrs.addFlashAttribute("success", "Update failed");
				return "redirect:/admin/listProducts";
			}
		}
	}

	@RequestMapping(value = { "detailProduct" })
	public String detailProduct(@RequestParam("ProId") Integer id, Model model) {
		Client client = Client.create();
		Client client1 = new Client();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
		String category = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<CategoriesDTO>> listtypecategory = new GenericType<List<CategoriesDTO>>() {
		};
		List<CategoriesDTO> categories = gson.fromJson(category, listtypecategory.getType());

		WebResource WebResource1 = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
		String brand = WebResource1.get(String.class);
		GenericType<List<BrandsDTO>> listtypebrand = new GenericType<List<BrandsDTO>>() {
		};
		List<CategoriesDTO> brands = gson.fromJson(brand, listtypebrand.getType());

		WebResource WebResource3 = client
				.resource("http://localhost:8080/WebService/rest/product_imageService/getByProId/" + id);
		String product_image = WebResource3.get(String.class);
		GenericType<List<BrandsDTO>> listtypeproduct_image = new GenericType<List<BrandsDTO>>() {
		};
		List<Product_imagesDTO> product_imagesDTOs = gson.fromJson(product_image, listtypeproduct_image.getType());

		WebResource webResource2 = client1
				.resource("http://localhost:8080/WebService/rest/productService/getById/" + id);
		String data = webResource2.get(String.class);
		ProductsDTO productsDTO = gson.fromJson(data, ProductsDTO.class);

		model.addAttribute("productimages", product_imagesDTOs);
		model.addAttribute("product", productsDTO);
		model.addAttribute("brand", brands);
		model.addAttribute("category", categories);

		return "admin/pages/product/detailProduct";
	}
}
