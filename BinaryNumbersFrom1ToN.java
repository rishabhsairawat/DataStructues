package queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersFrom1ToN {

	public static void main(String[] args) {
		int n=4;
		printBinaryNumbers(n);

	}

	 static void printBinaryNumbers(int n) {
		Queue<String> queue=new LinkedList<String>();
		queue.add("1");
		while(n!=0){
			String s1=queue.peek();
			queue.remove();
			System.out.print(s1+" ");
			String s2=s1;
			queue.add(s1+"0");
			queue.add(s2+"1");
			n--;
		}
	}

}
