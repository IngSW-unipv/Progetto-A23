package it.unipv.sfw.trebit.game.games;

public class WheelOfFortune implements IGames{
	
	private int numCasual;
	
	public WheelOfFortune() {
	}
	
	public int turn(int chosenSymbol) {
				
		
		
		//generazione casuale dello spostamento (rispetto al punto iniziale)
		numCasual=(int) Math.random()*11;				//*11 simboli nella sequenza --> <0.0;1.0> * 11 genera lo spostamento
		
		
		switch(chosenSymbol) {
		case 0:
			if(numCasual==0)
				return 14;
			else
				return 0;
		case 1:
			if(numCasual%2==1)
				return 2;
			else
				return 0;
		case 2:
			if(numCasual%2==0 && numCasual!=0)
				return 2;
			else
				return 0;
		}
		return 0;				//così ritorna sempre qualcosa e non da errore
		
	}
	
}
