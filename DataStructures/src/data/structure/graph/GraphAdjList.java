package data.structure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphAdjList {

	int v ; 
	int e;
	List<Integer> [] g;
	
	GraphAdjList(String filename){
		Scanner scan = null;
		try{
		File file = new File(filename);
		scan = new Scanner(file);
		} catch(FileNotFoundException e ) {
			System.out.println( e.getMessage());
			return;
		}
		this.v = scan.nextInt();
		g = (List<Integer>[]) new List [v];
		for(int i=0;i<v;i++)
			g[i] = new ArrayList<Integer>();
		while(scan.hasNext()){
			int m = scan.nextInt();
			int n = scan.nextInt();
			g[m].add(n);
		}
	}
	
	void print(){
		int count =0;
		for(List<Integer> list : g){
			System.out.print(count++ +"->");
			for(int i :list) System.out.print(i+"->");
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		GraphAdjList g1 = new GraphAdjList("graph.txt");
		g1.print();
	}
}
