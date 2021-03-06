package bkap.services;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
import bkap.dao.impl.CategoryDAOlmpl;
import bkap.entities.Brands;
import bkap.entities.Products;
import bkap.entities.dto.BrandsDTO;
import bkap.entities.dto.ProductsDTO;

@Path("/brandService/")
public class BrandService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListBrand() {
		List<Brands> listBrand = new BrandDAOImpl().getAll();
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
		boolean bl = new BrandDAOImpl().insertBrand(objBrand);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String b) {
		Gson son = new Gson();
		BrandsDTO objDTO = son.fromJson(b, BrandsDTO.class);
		Brands objBrand = new Brands(objDTO.getBrandId(), objDTO.getName(), objDTO.getImageUrl(), objDTO.isStatus(),
				objDTO.getCreatedAt(), null);
		boolean bl = new BrandDAOImpl().updateBrands(objBrand);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("Id") Integer Id) {
		Gson son = new Gson();
		boolean bl = new BrandDAOImpl().deleteBrands(Id);
		String data = son.toJson(bl);
		return data;

	}

	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") Integer id) {
		Gson son = new Gson();
		Brands b = new BrandDAOImpl().getBrandsById(id);
		BrandsDTO bdDTO = new BrandsDTO(b.getBrandId(), b.getName(), b.getImageUrl(), b.isStatus(), b.getCreatedAt());
		String Data = son.toJson(bdDTO);
		return Data;

	}

	@GET
	@Path("/getByName/{BrandName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCitiesByCountryName(@PathParam("BrandName") String BrandName) {
		List<Brands> list = new BrandDAOImpl().getBrandsByName(BrandName);
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

	@GET
	@Path("/checkUnique/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String checkUnique(@PathParam("name") String name) {
		StringTokenizer stk = new StringTokenizer(name, "+");
		name = "";
		while(stk.hasMoreElements()) {
			name = name+stk.nextToken()+" ";
		}
		name = name.trim();
		List<Brands> listCategory = new BrandDAOImpl().checkUnique(name);
		Gson son = new Gson();
		List<BrandsDTO> listData = new ArrayList<BrandsDTO>();
		for (Brands bra : listCategory) {
			BrandsDTO braDTO = new BrandsDTO(bra.getBrandId(), bra.getName(), bra.getImageUrl(), bra.isStatus(),bra.getCreatedAt());
			listData.add(braDTO);
		}
		String data = son.toJson(listData);
		return data;
	}
	
	@GET
	@Path("/getByProduct/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByProduct(@PathParam("brandId")Integer cateId) {
		List<Products> Products = new BrandDAOImpl().getByProduct(cateId);
		Gson son = new Gson();
		List<ProductsDTO> listData = new ArrayList<ProductsDTO>();
		for (Products pr : Products) {
			ProductsDTO prDTO = new ProductsDTO(0, pr.getName(), pr.getImageUrl(), pr.getPrice(), pr.getDiscount(),
					pr.getObjCategoryOfProduct().getCateId(), pr.getObjBrandOfProduct().getBrandId(),
					pr.getShortDescription(), pr.getDescription(), pr.getQuantity(), pr.getStatus(), pr.getCreatedAt());
			listData.add(prDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

}
