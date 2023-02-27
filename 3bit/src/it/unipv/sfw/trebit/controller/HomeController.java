package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.unipv.sfw.trebit.exception.YouCantChooseTheGame;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.masterView.*;

public class HomeController {
	
	private final Conto conto;
	private final HomeView homeView;
	
	public HomeController(Conto conto, HomeView homeView) {
		
		this.conto = conto;
		this.homeView = homeView;
				
		setListeners();
		
	}
	
	public void initView() {

		this.homeView.setSaldoText(Double.toString(conto.getSaldo()));

	}
		
	public void setListeners() {
		
		homeView.getButtonDeposita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					conto.deposita(Double.parseDouble(homeView.getAmountText()));
					
					homeView.setAmountText();
					homeView.setSaldoText(Double.toString(conto.getSaldo()));
					
				} catch(NumberFormatException exception) {
					homeView.popUp("ERRORE! Inserire un numero positivo e riprovare");
				}
				
			}
			
		});
		
		homeView.getButtonPreleva().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					conto.preleva(Double.parseDouble(homeView.getAmountText()));
					
					homeView.setAmountText();
					homeView.setSaldoText(Double.toString(conto.getSaldo()));
					
				} catch(NumberFormatException exception) {
					homeView.popUp("ERRORE! Inserire un numero positivo e riprovare");
				}
				
			}
			
		});
		
		homeView.getButtonPlaySlot().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					checkSaldo();
					
					homeView.dispose();

					SlotMachineController smc = new SlotMachineController(conto, MasterView.getInstance().getSlotMachineView());
					smc.initView();

				} catch (YouCantChooseTheGame e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		homeView.getButtonPlayRuota().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					checkSaldo();
					
					homeView.dispose();
					
					WheelOfFortuneController wfc = new WheelOfFortuneController(conto, MasterView.getInstance().getWheelOfFortuneView());
					wfc.initView();
					
				} catch (YouCantChooseTheGame e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	private void checkSaldo() throws YouCantChooseTheGame {
		
		if(conto.getSaldo() == 0) {
			throw new YouCantChooseTheGame(homeView);
		}
		
	}
	
}
