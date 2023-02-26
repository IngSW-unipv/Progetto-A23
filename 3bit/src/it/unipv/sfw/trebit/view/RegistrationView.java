package it.unipv.sfw.trebit.view;

import javax.swing.*;
import java.awt.*;

public class RegistrationView extends JFrame {
	
	private JLabel user;
	private JLabel nome, cognome;
	private JLabel psw, cpsw;
	private JLabel titolo;
	private JTextField nom, cognom, username,password,cpassword;
	private JButton continua;
	private JButton back;
	
	public RegistrationView() {
		
		setLayout(new BorderLayout());
		setSize(350,250);
		
		
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		titolo = new JLabel("Registrati");
		northPanel.add(titolo);
		
		
		
		JPanel westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(6,1));
		
		nome = new JLabel("Nome:");
		westPanel.add(nome);
		
		cognome = new JLabel("Cognome");
		westPanel.add(cognome);
		
		user = new JLabel("Username:");
		westPanel.add(user);
		
		psw = new JLabel("Password:");
		westPanel.add(psw);
		
		cpsw = new JLabel("Conferma password:");
		westPanel.add(cpsw);
		
		
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(6,1));
		
		nom = new JTextField();
		centerPanel.add(nom);
		nom.setColumns(10);
		
		cognom = new JTextField();
		centerPanel.add(cognom);
		cognom.setColumns(10);
		
		username = new JTextField();
		centerPanel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		centerPanel.add(password);
		password.setColumns(10);
		
		cpassword = new JPasswordField();
		centerPanel.add(cpassword);
		cpassword.setColumns(10);
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		
		back = new JButton("Back");
		back.setActionCommand("back");
		southPanel.add(back);
		
		continua = new JButton("Continue");
		continua.setActionCommand("continua");
		southPanel.add(continua);
		
	}
	
	public String getStringNome() {
		return nom.getText();
	}
	public String getStringCognome() {
		return cognom.getText();
	}

	public String getStringUsername() {
		return username.getText();
	}

	public String getStringPassword() {
		return password.getText();
	}

	public String getStringCpassword() {
		return cpassword.getText();
	}

	public JButton getButtonContinue() {
		return continua;
	}
	
	public JButton getButtonBack() {
		return back;
	}

}


