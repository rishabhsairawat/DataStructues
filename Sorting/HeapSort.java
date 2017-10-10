package sorting;

public class HeapSort{
	public static void main(String[] args){
		int[] arr={9,4,7,2,5,1,6,3,8};
		heapSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void heapSort(int[] arr) {
		int n=arr.length;
		buildHeap(arr,n);
		for(int i=n-1;i>0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}

	private static void buildHeap(int[] arr,int n) {
		for(int i=(n/2)-1;i>=0;i--){
			heapify(arr,n,i);
		}
	}

	private static void heapify(int[] arr,int n,int i){
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
}
