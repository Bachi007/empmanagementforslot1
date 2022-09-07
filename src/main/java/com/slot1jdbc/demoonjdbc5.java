package com.slot1jdbc;

import java.io.FileOutputStream;
import java.sql.*;

public class demoonjdbc5 {

	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anudipdeeptech","root","905906");
		String qu="select * from empimg where eid=102";
		PreparedStatement pst=con.prepareStatement(qu);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			//getting blob to create image from binary format
			Blob b=rs.getBlob(2);
			//getting binary values from  the blob
			byte bar[]=b.getBytes(1, (int)b.length());
			//creation of empty file
			FileOutputStream fo=new FileOutputStream("f://msd.jpg");
			//writing data into the file
			fo.write(bar);
			fo.close();
			System.out.println("Image is created");
		}
		
		
	}

}
