package it.unipv.sfw.trebit.game;

public class Game {

	public Game() {
	multiplier=1;
	chosenGame=0;			//forse non serve dipende da sotto
	win=0;					//forse non serve dipende da sotto
	
	
	
	VictoryStrategy v = new VictoryStrategy   //da capire bene come metterlo giù e se metterlo qui
	}
	
	
	
	
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
	
	
	
	
	
	
	public play(double bet, int chosenGame) {			//metodo chiamato da Casino!!!
		
	//forse non servono	
	//	super();								//non sono molto convinto si faccia così
	//	this.bet=bet;							//non sono molto convinto si faccia così, però serve 
	//	this.chosenGame=chosenGame;				//non sono molto convinto si faccia così, però serve 
	
		VictoryStrategy v = new VictoryStrategy   //da capire bene come metterlo giù e se metterlo qui
		multiplier=v.getMultiplier();
		
		win=choseGame(chosenGame);
		
		return win*multiplier-bet;
	}
	
	
	public choseGame(int chosenGame) {
		
	}
		switch(chosenGame) {
		case 1:
			//istanza di S (SlotMachine)
			return S.turn();
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
		case 2:
			//istanza di W (WheelOfFortune)
			return W.turn();
			break;					//forse non serve il break dato che prima c'è un return e quindi esce a prescindere
	}
}












//devi togliere tutti i commenti prima di dire che è giusto

//cose da fare:
//1) due giochi con interfaccia
//2) moltiplicatore con strategy








