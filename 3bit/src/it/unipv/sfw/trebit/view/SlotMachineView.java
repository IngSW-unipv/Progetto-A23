package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class SlotMachineView extends JFrame {

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
	
	public SlotMachineView() {
		
		setLayout(new BorderLayout());
		setSize(400, 300);
		setTitle("Slot-Machine");
		
		
		add(northPanel(), BorderLayout.NORTH);
		
		
		add(centerPanel(), BorderLayout.CENTER);
		
	}
	
	private JPanel northPanel() {
		
		JPanel northPanel = new JPanel();
		
		//label titolo con "Punta, scommetti e vinci!"
		
		return northPanel;
		
	}
	
	private JPanel centerPanel() {
		
		JPanel centerPanel = new JPanel();
		
		return centerPanel;
		
	}
	

}
