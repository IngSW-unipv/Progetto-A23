package it.unipv.sfw.trebit.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unipv.sfw.trebit.database.DBConn;
import it.unipv.sfw.trebit.utente.Utente;

public class UtenteDAO {

		private Connection conn;
		private String schema = "prova";
		
		public UtenteDAO() {
			super();
		}
		public boolean login(Utente u) throws SQLException {
			conn = DBConn.startConnection(conn,schema);
			PreparedStatement st1;
			ResultSet result;
			String query = "SELECT PW FROM UTENTI WHERE USERNAME="+ "'" + u.getNome() + "'" + ";";
			st1 = conn.prepareStatement(query);
			result=st1.executeQuery();
			boolean log = false;
			if( result.getString("PW").equals(u.getPassword().toString())) {
				log = true;
			}	
			conn.close();
			return log;
		}
		
		public void registrazione(Utente u) throws SQLException{
			conn = DBConn.startConnection(conn, schema);
			String query = "INSERT INTO UTENTI VALUES("+"'"+u.getNome()+"'"+",'"+u.getPassword().toString()+"');";
			PreparedStatement st1 = conn.prepareStatement(query);
			st1.executeUpdate();
			conn.close();
		}
}
