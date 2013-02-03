package org.madbit.jaas.rest;

import javax.ejb.AccessLocalException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AccessLocalExceptionMapper implements ExceptionMapper<AccessLocalException> {
	
	@Context
	HttpServletRequest request;

	@Override
	public Response toResponse(AccessLocalException exception) {
		try {
			request.logout();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}
}
