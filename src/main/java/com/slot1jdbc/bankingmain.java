package com.slot1jdbc;
import java.util.*;
public class bankingmain {

	public static void main(String[] args)throws Exception {
		
		Scanner bs=new Scanner(System.in);
		bankingdao dao=new bankingdao();
		bankingcustomer b1=new bankingcustomer();
		System.out.println("\t\t----Welcome to Anudip Bank----");
		
		System.out.println("Select Operation : \n1 for Register Account \n2 for Login to Account");
		int op=bs.nextInt();
		
		switch(op) {
		
		case 1->{
		//creating new account
			System.out.println("Enter Customer Details to create new account");
			System.out.print("Enter Customer Name");
			String cname=bs.next();
			System.out.print("Create Customer Password");
			String cpwd=bs.next();
			System.out.print("Enter Cutstomer Phone");
			String cphone=bs.next();
			System.out.print("Enter Acc balance");
			int caccbal=bs.nextInt();
			b1.cname=cname;
			b1.cpassword=cpwd;
			b1.cphone=cphone;
			b1.caccbal=caccbal;
			
			dao.connect();
			int res=dao.registerCustomer(b1);
			if(res!=0) {
				System.out.println("Account Created");
			}
			else {
				System.out.println("Something went wrong, please tryagain");
			}
		}
		
		case 2->{
			//login into my account
			System.out.println("Enter Customer Details to Login");
			System.out.print("Enter Customer Name");
			String cname=bs.next();
			System.out.print("Enter Customer Password");
			String cpwd=bs.next();
			
			dao.connect();
			int res=dao.login(cname, cpwd);
			if(res==0) {
				System.out.println("Wrong Username or Password");
			}
			else if(res==-1) {
				System.out.println("account not found\n Please Register yourself");
			}
			else {
				System.out.println("Login Success");
				//we are giving access to withdraw or deposit
				System.out.println("Select Operation : \n1 for Withdraw \n2 for deposit");
				int op2=bs.nextInt();
				switch(op2) {
				
				case 1->{
					//withdraw amount
					System.out.println("Enter amount to withdraw");
					int amt=bs.nextInt();
				int res2=dao.withdraw(res, amt);
					if(res2<=0) {
						System.out.println("Something went wrong");
					}
					else {
						System.out.println("Withdraw done");
						
					}
				}
				
				}
				
			}
		}
		
		
		}
		
		
		
		
		
				bs.close();
	}

}
