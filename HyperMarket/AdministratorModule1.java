package com.zensar.corejava.project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.zensar.corejava.project.ShopService;

import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.ListIterator;

public class AdministratorModule1 {

	public JFrame frame;
	public AdministratorModule1() {
		frame = new JFrame("ADMINISTARTOR MODULE");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.setBounds(100, 100, 474, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdministratorModule = new JLabel("ADMINISTRATOR MODULE:");
		lblAdministratorModule.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdministratorModule.setForeground(Color.BLUE);
		lblAdministratorModule.setBounds(23, 11, 207, 21);
		frame.getContentPane().add(lblAdministratorModule);
		
		JButton btnHome = new JButton("LOG OUT");
		btnHome.setForeground(Color.RED);
		btnHome.setBounds(349, 11, 99, 23);
		frame.getContentPane().add(btnHome);
		
		JLabel lblAddProducts = new JLabel("ADD PRODUCTS:");
		lblAddProducts.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddProducts.setForeground(Color.BLACK);
		lblAddProducts.setBounds(35, 76, 130, 14);
		frame.getContentPane().add(lblAddProducts);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBounds(188, 72, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(35, 152, 369, 149);
		frame.getContentPane().add(textArea);
		
		JButton btnAvailableProducts = new JButton("AVAILABLE PRODUCTS:");
		btnAvailableProducts.setForeground(Color.BLACK);
		btnAvailableProducts.setBounds(35, 123, 195, 23);
		frame.getContentPane().add(btnAvailableProducts);
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Product ID"));
				String name=JOptionPane.showInputDialog(null,"Enter Product Name");
				float price=Float.parseFloat(JOptionPane.showInputDialog(null,"Enter Product Price"));
				 float quan=Float.parseFloat(JOptionPane.showInputDialog(null,"Enter Product Quantity"));
				 ShopDAO sd=new ShopDAO();
				 ShopService ss=new ShopService();
				 int ur=ss.addShopService(id,name,price,quan);
				 System.out.println(id+" "+name+" "+price+" "+quan);
				
			}
		});
		
		

		btnHome.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				AdministratorModule sc=new AdministratorModule();
				frame.setVisible(false);
				sc.main(null);
			}
		});
		
		
		btnAvailableProducts.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String st="";
				ArrayList al=new ArrayList();
				try {
					al=ShopDAO.productList();
					ListIterator i=al.listIterator();
					while(i.hasNext())
					{
						st=st+i.next()+"\n";
					}
					textArea.setText(st);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorModule1 window = new AdministratorModule1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
