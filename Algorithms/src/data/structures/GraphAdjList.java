package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphAdjList {

	List<Integer>[] adj ; 
	int e;
	int v;
	

	/**
	 * initialize an empty graph
	 * @param v
	 */
	GraphAdjList(int v) {
		this.v = v; 
		e=0;
		adj =(List<Integer>[])new List[v];
		for(int i =0; i< v; i++)
			adj[i] = new ArrayList<Integer>();
	}
	
	/**
	 * initialize graph from file
	 * @param in
	 */
	GraphAdjList(Scanner in){
		this(in.nextInt());
		this.e = in.nextInt();
		
		while(in.hasNext()){
			int u = in.nextInt();
			int v = in.nextInt();
			addEdge(u,v);
		}
	}

	/**
	 * edge is valid if it lies between 0 and v
	 * @param v
	 * @return
	 */
	boolean edgeValid(int v){
		boolean valid = false;
		if(0<=v && v<this.v) valid = true;
		return valid;
	}
	
	/**
	 * add edge u-> v into graph which has been initialized
	 * @param u
	 * @param v
	 */
	void addEdge(int u , int v){
		if(edgeValid(v)&& edgeValid(u)) {
			adj[u].add(v);
			adj[v].add(u);
		}
	}
	
	/**
	 * helper function to prepare a scanner object
	 * @param fileName
	 * @return
	 */
	static Scanner getScanner(String fileName){
		Scanner scanner = null;
		try {
			File file = new File(fileName);
			scanner = new Scanner(file);
		} catch (FileNotFoundException e ){
			System.out.println(e.getMessage());
		}
		return scanner;
	}
	
	/**
	 * print the adjacency list
	 */
	void printAdjList(){
		for(int i =0 ; i < v; i++){
			System.out.print(i+"->");
			for(int num : adj[i])
				System.out.print(num +"->");
			System.out.println();
		}
	}
	
	public static void main(String args[]){
	GraphAdjList g1 = new GraphAdjList(getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt"));
	}
	
}
