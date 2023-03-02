package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;
import it.unipv.sfw.trebit.view.LoginView;
import it.unipv.sfw.trebit.view.*;
import it.unipv.sfw.trebit.view.masterView.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginController extends Controller{
	
	private final LoginView l;
	
	private Conto c;
	
	public LoginController(LoginView l) {
		this.l = l;
		setListeners();
	}
	
	public void setListeners() {
		
		l.getButtonSignIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Utente u = new Utente("","",
						l.getStringUsername(),
						l.getStringPassword().toString());
				
				try {
					if(facade.login(u) == false) {
						JOptionPane.showMessageDialog(l, "Credenziali errate", "Login", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						//JOptionPane.showMessageDialog(l, "Accesso autorizzato", "Login", JOptionPane.INFORMATION_MESSAGE);
						l.dispose();
						Conto c = facade.getContoByUsername(u);
						HomeController hc = new HomeController(c, mv.getHomeView());
						hc.initView(u);
						l.setStringUsername();
						l.setStringPassword();
					}
					
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		l.getButtonSignUp().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(l, "WorkInProgress", "Registrazione", JOptionPane.INFORMATION_MESSAGE);
				l.dispose();
				RegistrationController rc = new RegistrationController(mv.getRegistrationView());
			}
		});
	}
}