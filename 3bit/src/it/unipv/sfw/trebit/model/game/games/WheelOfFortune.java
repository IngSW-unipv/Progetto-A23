package it.unipv.sfw.trebit.model.game.games;

import it.unipv.sfw.trebit.model.game.multiplier.MultiplierContext;

public class WheelOfFortune implements IGames{
	
	private int numCasual;
	private double[] result= {};
	private double coin;
	private double win;
	private double multiplier;
	
	public WheelOfFortune() {
		coin=0;
	}
	
	
	public double[] turn(int chosenSymbol) {
		
		//istanza del moltiplicatore e chiamata al metodo che restituisce il moltiplicatore
		MultiplierContext m=MultiplierContext.getInstance();		
		multiplier=m.getMultiplier();
		
		//generazione casuale dello spostamento (rispetto al punto iniziale)
		numCasual=(int) Math.random()*11;				//*11 simboli nella sequenza --> <0.0;1.0> * 11 genera lo spostamento
		result[1]=numCasual;
		
		//victoryCase è il metodo del caso di vittoria (restituisce 0 se si perde)
		win=victoryCase(numCasual, chosenSymbol);
		
		//formula calcolo vincita/perdita
		result[0]=win*multiplier*coin-coin;
		
		//puntata che viene impostata a zero ogni volta che finisce un turno
		coin=0;
		return result;
		
	}
	
	//caso vittoria:	simboli generato (numCasual) uguale al simbolo scelto (chosenSymbol) 
	public int victoryCase(int numCasual,int chosenSymbol) {
		
		switch(chosenSymbol) {
		case 1:
			if(numCasual==0)
				return 14;
			else
				return 0;
		case 2:
			if(numCasual%2==1)
				return 2;
			else
				return 0;
		case 3:
			if(numCasual%2==0 && numCasual!=0)
				return 2;
			else
				return 0;
		}
		
		return 0;
	}
	
	
	public double subCoin() {
		
		//se la puntata è maggiore di zero si può abbassare di un valore
		if(coin>0)
			coin--;
		
		return coin;
	}
	
	public double addCoin() {
		
		//aumenta di un valore la puntata
		coin++;
		
		return coin;
		
	}
	
	public double getBet() {
		return coin;
	}
}
