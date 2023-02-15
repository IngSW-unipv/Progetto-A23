package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.conto.Conto;
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
				/*da modificare per problema di accoppiamento e coesione*/
				SlotMachineView s = new SlotMachineView();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//s.setSaldoText(Double.toString(conto.getSaldo()));
				s.setVisible(true);
				
			}
			
		});
		
		view.getButtonPlayRuota().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				WheelOfFortuneView w = new WheelOfFortuneView();
				WheelOfFortuneController wfc = new WheelOfFortuneController(conto, w);
				wfc.initView();
				
			}
			
		});
		
	}
	
}
