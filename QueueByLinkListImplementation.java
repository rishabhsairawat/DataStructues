package queue;

public class QueueByLinkListImplementation {
	Node front,rear;
	class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	QueueByLinkListImplementation(){
		this.front=null;
		this.rear=null;
	}
	//to check if queue is empty or not
	public boolean isEmpty(){
		return (this.rear==null && this.front==null);
	}
	 //Insertion in queue
	public void enQueue(int newData){
		Node newNode=new Node(newData);
		if(this.isEmpty()){
			this.front=this.rear=newNode;
			return;
		}
		this.rear.next=newNode;
		this.rear=newNode;
	}
	//Deletion from Queue
	public int deQueue(){
		int x=front.data;
		  if(this.isEmpty())
			  return -1;
		  else if(this.front==this.rear){
			this.front=this.rear=null;
		  }
		  else
			  this.front=this.front.next; 
		  return x;
	}
	public static void main(String[] args) {
		QueueByLinkListImplementation queue=new QueueByLinkListImplementation();
		queue.enQueue(2);
		queue.enQueue(5);
		queue.enQueue(7);
		queue.enQueue(3);
		queue.enQueue(1);
		queue.enQueue(9);
		queue.enQueue(10);
		queue.enQueue(4);
		queue.enQueue(6);
		System.out.println("Deleted elements are :"+queue.deQueue()+" "+queue.deQueue());
	}

}
