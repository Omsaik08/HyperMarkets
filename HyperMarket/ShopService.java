/*	public float calculateBill() {
		// TODO Auto-generated method stub
		return 0;
	}*/

package com.zensar.corejava.project1;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.zensar.corejava.project.ShopBean;
import com.zensar.corejava.project.ShopDAO;

public class ShopService 
{
	// calculate bill total
	public void calculateBill(String name,String mobno,float totalbill)throws Exception
	{
		JOptionPane.showMessageDialog(null,"**TEAM-2 GROCERY SHOP*\nName:"+name+"\nMob No.:"+mobno+"---------------------------\nTotal Bill: Rs."+totalbill+"\nThank You Visit Again!!");
	}
	
	// admin add products
	public int addShopService(int pId, String pName,float pCost,float pQuantity)
    
	 {
		 //implement the business logic
		 ShopDAO shopDAO = new ShopDAO();
		 ShopBean shopBean = new ShopBean();
		 //wrap up all the four field values into bean
		 
		 shopBean.setPId(pId);
		 shopBean.setPName(pName);
		 shopBean.setPCost(pCost);
		 shopBean.setPQuantity(pQuantity);
		 int updateResult = 0;
		 try
		 {
			 updateResult = shopDAO.addProduct(shopBean);
			 return updateResult;
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.toString());
			 return 0;
		 }
	 }
	
}