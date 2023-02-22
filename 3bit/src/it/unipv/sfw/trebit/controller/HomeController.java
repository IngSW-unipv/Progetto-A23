package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import it.unipv.sfw.trebit.conto.Conto;
import it.unipv.sfw.trebit.controller.masterController.MasterController;
import it.unipv.sfw.trebit.exception.YouCantChooseTheGame;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.SlotMachineView;
import it.unipv.sfw.trebit.view.WheelOfFortuneView;

public class HomeController {
	
	private final Conto conto;
	private final HomeView homeView;
	
	public HomeController(Conto conto, HomeView homeView) {
		
		this.conto = conto;
		this.homeView = homeView;
				
		setListeners();
		
	}
	
	public void initView() {

		this.homeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.homeView.setSaldoText(Double.toString(conto.getSaldo()));
		this.homeView.setVisible(true);

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

					SlotMachineController smc = MasterController.getInstance().getSlotMachineController();
					smc.initView();
					
					homeView.setVisible(false);

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
					
					WheelOfFortuneController wfc = MasterController.getInstance().getWheelOfFortuneController();
					wfc.initView();
					
					homeView.setVisible(false);
					
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
