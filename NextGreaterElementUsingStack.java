package stack;

import java.util.Stack;

public class NextGreaterElementUsingStack {

	public static void main(String[] args) {
		int array[]={11, 13, 21, 3};
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(array[0]);
		for(int i=1;i<array.length;i++){
			int next=array[i];
			if(!stack.isEmpty()){
				int x=stack.pop();
				while(x<next){
					System.out.println(x+" : "+next);
					if(stack.isEmpty())
						break;
					x=stack.pop();
				}
				if(x>next){
					stack.push(x);
				}
			}
			stack.push(next);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" : "+"-1");
		}
	}

}
