package sorting;

public class CountSort {

	public static void main(String[] args) {
		int arr[]={5,2,9,1,5,3,7,1,8};
		int[] sortedArr=new int[arr.length];
		countSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void countSort(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++){
			max=Math.max(max, arr[i]);
		}
		int aux[]=new int[max+1];
		for(int i=0;i<aux.length;i++){
			aux[i]=0;
		}
		for(int i=0;i<arr.length;i++){
			aux[arr[i]]++;
		}
		for(int i=1;i<aux.length;i++){
			aux[i]+=aux[i-1];
		}
		int sortedArr[]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			sortedArr[aux[arr[i]]-1]=arr[i];
			aux[arr[i]]--;
		}
		for(int i=0;i<arr.length;i++){
			arr[i]=sortedArr[i];
		}
		}

	
}
