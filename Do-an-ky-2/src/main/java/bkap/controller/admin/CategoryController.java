package bkap.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.CategoriesDTO;

@Controller
public class CategoryController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, false));
	}
	
	@RequestMapping(value = {"/categoryManagement"})
	public String categoryManagement(Model model) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
		String data = webResource.get(String.class);
		Gson gson = new Gson();
		GenericType<List<CategoriesDTO>> listtype = new GenericType<List<CategoriesDTO>>() {};
		List<CategoriesDTO> list = gson.fromJson(data, listtype.getType());
		
		CategoriesDTO category = new CategoriesDTO();

		model.addAttribute("category", category);
		model.addAttribute("list", list);
		return "admin/pages/category/categoryManagement";
	}

	@RequestMapping(value = { "/createCategory" })
	private String createCategory(@Valid @ModelAttribute("category") CategoriesDTO categoriesDTO, BindingResult result, RedirectAttributes redirAttrs ,
			Model model) {
		Gson gson = new Gson();
		Client client = Client.create();
		if (result.hasErrors()) {			
			WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getList");
			String data = webResource.get(String.class);
			GenericType<List<CategoriesDTO>> listtype = new GenericType<List<CategoriesDTO>>() {};
			List<CategoriesDTO> list = gson.fromJson(data, listtype.getType());
			model.addAttribute("list", list);
			return "admin/pages/category/categoryManagement";
		} else {
			Client client1 = new Client();
			String name = categoriesDTO.getName();		
			WebResource webResource1 = client1.resource("http://localhost:8080/WebService/rest/categoryService/checkUnique/"+name);
			String data1 = webResource1.get(String.class);			
			GenericType<List<CategoriesDTO>> listtype1 = new GenericType<List<CategoriesDTO>>() {};
			List<CategoriesDTO> list1 = gson.fromJson(data1, listtype1.getType());	    
			if(list1.size() == 0) {
				
				categoriesDTO.setCreatedAt(new Date());
				String data2 = gson.toJson(categoriesDTO);
				WebResource webResource2 = client.resource("http://localhost:8080/WebService/rest/categoryService/insert");
				ClientResponse clientResponse = webResource2.type("application/json").post(ClientResponse.class, data2);
				String re = clientResponse.getEntity(String.class);
				boolean bt = gson.fromJson(re, boolean.class);
				if (bt) {
					redirAttrs.addFlashAttribute("success", "Successfully added new");
					return "redirect:/categoryManagement";					
				} else {
					redirAttrs.addFlashAttribute("errors", "Add failed");
					return "redirect:/categoryManagement";
				}
			}else {
				redirAttrs.addFlashAttribute("uniquename", "Name category already exists");
				return "redirect:/categoryManagement";
			}
		}
	}
	
	@RequestMapping("/getByIdCategory")
	public String getByIdCategory(@RequestParam("CateId") Integer id, Model model) {
		Client client = new Client();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getById/"+id);
		String data = webResource.get(String.class);
		Gson gson = new Gson();
	    CategoriesDTO category = gson.fromJson(data, CategoriesDTO.class);
	    model.addAttribute("category", category);
	    model.addAttribute("name1", category.getName());
	    return "admin/pages/category/updateCategory";
	}
	
	@RequestMapping(value = {"/updateCategory" })
	private String updateCategory(@Valid @ModelAttribute("category") CategoriesDTO categoriesDTO, BindingResult result,@RequestParam("name1") String name1,
			RedirectAttributes redirAttrs ,Model model) {
		Gson gson = new Gson();
		if (result.hasErrors()) {
		    model.addAttribute("category", categoriesDTO);
			return "admin/pages/category/updateCategory";
		} else {
			if(categoriesDTO.getName().equals(name1)) {				
				String data = gson.toJson(categoriesDTO);
				Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/update");
				ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, data);
				String re = clientResponse.getEntity(String.class);
				boolean bt = gson.fromJson(re, boolean.class);
				if (bt) {
					redirAttrs.addFlashAttribute("success", "Update Successfully");
					return "redirect:/categoryManagement";
				} else {
					redirAttrs.addFlashAttribute("errors", "Update failed");
					return "redirect:/categoryManagement";
				}
			}else {
				Client client1 = new Client();
				String name = categoriesDTO.getName();		
				WebResource webResource1 = client1.resource("http://localhost:8080/WebService/rest/categoryService/checkUnique/"+name);
				String data1 = webResource1.get(String.class);			
				GenericType<List<CategoriesDTO>> listtype1 = new GenericType<List<CategoriesDTO>>() {};
				List<CategoriesDTO> list1 = gson.fromJson(data1, listtype1.getType());
				if(list1.size() == 0) {
					String data = gson.toJson(categoriesDTO);
					Client client = Client.create();
					WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/update");
					ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, data);
					String re = clientResponse.getEntity(String.class);
					boolean bt = gson.fromJson(re, boolean.class);
					if (bt) {
						redirAttrs.addFlashAttribute("success", "Update Successfully");
						return "redirect:/categoryManagement";
					} else {
						redirAttrs.addFlashAttribute("errors", "Update failed");
						return "redirect:/categoryManagement";											
					}
				}else {
					model.addAttribute("category", categoriesDTO);
					model.addAttribute("uniquename", "Name category already exists");
					model.addAttribute("name1", name1);
					return "admin/pages/category/updateCategory";
				}				
			}			
		}
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestParam("CateId") Integer id,RedirectAttributes redirAttrs , Model model) {
		Client client = new Client();
		Gson gson = new Gson();
		Client client1 = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/categoryService/getByProduct/"+id);
		String data = webResource.get(String.class);			
		GenericType<List<CategoriesDTO>> listtype = new GenericType<List<CategoriesDTO>>() {};
		List<CategoriesDTO> list = gson.fromJson(data, listtype.getType());
		if(list.size() == 0) {				
			WebResource webResource1 = client.resource("http://localhost:8080/WebService/rest/categoryService/delete/"+id);
			String data1 = webResource1.type("application/json").delete(String.class);
		    boolean bl = gson.fromJson(data1,boolean.class);
		    if(bl) {
				redirAttrs.addFlashAttribute("success", "Delete successful");
				return "redirect:/categoryManagement";
		    }else {
				redirAttrs.addFlashAttribute("errors", "Deletion failed");
				return "redirect:/categoryManagement";
		    }
		}else {			
			redirAttrs.addFlashAttribute("errors", "There are products in the catalog");
			return "redirect:/categoryManagement";
		}   
	}
}