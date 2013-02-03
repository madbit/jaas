package org.madbit.jaas.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("wisdom")
@Produces("text/plain")
public class WisdomResouce {
	
	@Inject
	WisdomStorage storage;
	
	@GET
	public String getWisdom() {
		return storage.getWisdom();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String setWisdom(
			@FormParam("wisdom") String wisdom) {
		storage.setWisdom(wisdom);
		return "thanks";
	}

}
