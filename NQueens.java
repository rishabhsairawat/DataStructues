package backtracking;

public class NQueens {
	static final int N=4;
	static int k=1;
	public static void main(String[] args) {
		
		int board[][]=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j]=0;
		solveNQueen(board);
	}

	static boolean solveNQueen(int[][] board) {
		if(solveNQueenUtil(board,0)==true)
		{
			System.out.println("Solution doesn't exists");
			return false;
		}
		//printSolution(board);
		return true;
		
	}

	  static void printSolution(int[][] board) {
		 
		 System.out.println("Solution No.:"+k++);
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	static boolean solveNQueenUtil(int[][] board, int col) {
		if(col==N){
			printSolution(board);
			return true;
		}
			
		for(int i=0;i<N;i++){
			if(isSafe(board,i,col)){
				board[i][col]=1;
				solveNQueenUtil(board,col+1);
//				if(solveNQueenUtil(board,col+1)==true)
//					return true;
				board[i][col]=0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		int i,j;
		//left side of same row
		for( i=0;i<col;i++){
			if(board[row][i]==1)
				return false;
		}
		//upper diagonal on the left hand side
		for(i=row,j=col;i>=0 && j>=0;i--,j--)
		if(board[i][j]==1)
			return false;
		//lower diagonal on the left hand side
		for(i=row,j=col;i<N && j>=0;j--,i++)
			if(board[i][j]==1)
				return false;
		
		return true;
	}
	
}
