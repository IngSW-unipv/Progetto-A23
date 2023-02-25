package it.unipv.sfw.trebit.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.model.game.games.SlotMachine;


public class SlotMachineController {
	
	private final Conto conto;
	private final SlotMachineView view;
	private SlotMachine s;
	private double outcome;
	private double[] result= {};
	private double bet;
	
	
	public SlotMachineController(Conto conto, SlotMachineView view) {
		
		this.conto = conto;
		this.view = view;
		
		
		//all'inizio sono nulli bet e outcome
		bet=0;
		outcome=0;
		
		
		SlotMachine w=new SlotMachine();
		
		setListeners();
		
	}
	
	
	
	public void initView() {
		
		//impostazioni all'apertura della view 
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
				
				//verifica che la puntata sia diversa da zero
				if(view.getBet2() != "0"){
					
					//serve perchè se no non segue l'interfaccia IGame
					int uselessVariable=0;
					
					//richiama metodo del model in cui si simula il gioco
					result=s.turn(uselessVariable);
				
					//result[0] è la vincita/perdita
					outcome=result[0];
				
					//metodi per modificare il conto con il risultato 
					if(outcome>0)
						conto.deposita(outcome);
					else
						conto.preleva(outcome*(-1));
				
				
					//imposta le immagini del risultato nei box 
					//result[1,2,3] sono i valori int dellimmagine da scegliere per ogni box
					view.setBoxes(result);
					
					//imposta l'ultima vincita/perdita
					view.setLastWinText(Double.toString(outcome));
				
					//imposta il saldo modificato
					view.setSaldo2Text(Double.toString(conto.getSaldo()));
				
					//imposta la puntata a zero
					bet=0;
					view.setBet2Text(Double.toString(bet));
				
				}
			}
			
		});
		
		
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//aggiunge un valore alla puntata
				bet=s.addCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//toglie un valore alla puntata
				bet=s.subCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
	}
	

}

