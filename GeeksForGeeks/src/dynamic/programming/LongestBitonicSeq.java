package dynamic.programming;

public class LongestBitonicSeq {
	
	static int lbs(int[] a){
		int[] lis = new int[a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<=i;j++){
				if(a[j]<=a[i] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
				}
			}
		}
		
		int[] lds = new int[a.length];
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[i] && lds[i]<lds[j]+1){
					lds[i]=lds[j]+1;
				}
			}
		}
		
		
		int max=0;
		for(int i=0;i<a.length;i++){
			int val = lis[i]+lds[i]-1;
			if(val>max) max=val;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(lbs(a));
	}

}
