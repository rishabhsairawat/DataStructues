package binarySearchTree;

public class SortedArrayToBalancedBST {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	 Node sortedArrToBST(int[] arr, int i, int j) {
			if(i>j)
				return null;
			int mid=(i+j)/2;
			Node node = new Node(arr[mid]);
			node.left= sortedArrToBST(arr,i,mid-1);
			node.right=sortedArrToBST(arr, mid+1, j);
			return node;
		}
	 void inorderTraversal(Node node){
		 if(node==null)
			 return;
		 inorderTraversal(node.left);
		 System.out.print(node.key+" ");
		 inorderTraversal(node.right);
	 }
	public static void main(String[] args) {
		SortedArrayToBalancedBST tree=new SortedArrayToBalancedBST();
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
		int n=arr.length;
		tree.root=tree.sortedArrToBST(arr,0,n-1);
		tree.inorderTraversal(tree.root);
	}

	

}
