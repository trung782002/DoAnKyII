package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.Product_imageDAOImpl;
import bkap.entities.Product_images;
import bkap.entities.Products;
import bkap.entities.dto.Product_imagesDTO;

@Path("/product_imageService/")
public class Product_imageService {
	@GET
	@Path("/getByProId/{ProId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByProId(@PathParam("ProId") Integer Id) {
		List<Product_images> listProduct_image = new Product_imageDAOImpl().getByProId(Id);
		Gson son = new Gson();
		List<Product_imagesDTO> listData = new ArrayList<Product_imagesDTO>();
		for (Product_images product_image : listProduct_image) {
			Product_imagesDTO Product_imageDTO = new Product_imagesDTO(product_image.getId(),
					product_image.getObjProductOfImage().getProId(), product_image.getImageUrl());
			listData.add(Product_imageDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String product_image) {
		Gson son = new Gson();
		Product_imagesDTO objDTO = son.fromJson(product_image, Product_imagesDTO.class);
		Products proId = new Products();
		proId.setProId(objDTO.getId());
		Product_images ojbProduct_image = new Product_images(0, objDTO.getImageUrl(), proId);
		boolean bl = new Product_imageDAOImpl().insert(ojbProduct_image);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{ProId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("ProId") Integer Id) {
		Gson son = new Gson();
		boolean bl = new Product_imageDAOImpl().delete(Id);
		String data = son.toJson(bl);
		return data;
	}
}
