package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DirectedEdge  {
	int v ; 
	int w ; 
	int weight; 
	
	DirectedEdge(int v , int w , int weight){
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
}

public class EdgeWeightedDigraph {
	int vertices ; 
	List<DirectedEdge>[] adj;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\edgeWeightedDirected.txt";
	
	EdgeWeightedDigraph(){
		try{
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			this.vertices= scan.nextInt();
			adj = (ArrayList<DirectedEdge>[])new ArrayList[vertices];
			for(int i =0;i < vertices ; i++) adj[i]= new ArrayList<DirectedEdge>();
			while(scan.hasNext()){
				int v = scan.nextInt();
				int w = scan.nextInt();
				int weight = scan.nextInt();
				adj[v].add(new DirectedEdge(v, w, weight));
			}
		} catch(FileNotFoundException e ){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
	EdgeWeightedDigraph g1 = new EdgeWeightedDigraph();	
	}

}
