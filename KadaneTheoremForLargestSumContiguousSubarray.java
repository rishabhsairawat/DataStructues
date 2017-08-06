package arrays;

public class KadaneTheoremForLargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		maxContiguousSum(array);
	}

	private static void maxContiguousSum(int[] array) {
		int maxHere=0;
		int maxSoFar=0;
		int start=0,end=0,s=0;
		for(int i=0;i<array.length;i++){
			maxHere+=array[i];
			if(maxHere<0){
				maxHere=0;
				s=i+1;
			}
			else if(maxSoFar<maxHere){
				maxSoFar=maxHere;
				start=s;
				end=i;
			}
		}
		System.out.println("Maximum Contiguous Sum Subarray is from "+start+" to "+end+" with sum "+maxSoFar+" .");
		
	}

}
