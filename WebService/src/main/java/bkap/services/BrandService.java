package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.BrandDAOImpl;
import bkap.entities.Brands;
import bkap.entities.dto.BrandsDTO;

@Path("/brandService/")
public class BrandService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListBrand() {
		List<Brands> listBrand = new BrandDAOImpl().getList();
		Gson son = new Gson();
		List<BrandsDTO> listData = new ArrayList<BrandsDTO>();
		for (Brands b : listBrand) {
			BrandsDTO bdDTO = new BrandsDTO(b.getBrandId(), b.getName(), b.getImageUrl(), b.isStatus(),
					b.getCreatedAt());
			listData.add(bdDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String b) {
		Gson son = new Gson();
		BrandsDTO objDTO = son.fromJson(b, BrandsDTO.class);
		Brands objBrand = new Brands(0, objDTO.getName(), objDTO.getImageUrl(), objDTO.isStatus(),
				objDTO.getCreatedAt(), null);
		boolean bl = new BrandDAOImpl().insert(objBrand);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String b) {
		Gson son = new Gson();
		BrandsDTO objDTO = son.fromJson(b, BrandsDTO.class);
		Brands objBrand = new Brands(0, objDTO.getName(), objDTO.getImageUrl(), objDTO.isStatus(),
				objDTO.getCreatedAt(), null);
		boolean bl = new BrandDAOImpl().update(objBrand);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("Id") Integer BrandId) {
		Gson son = new Gson();
		boolean bl = new BrandDAOImpl().delete(BrandId);
		String data = son.toJson(bl);
		return data;

	}

	@GET
	@Path("/getById/{cartId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("cartId") Integer cartId) {
		Gson son = new Gson();
		Brands b = new BrandDAOImpl().getById(cartId);
		BrandsDTO bdDTO = new BrandsDTO(b.getBrandId(), b.getName(), b.getImageUrl(), b.isStatus(), b.getCreatedAt());
		String Data = son.toJson(bdDTO);
		return Data;

	}

	@GET
	@Path("/getByName/{BrandName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCitiesByCountryName(@PathParam("BrandName") String BrandName) {
		List<Brands> list = new BrandDAOImpl().searchByName(BrandName);
		Gson son = new Gson();
		List<BrandsDTO> listData = new ArrayList<BrandsDTO>();
		for (Brands b : list) {
			BrandsDTO bdDTO = new BrandsDTO(b.getBrandId(), b.getName(), b.getImageUrl(), b.isStatus(),
					b.getCreatedAt());
			listData.add(bdDTO);
		}
		String data = son.toJson(list);
		return data;
	}
}
