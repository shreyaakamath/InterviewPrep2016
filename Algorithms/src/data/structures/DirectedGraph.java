package data.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedGraph {

	List<Integer>[] adj;
	List<Integer> cyclePath;
	boolean isCycle;
	int cycleCount;
	boolean[] marked;
	int[] edgeTo;
	final static String delim = " ";
	int v;
	List<Integer>[] cyclePaths;
	List<Integer> path;
	
	public DirectedGraph(int nodeNum) {
		adj = (List<Integer>[])new List[nodeNum];
		//cyclePath = (List<Integer>[])new List[nodeNum];
		cyclePath = new ArrayList<Integer>();
		isCycle = false;
		marked = new boolean[nodeNum];
		edgeTo = new int[nodeNum*2];
		this.v = nodeNum;
		cycleCount =0;
		path = new ArrayList<Integer>();
		
		for(int i =0; i< nodeNum; i++)
			adj[i] = new ArrayList<Integer>();
		}
	
	DirectedGraph(Scanner in){
		this(in.nextInt());
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
	}
}
	
	void dfs(int source, List<Integer> pathSoFar){
		if(marked[source]){ 
			if(pathSoFar.contains(source)){
				cycleCount++;
				int x =source;
				do{
				path.add(x);
				x= edgeTo[x];
				} while(x!=source);
				path.add(x);
			}
			return;
		} 
		else {
			marked[source]= true;
			pathSoFar.add(source);
		}
		for(int n : adj[source]){
			edgeTo[n] = source;
			dfs(n,pathSoFar);
		}
	}
	
	void hasCycle(){
		dfs(0,new ArrayList<Integer>());
	}
	
	public static void main(String args[]){
		DirectedGraph  d1 = new DirectedGraph(GraphAdjList.getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt"));
		d1.hasCycle();
		System.out.println("no of cycles"+ d1.cycleCount);
		for(int x : d1.path) System.out.println(x);
	}
	
}
