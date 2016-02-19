
public class TextJustify {

	public  static void fullJustify(String[] str, int L) {
		int start=0;int end=0;int sum=0;boolean flag=false;
		for(int i=0;i<str.length;i++){
			int len = str[i].length();
			if(sum+len<L) sum+=len+1;
			else if(sum+len==16){end=i;flag=true;}
			else{end=i-1;flag=true;}
			
			if(flag){
				if(sum==L){
					for(int k=start;k<end;k++){
						System.out.println(str[k]);
						if(k!=end-1) System.out.println(" ");
					}
				}else{
					int put=L-sum;
					int gaps=end-start;
					int[] arr= new int[gaps];
					int g=0;
					while(put>0){
						arr[g]+=1;
						g=(g+1)%gaps;put--;
					}
					g=0;
					for(int k=start;k<end;k++){
						System.out.println(str[k]);
						for(int h=0;h<arr[g];h++){
							System.out.println(" ");
						}
						g++;
					}
					sum=0;flag=false;start=end+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] arr={"This","is","an"};
		fullJustify(arr,16);

	}

}
