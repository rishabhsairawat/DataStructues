package sorting;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr={170,45,75,90,802,24,2,66};
		radixSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void radixSort(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++){
			max=Math.max(max, arr[i]);
		}
		int mul=1;
		while(max>0){
			countSort(arr,mul);
			mul*=10;
			max/=10;
		}
		
	}

	private static void countSort(int[] arr, int place) {
		int range=10;
		int freq[]=new int[range];
		int output[]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			freq[(arr[i]/place)%range]++;
		}
		for(int i=1;i<range;i++){
			freq[i]+=freq[i-1];
		}
		for(int i=arr.length-1;i>=0;i--){
			output[freq[(arr[i]/place)%range]-1]=arr[i];
			freq[(arr[i]/place)%range]--;
		}
		for(int i=0;i<arr.length;i++)
            arr[i]=output[i];
	}
}
