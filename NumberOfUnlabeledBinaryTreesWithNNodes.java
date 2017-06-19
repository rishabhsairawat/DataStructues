package binaryTree;

public class NumberOfUnlabeledBinaryTreesWithNNodes {

	public static void main(String[] args) {
		int n=3;
		System.out.println("Number of Different Labeled binary trees with "+n+" nodes is:"+findNoOfUnLabeledBinaryTrees(n));
	}

	 static int findNoOfUnLabeledBinaryTrees(int n) {
		int res=0;
		if(n<1)
			return 1;
		for(int i=0;i<n;i++){
			res += findNoOfUnLabeledBinaryTrees(i)*findNoOfUnLabeledBinaryTrees(n-i-1);
		}
		return res;
	}

}
