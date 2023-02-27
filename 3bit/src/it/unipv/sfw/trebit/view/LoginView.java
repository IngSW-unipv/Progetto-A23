package it.unipv.sfw.trebit.view;

import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {

	private JLabel benvenuto;
	private JLabel user;
	private JLabel psw;
	private JTextField username;
	private JPasswordField password;
	private JButton signIn;
	private JButton signUp;

	
	public LoginView() {
		
		setLayout(new BorderLayout());
		setSize(300, 200);
		
		
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		benvenuto = new JLabel("Benvenuto");
		northPanel.add(benvenuto);
		
		
		
		JPanel westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(4,1));
		
		user = new JLabel("Username:");
		westPanel.add(user);
		
		psw = new JLabel("Password:");
		westPanel.add(psw);
		
		
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		username = new JTextField();
		centerPanel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		centerPanel.add(password);
		password.setColumns(10);

		
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		signUp = new JButton("Sign Up");
		signUp.setActionCommand("signUp");
		southPanel.add(signUp);
		
		signIn = new JButton("Sign In");
		signIn.setActionCommand("signIn");
		southPanel.add(signIn);
		
	}
	
	public JButton getButtonSignIn() {
		return signIn;
	}
	
	public JButton getButtonSignUp() {
		return signUp;
	}
	
	public String getStringUsername() {
		return username.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getStringPassword() {
		return password.getText();
	}

}