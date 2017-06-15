package queue;

public class QueueByArrayImplementation {
	int front,rear;
	int capacity;
	int[] array;
	public QueueByArrayImplementation(int capacity) {
		this.capacity=capacity;
		front=-1;
		rear=-1;
		array=new int[this.capacity];
	}
	//To check if queue is full or not
	public boolean isFull(QueueByArrayImplementation queue){
		return ((rear+1)%capacity==front);
	}
	//to check if queue is empty or not
	public boolean isEmpty(QueueByArrayImplementation queue){
		return (front<0||front>rear);
	}
	//to insert an item to queue
	public void enqueue(int item){
		if(isFull(this)){
			System.out.println("Queue is full");
			return ;
		}
			
		else if(isEmpty(this))
			front=rear=0;
		else
			rear=(rear+1)%capacity;
		this.array[rear]=item;
		return;
	}
	//to delete an item from the queue
	public int dequeue(){
		int x=this.array[front];
		if(isEmpty(this)){
			System.out.println("Queue is full");
			return -1;
		}
		else if(front==rear){
			front=-1;
			rear=-1;
			return x;
		}
		else
			front=(front+1)%capacity;
			return x;
	}
	//to get peek element
	public int getFront(){
		return this.array[front];
	}
	//to get rear element
		public int getBack(){
			return this.array[rear];
		}
	//to print queue
		public void printQueue(){
			for(int i=this.front;i<=this.rear;i++){
				System.out.print(this.array[i]+" ");
			}
		}
	
	public static void main(String[] args) {
		QueueByArrayImplementation queue=new QueueByArrayImplementation(10);
		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(3);
		queue.enqueue(1);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.enqueue(4);
		queue.enqueue(6);
		System.out.println("Queue before deletion is: ");
		queue.printQueue();
		System.out.println();
		System.out.println("Deleted elements are :"+queue.dequeue()+" "+queue.dequeue());
		System.out.println("Queue after deletion is: ");
		queue.printQueue();
		System.out.println();
		System.out.println("Front element is :"+queue.getFront());
		System.out.println("Rear element is :"+queue.getBack());
	}

}
