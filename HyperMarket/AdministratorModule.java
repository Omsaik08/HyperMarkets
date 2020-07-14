package com.zensar.corejava.project1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class AdministratorModule {

	public JFrame frame;
	public JTextField textField,textField_1;
	public JButton btnHomePage,btnNewButton;
	
	
	public AdministratorModule() {
		frame = new JFrame("ADMINISTARTOR MODULE");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 btnHomePage = new JButton("HOME PAGE");
		 btnHomePage.setForeground(Color.BLUE);
		btnHomePage.setBounds(300, 11, 124, 23);
		frame.getContentPane().add(btnHomePage);
		
		JLabel lblAdministratorModule = new JLabel("ADMINISTRATOR MODULE");
		lblAdministratorModule.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdministratorModule.setForeground(Color.BLUE);
		lblAdministratorModule.setBounds(21, 11, 243, 33);
		frame.getContentPane().add(lblAdministratorModule);
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN:");
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdminLogin.setForeground(new Color(0, 0, 0));
		lblAdminLogin.setBounds(21, 73, 89, 23);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(79, 117, 76, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(79, 162, 76, 23);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(158, 118, 198, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 163, 198, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("SIGN IN");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(175, 206, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(textField.getText().equals("Omsai") && textField_1.getText().equals("Kalekar"))
				{
					JOptionPane.showMessageDialog(null," Sign In SucessFul");
					frame.setVisible(false);
					AdministratorModule1.main(null);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Inavalid Username/Password");
				}
				
			}
		});
		
		
		
		btnHomePage.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				ShopController sc=new ShopController();
				frame.setVisible(false);
				sc.main(null);
			}
		});
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorModule window = new AdministratorModule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
