package it.unipv.sfw.trebit.view.masterView;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.view.*;

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
		lview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lview.setVisible(true);
		return this.lview;
	}
	
	public RegistrationView getRegistrationView() {
		rview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rview.setVisible(true);
		return this.rview;
	}
	
	public HomeView getHomeView() {
		hview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hview.setVisible(true);
		return this.hview;
	}
	
	public SlotMachineView getSlotMachineView() {
		sview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sview.setVisible(true);
		return this.sview;
	}
	
	public WheelOfFortuneView getWheelOfFortuneView() {
		wview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wview.setVisible(true);
		return this.wview;
	}
}
