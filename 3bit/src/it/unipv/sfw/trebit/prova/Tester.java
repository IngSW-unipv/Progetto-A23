package it.unipv.sfw.trebit.prova;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.controller.LoginController;
import it.unipv.sfw.trebit.view.LoginView;

public class Tester {
	public static void main(String[] args) {
		
		LoginView l = new LoginView();
		LoginController c = new LoginController(l);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setVisible(true);
		
	}
}
