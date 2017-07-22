package sortingAlgos;

public class HeapSort {

	public void sort(int[] arr){
		int n=arr.length;
		for(int i=(n/2)-1;i>=0;i--){
			heapify(arr,n,i);
		}
		
		for(int i=n-1;i>0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}
	
	private void heapify(int[] arr,int n,int i){
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n && arr[l]>arr[largest])
			largest=l;
		if(r<n && arr[r]>arr[largest])
			largest=r;
		if(largest!=i){
			int swap=arr[largest];
			arr[largest]=arr[i];
			arr[i]=swap;
			heapify(arr,n,largest);
		}
	}
	static void printArray(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int arr[]={98,23,67,12,44,78};
		int n=arr.length;
		HeapSort hs=new HeapSort();
		hs.sort(arr);
		System.out.println("Sorted array is:");
		printArray(arr);
		
	}

}
