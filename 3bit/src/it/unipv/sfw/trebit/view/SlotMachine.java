package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class SlotMachine extends JFrame {

	private JButton spinBtn;
	private JButton addCoinBtn;
	private JButton betOneBtn;
	private JButton resetBtn;
	private JLabel title;
	private JLabel creditArea;
	private JLabel betArea;
	private JLabel creditAreaTitle;
	private JLabel betAreaTitle;
	private JLabel reel1, reel2, reel3;
	
	public SlotMachine() {
		
		setLayout(new BorderLayout());
		setSize(400, 300);
		
		
		add(northPanel(), BorderLayout.NORTH);
		
		
		add(centerPanel(), BorderLayout.CENTER);
		
	}
	
	private JPanel northPanel() {
		
		JPanel northPanel = new JPanel();
		
		return northPanel;
		
	}
	
	private JPanel centerPanel() {
		
		JPanel centerPanel = new JPanel();
		
		return centerPanel;
		
	}
	

}
