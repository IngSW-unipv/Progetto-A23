package it.unipv.sfw.trebit.casino;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.game.Game;
import it.unipv.sfw.trebit.database.*;

public class Casino {
	private double[] result;
	private double outcome;
	
	
	public boolean setConto(/*argomenti per comunicare con il database (credo siano username e password)*/) {
		//istanza database 
		saldo=//metodo di database che ritorna il saldo dell'utente
		Conto c=new Conto(double saldo);
		return true;
	}
	
	public double[] playGame(double bet, int chosenGame, int extra) {
		
//		if(c.getSaldo<bet)
//			throw exception
		
		
		Game g=new Game();
		result=g.play(bet, chosenGame, extra);
		outcome=result[0];
		
		
		//al posto della if:	outcome>0?c.deposita(outcome):c.preleva(outcome*(-1));		
		if(outcome>0)
			c.deposita(outcome);
		else
			c.preleva(outcome*(-1));
		
				
		return result;
			
		
	}

}
