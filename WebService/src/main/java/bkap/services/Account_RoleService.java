package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.Account_RoleDAOImpl;
import bkap.entities.Account_Roles;
import bkap.entities.Accounts;
import bkap.entities.Roles;
import bkap.entities.dto.Account_RolesDTO;

@Path("/account_roleService/")
public class Account_RoleService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		Gson son = new Gson();
		List<Account_Roles> listAccount_Role = new Account_RoleDAOImpl().getList();
		List<Account_RolesDTO> listAccount_RoleDTO = new ArrayList<Account_RolesDTO>();
		for (Account_Roles accountRole : listAccount_Role) {
			Account_RolesDTO accountRoleDTO = new Account_RolesDTO(accountRole.getId(),
					accountRole.getObjAccountOfAccountRole().getAccId(),
					accountRole.getObjRoleOfAccountRole().getRoleId());
			listAccount_RoleDTO.add(accountRoleDTO);
		}
		String Data = son.toJson(listAccount_RoleDTO);
		return Data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonAccountRole) {
		Gson son = new Gson();
		Account_RolesDTO accountRoleDTO = son.fromJson(jsonAccountRole, Account_RolesDTO.class);
		Accounts account = new Accounts();
		account.setAccId(accountRoleDTO.getAccId());
		Roles role = new Roles();
		role.setRoleId(accountRoleDTO.getRoleId());
		Account_Roles accountRole = new Account_Roles(0, account, role);
		boolean bl = new Account_RoleDAOImpl().insert(accountRole);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCity(String jsonAccountRole) {
		Gson son = new Gson();
		Account_RolesDTO accountRoleDTO = son.fromJson(jsonAccountRole, Account_RolesDTO.class);
		Accounts account = new Accounts();
		account.setAccId(accountRoleDTO.getAccId());
		Roles role = new Roles();
		role.setRoleId(accountRoleDTO.getRoleId());
		Account_Roles accountRole = new Account_Roles(0, account, role);
		boolean bl = new Account_RoleDAOImpl().update(accountRole);
		String data = son.toJson(bl);
		return data;
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("id") Integer id) {
		Gson son = new Gson();
		boolean bl = new Account_RoleDAOImpl().delete(id);
		String data = son.toJson(bl);
		return data;

	}

	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") Integer id) {
		Account_Roles accountRole = new Account_RoleDAOImpl().getById(id);
		Gson son = new Gson();
		Account_RolesDTO accountRoleDTO = new Account_RolesDTO(accountRole.getId(),
				accountRole.getObjAccountOfAccountRole().getAccId(), accountRole.getObjRoleOfAccountRole().getRoleId());
		String Data = son.toJson(accountRoleDTO);
		return Data;
	}
}
