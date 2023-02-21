package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.controller.masterController.MasterController;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;

public class HomeController {
	
	private final Conto conto;
	private final HomeView view;
	
	public HomeController(Conto conto, HomeView view) {
		
		this.conto = conto;
		this.view = view;
				
		setListeners();
		
	}
		
	public void setListeners() {
		
		view.getButtonDeposita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				conto.deposita(Double.parseDouble(view.getAmountText()));
				
				view.setAmountText();
				view.setSaldoText(Double.toString(conto.getSaldo()));
				
			}
			
		});
		
		view.getButtonPreleva().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				conto.preleva(Double.parseDouble(view.getAmountText()));
				
				view.setAmountText();
				view.setSaldoText(Double.toString(conto.getSaldo()));
				
			}
			
		});
		
		view.getButtonPlaySlot().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SlotMachineController smc = MasterController.getInstance().getSlotMachineController();
				smc.initView();
				
			}
			
		});
		
		view.getButtonPlayRuota().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				WheelOfFortuneController wfc = MasterController.getInstance().getWheelOfFortuneController();
				wfc.initView();
				
			}
			
		});
		
	}
	
}
