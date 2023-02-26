package it.unipv.sfw.trebit.model;

public class Conto {

	private String username;
	private double saldo;
	

	public Conto(String username, double saldo) {

		this.saldo = saldo;
		this.setUsername(username);

	}

	public boolean deposita(double amount) {

		if(amount < 0) {

			return false;

		}

		else {

			this.saldo = this.saldo + amount;

			return true;

		}

	}

	public boolean preleva(double amount) {

		if(this.saldo == 0 || amount < 0 || amount > this.saldo) {

			return false;

		}

		else {

			this.saldo = this.saldo - amount;

			return true;

		}

	}

	public double getSaldo() {

		return this.saldo;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}