package it.unipv.sfw.trebit.controller;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.view.RegistrationView;
import it.unipv.sfw.trebit.view.SlotMachineView;

public class SlotMachineController {
	
	private final SlotMachineView sm;
	private DBFacade facade = DBFacade.getInstance();
	private Conto c;
	
	public SlotMachineController(Conto c, SlotMachineView sm) {
		this.sm = sm;	
		setListeners();
	}
	
	public void setListeners() {
		
	}
	
	public void initView() {
		
	}
}

