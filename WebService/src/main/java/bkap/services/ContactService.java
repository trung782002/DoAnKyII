package bkap.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import bkap.dao.impl.ContactDAOImpl;
import bkap.entities.Contacts;

@Path("/contactService/")
public class ContactService {
	@GET
	@Path("/getList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getList() {
		List<Contacts> list = new ContactDAOImpl().getList();
		Gson son = new Gson();
		String data = son.toJson(list);
		return data;
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String contact) {
		Gson son = new Gson();
		Contacts objContact = son.fromJson(contact, Contacts.class);
		boolean bl = new ContactDAOImpl().insert(objContact);
		String data = son.toJson(bl);
		return data;
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String contact) {
		Gson son = new Gson();
		Contacts objContact = son.fromJson(contact, Contacts.class);
		boolean bl = new ContactDAOImpl().update(objContact);
		String data = son.toJson(bl);
		return data;
	}
}
