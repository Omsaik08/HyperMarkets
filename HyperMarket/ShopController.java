package com.zensar.corejava.project1;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;
public class ShopController extends JFrame{
	public JFrame frame;
	public JButton custbtn,adminbtn,close;
	public JLabel label,custlb,adminlb;
	private JButton btnClose;
	public ShopController()
	{	
			frame = new JFrame("SHOP MANAGEMENT SYSTEM");
			frame.getContentPane().setForeground(Color.LIGHT_GRAY);
			frame.setSize(450,450);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Main label
			label = new JLabel("WELCOME TO TEAM-2 GROCERY  SHOP.");
			label.setBounds(10, 24, 414, 43);
			label.setForeground(Color.BLUE); 
			Font f = new Font("Arial", 8, 15);
		    frame.getContentPane().setLayout(null);
		    label.setFont(new Font("Arial", Font.BOLD, 20));
			frame.getContentPane().add(label);
			
			//customer
			custbtn = new JButton("CUSTOMER");
			custbtn.setBounds(45, 189, 100, 70);
			custbtn.setForeground(Color.BLUE);
			frame.getContentPane().add(custbtn);
			
			//admin
			adminbtn= new JButton("ADMIN");
			adminbtn.setBounds(249, 189, 110, 70);
			adminbtn.setForeground(Color.BLUE);
			frame.getContentPane().add(adminbtn);
			
			custlb = new JLabel(" CUSTOMER  ");
			custlb.setBounds(51, 144, 94, 34);
			custlb.setFont(new Font("Tahoma", Font.BOLD, 13));
			frame.getContentPane().add(custlb);
			
			adminlb = new JLabel("ADMINISTRATOR");
			adminlb.setBounds(245, 144, 162, 34);
			adminlb.setFont(new Font("Tahoma", Font.BOLD, 13));
			frame.getContentPane().add(adminlb);
			
			close = new JButton("CLOSE");
			close.setBounds(169, 358, 89, 23);
			close.setForeground(Color.RED);
			frame.getContentPane().add(close);
			
			
			custbtn.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CustomerModule.main(null);
				}
			});
			
			
			
			adminbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AdministratorModule.main(null);
				}
			});
			
			
			
			close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopController window = new ShopController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
