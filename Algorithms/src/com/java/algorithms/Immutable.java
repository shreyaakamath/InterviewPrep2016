package com.java.algorithms;

import javax.management.RuntimeErrorException;

class Vector {

	final int b[];
	
	Vector (int a[]){
		b=a;
	}
	
	public void printValue(){
		for(int i=0;i<b.length;i++)
		System.out.println(b[i]);
	}
	
	
}

public class Immutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  a[]={1,2};
		Vector obj= new Vector(a);
		obj.printValue();
		a[0]=3;
		obj.printValue();
		throw new RuntimeException("shshs");
	}

}
