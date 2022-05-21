package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.AccountDAOImpl;
import bkap.entities.Accounts;
import bkap.entities.dto.AccountsDTO;

@Path("/accountService/")
public class AccountService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		Gson son = new Gson();
		List<Accounts> listAccount = new AccountDAOImpl().getList();
		List<AccountsDTO> listAccountDTO = new ArrayList<AccountsDTO>();
		for (Accounts account : listAccount) {
			AccountsDTO accountDTO = new AccountsDTO(account.getAccId(), account.getEmail(), account.getFullName(),
					account.getPhone(), account.getAddress(), account.getPassword(), account.isStatus(),
					account.getCreatedAt());
			listAccountDTO.add(accountDTO);
		}
		String Data = son.toJson(listAccountDTO);
		return Data;
	}

	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") Integer id) {
		Accounts account = new AccountDAOImpl().getById(id);
		Gson son = new Gson();
		AccountsDTO accountDTO = new AccountsDTO(account.getAccId(), account.getEmail(), account.getFullName(),
				account.getPhone(), account.getAddress(), account.getPassword(), account.isStatus(),
				account.getCreatedAt());
		String Data = son.toJson(accountDTO);
		return Data;
	}

	@GET
	@Path("/getEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkUnique(@PathParam("email") String email) {
		Gson son = new Gson();
		AccountsDTO accountsDTO = null;
		
		List<Accounts> listAccount = new AccountDAOImpl().getEmail(email);
		for (Accounts account : listAccount) {
			accountsDTO = new AccountsDTO(account.getAccId(), account.getEmail(), account.getFullName(),
					account.getPhone(), account.getAddress(), account.getPassword(), account.isStatus(),
					account.getCreatedAt());
		}
		String Data = son.toJson(accountsDTO);
		return Data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonAccount) {
		Gson son = new Gson();
		AccountsDTO accountDTO = son.fromJson(jsonAccount, AccountsDTO.class);
		Accounts account = new Accounts(0, accountDTO.getEmail(), accountDTO.getFullName(), accountDTO.getPhone(),
				accountDTO.getAddress(), accountDTO.getPassword(), accountDTO.isStatus(), accountDTO.getCreatedAt(),
				null, null, null);
		boolean bl = new AccountDAOImpl().insert(account);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String jsonAccount) {
		Gson son = new Gson();
		AccountsDTO accountDTO = son.fromJson(jsonAccount, AccountsDTO.class);
		Accounts account = new Accounts(accountDTO.getAccId(), accountDTO.getEmail(), accountDTO.getFullName(), accountDTO.getPhone(),
				accountDTO.getAddress(), accountDTO.getPassword(), accountDTO.isStatus(), accountDTO.getCreatedAt(),
				null, null, null);
		boolean bl = new AccountDAOImpl().update(account);
		String data = son.toJson(bl);
		return data;
	}

	@POST
	@Path("/delete/{accId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCity(@PathParam("accId") Integer accId) {
		Gson son = new Gson();
		boolean bl = new AccountDAOImpl().delete(accId);
		String data = son.toJson(bl);
		return data;

	}
}
