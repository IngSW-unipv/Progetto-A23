package it.unipv.sfw.trebit.model.account;

public abstract class Persona {
	
	private String nome, cognome;
	
	public Persona(String n, String c) {
		this.setNome(n);
		this.setCognome(c);
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
