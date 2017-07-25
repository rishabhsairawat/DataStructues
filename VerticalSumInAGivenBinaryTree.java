package binaryTree;

import java.util.TreeMap;


public class VerticalSumInAGivenBinaryTree {
	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	void makeTree(){
		 this.root = new Node(1);
		 this.root.left = new Node(2);
		 this.root.right = new Node(3);
		 this.root.left.left = new Node(4);
		 this.root.left.right = new Node(5);
		 this.root.right.left =new Node(7);
		 this.root.right.right =new Node(6);
	}
	void verticalSum(Node node){
		if(node==null)
			return;
		 
		TreeMap< Integer, Integer> hm=new TreeMap<>();
		vSum(node, 0, hm);
		if(hm!=null){
			for(Integer key:hm.keySet()){
				System.out.println(hm.get(key));
			}
		}
	}
	void vSum(Node node,int hd,TreeMap<Integer,Integer> hm){
		if(node==null)
			return;
		vSum(node.left,hd-1,hm);
		int prevSum=(hm.get(hd)==null)?0:hm.get(hd);
		hm.put(hd, prevSum+node.key);
		vSum(node.right, hd+1, hm);
	}
	
	

	public static void main(String[] args) {
		VerticalSumInAGivenBinaryTree tree=new VerticalSumInAGivenBinaryTree();
		tree.makeTree();
		tree.verticalSum(tree.root);
	}

}
