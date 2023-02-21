package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.view.*;

public class MasterController {
	
	private static MasterController instance;
	
	private LoginController login;
	private RegistrationController register;
	private HomeController home;
	private WheelOfFortuneController ruota;
	
	private LoginView lview;
	private RegistrationView rview;
	private HomeView hview;
	private WheelOfFortuneView wview;
	
	private Conto c;
	
	private MasterController() {
		this.login = new LoginController(lview);
		this.register = new RegistrationController(rview);
		this.home = new HomeController(c, hview);
		this.ruota = new WheelOfFortuneController(c, wview);
	}
	
	public static MasterController getInstance() {
		if (instance == null) {
			instance = new MasterController();
		}
		return instance;
	}
	
	public LoginController getLoginCon() {
		return login;
	}

	public RegistrationController getRegistrationController() {
		return register;
	}

	public HomeController getHomeController() {
		return home;
	}

	public WheelOfFortuneController getWheelOfFortuneController() {
		return ruota;
	}
	
}
