package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import it.unipv.sfw.trebit.controller.masterController.MasterController;
import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;
import it.unipv.sfw.trebit.view.*;
import it.unipv.sfw.trebit.view.masterView.MasterView;

public class RegistrationController {
	
	private final RegistrationView r;
	private DBFacade facade = DBFacade.getInstance();
	private MasterController mc = MasterController.getInstance();
	private MasterView mv = MasterView.getInstance();
	
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
					JOptionPane.showMessageDialog(r, "Le password non sono uguali", "Registrati", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				Utente u = new Utente(r.getStringNome(),
										r.getStringCognome(),
										r.getStringUsername(),
										r.getStringCpassword());
				try {
					facade.registrati(u);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				r.dispose();
				HomeView h = mv.getHomeView();
				mc.getHomeController(c, h);
				}
			}
		});
	}
}
