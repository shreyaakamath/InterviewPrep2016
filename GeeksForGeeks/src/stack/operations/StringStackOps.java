package stack.operations;

import java.util.LinkedList;

/**
 * Infix to postfix -> http://geeksquiz.com/stack-set-2-infix-to-postfix/
 * evaluate a postfix -> http://geeksquiz.com/stack-set-4-evaluation-postfix-expression/
 * reverse string -> http://geeksquiz.com/stack-set-3-reverse-string-using-stack/
 * @author shreyakamath
 *
 */
public class StringStackOps {
	
	int prec(char c){
		switch(c){
			case '+':
			case '-':
				return 0;
			case '*':
			case '/':
				return 1;
			case '^':
				return 2;
			default:
				throw new IllegalArgumentException("unknown operator");
		}
	}
	
	StringBuilder infixToPostfix(String inf){
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> opt = new LinkedList<Character>();
		for(int i=0;i<inf.length();i++){
			char c = inf.charAt(i);
			if(Character.isLetter(c)){ 
				sb.append(c);
				//System.out.print(c);
				continue;
			}
			if(opt.isEmpty()) {opt.addFirst(c);continue;}
			
			for(char top :opt){
				if(prec(c)<prec(top)){
					//pop out the topmost operand and print it 
					opt.removeFirst();
					//System.out.print(top);
					sb.append(top);
				}else{
					break;
				}
			}
			opt.addFirst(c);
		}
		
		for(char top :opt){
			sb.append(top);
			//System.out.print(top);
		}
		return sb;
	}
	
	int eval(int a , int b , char op){
		switch(op){
		case '+':
			return a +b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		case '^':
			return a^b;
		default:
			throw new IllegalArgumentException("op not valid");
		}
	}
	/*space delimiter between symbols -> to evaluate multi-digit post fix expression*/
	void evalPostfix(String post){
		LinkedList<Integer> stack = new LinkedList<Integer>();
		LinkedList<Integer> num = new LinkedList<Integer>();
		for(int i=0;i<post.length();i++){
			char c = post.charAt(i);
			if(Character.isDigit(c)){
				num.addFirst(Character.getNumericValue(c));
				continue;
			}else if(Character.isWhitespace(c)){
				if(num.isEmpty()) continue;
				//come accross a whitespace but the num stack is not empty -> so construct the multi digit num and push to stack
				int val =0;
				int j =0;
				int size=num.size();
				for(int k=0;k<size;k++){
					int pow = (int)Math.pow(10,j);
					val =val+ pow * num.removeFirst();
					j++;
				}
				stack.addFirst(val);
				continue;
			}

			int a = stack.removeFirst();
			int b = stack.removeFirst();
			int exp = eval(a,b,c);
			stack.addFirst(exp);
		}
		System.out.println(stack.get(0));
	}
	
	/*in place string reverse*/
	void reverse(String str){
		StringBuilder sb = new StringBuilder(str);
		int n = sb.length();
		for(int i=0;i<n/2;i++){
			char a = sb.charAt(i);
			char b = sb.charAt(n-i-1);
			sb.setCharAt(i,b);
			sb.setCharAt(n-i-1,a);
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		StringStackOps b = new StringStackOps();
//		System.out.println(b.infixToPostfix("a+b*c+d"));
//		b.evalPostfix("11 2 3 * 40 + +");
		b.reverse("abcde");
	}

}
