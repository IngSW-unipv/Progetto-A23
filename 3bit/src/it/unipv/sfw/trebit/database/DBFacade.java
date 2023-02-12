package it.unipv.sfw.trebit.database;

import java.sql.SQLException;


import it.unipv.sfw.trebit.database.DAO.UtenteDAO;
import it.unipv.sfw.trebit.utente.Utente;


public class DBFacade {
	
	static DBFacade instance;
	
	UtenteDAO utenteDAO;
	
	private DBFacade() {
		UtenteDAO u= new UtenteDAO();
	}
	
	public static synchronized DBFacade getInstance() {
		if(instance == null) instance = new DBFacade();
		return instance;
	}
	
	public boolean login(Utente u) throws SQLException{
		return utenteDAO.login(u);
	}
}