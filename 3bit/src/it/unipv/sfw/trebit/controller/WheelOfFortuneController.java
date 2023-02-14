package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;

public class WheelOfFortuneController {
	
	private Conto c;
	private WheelOfFortuneView view;
	
	public WheelOfFortuneController(Conto c, WheelOfFortuneView view) {
		
		this.c = c;
		this.view = view;
				
		setListeners();
		
	}
		
	public void setListeners() {
		
		view.getButtonBackHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*da modificare per problema di accoppiamento e coesione*/
				HomeView h = new HomeView();
				h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				h.setSaldoText(Double.toString(c.getSaldo()));
				h.setVisible(true);
				
			}
			
		});
		
		view.getButtonImg1().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		view.getButtonImg2().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		view.getButtonImg3().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		view.getButtonSpin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		view.getButtonAddCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
		view.getButtonSubCoin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		});
		
	}
	
}
