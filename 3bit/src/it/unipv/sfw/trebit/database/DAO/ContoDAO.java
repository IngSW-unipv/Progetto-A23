package it.unipv.sfw.trebit.database.DAO;

import java.sql.*;

import it.unipv.sfw.trebit.database.DBConn;
import it.unipv.sfw.trebit.model.account.Utente;

public class ContoDAO {
	
	private Connection conn;
	private String schema = "ESAMEPO";
	
	public ContoDAO() {
	}
	
	public double getSaldoByUsername(Utente u) throws SQLException {
		conn = DBConn.startConnection(conn,schema);
		
		double saldo;
		
		String query = "SELECT SALDO WHERE USERNAME = ?;";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, u.getUsername());
		ResultSet result = st1.executeQuery();
		if (result.next()) {
			saldo = result.getDouble("SALDO");
		}
		else {
			saldo = 0;
		}
		return saldo;
	}
	
}
