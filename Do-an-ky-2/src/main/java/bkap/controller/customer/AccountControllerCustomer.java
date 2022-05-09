package bkap.controller.customer;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.AccountsDTO;

@Controller
public class AccountControllerCustomer {
	@Autowired
	private PasswordEncoder pe;
	
	@RequestMapping(value = "/signUp")
	public String initSignUp(Model model) {
		AccountsDTO account = new AccountsDTO();
		model.addAttribute("account", account);
		return "customer/pages/signUp";
	}

	@RequestMapping(value = "/doSignUp")
	public String signUp(Model model, @Valid @ModelAttribute("account") AccountsDTO account, BindingResult result) {
		if(result.hasErrors()) {
			return "customer/pages/signUp";
		} else {
			Gson gson = new Gson();
	        Client client = Client.create();
	        
	        account.setPassword(pe.encode(account.getPassword()));
	        account.setStatus(true);
	        account.setCreatedAt(new Date());
	        
	        String jsonAccount = gson.toJson(account);
	        WebResource webResource =  client.resource("http://localhost:8080/WebService/rest/accountService/insert");
	        ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, jsonAccount);
	        String res = clientResponse.getEntity(String.class);
	        boolean rs = gson.fromJson(res, boolean.class);
	        
	        if(rs) {
	        	return "customer/pages/login";
	        } else {
	        	return "customer/pages/signUp";
	        }
		}
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {

		return "customer/pages/login";
	}

}
