package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int arr[]={6,8,2,7,4,1,5,3};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start<end){
			int piv=partition(arr,start,end);
			quickSort(arr, start, piv-1);
			quickSort(arr,piv+1,end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int piv=arr[start];
		int i=start+1;
		for(int j=start+1;j<=end;j++){
			if(arr[j]<piv){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
			}
		}
		int x=arr[start];
		arr[start]=arr[i-1];
		arr[i-1]=x;
		return i-1;
	}
}
