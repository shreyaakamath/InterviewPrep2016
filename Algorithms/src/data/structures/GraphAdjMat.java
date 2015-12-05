package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphAdjMat {
	int e;
	int v;
	int[][] adj;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt";
	
	GraphAdjMat(int v ){
		this.v=v;
		adj = new int[v][v];
		for(int i =0 ; i< v; i++)
			for(int j =0;j<v;j++)
				adj[i][j] =0;
	}
	
	GraphAdjMat(Scanner in) {
		this(in.nextInt());
		e = in.nextInt();
		while(in.hasNext()){
			int u = in.nextInt();
			int v = in.nextInt();
			addEdge(u,v);
		}
	}
	
	boolean validVertex(int u ){
		boolean valid = false;
		if(u>=0 && u <this.v) valid = true;
		return valid;
	}
	void addEdge(int u , int v){
		if(validVertex(u) && validVertex(v)) {
			adj[u][v] = 1;
			adj[v][u] = 1; 
		}
	}
	
	void printAdjMat(){
		for(int i =0; i< v; i++)
		{
			for(int j=0;j<v;j++){
				System.out.print(adj[i][j]);
			}
		System.out.println();	
		}
	}
	
	static Scanner getScanner(String fileName){
		Scanner scanner = null ; 
		try{
		File file = new File(fileName);
		scanner = new Scanner(file);
		}catch(FileNotFoundException e ){
			System.out.println(e.getMessage());
		}
		return scanner;
	}
	
	public static void main (String args[]) {
		GraphAdjMat g1 = new GraphAdjMat(getScanner(fileName));
		g1.printAdjMat();
	}
}
