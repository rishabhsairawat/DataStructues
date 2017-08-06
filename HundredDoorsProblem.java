package lab;

public class HundredDoorsProblem {

	public static void main(String[] args) {
		int totalDoors=100;
		int walk=100;
		boolean[] door=new boolean[totalDoors+1];
		for(int i=1;i<=walk;i++){
			for(int j=i;j<=totalDoors;j+=i){
					door[j]=!door[j];
			}
		}
		for(int i=1;i<=totalDoors;i++){
			if(door[i]){
				System.out.print((i)+" ");
			}
		}

	}

}
