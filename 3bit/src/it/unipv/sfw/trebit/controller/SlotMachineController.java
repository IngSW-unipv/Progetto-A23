package it.unipv.sfw.trebit.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.model.game.games.SlotMachine;


public class SlotMachineController extends Controller{
	
	private final Conto conto;
	private final SlotMachineView view;
	private SlotMachine s = new SlotMachine();
	private int outcome;
	private int[] result;
	private int bet;
	
	
	public SlotMachineController(Conto conto, SlotMachineView view) {
		
		this.conto = conto;
		this.view = view;
		
		result=new int[4];
		
		//all'inizio sono nulli bet e outcome
		bet=0;
		outcome=0;
		
		
		
		setListeners();
		
	}
	
	
	
	public void initView() throws SQLException {
		
		//impostazioni all'apertura della view 
		this.view.setSaldo2Text(Double.toString(facade.getSaldoByConto(conto)));
		this.view.setBet2Text(Integer.toString(bet));
		this.view.setLastWinText(Integer.toString(outcome));
		
	}

	
	
	public void setListeners() {
		
		
		view.getButtonBackHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.dispose();

				HomeController h = new HomeController(conto, mv.getHomeView());
				//h.initView();

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
					
					try {

						//metodi per modificare il conto con il risultato 
						if(outcome>0)
							facade.deposita(conto, outcome);

						else
							facade.preleva(conto, outcome*(-1));
						
					}  catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
					//imposta le immagini del risultato nei box 
					//result[1,2,3] sono i valori int dellimmagine da scegliere per ogni box
					view.setBoxes(result);
					
					//imposta l'ultima vincita/perdita
					view.setLastWinText(Integer.toString(outcome));
				
					//imposta il saldo modificato
					try {

						view.setSaldo2Text(Double.toString(facade.getSaldoByConto(conto)));

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					//imposta la puntata a zero
					bet=0;
					view.setBet2Text(Integer.toString(bet));
				
				}
			}
			
		});
		
		
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					//aumenta la puntata solo se il saldo è maggiore della puntata
					if(facade.getSaldoByConto(conto) > s.getBet()) {

						//aggiunge un valore alla puntata
						bet=s.addCoin();

						//imposta la puntata modificata
						view.setBet2Text(Integer.toString(bet));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//toglie un valore alla puntata
				bet=s.subCoin();
				
				//imposta la puntata modificata
				view.setBet2Text(Integer.toString(bet));
				
				
			}
			
		});
	}
	

}

