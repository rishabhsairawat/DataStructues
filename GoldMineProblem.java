package backtracking;
//not a backtracking solution
public class GoldMineProblem {

	public static void main(String[] args) {
		int gold[][]={ {1, 3, 1, 5},
					{2, 2, 4, 1},
					{5, 0, 2, 3},
					{0, 6, 1, 2}};
		int m=4,n=4;
		System.out.println("Maximum Gold:"+getMaxGold(gold,m,n));

	}
	
	 static int getMaxGold(int[][] gold, int m, int n) {
		int[][] goldTable=new int[m][n];
		
		for(int col=n-1;col>=0;col--){
			for(int row=0;row<m;row++){
				int right=(col==n-1)?0:goldTable[row][col+1];
				int right_up=(row==0||col==n-1)?0:goldTable[row-1][col+1];
				int right_down=(row==m-1||col==n-1)?0:goldTable[row+1][col+1];
				
				goldTable[row][col]=gold[row][col]+Math.max(right,Math.max(right_down,right_up));
			}	
		}
		int res=goldTable[0][0];
		for(int i=1;i<m;i++)
			res=Math.max(res, goldTable[i][0]);
		return res;
	}

}
