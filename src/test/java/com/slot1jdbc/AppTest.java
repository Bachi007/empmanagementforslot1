package com.slot1jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest{
	
	@Test
	void testregisterac()throws Exception
	{
		bankingcustomer b1=new bankingcustomer();
		b1.cname="priyanshu";
		b1.cpassword="123456";
		b1.cphone="8501003087";
		b1.caccbal=7000;
		
		bankingdao dao=new bankingdao();
		dao.connect();
		assertEquals(1,dao.registerCustomer(b1));
		
	}
}