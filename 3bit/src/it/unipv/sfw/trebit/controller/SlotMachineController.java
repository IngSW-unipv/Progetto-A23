package it.unipv.sfw.trebit.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.model.game.games.SlotMachine;


public class SlotMachineController {
	
	private Conto conto;
	private SlotMachineView view;
	private SlotMachine s;
	private double outcome;
	private double[] result= {};
	private double bet;
	
	
	public SlotMachineController(Conto conto, SlotMachineView view) {
		
		this.conto = conto;
		this.view = view;
		
		bet=0;
		outcome=0;
		
		
		SlotMachine w=new SlotMachine();
		
		setListeners();
		
	}
	
	
	
	public void initView() {
		
		this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.view.setSaldo2Text(Double.toString(conto.getSaldo()));
		this.view.setBet2Text(Double.toString(bet));
		this.view.setLastWinText(Double.toString(outcome));
		this.view.setVisible(true);
		
	}

	
	
	public void setListeners() {
		
		
		view.getButtonBackHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*da modificare per problema di accoppiamento e coesione*/
				HomeView h = new HomeView();
				h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				h.setSaldoText(Double.toString(conto.getSaldo()));
				h.setVisible(true);
				
			}
			
		});
		
		
		view.getButtonSpin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//serve perchè se no non segue l'interfaccia IGame
				int uselessVariable=0;
				result=s.turn(uselessVariable);
				
				outcome=result[0];
				
				
				if(outcome>0)
					conto.deposita(outcome);
				else
					conto.preleva(outcome*(-1));
				
				
				view.setBoxes(result);
				view.setLastWinText(Double.toString(outcome));
				
				view.setSaldo2Text(Double.toString(conto.getSaldo()));
				
				bet=0;
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
		
		
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bet=s.addCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bet=s.subCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
	}
	

}

