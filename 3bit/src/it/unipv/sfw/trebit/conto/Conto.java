package it.unipv.sfw.trebit.conto;

public class Conto {

	private double saldo;

	public Conto(double s) {

		this.saldo = s;

	}

	public boolean deposita(double cifra) {

		if(cifra < 0) {

			return false;

		}

		else {

			this.saldo = this.saldo + cifra;

			return true;

		}

	}

	public boolean preleva(double cifra) throws Exception {

		if(this.saldo == 0 || cifra < 0 || cifra > this.saldo) {

			return false;

		}

		else {

			this.saldo = this.saldo - cifra;

			return true;

		}

	}

	public double getSaldo() {

		return this.saldo;

	}

}