package it.unipv.sfw.trebit.game;

import it.unipv.sfw.trebit.game.games.SlotMachine;
import it.unipv.sfw.trebit.game.games.WheelOfFortune;
import it.unipv.sfw.trebit.game.multiplier.MultiplierContext;

public class Game {
	private double multiplier;
	private double win;
	double[] result= {};

	
	
	public double[] play(double bet, int chosenGame, int extra) {	
		double[] result= {};
		//istanza di m (MultiplierContext)
		MultiplierContext m = new MultiplierContext();   
		multiplier=m.getMultiplier();
		
		result=choseGame(chosenGame, extra);
		win=result[0];
		result[0]=win*multiplier*bet-bet;
		
		
		return result;
	}
	
	
	public double[] choseGame(int chosenGame, int e) {
		
		switch(chosenGame) {
		case 1:
			//istanza di s (SlotMachine)
			SlotMachine s=new SlotMachine();
			result=s.turn(e);
			
		case 2:
			//istanza di W (WheelOfFortune)
			WheelOfFortune w=new WheelOfFortune();
			result=w.turn(e);
			
		}
		
		return result;
	}
}












//devi togliere tutti i commenti prima di dire che è giusto









