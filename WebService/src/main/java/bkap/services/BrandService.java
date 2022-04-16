package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
			BrandsDTO bdDTO = new BrandsDTO(b.getBrandId(), b.getName(), b.getImageUrl(), b.getStatus(), b.getCreatedAt());
			listData.add(bdDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@GET
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(String b) {
		Gson son = new Gson();
		BrandsDTO objDTO = son.fromJson(b, BrandsDTO.class);
	}
}
