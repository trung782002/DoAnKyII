package bkap.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.BlogsDTO;
import bkap.entities.ConfigsDTO;
import bkap.entities.ProductsDTO;

@Controller
public class HomeControllerCustomer {
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();	
		Integer status = 1;
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/configService/getList");
		String data = webResource.get(String.class);
		GenericType<List<ConfigsDTO>> listConfigType = new GenericType<List<ConfigsDTO>>() {};
		List<ConfigsDTO> configs = gson.fromJson(data, listConfigType.getType());
		model.addAttribute("configs", configs);
		
		webResource = client.resource("http://localhost:8080/WebService/rest/productService/getListStatus");
		data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listProductType = new GenericType<List<ProductsDTO>>() {};
		List<ProductsDTO> list = gson.fromJson(data, listProductType.getType());
        model.addAttribute("products", list);
        
		webResource = client.resource("http://localhost:8080/WebService/rest/blogService/getList/" + status);
		data = webResource.get(String.class);
		GenericType<List<BlogsDTO>> listType = new GenericType<List<BlogsDTO>>() {};
		List<BlogsDTO> listBlogs = gson.fromJson(data, listType.getType());
		model.addAttribute("listBlogs", listBlogs);
        
		return "customer/pages/index";
	}
}
