package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Color{
	WHITE,BLACK,GREY;
}

class Node{
	Color color ; 
	int value;
	int d; 
	Node p;
	Node next;
	
	Node(int value){
		this.color = Color.WHITE;
		this.value = value ; 
		d=0;
	}
}

public class GraphOfNodes {

	List<Node>[] adj ; 
	int e;
	int v;

	/**
	 * initialize an empty graph
	 * @param v
	 */
	GraphOfNodes(int v) {
		this.v = v; 
		e=0;
		adj =(List<Node>[])new List[v];
		for(int i =0; i< v; i++)
			adj[i] = new ArrayList<Node>();
	}
	
	/**
	 * initialize graph from file
	 * @param in
	 */
	GraphOfNodes(Scanner in){
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
			adj[u].add(new Node(v));
			adj[v].add(new Node(u));
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
			for(Node n1 : adj[i])
				System.out.print(n1.value +"->");
			System.out.println();
		}
	}

	void BFS(){
		
	}
	
	public static void main(String args[]){
	GraphOfNodes g1 = new GraphOfNodes(getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt"));
	g1.printAdjList();
	}
	
}
