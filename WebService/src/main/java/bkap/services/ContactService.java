package bkap.services;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	public String insert(String jsonContact) {
		Gson son = new Gson();
		Contacts objContact = son.fromJson(jsonContact, Contacts.class);
		boolean bl = new ContactDAOImpl().insert(objContact);
		String data = son.toJson(bl);
		return data;
	}

	@GET
	@Path("/getById/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerById(@PathParam("Id") Integer Id) {
		Contacts contact = new ContactDAOImpl().getById(Id);
		
		Gson son = new Gson();
		String data = son.toJson(contact);
		return data;
	}

	@DELETE
	@Path("/delete/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCustomer(@PathParam("Id") Integer id) {
		boolean bl = new ContactDAOImpl().delete(id);
		Gson son = new Gson();
		String data = son.toJson(bl);
		return data;
	}

	@GET
	@Path("/getByName/{Fullname}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCitiesByCountryName(@PathParam("Fullname") String Fullname) {
		List<Contacts> list = new ContactDAOImpl().searchByName(Fullname);
		Gson son = new Gson();
		
		String data = son.toJson(list);
		return data;
	}
}
