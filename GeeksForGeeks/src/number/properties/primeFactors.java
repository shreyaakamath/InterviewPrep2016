package number.properties;

import java.util.ArrayList;
import java.util.List;

public class primeFactors {
	
	static void primeFcts(int n){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=2;i<=n;i++){
			if(n%i==0) list.add(i);
			while(n%i==0) n/=i;
		}
		System.out.println(list.size());
		for(int i:list)
			System.out.print(i+" ");
	}
	
	
	static boolean isPrime(int n){
		if(n==1||n==2) return true;
		boolean flag=true;
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%i==0) {flag=false;break;}
		}
		return flag;
	}
	
	static boolean isUglyNum(int n){
		boolean flag=false;
		int[] arr={2,3,5};
		for(int i:arr){
			while(n%i==0) n/=i;
			if(n==1) {flag=true;break;}
		}
		return flag;
	}
	
	public static void main(String[] args) {
//		primeFcts(10);
//		System.out.println(isPrime(7));
		isUglyNum(14);
	}

}
