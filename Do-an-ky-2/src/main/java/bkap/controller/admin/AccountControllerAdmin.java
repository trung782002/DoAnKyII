package bkap.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.AccountsDTO;

@Controller
public class AccountControllerAdmin {
	@RequestMapping(value = {"/accountManagement"})
	public String accountManagement(Model model) {
		Gson gson = new Gson();
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/accountService/getList");
		String data = webResource.get(String.class);
		GenericType<List<AccountsDTO>> listType = new GenericType<List<AccountsDTO>>() {};
		List<AccountsDTO> listAccounts = gson.fromJson(data, listType.getType());
		model.addAttribute("listAccounts", listAccounts);
		return "admin/pages/accountManagement";
	}
}
