package stack;

import java.util.Stack;

public class InfixToPostfixCon {

	static int prec(char ch){
		if(ch=='+'||ch=='-')
			return 1;
		else if(ch=='*'||ch=='/')
			return 2;
		else if(ch=='^')
			return 3;
		else
			return -1;
	}
	
	static String infixToPostfixConversion(String exp){
		String result="";
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<exp.length();i++){
			char c=exp.charAt(i);
			if(Character.isLetterOrDigit(c)){
				result+=c;
			}
			else if(c=='(')
				stack.push(c);
			else if(c==')'){
				while(!stack.isEmpty() && stack.peek()!='(')
					result+=stack.pop();
				if(!stack.isEmpty() && stack.peek()!='(')
					return "INVALID EXPRESSION";
				else
					stack.pop();	
			}
			else
			{
				while(!stack.isEmpty() && prec(c)<=prec(stack.peek()))
					result+=stack.pop();
				
				stack.push(c);
			}
		}
		while(!stack.isEmpty())
			result+=stack.pop();
		
		return result;
	}
	
	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(exp+" -------> "+infixToPostfixConversion(exp));
	}

}
