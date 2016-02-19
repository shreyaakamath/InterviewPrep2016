package strings;
/**
 * http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 * @author shreyakamath
 *
 */
public class ReverseSpl {

	static void reverse(StringBuilder str){
		int len = str.length();
		int i=0; int j =len-1;
		while(i<j){
			char left = str.charAt(i);
			char right = str.charAt(j);
			while(!Character.isAlphabetic(left)){ i++;left = str.charAt(i);}
			while(!Character.isAlphabetic(right)) {j--;right = str.charAt(j);}
			if(i<j){
				str.setCharAt(i,right);
				str.setCharAt(j,left);
				i++;j--;
			}
		}
	}
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("Ab,c,de!$");
		reverse(str);
		System.out.println(str.toString());
	}

}
