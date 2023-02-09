package it.unipv.sfw.trebit.conto;

public class Conto {

	private double saldo;

	public Conto(double s) {

		this.saldo = s;

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

}