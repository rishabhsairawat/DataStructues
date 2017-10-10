package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[]={6,2,7,4,1,5,3};
		bubbleSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}

	private static void bubbleSort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++){
		/*	(n-i-1) is for ignoring comparisons of elements 
		which have already been compared in earlier iterations */
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
}
