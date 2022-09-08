package com.slot1jdbc;
import java.sql.*;
public class demoonjdbc0 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","905906");
		Statement st=con.createStatement();
		String query="select * from deeptechemp where eid=101";
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String emp=rs.getString(2);
		int sal=rs.getInt(4);
		System.out.println(emp+" : "+sal);
	}

}
