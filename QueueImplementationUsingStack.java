package queue;

import java.util.Stack;

public class QueueImplementationUsingStack {
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	//To insert an item into Queue
	public void enQueue(int item){
		System.out.println("Inserted element is:"+item);
		this.stack1.push(item);
	}
	//To delete an item from Queue
	public void deQueue(){
		if(this.stack1.isEmpty() && this.stack2.isEmpty()){
			System.out.println("Deletion not possible !");
			return;
		}
		else if(this.stack2.isEmpty()){
			while(!this.stack1.isEmpty()){
				this.stack2.push(this.stack1.pop());
			}
		}
		System.out.println("Deleted element is :"+this.stack2.pop());
	}
	
	public static void main(String[] args) {
		QueueImplementationUsingStack queue=new QueueImplementationUsingStack();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		
	}

}
