package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[]={6,8,2,7,4,1,5,3};
		mergeSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}

	private static void mergeSort(int[] arr,int start, int end) {
		if(start<end){
			int mid=(start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr,start,mid,end);
		}
		
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int p=start, q=mid+1;
		int arr_new[]=new int[end-start+1];
		int k=0;
		while(p<=mid && q <=end){
			if(arr[p]<=arr[q]){
				arr_new[k++]=arr[p++];
			}
			else{
				arr_new[k++]=arr[q++];
			}
		}
		while(p<=mid){
			arr_new[k++]=arr[p++];
		}
		while(q <=end){
			arr_new[k++]=arr[q++];
		}
		for(int i=0;i<k;i++){
			arr[start++]=arr_new[i];
		}
	}

}
