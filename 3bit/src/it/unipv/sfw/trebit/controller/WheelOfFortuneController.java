package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;
import it.unipv.sfw.trebit.model.game.games.WheelOfFortune;

public class WheelOfFortuneController {
	
	private Conto conto;
	private WheelOfFortuneView view;
	private WheelOfFortune w;
	private int symbol;
	double[] result= {};
	private double outcome;
	private double bet;

	
	public WheelOfFortuneController(Conto conto, WheelOfFortuneView view) {
		
		this.conto = conto;
		this.view = view;
		
		bet=0;
		outcome=0;
		
		
		WheelOfFortune w=new WheelOfFortune();
		
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
		
		view.getButtonImg1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				symbol=1;
				
			}
			
		});
		
		view.getButtonImg2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				symbol=2;
				
			}
			
		});
		
		view.getButtonImg3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				symbol=3;
				
			}
			
		});
		
		view.getButtonSpin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//cosa succede se non si è impostato nessun symbol?????
				
				result=w.turn(symbol);
				
				outcome=result[0];
				
				
				if(outcome>0)
					conto.deposita(outcome);
				else
					conto.preleva(outcome*(-1));
				
				
				
				view.setWheel((int) result[1]);
				view.setLastWinText(Double.toString(outcome));
				
				view.setSaldo2Text(Double.toString(conto.getSaldo()));
				
				bet=0;
				view.setBet2Text(Double.toString(bet));
			}
			
		});
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bet=w.addCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bet=w.subCoin();
				view.setBet2Text(Double.toString(bet));
				
				
			}
			
		});
		
	}
	
}
