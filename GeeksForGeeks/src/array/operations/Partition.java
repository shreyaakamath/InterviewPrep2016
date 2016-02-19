package array.operations;
/**
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * logic -> http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 * @author shreyakamath
 *
 */
	
public class Partition {

	//works but very convoluted solution
	void segregate(int a[]){
		int left=0;
		int right=a.length-1;
		while(left<right){
			if(a[left]==1 && a[right]==1){ 
				for(int i=left+1;i<right;i++) a[i-1]=a[i];
				a[right-1]=1;
				right-=2;
				continue;
			}
			if(a[left]==0 && a[right]==0){
				for(int i=right-1;i>left;i--) a[i+1]=a[i];
				a[left+1]=0;
				left+=2;
				continue;
			}
			if(a[left]==0) left++;
			if(a[right]==1) right--;
			else{
				int tmp=a[right];
				a[right]=a[left];
				a[left]=tmp;
			}
			}
		for(int i:a)System.out.println(i);
	}
	
	void swap(int[] a , int i ,int j){
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	void segBetter(int[] a){
		int left=0;
		int right=a.length-1;
		while(left<right){
			while(a[left]==0) left++;
			while(a[right]==1) right--;
			if(left<right){
				swap(a,left,right);
				left++;right--;
			}
		}
		for(int i:a)System.out.println(i);
	}
	
	
	void dutch(int[] a){
		int low=0; int mid=0; int high=a.length-1;
		while(mid<=high){
			switch(a[mid]){
				case 0:
					swap(a,low,mid);
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(a,mid,high);
					high--;
					break;
		}			
		}
		
		for(int i:a)System.out.println(i);
	}
	public static void main(String[] args) {
		Partition p = new Partition();
		int[] a={0,1,0,0,1,1,0};
	//	p.segBetter(a);
		int[] b={0,1,2,0,1,2,0,1};
		p.dutch(b);
	}

}
