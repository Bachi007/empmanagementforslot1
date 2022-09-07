package com.slot1jdbc;
import java.sql.*;
public class bankingdao {

	Connection con=null;
	
	public void connect()throws Exception {
		//getting connection with DB
		Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","905906");	
		
	}
	
	//register account
	public int registerCustomer(bankingcustomer b1)throws Exception {
		
		String query="insert into banking(cname,cpassword,cphone,caccbal) values(?,?,?,?)";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,b1.cname);
		pst.setString(2, b1.cpassword);
		pst.setString(3, b1.cphone);
		pst.setInt(4, b1.caccbal);
		int count=pst.executeUpdate();
		
		return count;
		
	}
	
	public int login(String username, String pwd)throws Exception{
		//feteching the account details by username
		
		String query="select * from banking where cname= '"+username+"'";
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next()) {
		//fetching the password from db
			String cpwd=rs.getString(3);
			//matching the db password with enterd password
			if(cpwd.equals(pwd)) {
			int eid=rs.getInt(1);
			//if login success we can return cid
			return eid;
			}
			else {
			return 0;
				}
			}
			else {
			return -1;
			}
	}
	
	
	public int withdraw(int cid,int amount)throws Exception {
		//getting account details based on cid
		String query="select * from banking where cid="+cid;
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		//fetching account balance
		int accbal=rs.getInt(5);
		//if account balance is greater than withdraw amount we can allow to withdraw
		if(accbal>amount) {
			accbal-=amount;
			String query2="update banking set caccbal="+accbal+" where cid="+cid;
			//updating the accbalance after withdraw
			Statement st2=con.createStatement();
			int res=st2.executeUpdate(query2);
			return res;
		}	
		else {
			return -1;
		}
		
		
}
	
	
	}

