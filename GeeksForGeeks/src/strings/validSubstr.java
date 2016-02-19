package strings;
/**
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
import java.util.LinkedList;

public class validSubstr {
	
	static boolean isOpen(char ch){
		boolean flag=false;
		switch(ch){
		case '(':
			flag=true;break;
		case '[':
			flag=true;break;
		case '<':
			flag=true;break;
		case '{':
			flag=true;break;
		}
		return flag;
	}
	
	static boolean isClose(char ch){
		boolean flag=false;
		switch(ch){
		case ')':
			flag=true;break;
		case ']':
			flag=true;break;
		case '>':
			flag=true;break;
		case '}':
			flag=true;break;
		}
		return flag;
	}
	static boolean matches(char close, char open){
		boolean flag = false;
		switch(close){
		case ')':
			if(open=='(') flag=true;
			break;
		case ']':
			if(open=='[') flag=true;
			break;
		case '}':
			if(open=='{') flag=true;
			break;
		case '>':
			if(open=='<') flag=true;
			break;
		}
		return flag;
	}
	
	static int sub(String str){
		LinkedList<Character> stack = new LinkedList<Character>();
		int valid=0;
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(isOpen(c)) stack.addFirst(c);
			if(isClose(c)){
				if(!stack.isEmpty()){
					char top = stack.removeFirst();
					if(matches(c,top)) valid++;
				}
			}
		}
		return valid;
	}
	public static void main(String[] args) {
		System.out.println(sub("((()"));
	}

}
