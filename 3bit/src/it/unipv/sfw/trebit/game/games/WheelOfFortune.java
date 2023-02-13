package it.unipv.sfw.trebit.game.games;

public class WheelOfFortune implements IGames{
	
	private int numCasual;
	double[] result= {};
	
	
	public double[] turn(int chosenSymbol) {
				
		
		
		//generazione casuale dello spostamento (rispetto al punto iniziale)
		numCasual=(int) Math.random()*11;				//*11 simboli nella sequenza --> <0.0;1.0> * 11 genera lo spostamento
		result[1]=numCasual;
		
		switch(chosenSymbol) {
		case 0:
			if(numCasual==0)
				result[0]=14;
			else
				result[0]=0;
		case 1:
			if(numCasual%2==1)
				result[0]=2;
			else
				result[0]=0;
		case 2:
			if(numCasual%2==0 && numCasual!=0)
				result[0]=2;
			else
				result[0]=0;
		}
		
		return result;
		
	}
	
}
