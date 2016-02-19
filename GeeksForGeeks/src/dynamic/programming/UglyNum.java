package dynamic.programming;

public class UglyNum {

	static boolean isUglyNum(int n){
		if(n==1) return true;
		boolean flag=false;
		int[] arr={2,3,5};
		for(int i:arr){
			while(n%i==0) n/=i;
			if(n==1) {flag=true;break;}
		}
		return flag;
	}
	
	static void nthUgly(int n){
		int count=0;
		int val=0;
		while(count<n){
			val++;
			if(isUglyNum(val)) count++;
		}
		System.out.println(val);
	}
	public static void main(String[] args) {
		nthUgly(7);
	}

}
