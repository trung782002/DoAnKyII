package bkap.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.ConfigDAOImpl;
import bkap.entities.Configs;

@Path("/configService/")
public class ConfigService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		List<Configs> list = new ConfigDAOImpl().getList();
		Gson son = new Gson();
		String data = son.toJson(list);
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
	
	@GET
	@Path("/getById/{configId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("configId") Integer configId) {
		Configs configById = new ConfigDAOImpl().getById(configId) ;
		Gson son = new Gson();
		String data = son.toJson(configById);
		return data;
	}
}
