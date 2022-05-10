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
			AccountsDTO accountDTO = new AccountsDTO(account.getAccId(), account.getAccName(), account.getFullName(),
					account.getEmail(), account.getAddress(), account.getPhone(), account.getPassword(),
					account.isStatus(), account.getRememberToken(), account.getCreatedAt());
			listAccountDTO.add(accountDTO);
		}
		String Data = son.toJson(listAccountDTO);
		return Data;
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String jsonAccount) {
		Gson son = new Gson();
		AccountsDTO accountDTO = son.fromJson(jsonAccount, AccountsDTO.class);
		Accounts account = new Accounts(0, accountDTO.getAccName(), accountDTO.getFullName(), accountDTO.getEmail(),
				accountDTO.getAddress(), accountDTO.getPhone(), accountDTO.getPassword(), accountDTO.isStatus(),
				accountDTO.getRememberToken(), accountDTO.getCreatedAt(), null, null, null, null);
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
		Accounts account = new Accounts(accountDTO.getAccId(), accountDTO.getAccName(), accountDTO.getFullName(), accountDTO.getEmail(),
				accountDTO.getAddress(), accountDTO.getPhone(), accountDTO.getPassword(), accountDTO.isStatus(),
				accountDTO.getRememberToken(), accountDTO.getCreatedAt(), null, null, null, null);
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

	@GET
	@Path("/getById/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("Id") Integer Id) {
		Accounts account = new AccountDAOImpl().getById(Id);
		Gson son = new Gson();
		AccountsDTO accountDTO = new AccountsDTO(account.getAccId(), account.getAccName(), account.getFullName(),
				account.getEmail(), account.getAddress(), account.getPhone(), account.getPassword(), account.isStatus(),
				account.getRememberToken(), account.getCreatedAt());
		String Data = son.toJson(accountDTO);
		return Data;
	}
}
