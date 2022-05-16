package bkap.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.ConfigDAOImpl;
import bkap.entities.Configs;

@Path("/configService/")
public class ConfigService {
	
	@GET
	@Path("/getConfig")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfig() {
		Configs config = new ConfigDAOImpl().getConfig();
		Gson son = new Gson();
		String data = son.toJson(config);
		return data;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String jsonConfig) {
		Gson son = new Gson();
		Configs objConfig = son.fromJson(jsonConfig, Configs.class);
		boolean bl = new ConfigDAOImpl().update(objConfig);
		String data = son.toJson(bl);
		return data;
	}
	
}
