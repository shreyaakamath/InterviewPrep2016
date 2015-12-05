package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node{
    int data;
    Node(int data){
        this.data=data;
    }
}

class Graph{
    int n;
    int e;
    List<Node>[] adj;
    LinkedList<Integer> q;
    int[] visited;
    int[] pathTo;
    Graph(int n,int e){
        this.n=n;
        this.e=e;
        adj = (List<Node>[])new ArrayList[n+1];
        q=new LinkedList<Integer>();
        visited=new int[n+1];
        pathTo = new int[n+1];
        for(int i=0;i<n+1;i++)
            adj[i]=new ArrayList<Node>();
    }
    
    void shortestReach(int s){
    	q.addLast(s);
        visited[s]=1;
        pathTo[s]=s;
        while(!q.isEmpty()){
        	int elem = q.removeFirst();
        	for(Node n1:adj[elem]){
        		if(visited[n1.data] ==0){
        		q.addLast(n1.data);
        		visited[n1.data]=1;
        		pathTo[n1.data]=elem;
        		}
        	}
        }

        for(int j=1;j<=n;j++)
        	System.out.println("j="+j+" path ="+pathTo[j]);
        
        for(int j=1;j<=n;j++){
        	if(j==s) continue;
        	if(visited[j] ==1) {
        		int length=6;
        		int temp=j;
        		while(pathTo[temp]!=s){
        			temp=pathTo[temp];
        			length+=6;
        		}
        		System.out.print(length+" ");
        	}
        	else System.out.print("-1 ");
        }
    }
    

    
}
public class BFS {
    
    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        File file=new File("/home/shreyakamath/Documents/algorithms - programming practice/HackerRankChallenges/src/graph/g.txt");
    	Scanner scan = new Scanner(file);
        int test = scan.nextInt();
        for(int i =0;i<test;i++){
            int n = scan.nextInt();
            int e = scan.nextInt();
            Graph g1= new Graph(n,e);
            for(int j=0;j<e;j++){
                int a=scan.nextInt();
                int b = scan.nextInt();
                g1.adj[a].add(new Node(b));
                g1.adj[b].add(new Node(a));
            }
            int s = scan.nextInt();
            g1.shortestReach(s);
            System.out.println();
 
        }
    }
}