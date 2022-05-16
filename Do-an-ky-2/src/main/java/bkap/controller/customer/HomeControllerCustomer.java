package bkap.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.AccountsDTO;
import bkap.entities.BlogsDTO;
import bkap.entities.ConfigsDTO;
import bkap.entities.ProductsDTO;

@Controller
public class HomeControllerCustomer {
	
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model, HttpSession session) {
		Client client = Client.create();
		Gson gson = new Gson();
		WebResource webResource;
		Integer status = 1;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal!=null && principal!="anonymousUser") {
			User user = (User) principal;
			String email = user.getUsername();
			webResource = client.resource("http://localhost:8080/WebService/rest/accountService/getEmail/" + email);
			String data = webResource.get(String.class);
			GenericType<List<AccountsDTO>> listType = new GenericType<List<AccountsDTO>>() {};
			List<AccountsDTO> listAccount = gson.fromJson(data, listType.getType());
			for (AccountsDTO account : listAccount) {
				session.setAttribute("accId", account.getAccId());
				session.setAttribute("accEmail", account.getEmail());
				session.setAttribute("accFullName", account.getFullName());
				session.setAttribute("accPhone", account.getPhone());
				session.setAttribute("accAddress", account.getAddress());
			}
			model.addAttribute("accFullName", session.getAttribute("accFullName"));
		}
		
		webResource = client.resource("http://localhost:8080/WebService/rest/configService/getConfig");
		String data = webResource.get(String.class);
		ConfigsDTO config = gson.fromJson(data, ConfigsDTO.class);
		model.addAttribute("config", config);
		
		webResource = client.resource("http://localhost:8080/WebService/rest/productService/getListStatus");
		data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listProductType = new GenericType<List<ProductsDTO>>() {};
		List<ProductsDTO> listProducts = gson.fromJson(data, listProductType.getType());
        model.addAttribute("listProducts", listProducts);
        
		webResource = client.resource("http://localhost:8080/WebService/rest/blogService/getList/" + status);
		data = webResource.get(String.class);
		GenericType<List<BlogsDTO>> listType = new GenericType<List<BlogsDTO>>() {};
		List<BlogsDTO> listBlogs = gson.fromJson(data, listType.getType());
		model.addAttribute("listBlogs", listBlogs);
        
		return "customer/pages/index";
	}
}
