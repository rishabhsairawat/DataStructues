package backtracking;

public class SolveSudoku {
	static final int N=9;
	public static void main(String[] args) {
			int[][] grid =  {{3, 0, 6, 5, 0, 8, 4, 0, 0},
							{5, 2, 0, 0, 0, 0, 0, 0, 0},
							{0, 8, 7, 0, 0, 0, 0, 3, 1},
							{0, 0, 3, 0, 1, 0, 0, 8, 0},
							{9, 0, 0, 8, 6, 3, 0, 0, 5},
							{0, 5, 0, 0, 9, 0, 6, 0, 0},
							{1, 3, 0, 0, 0, 0, 2, 5, 0},
							{0, 0, 0, 0, 0, 0, 0, 7, 4},
							{0, 0, 5, 2, 0, 6, 3, 0, 0}};
			if(solveSudoku(grid)==true)
				printGrid(grid);
			else
				System.out.println("No Solution Exists ");
	}
	 static boolean solveSudoku(int[][] grid) {
		int[] temp=findUnassigned(grid);
		if(findUnassigned(grid)!=null) {
			int row=temp[0];
			int col=temp[1];
			for(int i=1;i<=9;i++){
				if(isSafe(grid,row,col,i))
					{
						grid[row][col]=i;
						if(solveSudoku(grid))
							return true;
					}
					grid[row][col]=0;
			}
		}
		else
			return true;
		return false;
	}
	 
	 static boolean isSafe(int[][] grid,int row, int col, int num) {
		return (checkRow(grid,row,num) && checkCol(grid,col,num) && checkBlock(grid,row,col,num));
			
	}
	static boolean checkCol(int[][] grid, int col, int num) {
		for(int i=0;i<N;i++){
			if(grid[i][col]==num)
				return false;
		}
		return true;
	}
	static boolean checkRow(int[][] grid,int row, int num) {
		for(int i=0;i<N;i++){
			if(grid[row][i]==num)
				return false;
		}
		return true;
	}
	static boolean checkBlock(int[][] grid,int row, int col, int num) {
		row=row-(row%3);
		col=col-(col%3);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(grid[i+row][j+col]==num)
					return false;
			}
		}
		return true;
	}
	static int[] findUnassigned(int[][] grid) {
		int[] t=new int[2];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(grid[i][j]==0){
					t[0]=i;
					t[1]=j;
					return t;
				}
			}
		}
		return null;
	}
	static void printGrid(int[][] grid) {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
