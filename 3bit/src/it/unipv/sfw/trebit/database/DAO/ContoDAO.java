package it.unipv.sfw.trebit.database.DAO;

import java.sql.*;

import it.unipv.sfw.trebit.database.DBConn;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;

public class ContoDAO {
	
	private Connection conn;
	private String schema = "ESAMEPO";
	
	public ContoDAO() {
	}
	
	public double getSaldoByUsername(Utente u) throws SQLException {
		conn = DBConn.startConnection(conn,schema);
		double saldo;
		
		String query = "SELECT SALDO FROM CONTO WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, u.getUsername());
		ResultSet result = st1.executeQuery();
		if (result.next()) {
			saldo = result.getDouble("SALDO");
		}
		else {
			saldo = 0;
		}
		
		conn.close();
		return saldo;
	}
	
	public double getSaldoByConto(Conto c) throws SQLException{
		conn = DBConn.startConnection(conn, schema);
		double saldo;
		
		String query = "SELECT SALDO FROM CONTO WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, c.getUsername());
		ResultSet result = st1.executeQuery();
		if (result.next()) {
			saldo = result.getDouble("SALDO");
		}
		else {
			saldo = 0;
		}
		conn.close();
		return saldo;
	}
	
	public boolean preleva(Conto c, double amount) throws SQLException {
		
		boolean v;
		
		if(c.getSaldo() == 0 || amount  < 0 || amount > c.getSaldo()) {
			v = false;
			return v;
		}
		
		conn = DBConn.startConnection(conn, schema);
		
		String query = "UPDATE CONTO SET SALDO = SALDO - ? WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setDouble(1, amount);
		st1.setString(2, c.getUsername());
		st1.executeUpdate();
		v = true;
		
		conn.close();
		return v;
	}
	
	public boolean deposita(Conto c, double amount) throws SQLException {
		
		boolean v;
		if (amount < 0) {
			v = false;
			return v;
		}
		
		conn = DBConn.startConnection(conn, schema);
		
		String query = "UPDATE CONTO SET SALDO = SALDO + ? WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setDouble(1, amount);
		st1.setString(2, c.getUsername());
		st1.executeUpdate();
		
		v = true;
		
		conn.close();
		return v;
	}
	
	public Conto getContoByUtente(Utente u) throws SQLException {
		conn = DBConn.startConnection(conn, schema);
		Conto c;
		
		String query = "SELECT * FROM CONTO WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, u.getUsername());
		ResultSet result = st1.executeQuery();
		if(result.next()) {
			c = new Conto(result.getString("USERNAME"), result.getDouble("SALDO"));
		}
		else {
			c = new Conto("Missing", 0);
		}
		
		conn.close();
		return c;
	}
	
}
