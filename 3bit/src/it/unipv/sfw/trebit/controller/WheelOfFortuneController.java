package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;
import it.unipv.sfw.trebit.model.game.games.WheelOfFortune;

public class WheelOfFortuneController extends Controller{
	
	private Conto conto;
	private WheelOfFortuneView view;
	private WheelOfFortune w=new WheelOfFortune();;
	private int symbol;
	int[] result;
	private int outcome;
	private int bet;

	
	public WheelOfFortuneController(Conto conto, WheelOfFortuneView view) {
		
		this.conto = conto;
		this.view = view;
		
		result=new int[4];
		
		//all'inizio sono nulli bet, outcome e symbol
		bet=0;
		outcome=0;
		symbol=0;
		
		setListeners();
		
	}
	
	public void initView() {
		
		
		//impostazioni all'apertura della view 
		this.view.setSaldo2Text(Double.toString(conto.getSaldo()));
		this.view.setBet2Text(Integer.toString(bet));
		this.view.setLastWinText(Integer.toString(outcome));
		
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
		
		view.getButtonImg1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//imposta il simbolo scelto (1)
				symbol=1;
				
			}
			
		});
		
		view.getButtonImg2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//imposta il simbolo scelto (2)
				symbol=2;
				
			}
			
		});
		
		view.getButtonImg3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//imposta il simbolo scelto (3)
				symbol=3;
				
			}
			
		});
		
		view.getButtonSpin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//verifica che la puntata sia diversa da zero e che si sia impostato un simbolo 
				if(view.getBet2()!="0" && symbol!=0){
					
					//richiama metodo del model in cui si simula il gioco passando come argomento il simbolo scelto
					result=w.turn(symbol);
				
					//result[0] è la vincita/perdita
					outcome=result[0];
				
				
					//metodi per modificare il conto con il risultato 
					if(outcome>0)
						conto.deposita((double)outcome);
					else
						conto.preleva((double)outcome*(-1));
				
				
					//imposta la gif (simulazione) del risultato
					//result[1] è il valore int che rappresenta la gif da scegliere
					view.setWheel(result[1]);
					
					//imposta l'ultima vincita/perdita
					view.setLastWinText(Integer.toString(outcome));
				
					//imposta il saldo modificato
					view.setSaldo2Text(Double.toString(conto.getSaldo()));
				
					//imposta la puntata a zero
					bet=0;
					view.setBet2Text(Integer.toString(bet));
				}
			}
			
		});
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//aumenta la puntata solo se il saldo è maggiore della puntata
				if(conto.getSaldo() > w.getBet()) {
					
					//aggiunge un valore alla puntata
					bet=w.addCoin();
				
					//imposta la puntata modificata
					view.setBet2Text(Integer.toString(bet));
				}
				
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//toglie un valore alla puntata
				bet=w.subCoin();
				view.setBet2Text(Integer.toString(bet));
				
				
			}
			
		});
		
	}
	
}
