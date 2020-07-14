package com.zensar.corejava.project1;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.zensar.corejava.project.ShopBean;
import com.zensar.corejava.project.ShopDB;


public class ShopDAO 
{
	public static Connection con=null;
	public static Statement st=null;
	public static float total;
	
	//admin add products
	 public int addProduct(ShopBean obj)
	  {
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  try
		  {
			  
			  con=ShopDB.getConnection(); 
			  
			  String ins_str = "insert into product values(?,?,?,?)";
			  
			  pstmt = con.prepareStatement(ins_str);
			  
			  pstmt.setInt(1,obj.getPId());
			  pstmt.setString(2,obj.getPName());
			  pstmt.setFloat(3,obj.getPCost());
			  pstmt.setFloat(4,obj.getPQuantity());
			  
			  
			  int updateCount = pstmt.executeUpdate();
			  
			  con.close();
			  
			  return updateCount;
			  
			  
		  }
		  catch(Exception ex)
		  {
			  System.out.println(ex.toString());
			  return 0;
		  }
		  
	  }
	
	
	
	//user_info
	public void addUserInfo(String uname, String mobno) throws Exception {

		con=ShopDB.getConnection();
		st=con.createStatement();
		String s="insert into user_info values(?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1, uname);
		ps.setString(2,mobno);
		int i=ps.executeUpdate();
		System.out.println("User Info:"+i);
		st.close();
		con.close();
		
	}

	//product list
		public static ArrayList productList() throws Exception
		{
			con=ShopDB.getConnection();
			st=con.createStatement();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String str="select * from product";
			pstmt=con.prepareStatement(str);
			ArrayList a=new ArrayList();
			 rs=pstmt.executeQuery();
			while(rs.next())
			{
				//System.out.println("jshdg");
				int s1=rs.getInt(1);
				String s2=rs.getString(2);
				float s3=rs.getFloat(3);
				float s4=rs.getFloat(4);
				String s=" "+ s1+"  "+s2+"  "+s3+"  "+s4;
				//System.out.println("Added..");
				a.add(s);
			}
			//System.out.println(a);
			st.close();
			con.close();
			return a;
		}

		
		public static String getproducts() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		//add purchased
		public static void addpurchased(String pname, float pquantity) throws Exception {
			ResultSet rs=null;
			con = ShopDB.getConnection();
			String sel_str ="Select pcost,pquantity from product where pname=(?)";
			PreparedStatement pstmt = con.prepareStatement(sel_str);
			 pstmt.setString(1,pname);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getFloat(2)<pquantity)
				{
					JOptionPane.showMessageDialog(null,"OUT OF STOCK");
				}
				else
				{
				total=pquantity * rs.getFloat(1);
				}
			}
			System.out.println(total);
			
			st.close();
			con.close();
			
		}

	
	 
}

