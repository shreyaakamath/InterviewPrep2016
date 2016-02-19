
public class bitManipulation {

	static int count1(int n){
		int mask=1;int one=0;int zero=0;
		while(n>0){
			int check=n&mask;
			if(check==1) one++;
			else zero++;
			n=n>>1;
		}
		System.out.println("one-"+one+" zero="+zero);
		return one;
	}
	
	static int countLogn(int n){
		if(n<=0) return 0;
		return (n%2==0?0:1 )+countLogn(n/2);
		
	}
	
	static int setPos(int pos){
		int n =1;
		int count=0;
		while(count!=pos){ n=n<<1;pos++;}
		return n;
	}
	static int getPos(int pos,int n){
		int count=0;
		while(count!=pos){n=n>>1;pos++;}
		return n;
	}
	static void swapBits(int n, int l , int r){
		
	}
	public static void main(String[] args) {
		count1(3);
		System.out.println(countLogn(2));
	}

}
