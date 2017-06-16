package queue;

public class FirstCircularTourToVisitAllPetrolPumps {

	public static void main(String[] args) {
		int petrolPumpArr[][] = {{4, 6}, {6, 5}, {7, 3},{4, 5}};
		int n=petrolPumpArr.length;
		int start=printTour(petrolPumpArr,n);
		if(start==-1)
			System.out.println("No solution exists!");
		else
			System.out.println("Starting station should be: "+(start+1));

	}

	private static int printTour(int[][] petrolPumpArr, int n) {
		int start=0;
		int end=1;
		int curr_petrol=petrolPumpArr[start][0]-petrolPumpArr[start][1];
		//Running a loop to visit all petrol pumps and we should come back to starting pump with 0 or more petrol
		while(end != start|| curr_petrol<0){
			//If petrol becomes less than 0 and we have not visit all petrol pumps than change the starting pump
			while(curr_petrol<0 && start!=end){
				//reset current petrol
				curr_petrol-=petrolPumpArr[start][0]-petrolPumpArr[start][1];
				start=(start+1)%n;
				//if we again reach at the same starting point while choosing next starting point then exit
				if(start==0)
					return -1;
			}
			//add petrol from next petrol pump and choose new end for next petrol pump
			curr_petrol += petrolPumpArr[end][0]-petrolPumpArr[end][1];
			end=(end+1)%n;
		}
		
		return start;
	}

}
