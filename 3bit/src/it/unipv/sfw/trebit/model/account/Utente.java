package it.unipv.sfw.trebit.model.account;

public class Utente extends Persona{
	
	private String username;
	private String password;
	
	public Utente(String nome, String cognome, String username, String password) {
		super(nome, cognome);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setNome(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + username + ", password=" + password + "]";
	}
}

