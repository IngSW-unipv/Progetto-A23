package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.view.masterView.MasterView;

public abstract class Controller {
	
	protected MasterView mv = MasterView.getInstance();
	
	public Controller() {
	}
}
