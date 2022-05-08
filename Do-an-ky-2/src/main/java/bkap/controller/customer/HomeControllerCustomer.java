package bkap.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.ProductsDTO;

@Controller
public class HomeControllerCustomer {
	@RequestMapping(value = {"/", "/home"})
	public String home(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();	
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/productService/getListStatus");
		String data = webResource.get(String.class);
		GenericType<List<ProductsDTO>> listtype = new GenericType<List<ProductsDTO>>() {};
		List<ProductsDTO> list = gson.fromJson(data, listtype.getType());
        model.addAttribute("products", list);
		return "customer/pages/index";
	}
}
