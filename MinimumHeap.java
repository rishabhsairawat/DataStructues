
package heap;

import java.util.Arrays;

public class MinimumHeap {
	 int capacity;
	 int size;
	 int heap[];
	 
	//Constructor to initializing the Heap
	MinimumHeap(int cap){
	this.capacity=cap;
	this.size=0;
	this.heap=new int[this.capacity];
	}
	
	//Parent Index
	int parentIndex(int index){return (index-1)/2;}
	
	//Left Child Index
	int leftChildIndex(int index){return (index*2)+1;}
	
	//Right Child Index
	int rightChildIndex(int index){return (index*2)+2;}
	
	//To get the minimum element from Heap --"Function 1"
	int getMin(){
		return heap[0];
	}
	
	//To remove the minimum element from Heap  --"Function 2"
	int extractMin(){
		if(size<=0)
			return Integer.MAX_VALUE;
		if(size==1){
			size--;
			return heap[0];
		}
		else{
			int root=heap[0];
			heap[0]=heap[size-1];
			size--;
			heapify();
			return root;
		}
	}
	
	//To decrease a key   --"Function 3"
	void decreaseKey(int i,int newValue){
		heap[i]=newValue;
		while(i!=0 && heap[parentIndex(i)]>heap[i]){
			swap(i,parentIndex(i));
			i=parentIndex(i);
		}
	}
	
	//To add an key to Heap  --"Function 4"
	void insertKey(int key){
		ensureCapacity();
		size++;
		int i=size-1;
		heap[i]=key;
		while(i!=0 && heap[parentIndex(i)]>heap[i]){
			swap(i,parentIndex(i));
			i=parentIndex(i);
		}
	}
	
	//To remove an key from Heap stored at index i  --"Function 5"
	void deleteKey(int index){
		decreaseKey(index, Integer.MIN_VALUE);
		extractMin();
	}
	
	//To ensure the empty space for insertion
	private void ensureCapacity(){
		if(size==capacity){
			heap=Arrays.copyOf(heap, capacity*2);
			capacity*=2;
		}
	}
	
	//To swap the keys at two indices
	private void swap(int key1,int key2){
		int temp=heap[key1];
		heap[key1]=heap[key2];
		heap[key2]=temp;
	}
	
	//To maintain heap properties
	private void heapify(){
		int index=0;
		while(leftChildIndex(index)<size){
			int smallestChildIndex=leftChildIndex(index);
			if(rightChildIndex(index)<size && rightChildIndex(index)<leftChildIndex(index)){
				smallestChildIndex=rightChildIndex(index);
			}
			if(heap[index]<heap[smallestChildIndex])
				break;
			else
				swap(index,smallestChildIndex);
			index=smallestChildIndex;
		}
	}
	void printHeap(){
		for(int i=0;i<size;i++){
			System.out.print(heap[i]+" ");
		}
	}
	public static void main(String[] args) {
		MinimumHeap heap=new MinimumHeap(11);
		heap.insertKey(3);
		heap.insertKey(2);
		heap.deleteKey(1);
		heap.insertKey(15);
		heap.insertKey(5);
		heap.insertKey(4);
		heap.insertKey(45);
		heap.printHeap();
		System.out.println("\n"+heap.extractMin());		
		System.out.println(heap.getMin());
		heap.decreaseKey(2, 1);
		System.out.println(heap.getMin());
		heap.printHeap();
	}

}
