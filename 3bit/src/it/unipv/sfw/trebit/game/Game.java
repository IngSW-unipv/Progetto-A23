package it.unipv.sfw.trebit.game;

import it.unipv.sfw.trebit.game.games.SlotMachine;
import it.unipv.sfw.trebit.game.games.WheelOfFortune;
import it.unipv.sfw.trebit.game.multiplier.MultiplierContext;

public class Game {
	private double multiplier;
	private int win;
	
	
	public double play(double bet, int chosenGame, int extra) {		
		//istanza di m (MultiplierContext)
		MultiplierContext m = new MultiplierContext();   
		multiplier=m.getMultiplier();
		
		win=choseGame(chosenGame, extra);
		
		return win*multiplier*bet-bet;
	}
	
	
	public int choseGame(int chosenGame, int e) {
		
		switch(chosenGame) {
		case 1:
			//istanza di s (SlotMachine)
			SlotMachine s=new SlotMachine();
			return s.turn(e);
		case 2:
			//istanza di W (WheelOfFortune)
			WheelOfFortune w=new WheelOfFortune();
			return w.turn(e);
		}
		
		return 0;
	}
}












//devi togliere tutti i commenti prima di dire che è giusto

//cose da fare:
//1) due giochi con interfaccia				FATTI 		(mi da ancora errore l'istanza .....)
//!!!!!!!!									MANCA IL METODO CHE RITORNA AL CONTROLLER LO SPOSTAMENTO DEI SIMBOLI
//2) moltiplicatore con strategy








