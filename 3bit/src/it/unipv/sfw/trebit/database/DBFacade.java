package it.unipv.sfw.trebit.database;

import java.sql.SQLException;

import it.unipv.sfw.trebit.database.DAO.ContoDAO;
import it.unipv.sfw.trebit.database.DAO.UtenteDAO;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;


public class DBFacade {
	
	static DBFacade instance;
	
	UtenteDAO utenteDAO;
	ContoDAO contoDAO;
	
	private DBFacade() {
		utenteDAO = new UtenteDAO();
		contoDAO = new ContoDAO();
	}
	
	public static synchronized DBFacade getInstance() {
		if(instance == null) instance = new DBFacade();
		return instance;
	}
	
	public boolean login(Utente u) throws SQLException{
		return utenteDAO.login(u);
	}
	
	public boolean registrazione(Utente u) throws SQLException {
		return utenteDAO.registrazione(u);
	}
	
	public double getSaldoByUsername(Utente u) throws SQLException {
		return contoDAO.getSaldoByUsername(u);
	}
	
	public double getSaldoByConto(Conto c) throws SQLException{
		return contoDAO.getSaldoByConto(c);
	}
	
	public boolean preleva(Conto c, double amount) throws SQLException {
		return contoDAO.preleva(c, amount);
	}
	
	public boolean deposita(Conto c, double amount) throws SQLException{
		return contoDAO.deposita(c, amount);
	}
	
	public Conto getContoByUsername(Utente u) throws SQLException {
		return contoDAO.getContoByUtente(u);
	}
}






