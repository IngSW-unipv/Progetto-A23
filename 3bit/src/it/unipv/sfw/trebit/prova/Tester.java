package it.unipv.sfw.trebit.prova;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.controller.LoginController;
import it.unipv.sfw.trebit.view.LoginView;
import it.unipv.sfw.trebit.view.masterView.MasterView;

public class Tester {
	public static void main(String[] args) {
		
		MasterView mv = MasterView.getInstance();
		LoginController lc = new LoginController(mv.getLoginView());
	}
}
