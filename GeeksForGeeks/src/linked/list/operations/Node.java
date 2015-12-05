package linked.list.operations;
class Node{
 int val;
 Node nxt;
 boolean visited;
 Node child;
 
 Node(int val){
	 this.val=val;
	 this.nxt=null;
	 this.visited=false;
	 this.child=null;
 }
 Node(int val,Node nxt){
	 this.val=val;
	 this.nxt=nxt;
 }
 Node(){
	 
 }
 void setVisited(boolean val){
	 this.visited=val;
 }
}

