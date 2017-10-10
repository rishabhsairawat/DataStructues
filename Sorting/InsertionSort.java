package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[]={6,2,7,4,1,5,3};
		insertionSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++){
			int temp=arr[i];
			int j=i;
			while(j>0 && arr[j-1]>temp){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
	}

}
