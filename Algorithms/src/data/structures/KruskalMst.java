package data.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMst {
	List<Edge> mst ;
	PriorityQueue<Edge> pq ;
	boolean[] marked ;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\mstSample.txt";
	
	KruskalMst(EdgeWeightedGraph g1){
		mst = new ArrayList<Edge>();
		pq = new PriorityQueue<Edge>();
		marked = new boolean[g1.vertices];
		marked[0] = true;
		
		/*add all graph edges to a priority queue*/
		for(int i =0;i<g1.vertices;i++){
			for(Edge n : g1.adj[i] ){
				pq.add(n);
			}
		}
		/*get min edge . if the two vertices are not marked then mark it . continue*/
		while(mst.size()< g1.vertices-1 && !pq.isEmpty()){
			Edge min = pq.remove();
			int v = min.v1 ; int w = min.v2;
			if(marked[v] && marked[w]) continue;
			else {
				marked[v] = true; marked[w]= true;
				mst.add(min);
			}
		}
	}
	
	
	public static void main(String[] args) {
		KruskalMst k1 = new KruskalMst(new EdgeWeightedGraph(EdgeWeightedGraph.getScanner(fileName)));
		for(Edge n : k1.mst) System.out.println(n.weight);
		}
	}

