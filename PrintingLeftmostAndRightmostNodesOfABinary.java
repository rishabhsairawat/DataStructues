package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintingLeftmostAndRightmostNodesOfABinary {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	void makeTree(){
		 this.root = new Node(1);
		 this.root.right=new Node(2);
		 this.root.right.right=new Node(3);
	}
	void printLeftMostAndRighMost(Node node){
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		q.add(null);
		boolean isFirst=true;
		boolean isLast=false;
		int rightMost=0;
		while(!q.isEmpty()){
			Node temp=q.poll();
			if(isFirst){
				System.out.print(temp.key+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				isFirst=false;
			}
			else if(temp==null){
				if(q.size()>=1){
					q.add(null);
				}
				isFirst=true;
				if(isLast)
					System.out.print(rightMost+" ");
			}
			else{
				rightMost=temp.key;
				isLast=true;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		PrintingLeftmostAndRightmostNodesOfABinary tree =new PrintingLeftmostAndRightmostNodesOfABinary();
		tree.makeTree();
		tree.printLeftMostAndRighMost(tree.root);
	}

}
