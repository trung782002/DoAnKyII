package bkap.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import bkap.entities.ConfigsDTO;

@Controller
public class ConfigurationController {
	@RequestMapping(value = {"/configuration"})
	public String configuration(Model model) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/configService/getList");
		String data = webResource.get(String.class);

		Gson son = new Gson();
		GenericType<List<ConfigsDTO>> listType = new GenericType<List<ConfigsDTO>>() {};

		List<ConfigsDTO> list = son.fromJson(data, listType.getType());
		model.addAttribute("list", list);
		return "admin/pages/configs/configuration";
	}
	
	@RequestMapping(value = { "initUpdateConfig" })
	public String initUpdateConfig(@PathParam("id") Integer id, Model model) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/WebService/rest/configService/getById/" + id);
		String data = webResource.get(String.class);

		Gson son = new Gson();
		ConfigsDTO config = son.fromJson(data, ConfigsDTO.class);
		model.addAttribute("config", config);
		return "admin/pages/configs/confiUpdateguration";
	}

	@RequestMapping(value = { "/updateConfig" })
	public String updateConfig(@Valid @ModelAttribute("Configs") ConfigsDTO configsDTO, BindingResult result,
			@RequestParam("img") MultipartFile multipartFile, @RequestParam("img1") MultipartFile multipartFile1,
			HttpServletRequest request, Model model) {
		String a = multipartFile.getOriginalFilename();
		String b = multipartFile1.getOriginalFilename();
		Gson son = new Gson();
		String path = request.getServletContext().getRealPath("resources/image/");
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		File dest = new File(f.getAbsolutePath() + "/" + multipartFile.getOriginalFilename());
		if (!dest.exists()) {
			try {
				Files.write(dest.toPath(), multipartFile.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File des = new File(f.getAbsolutePath() + "/" + multipartFile1.getOriginalFilename());
		if (!des.exists()) {
			try {
				Files.write(dest.toPath(), multipartFile1.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (a.length() == 0) {
			String data = son.toJson(configsDTO);

			Client client = Client.create();
			WebResource resource = client.resource("http://localhost:8080/WebService/rest/configService/updateConfig");
			ClientResponse clientResponse = resource.type("application/json").put(ClientResponse.class, data);
			String res = clientResponse.getEntity(String.class);
			Boolean check = son.fromJson(res, Boolean.class);

			if (check) {
				model.addAttribute("success", "Update success");
				return "redirect:/admin/configuration";
			} else {
				model.addAttribute("error", "Update False !");
				model.addAttribute("b", configsDTO);
				return "admin/pages/configs/confiUpdateguration";
			}
		} else if (b.length() == 0) {
			String data = son.toJson(configsDTO);

			Client client = Client.create();
			WebResource resource = client.resource("http://localhost:8080/WebService/rest/configService/updateConfig");
			ClientResponse clientResponse = resource.type("application/json").put(ClientResponse.class, data);
			String res = clientResponse.getEntity(String.class);
			Boolean check = son.fromJson(res, Boolean.class);

			if (check) {
				model.addAttribute("success", "Update success");
				return "redirect:/admin/configuration";
			} else {
				model.addAttribute("error", "Update False !");
				model.addAttribute("b", configsDTO);
				return "redirect:/admin/confiUpdateguration";
			}
		} else {
			configsDTO.setLogoImage(multipartFile.getOriginalFilename());
			configsDTO.setBannerImage(multipartFile1.getOriginalFilename());
			String data = son.toJson(configsDTO);

			Client client = Client.create();
			WebResource resource = client.resource("http://localhost:8080/WebService/rest/configService/updateConfig");
			ClientResponse clientResponse = resource.type("application/json").put(ClientResponse.class, data);
			String res = clientResponse.getEntity(String.class);
			Boolean check = son.fromJson(res, Boolean.class);

			if (check) {
				model.addAttribute("success", "Update success");
				return "redirect:/admin/configuration";
			} else {
				model.addAttribute("error", "Update False !");
				model.addAttribute("c", configsDTO);
				return "redirect:/admin/confiUpdateguration";
			}
		}

	}
}
