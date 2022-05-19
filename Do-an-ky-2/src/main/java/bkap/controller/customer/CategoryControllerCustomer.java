package bkap.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.BrandsDTO;
import bkap.entities.CategoriesDTO;
import bkap.entities.ConfigsDTO;
import bkap.entities.ProductsDTO;

@Controller
public class CategoryControllerCustomer {
	
	public ConfigsDTO getConfig(Client client, Gson gson) {
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/configService/getConfig"); 
		String data = webResource.get(String.class); 
		ConfigsDTO config = gson.fromJson(data,ConfigsDTO.class);
		return config;
	}
	
	public List<CategoriesDTO> getListCategories(Client client, Gson gson, Integer status) {
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList/" + status);
		String data = webResource.get(String.class);
		GenericType<List<CategoriesDTO>> listCategoryType = new GenericType<List<CategoriesDTO>>() {};
		List<CategoriesDTO> listCategories = gson.fromJson(data, listCategoryType.getType());
		return listCategories;
	}

	public List<BrandsDTO> getListBrands(Client client, Gson gson) {
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/brandService/getList");
		String data = webResource.get(String.class);
		GenericType<List<BrandsDTO>> listBrandType = new GenericType<List<BrandsDTO>>() {};
		List<BrandsDTO> listBrands = gson.fromJson(data, listBrandType.getType());
		return listBrands;
	}
	
	@RequestMapping(value = "/allCategory")
	public String allCategory(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		Integer status = 1;
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getList");
		String data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listProductType = new GenericType<List<ProductsDTO>>() {};
		List<BrandsDTO> listProducts = gson.fromJson(data, listProductType.getType());
		model.addAttribute("listProducts", listProducts);
		
		model.addAttribute("listCategories", getListCategories(client, gson, status));
		model.addAttribute("listBrands", getListBrands(client, gson));
		model.addAttribute("config", getConfig(client, gson));
		return "customer/pages/category";
	}
	
	@RequestMapping(value = "/category")
	public String category(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		Integer status = 1;
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getList");
		String data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listProductType = new GenericType<List<ProductsDTO>>() {};
		List<BrandsDTO> listProducts = gson.fromJson(data, listProductType.getType());
		model.addAttribute("listProducts", listProducts);
		
		model.addAttribute("listCategories", getListCategories(client, gson, status));
		model.addAttribute("listBrands", getListBrands(client, gson));
		model.addAttribute("config", getConfig(client, gson));
		return "customer/pages/category";
	}
	
	@RequestMapping(value = "/brand")
	public String brand(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();
		Integer status = 1;
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getList");
		String data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listProductType = new GenericType<List<ProductsDTO>>() {};
		List<BrandsDTO> listProducts = gson.fromJson(data, listProductType.getType());
		model.addAttribute("listProducts", listProducts);
		
		model.addAttribute("listCategories", getListCategories(client, gson, status));
		model.addAttribute("listBrands", getListBrands(client, gson));
		model.addAttribute("config", getConfig(client, gson));
		return "customer/pages/category";
	}
}
