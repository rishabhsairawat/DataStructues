package backtracking;

public class KnightTour {
		static final int N=8;

	public static void main(String[] args) {
		solveKT();

	}

	 static boolean solveKT() {
		int sol[][]=new int[N][N];
		//initialization of solution matrix
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				sol[i][j]=-1;
			
		  int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
	      int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
	      sol[0][0]=0;
	      
	      if(solveKTUtil(0,0,1,sol,xMove,yMove)==false){
	    	  System.out.println("Solution doesn't exist");
	    	  return false;
	      }
	      else
	    	  printSol(sol);
	      return true;
	}

	 static void printSol(int[][] sol) {
		 for(int i=0;i<N;i++){
				for(int j=0;j<N;j++)
				{
					System.out.print(sol[i][j]+"  ");
				}	
				System.out.println();
		 }
	}

	static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] xMove, int[] yMove) {
		int next_x,next_y;
		if(movei==N*N)
			return true;
		
		for(int k=0;k<N;k++){
			next_x=x+xMove[k];
			next_y=y+yMove[k];
			if(isSafe(next_x,next_y,sol)){
				sol[next_x][next_y]=movei;
				if(solveKTUtil(next_x,next_y,movei+1,sol,xMove,yMove)==true)
					return true;
				else
					sol[next_x][next_y]=-1;
					
			}
		}
		return false;
	}

	private static boolean isSafe(int next_x, int next_y, int[][] sol) {
		if(next_x>=0 && next_x<N && next_y>=0 && next_y<N && sol[next_x][next_y]==-1)
			return true;
		return false;
	}

}
