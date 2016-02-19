package practice.all.chapters;

public class BitManipulation {

	static int setBit(int n , int m , int i , int j){
		for(int k=i;k<=j;k++){
			n=n & ~(1<<k);
		}
		return n|m<<i;
	}
	public static void main(String[] args) {
		System.out.println(setBit(14,2,1,2));
	}

}
