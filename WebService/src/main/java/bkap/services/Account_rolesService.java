package bkap.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.ReviewDAOImpl;
import bkap.entities.Accounts;
import bkap.entities.Products;
import bkap.entities.Reviews;
import bkap.entities.dto.ReviewsDTO;

@Path("/Account_rolesService/")
public class Account_rolesService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		Gson son = new Gson();
		List<Account_Roles> list = new Account_RoleDAOImpl().getList();
		List<Account_RolesDTO> data = new ArrayList<Account_RolesDTO>();
		for (Account_Roles a : list) {
			ReviewsDTO cDTO = new ReviewsDTO(a.getId(),a.getObjAccountOfAccountRole().getAccId()
					,a.objRoleOfAccountRole().getRoleId());
			data.add(cDTO);
		}
		String Data = son.toJson(data);
		return Data;
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String a) {
		Gson son = new Gson();
		Account_RolesDTO objDTO = son.fromJson(a, Account_RolesDTO.class);
		Accounts objAccounts = new Accounts();
		objAccounts.setAccId(objDTO.getAccId());
		Roles objRoles = new Roles();
		objRoleOfAccountRole.setRoleId(objDTO.getRoleId());
		Account_Roles objAccount_Roles = new Account_Roles(0,objAccounts,objRoleOfAccountRole );
		boolean bl = new Account_RoleDAOImpl().insert(objAccount_Roles);
		String data = son.toJson(bl);
		return data;
	}
	 @POST
	 @Path("/updateCity")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public String updateCity(String a) {
		 Gson son = new Gson();
		 Account_RolesDTO objDTO = son.fromJson(a, Account_RolesDTO.class);
		 Accounts objAccounts = new Accounts();
			objAccounts.setAccId(objDTO.getAccId());
			Roles objRoles = new Roles();
			objRoleOfAccountRole.setRoleId(objDTO.getRoleId());
			Account_Roles objAccount_Roles = new Account_Roles(0,objAccounts,objRoleOfAccountRole );
			boolean bl = new Account_RoleDAOImpl().insert(objAccount_Roles);
			String data = son.toJson(bl);
			return data;
	 }
	@POST
    @Path("/delete/{Id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteCity(@PathParam("Id")Integer Id) {
		Gson son = new Gson();
		boolean bl = new Account_RoleDAOImpl().delete(Id);
		String data = son.toJson(bl);
		return data;
	
	}
	 @GET
	 @Path("/getById/{Id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String getById(@PathParam("ReviewId")Integer Id) {
		 Account_Roles r =new Account_RoleDAOImpl().getById(Id);
		 Gson son = new Gson();
		 
		 ReviewsDTO cDTO = new ReviewsDTO(a.getId(),a.getObjAccountOfAccountRole().getAccId()
					,a.objRoleOfAccountRole().getRoleId());
		 String Data = son.toJson(cDTO);
			return Data;
	 }
}
