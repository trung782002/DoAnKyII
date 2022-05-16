package bkap.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.ConfigsDTO;

@Controller
public class ContactControllerCustomer {
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		Client client = Client.create();
		Gson gson = new Gson();	
		
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/configService/getConfig");
		String data = webResource.get(String.class);
		ConfigsDTO config = gson.fromJson(data, ConfigsDTO.class);
		model.addAttribute("config", config);
		return "customer/pages/contact";
	}
}
