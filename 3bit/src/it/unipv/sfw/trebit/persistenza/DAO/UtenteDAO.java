package it.unipv.sfw.trebit.persistenza.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unipv.sfw.trebit.utente.Utente;

public class UtenteDAO {

		private Connection conn;
		
		public UtenteDAO() {
			super();
		}
		public boolean login(Utente u) throws SQLException {
			conn = DriverManager.getConnection("jdbc:mysql://34.154.119.106:3306/PROVA?user=root&password=e");
			PreparedStatement st1;
			ResultSet result;
			String query = "SELECT PW FROM UTENTI WHERE USERNAME=?;";
			st1 = conn.prepareStatement(query);
			st1.setString(1, u.getNome());
			result=st1.executeQuery();
			boolean log = false;
			if( result.next() && result.getString("psw").equals(u.getPassword())) {
				log = true;
			}	
			conn.close();
			return log;
		}
		
		public void registrazione(Utente u) throws SQLException{
			conn = DriverManager.getConnection("jdbc:mysql://34.154.119.106:3306/PROVA?user=root&password=e");
			String query = "INSERT INTO UTENTI VALUES(?,?)";
			PreparedStatement st1 = conn.prepareStatement(query);
			st1.setString(1, u.getNome());
			st1.setString(2, u.getPassword());
			st1.executeUpdate();
			conn.close();
		}
}
