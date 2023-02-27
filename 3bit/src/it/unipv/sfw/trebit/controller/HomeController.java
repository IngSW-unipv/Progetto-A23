package it.unipv.sfw.trebit.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import it.unipv.sfw.trebit.database.DBFacade;
import it.unipv.sfw.trebit.exception.YouCantChooseTheGame;
import it.unipv.sfw.trebit.model.Conto;
import it.unipv.sfw.trebit.model.account.Utente;
import it.unipv.sfw.trebit.view.HomeView;
import it.unipv.sfw.trebit.view.masterView.*;

public class HomeController {
	
	private Conto conto;
	private final HomeView homeView;
	private MasterView mv = MasterView.getInstance();
	private DBFacade facade = DBFacade.getInstance();
	
	public HomeController(Conto conto, HomeView homeView) {
		
		this.conto = conto;
		this.homeView = homeView;
		
		setListeners();
		
	}
	
	public void initView(Utente u) throws SQLException {

		this.homeView.setSaldoText(Double.toString(facade.getSaldoByUsername(u)));

	}
		
	public void setListeners() {
		
		homeView.getButtonDeposita().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						facade.deposita(conto, Double.parseDouble(homeView.getAmountText()));
						homeView.setSaldoText(Double.toString(facade.getSaldoByConto(conto)));
					} catch(NumberFormatException exception) {
						homeView.popUp("ERRORE! Inserire un numero positivo e riprovare");
					} 
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
			}
			
		});
		
		homeView.getButtonPreleva().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					facade.preleva(conto, Double.parseDouble(homeView.getAmountText()));
					homeView.setSaldoText(Double.toString(facade.getSaldoByConto(conto)));
					
				} catch(NumberFormatException exception) {
					homeView.popUp("ERRORE! Inserire un numero positivo e riprovare");
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		homeView.getButtonPlaySlot().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					checkSaldo();
					
					homeView.dispose();

					SlotMachineController smc = new SlotMachineController(conto, mv.getSlotMachineView());
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
					
					WheelOfFortuneController wfc = new WheelOfFortuneController(conto, mv.getWheelOfFortuneView());
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
