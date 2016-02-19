package strings;
/**
 * http://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/	
 * @author shreyakamath
 *
 */
public class StrSeq {

	// complexity O(m+n)
	static void subseq(String str1 , String str2){
		int len1= str1.length();
		int len2= str2.length();
		int j=0;
		for(int i=0;i<len1;i++){
			char s1 = str1.charAt(i);
			while(j<len2 && str2.charAt(j)!=s1){
				j++;
			}
			if(j>=len2) {System.out.println("not subseq");return;}
			else continue;
		}
		System.out.println("subseq");
	}
	
	static  boolean editDist(String str1, String str2){
		int i=0;int j=0;
		int dist=0;boolean flag=true;
		int len1=str1.length();
		int len2=str2.length();
		
		while(i<len1  && j<len2){
			if(str1.charAt(i)==str2.charAt(j)){ i++;j++;continue;}
			else{
				if(dist>0){flag=false;break;}
				dist++;
				if(len1>len2)i++;
				else if (len2>len1) j++;
				else {i++;j++;}
			}
		}
		
		//handles case like "abc" "abcde"
		if(i==len1){
			if(len2-j>1) flag = false;
		}
		else if (j==len2){
			if(len1-i>1) flag= false;
		}
		return flag;
	}
	public static void main(String[] args) {
//		subseq("gksrek","geeksforgeeks");
		System.out.println(editDist("geaks","geeks"));
	}

}
