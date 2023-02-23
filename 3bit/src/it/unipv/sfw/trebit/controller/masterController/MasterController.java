package it.unipv.sfw.trebit.controller.masterController;

import it.unipv.sfw.trebit.controller.*;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.*;
import it.unipv.sfw.trebit.view.masterView.MasterView;

public class MasterController {
	
	private static MasterController instance;
	
	private LoginController login;
	private RegistrationController register;
	private HomeController home;
	private SlotMachineController slot;
	private WheelOfFortuneController ruota;
	
	private MasterView mv;
	
	private Conto c;
	
	private MasterController() {
		mv = MasterView.getInstance();
		this.login = new LoginController();
		this.register = new RegistrationController(mv.getRegistrationView());
		this.home = new HomeController(c, mv.getHomeView());
		this.slot = new SlotMachineController(c, mv.getSlotMachineView());
		this.ruota = new WheelOfFortuneController(c, mv.getWheelOfFortuneView());
	}
	
	public static MasterController getInstance() {
		if (instance == null) {
			instance = new MasterController();
		}
		return instance;
	}
	
	public LoginController getLoginController() {
		return login;
	}

	public RegistrationController getRegistrationController() {
		return register;
	}

	public HomeController getHomeController() {
		return home;
	}
	
	public SlotMachineController getSlotMachineController() {
		return slot;
	}

	public WheelOfFortuneController getWheelOfFortuneController() {
		return ruota;
	}
	
}
