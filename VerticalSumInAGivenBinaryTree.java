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
	void verticalSum(){
		TreeMap<Integer,Integer> map=new TreeMap<>();
		getSum(this.root,map,0);
		for(Integer key:map.keySet())
			System.out.println(map.get(key));
	}
	private void getSum(Node node, TreeMap<Integer, Integer> map, int hd) {
		if(node==null)
			return;
		if(map.containsKey(hd)){
			int oldSum=map.get(hd);
			map.put(hd, oldSum+node.key);
		}
		else{
			map.put(hd, node.key);
		}
		getSum(node.left, map, hd-1);
		getSum(node.right, map, hd+1);
	}
	public static void main(String[] args) {
		VerticalSumInAGivenBinaryTree tree=new VerticalSumInAGivenBinaryTree();
		tree.makeTree();
		tree.verticalSum();
	}

}
