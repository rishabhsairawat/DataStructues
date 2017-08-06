package arrays;

public class KadaneAlgorithmForLargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		maxContiguousSum(array);
	}

	private static void maxContiguousSum(int[] array) {
		int maxHere=array[0];
		int maxSoFar=array[0];
		int start=0,end=0,s=0;
		for(int i=1;i<array.length;i++){
			maxHere=Math.max(array[i], maxHere+array[i]);
			maxSoFar=Math.max(maxSoFar, maxHere);
		}
		System.out.println("Maximum Contiguous Sum  is "+maxSoFar+" .");
		
	}

}
