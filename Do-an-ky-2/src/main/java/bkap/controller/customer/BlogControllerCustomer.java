package bkap.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.BlogsDTO;

@Controller
public class BlogControllerCustomer {
	@RequestMapping(value = "/blog")
	public String listBlogs(Model model) {
		Gson gson = new Gson();
		Client client = Client.create();
		Integer status = 1;

		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/blogService/getList/" + status);
		String data = webResource.get(String.class);
		GenericType<List<BlogsDTO>> listType = new GenericType<List<BlogsDTO>>() {};
		List<BlogsDTO> listBlogs = gson.fromJson(data, listType.getType());
		model.addAttribute("listBlogs", listBlogs);
		return "customer/pages/blog";
	}
	
	@RequestMapping(value = "/blogDetail")
	public String blogDetail(Model model, @RequestParam("blogId")Integer blogId) {
		Gson gson = new Gson();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/blogService/getById/"+blogId);
		String res = webResource.get(String.class);
		BlogsDTO blog = gson.fromJson(res, BlogsDTO.class);
		model.addAttribute("blog", blog);
		return "customer/pages/blogDetail";
	}
}
