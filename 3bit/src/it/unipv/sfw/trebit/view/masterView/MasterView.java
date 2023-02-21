package it.unipv.sfw.trebit.view.masterView;

import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.LoginView;
import it.unipv.sfw.trebit.view.RegistrationView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;

public class MasterView {
	
	private static MasterView instance;
	
	private LoginView lview;
	private RegistrationView rview;
	private HomeView hview;
	private SlotMachineView sview;
	private WheelOfFortuneView wview;
	
	private MasterView() {
		
		this.lview = new LoginView();
		this.rview = new RegistrationView();
		this.hview = new HomeView();
		this.sview = new SlotMachineView();
		this.wview = new WheelOfFortuneView();
		
	}
	
	public static MasterView getInstance() {
		if (instance == null) {
			instance = new MasterView();
		}
		return instance;
	}
	
	public LoginView getLoginView() {
		return this.lview;
	}
	
	public RegistrationView getRegistrationView() {
		return this.rview;
	}
	
	public HomeView getHomeView() {
		return this.hview;
	}
	
	public SlotMachineView getSlotMachineView() {
		return this.sview;
	}
	
	public WheelOfFortuneView getWheelOfFortuneView() {
		return this.wview;
	}
}
