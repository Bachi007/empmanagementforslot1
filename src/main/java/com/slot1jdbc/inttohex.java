package com.slot1jdbc;

import java.util.ArrayList;

public class inttohex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al=new ArrayList<Integer>();
		
		al.add(5);
		
		//auto boxing
		int b=8;
		Integer c=b;
		System.out.println("c = "+c);
		//unboxing
		int a=Integer.valueOf(c);
		System.out.println("a="+a);
	}
	

}
