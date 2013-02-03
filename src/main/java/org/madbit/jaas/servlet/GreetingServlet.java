package org.madbit.jaas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="GreetingServlet", urlPatterns="/greeting")
@ServletSecurity(
		@HttpConstraint( /*transportGuarantee= TransportGuarantee.CONFIDENTIAL,*/ rolesAllowed={"TutorialUser"})
)
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message = "Hello World";
		req.setAttribute("message", message); // This will be available as ${message}
		req.getRequestDispatcher("/page.jsp").forward(req, resp);
	}
	
	

}
