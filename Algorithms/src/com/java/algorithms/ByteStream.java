package com.java.algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		String fileName = buffReader.readLine();
		System.out.println("name if the file :" + fileName);
		
		FileInputStream in = new FileInputStream(fileName);
		FileOutputStream out = new FileOutputStream("output.txt"); 
		
		int c ; 
		while ((c = in.read()) !=  -1) {
			out.write(c);
		
		}
		if( in!= null ) {
			in.close();
		}
		if(out != null ) {
			out.close();
		}

	}

}
