package lab;

public class CountTrailingZeroesInFactorialOfANumber {

	public static void main(String[] args) {
		int n1=101,n2=1000,n3=4617;
		countTrailingZeroes(n1);
		countTrailingZeroes(n2);
		countTrailingZeroes(n3);
	}

	 static void countTrailingZeroes(int n) {
		int count=0;
		while(n>0){
			count+=n/5;
			n=n/5;
		}
		System.out.println(count);
	}

}
