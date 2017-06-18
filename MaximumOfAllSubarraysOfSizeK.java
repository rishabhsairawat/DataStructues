package lab;

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int n=arr.length;
		int k=4;
		System.out.println("Maximum of all Subarrays of size "+k+" : ");
		printMax(arr,n,k);

	}

	static void printMax(int[] arr, int n, int k) {
		int max;
		for(int i=0;i<=n-k;i++){
			max=arr[i];
			for(int j=1;j<k;j++){
				if(arr[i+j]>max)
				max=arr[i+j];
			}
			System.out.print(max+" ");
		}
		
	}

}
