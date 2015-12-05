package data.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MstPrims {

	boolean[] marked;
	List<Edge> mstEdges;
	PriorityQueue<Edge> pq;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\edgeWeighted.txt";
	
	int count;
	
	MstPrims(EdgeWeightedGraph g1){
		int source = 0;
		addAdjEdgesToPQ(g1, 0);
		while(count!=g1.vertices){
			Edge minEdge = pq.remove(); // TODO implement MinPQ
			
			if(marked[minEdge.v1] && marked[minEdge.v2]) continue;
			mstEdges.add(minEdge);
			if(!marked[minEdge.v1]) addAdjEdgesToPQ(g1, minEdge.v1);
			if(!marked[minEdge.v2]) addAdjEdgesToPQ(g1, minEdge.v2);
		}
	}
	
	void addAdjEdgesToPQ(EdgeWeightedGraph g1, int v){
		for(Edge n : g1.adj[v]){
			if(!marked[n.otherVertex(v)]) pq.add(n);
		}
	}
	
	public static void main(String args[]){
		EdgeWeightedGraph e1 = new EdgeWeightedGraph(EdgeWeightedGraph.getScanner(fileName));
		MstPrims p1 = new MstPrims(e1);
		
	}
}
