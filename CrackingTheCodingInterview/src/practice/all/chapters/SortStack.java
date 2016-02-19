package practice.all.chapters;

public class SortStack {

	Stack<Integer> s1;
	Stack<Integer> s2;
	
	SortStack(){
		s1= new Stack<Integer>();
		s2= new Stack<Integer>();
		s1.push(1);
		s1.push(4);
		s1.push(5);
		s1.push(3);
	}
	
	void printBefore(){
		s1.print();
	}
	void printAfter(){
		s2.print();
	}
	
	void sort(){
		while(!s1.isEmpty()){
			
			int val = s1.pop();
			System.out.println(val);
			int i=1;
			while(!s2.isEmpty() && s2.peek()>val){
				s1.push(s2.pop());i++;
			}
			s2.push(val);
			int j=1;
			while(j!=i){
				s2.push(s1.pop());j++;
			}
		}
	}
	public static void main(String[] args) {
		SortStack s1 = new SortStack();
		s1.printBefore();
		s1.sort();
		s1.printAfter();
	}

}
