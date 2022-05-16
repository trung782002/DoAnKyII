package bkap.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.AccountsDTO;

@Controller
public class AccountController {
	
	@Autowired
	private PasswordEncoder pe;
	
	@RequestMapping(value = "/signUp")
	public String initSignUp(Model model) {
		AccountsDTO account = new AccountsDTO();
		model.addAttribute("account", account);
		return "customer/pages/account/signUp";
	}

	@RequestMapping(value = "/doSignUp")
	public String signUp(@Valid @ModelAttribute("account") AccountsDTO account, BindingResult result, 
			@RequestParam("confirmPassword") String confirmPassword, Model model, RedirectAttributes redirAttrs) {
		Integer flag = 0;
		Gson gson = new Gson();
		Client client = Client.create();
		WebResource webResource;
		
		if(account.getEmail().length() > 0) {
			webResource = client.resource("http://localhost:8080/WebService/rest/accountService/getEmail/" + account.getEmail());
			String data = webResource.get(String.class);
			GenericType<List<AccountsDTO>> listType = new GenericType<List<AccountsDTO>>() {};
			List<AccountsDTO> listAccount = gson.fromJson(data, listType.getType());
			if(listAccount.size() > 0) {
				model.addAttribute("emailExist", "This email is already registered.");
				flag++;
			}
		}
		
		if (!account.getPassword().equals(confirmPassword)) {
			model.addAttribute("confirmPassword", "Confirm password does not match password.");
			flag++;
		}

		if (result.hasErrors() == true || flag > 0) {
			return "customer/pages/account/signUp";
		} else {
			account.setPassword(pe.encode(account.getPassword()));
	        account.setStatus(true);
	        account.setCreatedAt(new Date());
	        
	        String jsonAccount = gson.toJson(account);
	        webResource =  client.resource("http://localhost:8080/WebService/rest/accountService/insert");
	        ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, jsonAccount);
	        String res = clientResponse.getEntity(String.class);
	        boolean rs = gson.fromJson(res, boolean.class);
	        
	        if(rs)
	        	return "customer/pages/account/login";
	        else 
	        	return "customer/pages/account/signUp";
		}
	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("login", "Your email or password is incorrect, please try again");
		}
		return "customer/pages/account/login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		return "redirect:/home";
	}
	
}
