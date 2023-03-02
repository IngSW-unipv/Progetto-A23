package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;


public class HomeView extends JFrame {

	private JLabel label;
	private JLabel saldo;
	private JButton logout;
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
		northPanel.setBackground(new Color(49, 171, 24));
		add(northPanel, BorderLayout.NORTH);
		
		label = new JLabel("Scegli una delle seguenti operazioni:");
		northPanel.add(label);
		
		
		
		JPanel eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		
		logout = new JButton("Logout");
		logout.setActionCommand("Logout");
		eastPanel.add(logout);
		
		saldo = new JLabel("il tuo saldo: €");
		eastPanel.add(saldo);
		
		
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2, 1));
		add(southPanel, BorderLayout.SOUTH);
		
		importo = new JLabel("Scegli l'importo:");
		southPanel.add(importo);
		
		amount = new JTextField();
		southPanel.add(amount);
		
		deposita = new JButton("Deposita");
		deposita.setActionCommand("deposita");
		southPanel.add(deposita);
		
		preleva = new JButton("preleva");
		preleva.setActionCommand("preleva");
		southPanel.add(preleva);
		
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 2));
		add(centerPanel, BorderLayout.CENTER);
		
		Icon image = new ImageIcon(getClass().getResource("slotGif.gif"));
		slotMachine = new JLabel(image);
		centerPanel.add(slotMachine);
		
		Icon image2 = new ImageIcon(getClass().getResource("wheelGif1.gif"));
		ruotaDellaFortuna = new JLabel(image2);
		centerPanel.add(ruotaDellaFortuna);
		
		playSlot = new JButton("Play Slot Machine");
		playSlot.setActionCommand("playSlot");
		centerPanel.add(playSlot);
		
		playRuota = new JButton("Play Ruota della Fortuna");
		playRuota.setActionCommand("playRuota");
		centerPanel.add(playRuota);
		
	}
	
	public void setSaldoText(String text) {
		saldo.setText("il tuo saldo: € " + text);
	}
	
	public JButton getButtonLogout() {
		return logout;
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
	
	public void popUp(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}