package it.unipv.sfw.trebit.controller.masterController;

import it.unipv.sfw.trebit.controller.*;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.*;
import it.unipv.sfw.trebit.view.masterView.MasterView;

public class MasterController {
	
	private static MasterController instance;
	
	private MasterController() {
	}
	
	public static MasterController getInstance() {
		if (instance == null) {
			instance = new MasterController();
		}
		return instance;
	}
	
	public LoginController getLoginController(LoginView l) {
		LoginController c = new LoginController(l);
		return c;
	}

	public RegistrationController getRegistrationController(RegistrationView r) {
		RegistrationController c = new RegistrationController(r);
		return c;
	}

	public HomeController getHomeController(Conto conto, HomeView h) {
		HomeController c = new HomeController(conto, h);
		return c;
	}
	
	public SlotMachineController getSlotMachineController(Conto conto, SlotMachineView sm) {
		SlotMachineController c = new SlotMachineController(conto, sm);
		return c;
	}

	public WheelOfFortuneController getWheelOfFortuneController(Conto conto, WheelOfFortuneView wf) {
		WheelOfFortuneController c = new WheelOfFortuneController(conto, wf);
		return c;
	}
	
}
