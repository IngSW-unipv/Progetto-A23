package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;
import it.unipv.sfw.trebit.view.*;
import it.unipv.sfw.trebit.view.masterView.MasterView;

public class RegistrationController extends Controller{
	
	private final RegistrationView r;
	
	private Conto c;
	
	public RegistrationController(RegistrationView r) {
		this.r = r;	
		setListeners();
	}
	
	public void setListeners() {
		
		r.getButtonContinue().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!r.getStringCpassword().equals(r.getStringPassword())) {
					JOptionPane.showMessageDialog(r, "Le password non coincidono", "Registrati", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
				Utente u = new Utente(r.getStringNome(),
										r.getStringCognome(),
										r.getStringUsername(),
										r.getStringCpassword());
				
				try {
					if(facade.registrazione(u)) {
						r.dispose();
						mv.getHomeView();
					}
					else {
						JOptionPane.showMessageDialog(r, "Questo utente è già registrato", "Registrati", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
		r.getButtonBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				r.dispose();
				mv.getLoginView();
			}
		});
	}
}
