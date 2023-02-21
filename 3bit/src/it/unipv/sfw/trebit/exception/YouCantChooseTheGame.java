package it.unipv.sfw.trebit.exception;

import it.unipv.sfw.trebit.view.HomeView;

public class YouCantChooseTheGame extends Exception {
	
	private static String message = "Depositare denaro sul conto per poter giocare";

	public YouCantChooseTheGame(HomeView homeView) {
		super(message);
		homeView.popUp(message);
	}
	
}
