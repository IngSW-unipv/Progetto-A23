package it.unipv.sfw.trebit.database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unipv.sfw.trebit.database.DBConn;
import it.unipv.sfw.trebit.model.account.Utente;

public class UtenteDAO {

		private Connection conn;
		private String schema = "ESAMEPO";
		
		public UtenteDAO() {
		}
		
		public boolean login(Utente u) throws SQLException {
			conn = DBConn.startConnection(conn,schema);
			PreparedStatement st1;
			ResultSet result;
			String query = "SELECT PW from UTENTI where USERNAME= ?;";
			st1 = conn.prepareStatement(query);
			st1.setString(1, u.getUsername());
			result=st1.executeQuery();
			boolean log = false;
			if( result.next() && result.getString("PW").equals(u.getPassword())) {
				log = true;
			}	
			DBConn.closeConnection(conn);
			return log;
		}	
		
		public boolean registrazione(Utente u) throws SQLException{
			
			conn = DBConn.startConnection(conn,schema);
			
			String verifica = "SELECT PW FROM UTENTI WHERE USERNAME =?;";
			PreparedStatement ver = conn.prepareStatement(verifica);
			ver.setString(1, u.getUsername());
			ResultSet result = ver.executeQuery();
			boolean reg = false;
			if(result.next()==false) {
				reg = true;
			}
			
			String query1 = "INSERT INTO UTENTI VALUES(?,?,?,?,?);";
			String query2 = "INSERT INTO CONTO VALUES(?,?)";
							
			PreparedStatement st1 = conn.prepareStatement(query1);
			st1.setString(1, u.getNome());
			st1.setString(2,  u.getCognome());
			st1.setString(3, u.getUsername());
			st1.setInt(4, 1);
			st1.setString(5, u.getPassword());
			st1.executeUpdate();
			PreparedStatement st2 = conn.prepareStatement(query2);
			st2.setString(1, u.getUsername());
			st2.setInt(2,0);
			st2.executeUpdate();
			DBConn.closeConnection(conn);
			return reg;
		}
}
