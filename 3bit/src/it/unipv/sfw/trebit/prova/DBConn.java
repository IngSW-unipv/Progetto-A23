package it.unipv.sfw.trebit.prova;

import java.sql.*;

public class DBConn {
	public static void main(String[] args) throws SQLException {
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

			cn = DriverManager.getConnection("jdbc:mysql://34.154.119.106:3306/PROVA?user=root&password=e");
	
		sql = "SELECT * FROM UTENTI;";
		// ________________________________query
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true)
				System.out.println(rs.getInt("ID") + "\t" + rs.getString("USERNAME") + "\t" + rs.getString("PW"));
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		cn.close(); // chiusura connessione
	}// fine main
}
