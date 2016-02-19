package binary.tree.operations;

class NodeNxt{
	int val;
	NodeNxt left;
	NodeNxt right;
	NodeNxt next;
	
	NodeNxt(int val){
		this.val=val;
	}
}
public class BTNxtInorderSucc {
	NodeNxt root;
	NodeNxt nxt;

	BTNxtInorderSucc(){
		root=new NodeNxt(10);
		root.right=new NodeNxt(12);
		root.left=new NodeNxt(8);
		root.left.left=new NodeNxt(3);
		root.left.right=new NodeNxt(5);
	}
	
	 void fillNxt(NodeNxt root){
		if(root==null) return;
		fillNxt(root.right);
		root.next=nxt;
		nxt=root;
		fillNxt(root.left);
	}
	
	void print(){
		NodeNxt tmp=root;
		while(tmp.left!=null) tmp=tmp.left;
		System.out.println(tmp.val);
		while(tmp.next!=null) {
			System.out.println(tmp.next.val);tmp=tmp.next;
		}
	}
	public static void main(String[] args) {
		BTNxtInorderSucc bt = new BTNxtInorderSucc();
		bt.nxt=null;
		bt.fillNxt(bt.root);
		bt.print();
	}

}
