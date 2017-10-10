package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[]={6,2,7,4,1,5,3};
		selectionSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void selectionSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(arr[min]>arr[j]){
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}

}
