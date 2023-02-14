package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;

public class HomeController {
	
	private Conto c;
	private HomeView view;
	
	public HomeController(Conto c, HomeView view) {
		
		this.c = c;
		this.view = view;
				
		setListeners();
		
	}
		
	public void setListeners() {
		
		view.getButtonDeposita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				c.deposita(Double.parseDouble(view.getAmountText()));
				
				view.setAmountText();
				view.setSaldoText(Double.toString(c.getSaldo()));
				
			}
			
		});
		
		view.getButtonPreleva().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				c.preleva(Double.parseDouble(view.getAmountText()));
				
				view.setAmountText();
				view.setSaldoText(Double.toString(c.getSaldo()));
				
			}
			
		});
		
		view.getButtonPlaySlot().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*da modificare per problema di accoppiamento e coesione*/
				SlotMachineView s = new SlotMachineView();
				s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				s.setVisible(true);
				
			}
			
		});
		
		view.getButtonPlayRuota().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*da modificare per problema di accoppiamento e coesione*/
				WheelOfFortuneView w = new WheelOfFortuneView();
				w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				w.setVisible(true);
				
			}
			
		});
		
	}
	
}
