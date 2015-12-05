/**
 * http://stackoverflow.com/questions/14917375/cannot-create-generic-array-of-how-to-create-an-array-of-mapstring-obje
 * cannot directly create array of generic type .therefor on RHS array is initialised without data type in <>. Need to caste it to the specific type
 * 
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
package graph.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PrimsMST {
	
	ArrayList<GraphNode>[] adj; 
	int n;
	int e;
	Queue<GraphNode> q;
	boolean visited[];
	int pathTo[];
	
	PrimsMST(String path){

		File file = new File(path);
		Scanner scan=null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		n = scan.nextInt();
		e = scan.nextInt();
		adj = (ArrayList<GraphNode>[])new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			adj[i]= new ArrayList<GraphNode>();
		}
		q=new LinkedList<GraphNode>();
		visited = new boolean[n+1];
		pathTo = new int[n+1];
		
		for(int i=0;i<e;i++){
			int u=scan.nextInt();
			int v=scan.nextInt();
			adj[u].add(new GraphNode(v));
		}
	}
	

	void prims(){
		
	}
	public static void main(String[] args) {
		PrimsMST g1= new PrimsMST("graph.txt");
	}

}
