package stack.operations;
/*
 * http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
public class TwoStacks {

	int[] arr;
	int top1;
	int top2;
	int n;
	
	TwoStacks(int top1,int top2, int n){
		this.top1=top1;
		this.top2=top2;
		this.n=n;
		arr=new int[n];
	}
	
	void push1(int x){
		if(top1==top2) System.out.println("full");
		else {
			arr[top1]=x;
			top1++;
		}
		return;
	}
	
	void push2(int x){
		if(top1==top2) System.out.println("full");
		else {
			arr[top2]=x;
			top2--;
		}
		return;
	}
	
	void pop1(){
		if(top1==0) System.out.println("empty");
		else{
			top1--;
			arr[top1]=0;
			
		}
	}
	
	void pop2(){
		if(top2==0) System.out.println("empty");
		else{
			top2++;
			arr[top2]=0;
			
		}
	}
	
	void print(){
		for(int n : arr)
			System.out.print(n+" ");
	}
	
	public static void main(String[] args) {
		TwoStacks t = new TwoStacks(0,9,10);
		t.push1(1);
		t.push1(2);
		t.push2(3);
		t.push2(4);
		t.print();
		t.pop1();
		t.pop2();
		System.out.println();
		t.print();
	}

}
