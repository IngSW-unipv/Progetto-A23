package it.unipv.sfw.trebit.model.game.games;

import it.unipv.sfw.trebit.model.game.multiplier.MultiplierContext;

public class SlotMachine implements IGames {
	
	private int[] numCasual;
	private double[] result= {};
	private double multiplier;
	private double win;
	private double coin;
	
	
	
	public double[] turn(int uselessVariable) {
		
		//istanza del moltiplicatore e chiamata al metodo che restituisce il moltiplicatore
		MultiplierContext m=MultiplierContext.getInstance();
		multiplier=m.getMultiplier();
		
		
		// variabile inizializzata a 0 ogni volta che si inizia un turno (rappresenta la vincita/perdita)
		result[0]=0;		
		
		
		//generazione casuale spostamento di ogni colonna (tutti rispetto al punto iniziale)
		for(int i=0;i<3;i++) {
			numCasual[i]=(int) Math.random()*5;			//*5 simboli --> <0.0;1.0> * 5 genera lo spostamento
			result[i+1]=numCasual[i];
		}
		
		//victoryCase è il metodo del caso di vittoria (restituisce 0 se si perde)
		win=victoryCase(numCasual);
		
		//formula calcolo vincita/perdita
		result[0]=win*multiplier*coin-coin;
		
		//puntata che viene impostata a zero ogni volta che finisce un turno
		coin=0;
		
		return result;
		
		
	}
	
	
	//caso vittoria:	3 simboli uguali sulla stessa riga 
	public int victoryCase(int[] num) {
		
		//se le tre immagini (i valori casuali generati) sono uguali si vince se no si perde
		if(num[0]==num[1] && num[1]==num[2])
			return 5;
		else
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
	

