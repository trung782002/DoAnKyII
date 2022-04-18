package bkap.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.CategoryDAOlmpl;
import bkap.entities.Categories;
import bkap.entities.Products;
import bkap.entities.dto.CategoriesDTO;

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
	@Path("/getById/{CateId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("CateId")Integer Id) {
		Categories category = new CategoryDAOlmpl().getById(Id);
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
		Set<Products> listProducts = new HashSet<Products>();
		Categories objCategory = new Categories(0, objDTO.getName(),
				objDTO.isStatus(), objDTO.getCreatedAt(), listProducts);
		boolean bl = new CategoryDAOlmpl().update(objCategory);
		String data = son.toJson(bl);
		return data;
	}
	
	@DELETE
    @Path("/delete/{CateId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("CateId")Integer Id) {
        Gson son = new Gson();      
        boolean bl = new CategoryDAOlmpl().delete(Id);
        String data = son.toJson(bl);
        return data;
    }


}
