package cracking.the.coding.interview;

public class Recursion {

	static int factorial(int n, int prod){
		if(n==0) return prod;
		prod = prod * n ;
		return factorial(n-1,prod);
	}
	
	static int gcd(int a , int b){
		if(b==0) return a;
		else return gcd(b,a%b);
	
	}
	
	static void move(int n, int start , int aux , int end ){
		if(n==1) System.out.println("move" + n + "from " +start+"->"+end);
		else{
			move(n-1,start,end,aux);
			System.out.println("move" + n + "from " +start+"->"+end);
			move(n-1,aux,start,end);
		}
		
	}
	
	/*complexity is n*n! => print stmt printed n! times . this is inturn called from i 0:n for loop . so n*(n-1)!*/
	static void permOrder(String prefix , String str){
		int n = str.length();
		if(n==0) System.out.println(prefix);
		else{
			for(int i=0;i<n;i++)
				permOrder(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
		}
	}
	public static void main(String[] args) {
		int prod=1;
//		prod = factorial(0,prod);
//		System.out.println(prod);
//		System.out.println(gcd(68,102));
//		move(3,0,1,2);
		permOrder("","abc");
	}

}