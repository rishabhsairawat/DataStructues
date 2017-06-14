package stack;

import java.util.*;


public class BalancedParentheses {

    static boolean ismatchingPair(char x, char c) {
		if(x=='('&&c==')')
			return true;
		else if(x=='{'&&c=='}')
			return true;
		else if(x=='['&&c==']')
			return true;
		else
		return false;
	}
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextInt();
        for(long a0 = 0; a0 < t; a0++){
            String input = in.next();
            Stack<Character> stack=new Stack<Character>();
		  int flag=1;
		  for(int i=0;i<input.length();i++){
			char c=input.charAt(i);
			if(c=='('||c=='{'||c=='['){
				stack.push(c);
			}
			else if(!stack.isEmpty()) 
			{
				if(c==')'||c=='}'||c==']'){
				char x=stack.pop();
				if(!ismatchingPair(x,c)){
					flag=0;
					break;
				}
				}
			}
			else
			{
				flag=0;
				break;	
			}
		  }
		  in.close();
		  if(flag==1&&stack.isEmpty()){
			System.out.println("YES");
		  }
		  else
			System.out.println("NO");   
        }
    }
}