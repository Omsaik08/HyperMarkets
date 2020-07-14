package com.zensar.corejava.project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.TextArea;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CustomerModule {
	public JFrame frame;
	String uname,mobno,pname;
	float pquantity;
	JButton btnTotalBill,btnUserInfo,btnPurchase;
	String s;
	public CustomerModule() {
		
		//frame
		frame = new JFrame("CUSTOMER MODULE");
		frame.setBounds(100, 100, 462, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//userinfo
		 btnUserInfo = new JButton("CUSTOMER INFO");
		 btnUserInfo.setForeground(Color.BLACK);
		 btnUserInfo.setBounds(10, 74, 142, 23);
		 frame.getContentPane().add(btnUserInfo);
		
		btnPurchase = new JButton("PURCHASE");
		btnPurchase.setForeground(Color.BLACK);
		btnPurchase.setBounds(173, 74, 119, 23);
		frame.getContentPane().add(btnPurchase);
		
		JButton btnTotalBill = new JButton("TOTAL BILL");
		btnTotalBill.setForeground(Color.BLACK);
		btnTotalBill.setBounds(325, 338, 100, 23);
		frame.getContentPane().add(btnTotalBill);
		
		
		
		TextArea textArea = new TextArea();
		textArea.setBounds(21, 157, 380, 160);
		frame.getContentPane().add(textArea);
		
		JButton btnAvailableProducts = new JButton("AVAILABLE PRODUCTS");
		btnAvailableProducts.setForeground(Color.BLACK);
		btnAvailableProducts.setBounds(21, 128, 194, 23);
		frame.getContentPane().add(btnAvailableProducts);
		
		JButton btnHomePage = new JButton("HOME PAGE");
		btnHomePage.setForeground(Color.BLACK);
		btnHomePage.setBounds(316, 15, 120, 23);
		frame.getContentPane().add(btnHomePage);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 63, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblCustomerInformation = new JLabel("CUSTOMER MODULE");
		lblCustomerInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomerInformation.setForeground(Color.BLUE);
		lblCustomerInformation.setBounds(21, 13, 206, 23);
		frame.getContentPane().add(lblCustomerInformation);
		

		btnPurchase.setEnabled(false);
		btnTotalBill.setEnabled(false);
		
		JButton btnitem = new JButton("PURCHASED ITEMS");
		btnitem.setForeground(Color.BLACK);
		btnitem.setBounds(302, 74, 134, 23);
		frame.getContentPane().add(btnitem);
		
		
	/*--------------------------------------------------------------------*/
		
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShopDAO sd=new ShopDAO();
				uname=JOptionPane.showInputDialog(null,"Enter Customer Name:");
				mobno=JOptionPane.showInputDialog(null,"Enter Mobile no");
				btnPurchase.setEnabled(true);
				try {
					sd.addUserInfo(uname,mobno);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pname=JOptionPane.showInputDialog(null,"Enter Product Name:");
				pquantity=Float.parseFloat(JOptionPane.showInputDialog(null,"Enter Product Quantity in Kg"));
				try {
					ShopDAO.addpurchased(pname,pquantity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnTotalBill.setEnabled(true);
				
				
			}
		});
		
		
		btnitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=ShopDAO.getproducts();
				textArea.setText(s);
			}
		});
		
		btnTotalBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShopService sc=new ShopService();
				ShopDAO sd=new ShopDAO();
				try {
					sc.calculateBill(uname,mobno,sd.total);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnAvailableProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				}catch (Exception e) {
					e.printStackTrace();
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
					CustomerModule window = new CustomerModule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
