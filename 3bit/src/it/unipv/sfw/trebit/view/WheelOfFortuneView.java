package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class WheelOfFortuneView extends JFrame {
	
	private JLabel titolo;
	private JLabel saldo1;
	private JLabel saldo2;
	private JLabel bet1;
	private JLabel bet2;
	private JLabel wheel;
	private JLabel lastWin;
	private JButton addCoin;
	private JButton subCoin;
	private JButton spin;
	private JButton img1;
	private JButton img2;
	private JButton img3;
	private JButton backHome;
	
	private Icon gif1 = new ImageIcon(getClass().getResource("wheelGif1.gif"));
	private Icon gif2 = new ImageIcon(getClass().getResource("wheelGif2.gif"));
	private Icon gif3 = new ImageIcon(getClass().getResource("wheelGif3.gif"));

	public WheelOfFortuneView() {
		
		setLayout(new BorderLayout());
		setSize(500, 300);
		setTitle("Ruota Della Fortuna");
		
		
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		titolo = new JLabel("Scegli l'immagine su cui puntare e vinci!");
		northPanel.add(titolo);
		
		backHome = new JButton("Back to Home");
		backHome.setActionCommand("backHome");
		northPanel.add(backHome);
		
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(3, 2));
		add(eastPanel, BorderLayout.EAST);
		
		saldo1 = new JLabel("Il tuo saldo: €");
		eastPanel.add(saldo1);
		
		saldo2 = new JLabel();
		eastPanel.add(saldo2);
		
		bet1 = new JLabel("Bet");
		eastPanel.add(bet1);
		
		bet2 = new JLabel("0");
		eastPanel.add(bet2);
		
		addCoin = new JButton("Coin ++");
		addCoin.setActionCommand("addCoin");
		eastPanel.add(addCoin);
		
		subCoin = new JButton("Coin --");
		subCoin.setActionCommand("subCoin");
		eastPanel.add(subCoin);
		
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 1));
		add(centerPanel, BorderLayout.CENTER);
		
		Icon image = new ImageIcon(getClass().getResource("baseWheel.png"));
		wheel = new JLabel(image);
		centerPanel.add(wheel);
		
		spin = new JButton("SPIN");
		spin.setActionCommand("SPIN");
		centerPanel.add(spin);
		
		
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		lastWin = new JLabel("Last Win: ");
		southPanel.add(lastWin);
		
		
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3, 1));
		add(westPanel, BorderLayout.WEST);
		
		Icon image1 = new ImageIcon(getClass().getResource("symbol1Wheel.png"));
		img1 = new JButton(image1);
		img1.setActionCommand("img1");
		westPanel.add(img1);
		
		Icon image2 = new ImageIcon(getClass().getResource("symbol2Wheel.png"));
		img2 = new JButton(image2);
		img2.setActionCommand("img2");
		westPanel.add(img2);
		
		Icon image3 = new ImageIcon(getClass().getResource("symbol3Wheel.png"));
		img3 = new JButton(image3);
		img3.setActionCommand("img3");
		westPanel.add(img3);
		
	
	}
	
	public JButton getButtonBackHome() {
		return backHome;
	}
	
	public JButton getButtonImg1() {
		return img1;
	}
	
	public JButton getButtonImg2() {
		return img2;
	}
	
	public JButton getButtonImg3() {
		return img3;
	}
	
	public void setWheel(int gifChose) {
			
			//imposta la gif corrispondente
			switch(gifChose) {
				case 1:
					wheel.setIcon(gif1);
					break;
				case 2:
					wheel.setIcon(gif2);
					break;
				case 3:
					wheel.setIcon(gif3);				
				}
	}
	
	public JButton getButtonSpin() {
		return spin;
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
	
	public void popUp(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
