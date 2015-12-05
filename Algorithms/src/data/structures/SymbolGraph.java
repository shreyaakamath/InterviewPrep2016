package data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SymbolGraph {
	final Map<String,Integer> symTable;
	final String[] keys;
	final List<Integer>[] adjList;
	int nodeCount;
	final static String fileName = "C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\symbol.txt";
	final static String delim = " ";
	
	SymbolGraph(int num) {
		nodeCount = num ;
		adjList =(List<Integer>[]) new List[num];
		keys = new String[num];
		symTable = new HashMap<String, Integer>();
		for(int i=0;i<num;i++){
			adjList[i] = new ArrayList<Integer>();
		}
	}

	/*calculate no of nodes from a file . "delim" seperates the elements . file format node1<delim>node2<line>node3<delim>node4><line>*/
	static int numberOfNodes(Scanner scanner , String delim){
		int count =0;
		while(scanner.hasNext()){
			String[] line = scanner.nextLine().split(delim);
			count+=2;
		}
		return count;
	}
	
	/*build symbol table map and keys array*/
	void buildSymGraph(Scanner scan, String delim) throws FileNotFoundException{
		int index =0;
		while(scan.hasNext()){
			String[] strArray=scan.nextLine().split(delim);
			for(String s : strArray){
				if(!symTable.containsKey(s)){
				symTable.put(s, index);
				keys[index]= s;
				index++;
				}
			}
			addEdge(strArray[0], strArray[1]);
		}
	}
	
	/*edge is valid if it's key is between 0 and nodecount*/
	boolean edgeValid(String str){
		boolean val = false;;
		if(symTable.get(str)< nodeCount && symTable.get(str)>=0) val = true;
		return val;
	}
	
	/*add str2 as key of str1*/
	void addEdge(String str1, String str2){
		if(edgeValid(str1)&& edgeValid(str2)){
			int key1 = symTable.get(str1);
			int key2 = symTable.get(str2);
			adjList[key1].add(key2);
		}
	}

	/*check if str is present in the graph*/
	boolean contains(String str){
		return symTable.containsKey(str);
	}

	
	String indexToVal(int index){
		return keys[index];
	}
	
	int valToIndex(String val){
		return symTable.get(val);
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		final SymbolGraph g1 = new SymbolGraph(numberOfNodes(GraphAdjList.getScanner(fileName),delim));
		g1.buildSymGraph(GraphAdjList.getScanner(fileName), delim);
		String testStr = "cd";
		if(g1.contains(testStr)) System.out.println(g1.valToIndex(testStr));
		else System.out.println("not present");
		System.out.println(g1.indexToVal(3));
	}
}
