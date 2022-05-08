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

import bkap.dao.impl.CategoryDAOlmpl;
import bkap.entities.Categories;
import bkap.entities.Products;
import bkap.entities.dto.CategoriesDTO;
import bkap.entities.dto.ProductsDTO;

@Path("/categoryService/")
public class CategoryService {
	
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListBrand() {
		List<Categories> listCategory = new CategoryDAOlmpl().getList();
		Gson son = new Gson();
		List<CategoriesDTO> listData = new ArrayList<CategoriesDTO>();
		for (Categories cat : listCategory) {
            CategoriesDTO catDTO = new CategoriesDTO(cat.getCateId(),cat.getName(),cat.isStatus(),cat.getCreatedAt());
			listData.add(catDTO);
		}
		String data = son.toJson(listData);
		return data;
	}
	
	@GET
	@Path("/getById/{cateId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("cateId")Integer id) {
		Categories category = new CategoryDAOlmpl().getById(id);
		Gson son = new Gson();
		CategoriesDTO Data = new CategoriesDTO(category.getCateId(), category.getName(), category.isStatus(), category.getCreatedAt());		
		String data = son.toJson(Data);
		return data;
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String category) {
		Gson son = new Gson();
		CategoriesDTO objDTO = son.fromJson(category, CategoriesDTO.class);
		Categories objCategory = new Categories(0, objDTO.getName(), objDTO.isStatus(), objDTO.getCreatedAt(), null);
		boolean bl = new CategoryDAOlmpl().insert(objCategory);
		String data = son.toJson(bl);
		return data;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String category) {
		Gson son = new Gson();
		CategoriesDTO objDTO = son.fromJson(category, CategoriesDTO.class);
		Categories objCategory = new Categories(objDTO.getCateId(), objDTO.getName(),
				objDTO.isStatus(), objDTO.getCreatedAt(),null);
		boolean bl = new CategoryDAOlmpl().update(objCategory);
		String data = son.toJson(bl);
		return data; 
	}
	
	@DELETE
    @Path("/delete/{cateId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("cateId")Integer Id) {
        Gson son = new Gson();      
        boolean bl = new CategoryDAOlmpl().delete(Id);
        String data = son.toJson(bl);
        return data;
    }
	
	@GET
	@Path("/checkUnique/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkUnique(@PathParam("name")String name) {
		List<Categories> listCategory = new CategoryDAOlmpl().checkUnique(name);
		Gson son = new Gson();
		List<CategoriesDTO> listData = new ArrayList<CategoriesDTO>();
		for (Categories cat : listCategory) {
            CategoriesDTO catDTO = new CategoriesDTO(cat.getCateId(),cat.getName(),cat.isStatus(),cat.getCreatedAt());
			listData.add(catDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

	@GET
	@Path("/getByProduct/{cateId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByProduct(@PathParam("cateId")Integer cateId) {
		List<Products> Products = new CategoryDAOlmpl().getByProduct(cateId);
		Gson son = new Gson();
		List<ProductsDTO> listData = new ArrayList<ProductsDTO>();
		for (Products pr : Products) {
			ProductsDTO prDTO = new ProductsDTO(0, pr.getName(), pr.getImageUrl(), pr.getPrice(), pr.getDiscount(),
					pr.getObjCategoryOfProduct().getCateId(), pr.getObjBrandOfProduct().getBrandId(),
					pr.getShortDescription(), pr.getDescription(), pr.getQuanity(), pr.getStatus(), pr.getCreatedAt());
			listData.add(prDTO);
		}
		String data = son.toJson(listData);
		return data;
	}

}
