/*
package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class SlotMachineView extends JFrame {


	private JLabel titolo;
	private JLabel saldo1;
	private JLabel saldo2;
	private JLabel bet1;
	private JLabel bet2;
	private JLabel lastWin;
	private JButton addCoin;
	private JButton subCoin;
	private JButton backHome;
	private JButton spin;
	private JLabel box1;
	private JLabel box2;
	private JLabel box3;
	
	private Icon[] image;

	
	public SlotMachineView() {
		
		setSize(400, 300);
		setTitle("Slot-Machine");
		getContentPane().setLayout(null);

		
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBounds(0, 0, 400, 35);
		getContentPane().add(northPanel);
		
		titolo = new JLabel("Seleziona la tua puntata e vinci!");
		northPanel.add(titolo);
		
		backHome = new JButton("Back to Home");
		backHome.setActionCommand("backHome");
		northPanel.add(backHome);
		
		
		
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBounds(208, 35, 192, 203);
		getContentPane().add(eastPanel);
		eastPanel.setLayout(null);
		
		saldo1 = new JLabel("Il tuo saldo: €");
		saldo1.setBounds(0, 1, 96, 67);
		eastPanel.add(saldo1);
		
		saldo2 = new JLabel();
		saldo2.setBounds(96, 1, 96, 67);
		eastPanel.add(saldo2);
		
		bet1 = new JLabel("Bet");
		bet1.setBounds(0, 68, 96, 67);
		eastPanel.add(bet1);
		
		bet2 = new JLabel("0");
		bet2.setBounds(96, 68, 96, 67);
		eastPanel.add(bet2);
		
		addCoin = new JButton("Coin ++");
		addCoin.setBounds(0, 135, 96, 67);
		addCoin.setActionCommand("addCoin");
		eastPanel.add(addCoin);
		
		subCoin = new JButton("Coin --");
		subCoin.setBounds(96, 135, 96, 67);
		subCoin.setActionCommand("subCoin");
		eastPanel.add(subCoin);
		
		
		
		
		JPanel southPanel = new JPanel();
		southPanel.setBounds(0, 238, 400, 25);
		getContentPane().add(southPanel);
		
		lastWin = new JLabel("Last Win: ");
		southPanel.add(lastWin);
		
		
		
		
		JPanel westNorthPanel = new JPanel();
		westNorthPanel.setBounds(0, 35, 209, 116);
		westNorthPanel.setLayout(new GridLayout(1, 3));
		getContentPane().add(westNorthPanel);
	
		box1 = new JLabel();
		westNorthPanel.add(box1);
		
		box2 = new JLabel();
		westNorthPanel.add(box2);
		
		box3 = new JLabel();
		westNorthPanel.add(box3);
				
		
		
		
		JPanel westSouthPanel = new JPanel();
		westSouthPanel.setBounds(0, 150, 209, 83);
		getContentPane().add(westSouthPanel);
		westSouthPanel.setLayout(null);
		
		spin = new JButton("SPIN");
		spin.setBounds(0, 22, 209, 61);
		spin.setActionCommand("SPIN");
		westSouthPanel.add(spin);
		
		
		
		
		image[0] = new ImageIcon(getClass().getResource("bell.png"));
		image[1] = new ImageIcon(getClass().getResource("cherry.png"));
		image[2] = new ImageIcon(getClass().getResource("lemon.png"));
		image[3] = new ImageIcon(getClass().getResource("plum.png"));
		image[4] = new ImageIcon(getClass().getResource("redseven.png"));
	
	}
	
	public JButton getButtonBackHome() {
		return backHome;
	}
		
	public void setSaldo2Text(String text) {
		saldo2.setText(text);
	}
	
	public String getBet2() {
		return bet2.getText();
	}
	
	public void setBet2Text(String text) {
		bet2.setText(text);
	}
	
	public JButton getButtonAddCoin() {
		return addCoin;
	}
	
	public JButton getButtonSubCoin() {
		return subCoin;
	}
	
	public void setLastWinText(String text) {
		lastWin.setText("Last Win: " + text);
	}

	public JButton getButtonSpin() {
		return spin;
	}
	
	public void setBoxes(double[] iconChose) {
		//iconChose[1,2,3] sono i valori int dellimmagine da scegliere per ogni box 
		//le immagini sono salvate in ordine numerico (il valore int rappresenta proprio quale immagine dell'ordine si prende)
		box1.setIcon(image[(int) iconChose[1]]);
		box2.setIcon(image[(int) iconChose[2]]);
		box3.setIcon(image[(int) iconChose[3]]);
	}
}*/
