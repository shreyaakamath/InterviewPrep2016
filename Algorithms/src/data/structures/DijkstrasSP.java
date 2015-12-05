package data.structures;

import java.util.PriorityQueue;

public class DijkstrasSP {

	EdgeWeightedDigraph g1; 
	DirectedEdge[] edgeTo;
	double[] distanceTo;
	PriorityQueue<DirectedEdge> pq;//pq.remove should remove edge with min weight
	
	DijkstrasSP(EdgeWeightedDigraph g1, int source){
		this.g1 = g1;
		edgeTo = new DirectedEdge[g1.vertices];
		distanceTo = new double[g1.vertices];
		for(int i=0;i<g1.vertices;i++) {
			distanceTo[i] = Double.POSITIVE_INFINITY;
		}
	}
	
	void relax (DirectedEdge e){
		int v = e.v; int w = e.w;
		if(distanceTo[w] > distanceTo[v] +e.weight ){
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
