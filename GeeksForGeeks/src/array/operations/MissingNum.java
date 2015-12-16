package array.operations;
/*
 * http://www.geeksforgeeks.org/find-the-missing-number/
 * complexity O(n)
 */
public class MissingNum {

	int missingSum(int[] a, int n ){
		int sum1=0;int sum2=0;
		for(int i=1;i<=n;i++) sum1+=i;
		for(int i:a) sum2+=i;
		return sum1-sum2;
	}
	
	int missingXor(int[] a, int n ){
		int sum1=0;int sum2=0;
		for(int i=1;i<=n;i++) sum1^=i;
		for(int i:a) sum2^=i;
		return sum1^sum2;
	}

	public static void main(String[] args) {
		int a[]={1,2,4,6,3,7,8};
		MissingNum m= new MissingNum();
		System.out.println(m.missingSum(a,8));
		System.out.println(m.missingXor(a,8));
	}

}
