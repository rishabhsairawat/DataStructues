package dynamicProgramming;

public class KnapsackProblem01 {
	private static int max(int a,int b){
		return (a>b)?a:b;	
	}
	
	private static void getMaximumValue(int[] val, int[] wt, int W, int n) {
		int sol[][]=new int[n+1][W+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<W+1;j++){
				if(i==0 || j==0)
					sol[i][j]=0;
				else if(wt[i-1]>j){
					sol[i][j]=sol[i-1][j];
				}
				else
					sol[i][j]=max(val[i-1]+sol[i-1][j-wt[i-1]],sol[i-1][j]);
			}
		}
		System.out.println(sol[n][W]);
		
	}

	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int n=val.length;
	    int W=50;
	    getMaximumValue(val,wt,W,n);
	}
}
