package array.operations;
/**
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * xor all the elements of the array. the elements which are same will cancel each other out in the xor . the remaining element is the odd element.
 * complexity : o(n) and constant space
 * @author shreyakamath
 *
 */
public class OddOccurence {
	int odd(int[] arr){
		int val=arr[0];
		for(int i=1;i<arr.length;i++){
			val ^= arr[i];
		}
		return val;
	}
	public static void main(String[] args) {
		OddOccurence o = new OddOccurence();
		int[] a = {1,2,3,2,3,1,3};
		System.out.println(o.odd(a));
	}
	

}
