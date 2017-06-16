package queue;

import java.util.Stack;

public class QueueImplementationUsingOnlyOneStack {
	Stack<Integer> stack =new Stack<Integer>();
	//Insertion of an item into queue
	public void enQueue(int item){
		this.stack.push(item);
	}
	//Deletion of an item from queue
	public int deQueue(){
		if(this.stack.isEmpty()){
			System.out.print("Stack is Empty");
			return -1;
		}
		else{
			int x=this.stack.pop();
			if(this.stack.isEmpty()){
				return x;
			}
			int res=deQueue();
			this.stack.push(x);
			return res;
		}
	}
	public static void main(String[] args) {
		QueueImplementationUsingOnlyOneStack queue=new QueueImplementationUsingOnlyOneStack();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}
