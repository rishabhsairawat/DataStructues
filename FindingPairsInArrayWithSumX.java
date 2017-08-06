package arrays;

public class FindingPairsInArrayWithSumX {
	private static final int MAX=100000;
	 static void findPairs(int[] a, int x) {
		boolean[] binaryHashMap=new boolean[MAX];
		for(int i=0;i<a.length;++i){
			int temp=x-a[i];
			if(temp>=0 && binaryHashMap[temp]){
				System.out.println("("+temp+","+a[i]+")");
			}
			binaryHashMap[a[i]]=true;
		}
	}
	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, 8};
	    int X = 16;
	    findPairs(A,X);
	}
}
