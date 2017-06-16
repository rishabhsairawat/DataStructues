package dequeue;

public class DequeueImplementationUsingCircularArray {
	int maxSize,front,rear;
	int arr[];
	DequeueImplementationUsingCircularArray(int maxSize){
		this.maxSize=maxSize;
		arr=new int[this.maxSize];
		this.front=-1;
		this.rear=-1;
	}
	//to check whether dequeue is full or not
    boolean isFull(DequeueImplementationUsingCircularArray queue){
		return (this.rear+1)%this.maxSize==this.front;
	}
	//to check whether dequeue is empty or not
	boolean isEmpty(DequeueImplementationUsingCircularArray queue){
		return (this.front==-1&&this.rear==-1);
	}
	// Insertion of an item at front
	void insertAtFront(int item)
    {
		if(isFull(this)){
			System.out.print("Insertion not possible !");
			return;
		}
		else if(isEmpty(this)){
			this.front=this.rear=0;
		}
		else if(this.front==0){
			this.front=this.maxSize-1;
		}
		else
			front=front-1;
		
		this.arr[front]=item;
    }
	// Insertion of an item at rear
		void insertAtRear(int item)
	    {
			if(isFull(this)){
				System.out.print("Insertion not possible !");
				return;
			}
			else if(isEmpty(this)){
				this.front=this.rear=0;
			}
			else if(this.rear==this.maxSize-1){
				this.rear=0;
			}
			else
				rear=rear+1;
			
			this.arr[rear]=item;
	    }
		//deletion from front
		int deletionFromFront(){
			
			if(isEmpty(this)){
				System.out.print("Deletion not possible::");
				return -1;
			}
			int x=this.arr[this.front];
			if(this.front==this.rear)
				this.front=this.rear=-1;
			else if(this.front==this.maxSize-1)
				this.front=0;
			else 
				this.front=this.front+1;
			
			return x;
		}
		//deletion from rear end
		int deletionFromRear(){
			
			if(isEmpty(this)){
				System.out.print("Deletion not possible::");
				return -1;
			}
			int x=this.arr[this.rear];
			if(this.front==this.rear)
				this.front=this.rear=-1;
			else if(this.rear==0)
				this.rear=this.maxSize-1;
			else
				this.rear=this.rear-1;
			return x;
		}
		
	public static void main(String[] args) {
		DequeueImplementationUsingCircularArray deQueue=new DequeueImplementationUsingCircularArray(6);
		deQueue.insertAtFront(3);
		System.out.println(deQueue.deletionFromRear());
		System.out.println(deQueue.deletionFromRear());
		deQueue.insertAtFront(3);
		deQueue.insertAtFront(9);
		deQueue.insertAtRear(6);
		deQueue.insertAtRear(5);
		deQueue.insertAtFront(1);
		deQueue.insertAtFront(4);
		deQueue.insertAtFront(44);
		System.out.println();
		System.out.println(deQueue.deletionFromRear());
		deQueue.insertAtFront(44);
		System.out.println(deQueue.deletionFromFront());
	}

}
