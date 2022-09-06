package com.slot1jdbc;

public class enumex {
	public enum months {Jan,Feb,Mar,Apr,May};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(months m:months.values())
//			System.out.println(m);
		System.out.println(months.valueOf("May").ordinal());
	}

}
