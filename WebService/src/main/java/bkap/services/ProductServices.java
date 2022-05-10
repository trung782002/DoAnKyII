package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import bkap.dao.impl.ProductDAOImpl;
import bkap.entities.Brands;
import bkap.entities.Categories;
import bkap.entities.Products;
import bkap.entities.dto.ProductsDTO;

@Path("/productService/")
public class ProductServices {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListProduct() {
		List<Products> listProduct = new ProductDAOImpl().getList();
		Gson son = new Gson();
		List<ProductsDTO> listData = new ArrayList<ProductsDTO>();
		for (Products pr : listProduct) {
			ProductsDTO prDTO = new ProductsDTO(pr.getProId(), pr.getName(), pr.getImageUrl(), pr.getPrice(), pr.getDiscount(),
					pr.getObjCategoryOfProduct().getCateId(), pr.getObjBrandOfProduct().getBrandId(),
					pr.getShortDescription(), pr.getDescription(), pr.getQuantity(), pr.getStatus(), pr.getCreatedAt());
			listData.add(prDTO);
		}
		String data = son.toJson(listData);
		return data;
	}
	
	@GET
	@Path("/getListStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListProductStatus() {
		List<Products> listProduct = new ProductDAOImpl().getListStatus();
		Gson son = new Gson();
		List<ProductsDTO> listData = new ArrayList<ProductsDTO>();
		for (Products pr : listProduct) {
			ProductsDTO prDTO = new ProductsDTO(pr.getProId(), pr.getName(), pr.getImageUrl(), pr.getPrice(), pr.getDiscount(),
					pr.getObjCategoryOfProduct().getCateId(), pr.getObjBrandOfProduct().getBrandId(),
					pr.getShortDescription(), pr.getDescription(), pr.getQuantity(), pr.getStatus(), pr.getCreatedAt());
			listData.add(prDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@GET
	@Path("/getById/{proId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("proId") Integer Id) {
		Products product = new ProductDAOImpl().getById(Id);
		Gson son = new Gson();
		ProductsDTO Data = new ProductsDTO(product.getProId(), product.getName(), product.getImageUrl(),
				product.getPrice(), product.getDiscount(), product.getObjCategoryOfProduct().getCateId(),
				product.getObjBrandOfProduct().getBrandId(), product.getShortDescription(), product.getDescription(),
				product.getQuantity(), product.getStatus(), product.getCreatedAt());
		String data = son.toJson(Data);
		return data;
	}

	@GET
	@Path("/searchByName/{Name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchByName(@PathParam("Name") String name) {
		List<Products> listProduct = new ProductDAOImpl().searchByName(name);
		Gson son = new Gson();
		List<ProductsDTO> listData = new ArrayList<ProductsDTO>();
		for (Products pr : listProduct) {
			ProductsDTO prDTO = new ProductsDTO(pr.getProId(), pr.getName(), pr.getImageUrl(), pr.getPrice(), pr.getDiscount(),
					pr.getObjCategoryOfProduct().getCateId(), pr.getObjBrandOfProduct().getBrandId(),
					pr.getShortDescription(), pr.getDescription(), pr.getQuantity(), pr.getStatus(), pr.getCreatedAt());
			listData.add(prDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(String product) {
		Gson son = new Gson();
		ProductsDTO objDTO = son.fromJson(product, ProductsDTO.class);
		Categories objCate = new Categories();
		objCate.setCateId(objDTO.getCateId());
		Brands objBrand = new Brands();
		objBrand.setBrandId(objDTO.getBrandId());
		Products objProduct = new Products(0, objDTO.getName(), objDTO.getImageUrl(), objDTO.getPrice(),
				objDTO.getDiscount(), objDTO.getShortDescription(), objDTO.getDescription(), objDTO.getQuantity(),
				objDTO.getStatus(), objDTO.getCreatedAt(), objCate, objBrand, null, null, null, null);
		Products products = new ProductDAOImpl().insert(objProduct);
		String data = son.toJson(products);
		return data;
	}

	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String product) {
		Gson son = new Gson();
		ProductsDTO objDTO = son.fromJson(product, ProductsDTO.class);
		Categories objCate = new Categories();
		objCate.setCateId(objDTO.getCateId());
		Brands objBrand = new Brands();
		objBrand.setBrandId(objDTO.getBrandId());
		Products objProduct = new Products(objDTO.getProId(), objDTO.getName(), objDTO.getImageUrl(), objDTO.getPrice(),
				objDTO.getDiscount(), objDTO.getShortDescription(), objDTO.getDescription(), objDTO.getQuantity(),
				objDTO.getStatus(), objDTO.getCreatedAt(), objCate, objBrand, null, null, null, null);
		boolean bl = new ProductDAOImpl().update(objProduct);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{ProId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("ProId") Integer Id) {
		Gson son = new Gson();
		boolean bl = new ProductDAOImpl().delete(Id);
		String data = son.toJson(bl);
		return data;
	}
}
