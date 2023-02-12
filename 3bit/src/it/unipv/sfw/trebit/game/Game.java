package it.unipv.sfw.trebit.game;

public class Game {
	private double multiplier;
	private int win;

		
	
	
	/*
	public play(double bet, int chosenGame)
	
	multiplier=v.getMultiplier();
	//istanze dei due giochi   soluzione 1    S R		(non mi piace, in particolare se faccio il metodo choseGame)
	
	switch(chosenGame) {
	case 1: 
			//istanza gioco scelto soluzione 2    S		(forse è meglio così)
			win=S.turn();
			return bet-win*multiplier;
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
			
	case 2: 
			//istanza gioco scelto soluzione 2     R	(forse è meglio così)
			win=R.turn();
			return win*multiplier-bet;
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
	}
	
	
	//in caso di aggiunta di un gioco basta aggiungere un case
	//forse conviene creare un metodo choseGame che abbia al suo interno solo la switch così non metto tutto insieme
	//e l'aggiunta di un gioco non necessiterà di troppe modifiche (quantità di linee di codice)
	
	*/
	
	
	
	
	public double play(double bet, int chosenGame, int extra) {			//metodo chiamato da Casino!!!
		
	//forse non servono	
	//	super();								//non sono molto convinto si faccia così
	//	this.bet=bet;							//non sono molto convinto si faccia così, però serve 
	//	this.chosenGame=chosenGame;				//non sono molto convinto si faccia così, però serve 
	
		MultiplierContext m = new MultiplierContext();   //da capire bene come metterlo giù e se metterlo qui
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
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
		case 2:
			//istanza di W (WheelOfFortune)
			WheelOfFortune w=new WheelOfFortune();
			return w.turn(e);
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
		}
	}
}












//devi togliere tutti i commenti prima di dire che è giusto

//cose da fare:
//1) due giochi con interfaccia				FATTI 		(mi da ancora errore l'istanza .....)
//!!!!!!!!									MANCA IL METODO CHE RITORNA AL CONTROLLER LO SPOSTAMENTO DEI SIMBOLI
//2) moltiplicatore con strategy








