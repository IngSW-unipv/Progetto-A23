package it.unipv.sfw.trebit.game.games;

public class SlotMachine implements IGames {
	
	private int[] numCasual;
	private int win;
	
	
	public SlotMachine() {
		win=0;
	}
	
	public int turn(int extraUseless) {
		
		// variabile inizializzata a 0 ogni volta che si inizia un turno
		win=0;		
		
		
		//generazione casuale spostamento di ogni colonna (tutti rispetto al punto iniziale)
		for(int i=0;i<3;i++) {
			numCasual[i]=(int) Math.random()*5;			//*5 simboli --> <0.0;1.0> * 5 genera lo spostamento
		}
		
		//winX sono i metodi dei casi di vittoria (restituiscono 0 se si perde)
		win+=win1(numCasual);
		win+=win2(numCasual);
		win+=win3(numCasual);
		
		return win;
		
	}
	
	//caso vittoria 1:	3 simboli uguali sulla stessa riga 
	public int win1(int[] num) {
		if(num[0]==num[1] && num[1]==num[2])
			return 5;
		else
			return 0;
	}
	
	
	
	//caso vittoria 2:	3 simboli uguali sulla diagonale \
	public int win2(int[] num) {
		if(num[0]==num[1]+1 && num[1]==num[2]+2)
			return 3;
		else
			return 0;
	}
	
	
	
	//caso vittoria 3:	3 simboli uguali sulla diagonale / 
	public int win3(int[] num) {
		if(num[0]==num[1]-1 && num[1]==num[2]-2)
			return 3;
		else
			return 0;
	}

}
