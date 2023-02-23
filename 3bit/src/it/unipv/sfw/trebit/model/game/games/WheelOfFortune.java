package it.unipv.sfw.trebit.model.game.games;

import it.unipv.sfw.trebit.model.game.multiplier.MultiplierContext;

public class WheelOfFortune implements IGames{
	
	private int numCasual;
	double[] result= {};
	private int coin;
	private double win;
	private double multiplier;
	
	public WheelOfFortune() {
		coin=0;
	}
	
	
	public double[] turn(int chosenSymbol) {
		
		MultiplierContext m=MultiplierContext.getInstance();		
		multiplier=m.getMultiplier();
		
		//generazione casuale dello spostamento (rispetto al punto iniziale)
		numCasual=(int) Math.random()*11;				//*11 simboli nella sequenza --> <0.0;1.0> * 11 genera lo spostamento
		result[1]=numCasual;
		
		switch(chosenSymbol) {
		case 0:
			if(numCasual==0)
				win=14;
			else
				win=0;
		case 1:
			if(numCasual%2==1)
				win=2;
			else
				win=0;
		case 2:
			if(numCasual%2==0 && numCasual!=0)
				win=2;
			else
				win=0;
		}
		
		result[0]=win*multiplier*coin-coin;
		
		return result;
		
	}
	
	
	public void subCoin() {
		if(coin>0)
			coin--;
	}
	
	public void addCoin() {
		coin++;
	}
}
