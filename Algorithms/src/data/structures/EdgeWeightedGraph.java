package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int weight;
	int v1;
	int v2;
	
	public Edge(int v1 , int v2 ,int weight){
		this.v1 = v1;
		this.v2= v2;
		this.weight = weight;
			
	}

	public int compareTo(Edge that) {
		if(this.weight < that.weight) return -1;
		else if(this.weight > that.weight) return +1;
		else return 0;
	}
	
	public int otherVertex(int vertex){
		if(vertex == v1) return v2;
		else return v1;
	}
}
public class EdgeWeightedGraph {

	List<Edge>[] adj;
	int vertices;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\edgeWeighted.txt";
	
	public EdgeWeightedGraph(int vertices) {
		this.vertices = vertices;
		adj = (List<Edge>[])new List[vertices];
		for(int i=0;i<vertices;i++)
			adj[i] = new ArrayList<Edge>();
	}
	
	public EdgeWeightedGraph(Scanner scan){
		this(scan.nextInt());
		while(scan.hasNext()){
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			int weight = scan.nextInt();
			addEdge(v1, v2, weight);
		}
	}
	
	public boolean vertexValid(int v){
		if((v>=0) && (v<=this.vertices))return true;
		return false;
	}
	public void addEdge(int v1 , int v2, int weight){
		if(vertexValid(v1)&& vertexValid(v2))
		adj[v1].add(new Edge(v1, v2, weight));
	}
	
	public static Scanner getScanner(String fileName){
		Scanner scan = null;
		try{
		File file = new File(fileName);
		scan = new Scanner(file);
		}
		catch(FileNotFoundException e ){
			System.out.println("file not found "+ e.getMessage());
		}
		return scan;
		
	}
	
	public Iterable<Edge> getEdges(int v){
		return adj[v];
	}
	
	
	public static void main(String args[]){
		EdgeWeightedGraph e1 = new EdgeWeightedGraph(getScanner(fileName));
	}
}
