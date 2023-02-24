package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class SlotMachineView extends JFrame {

/*	private JButton spinBtn;
	private JButton addCoinBtn;
	private JButton betOneBtn;
	private JButton resetBtn;
	private JLabel title;
	private JLabel creditArea;
	private JLabel betArea;
	private JLabel creditAreaTitle;
	private JLabel betAreaTitle;
	private JLabel reel1, reel2, reel3;*/
	
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
		
		getContentPane().setLayout(new BorderLayout());
		setSize(400, 300);
		setTitle("Slot-Machine");

		
		JPanel northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		titolo = new JLabel("Seleziona la tua puntata e vinci!");
		northPanel.add(titolo);
		
		backHome = new JButton("Back to Home");
		backHome.setActionCommand("backHome");
		northPanel.add(backHome);
		
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(3, 2));
		getContentPane().add(eastPanel, BorderLayout.EAST);
		
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
		
		JPanel southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		lastWin = new JLabel("Last Win: ");
		southPanel.add(lastWin);
		
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(4, 1));
		getContentPane().add(westPanel, BorderLayout.WEST);
		
	//	Icon image1 = new ImageIcon(getClass().getResource("cherry.png"));
		box1 = new JLabel();
		westPanel.add(box1);
		
	//	Icon image2 = new ImageIcon(getClass().getResource("bell.png"));
		
	//	Icon image3 = new ImageIcon(getClass().getResource("lemon.png"));
		box2 = new JLabel();
		westPanel.add(box2);
		
		box3 = new JLabel();
		westPanel.add(box3);
		
		
		
		spin = new JButton("SPIN");
		spin.setActionCommand("SPIN");
		westPanel.add(spin);
		
		
		image[0] = new ImageIcon(getClass().getResource("bell.png"));
		image[1] = new ImageIcon(getClass().getResource("cherry.png"));
		image[2] = new ImageIcon(getClass().getResource("lemon.png"));
		image[3] = new ImageIcon(getClass().getResource("plum.png"));
		image[4] = new ImageIcon(getClass().getResource("redseven.png"));
	
	}
	
	public JButton getButtonBackHome() {
		return backHome;
	}
	
	
/*	public String getSaldo2() {
		return saldo2.getText();
	}*/
	
	public void setSaldo2Text(String text) {
		saldo2.setText(text);
	}
	
/*	public String getBet2() {
		return bet2.getText();
	}*/
	
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
		box1.setIcon(image[(int) iconChose[1]]);
		box2.setIcon(image[(int) iconChose[2]]);
		box3.setIcon(image[(int) iconChose[3]]);
	}

	
	
	
}
