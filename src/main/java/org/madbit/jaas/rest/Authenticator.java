package org.madbit.jaas.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class Authenticator implements Filter {

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(req.authenticate(res)) {
			chain.doFilter(req, res);
		} else {
			req.setAttribute("message", "Utente non autenticato");
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { }

}
