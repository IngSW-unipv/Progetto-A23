package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.view.*;

public class RegistrationController {
	
	private final RegistrationView r;
	private DBFacade facade = DBFacade.getInstance();
	
	public RegistrationController(RegistrationView r) {
		this.r = r;	
		setListeners();
	}
	
	public void setListeners() {
		
	}
}
