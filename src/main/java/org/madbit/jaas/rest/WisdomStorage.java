package org.madbit.jaas.rest;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@DeclareRoles("TutorialUser")
public class WisdomStorage {

	private String wisdom;
	
	@Inject
	Principal principal;
	
	@PostConstruct
	public void initialize() {
		wisdom = "Bla bla";
	}
	
	@RolesAllowed("TutorialUser")
	public void setWisdom(String wisdom) {
		this.wisdom = wisdom;
	}
	
	@PermitAll
	public String getWisdom() {
		return wisdom;
	}
}
