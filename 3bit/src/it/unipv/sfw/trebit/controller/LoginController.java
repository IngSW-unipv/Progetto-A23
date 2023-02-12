package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.utente.Utente;
import it.unipv.sfw.trebit.view.LoginView;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginController {
	
	private final LoginView l;
	private DBFacade facade = DBFacade.getInstance();
	
	public LoginController() {
		l = new LoginView();
		
		l.getButtonSignIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Utente u = new Utente(
						l.getStringUsername(),
						l.getStringPassword().toString());
				try {
					if(!facade.login(u)) {
						JOptionPane.showMessageDialog(l, "Credenziali errate", "Login", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(l, "Accesso autorizzato", "Login", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		l.getButtonSignUp().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(l, "WorkInProgress", "Registrazione", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	
}