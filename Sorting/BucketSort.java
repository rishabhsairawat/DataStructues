package sorting;
import java.util.*;
public class BucketSort {

	public static void main(String[] args) {
		double arr[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
		bucketSort(arr,arr.length);
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}

	private static void bucketSort(double[] arr,int n) {
		LinkedList<Double>[] bucket = new LinkedList[n];
		for (int i=0; i<n; i++)
		    bucket[i]=new LinkedList<Double>();
		for (int i=0; i<arr.length; i++)
			bucket[(int) (n*arr[i])].add(arr[i]);
		for (int i=0; i<n; i++){
			if(bucket[i].size()>1)
				Collections.sort(bucket[i]);
		}
		int j=0;
		for (int i=0; i<n; i++)
			if(bucket[i].size()>0)
				for(Double x:bucket[i])
					arr[j++]=x;
	}
}
