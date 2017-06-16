package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationiUsingQueue {
	Queue<Integer> q1=new LinkedList<Integer>();
	Queue<Integer> q2=new LinkedList<Integer>();
	//push operation
	public void push(int data){
		this.q1.add(data);
	}
	//pop operation
	public int pop(){
		if(this.q1.isEmpty()){
			System.out.println("No Element found !");
		}
		else {
			int x;
			while(this.q1.size()>1){
				x=this.q1.remove();
				this.q2.add(x);
			}
			x=q1.remove();
			this.q1.addAll(q2);
			return x;
		}
		return -1;
	}
	public static void main(String[] args) {
		StackImplementationiUsingQueue stack=new StackImplementationiUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
