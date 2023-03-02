package it.unipv.sfw.trebit.model;

public class Conto {

	private String username;
	private double saldo;
	

	public Conto(String username, double saldo) {

		this.saldo = saldo;
		this.username = username;

	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getUsername() {
		return username;
	}

}