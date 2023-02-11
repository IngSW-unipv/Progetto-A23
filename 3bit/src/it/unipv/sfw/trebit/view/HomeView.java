package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;


public class HomeView extends JFrame {

	private JLabel label;
	private JLabel saldo;
	private JLabel importo;
	private JTextField amount;
	private JButton deposita;
	private JButton preleva;
	private JLabel slotMachine;
	private JLabel ruotaDellaFortuna;
	private JButton playSlot;
	private JButton playRuota;


	public HomeView() {
		
		setLayout(new BorderLayout());
		setSize(400, 300);
		
		
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		label = new JLabel("Scegli una delle seguenti operazioni:");
		northPanel.add(label);
		
		
		
		JPanel eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		
		saldo = new JLabel("il tuo saldo: € ");
		eastPanel.add(saldo);
		
		
		
		JPanel westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		//westPanel.setLayout(new GridLayout(2, 1));
		
		importo = new JLabel("Scegli l'importo:");
		westPanel.add(importo);
		
		amount = new JTextField();
		westPanel.add(amount);
		amount.setColumns(4);
		
		deposita = new JButton("Deposita");
		deposita.setActionCommand("deposita");
		westPanel.add(deposita);
		
		preleva = new JButton("preleva");
		preleva.setActionCommand("preleva");
		westPanel.add(preleva);
		
		
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		slotMachine = new JLabel();
		centerPanel.add(slotMachine);
		
		ruotaDellaFortuna = new JLabel();
		centerPanel.add(ruotaDellaFortuna);
		
		playSlot = new JButton("sss");
		playSlot.setActionCommand("playSlot");
		centerPanel.add(playSlot);
		
		playRuota = new JButton("ddd");
		playRuota.setActionCommand("playRuota");
		centerPanel.add(playRuota);
		
	}
	
	public void setSaldoText(String text) {
		saldo.setText("il tuo saldo: € " + text);
	}
	
	public String getAmountText() {
		return amount.getText();
	}
	
	public void setAmountText() {
		amount.setText(null);
	}
	
	public JButton getButtonDeposita() {
		return deposita;
	}
	
	public JButton getButtonPreleva() {
		return preleva;
	}
	
	public JButton getButtonPlaySlot() {
		return playSlot;
	}
	
	public JButton getButtonPlayRuota() {
		return playRuota;
	}

}