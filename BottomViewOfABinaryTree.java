package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfABinaryTree {
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
		 this.root.left = new Node(2);
		 this.root.right = new Node(3);
		 this.root.left.left = new Node(4);
		 this.root.left.right = new Node(5);
		 this.root.right.left =new Node(6);
		 this.root.right.right =new Node(7);
		 this.root.right.left.right=new Node(8);
		 this.root.right.right.right=new Node(9);
		 this.root.right.right.left=new Node(10);
		 this.root.right.right.left.right=new Node(11);
		 this.root.right.right.left.right.right=new Node(12);
	}

	void bottomView(Node node){
		if(node==null)
			return;
		Queue<Node> queue=new LinkedList<Node>();
		Queue<Integer> distenceQueue=new LinkedList<Integer>();
		queue.add(node);
		distenceQueue.add(0);
		TreeMap<Integer, Node> map=new TreeMap<>();
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			int hd=distenceQueue.poll();
			map.put(hd, temp);
			if(temp.left!=null){
				queue.add(temp.left);
				distenceQueue.add(hd-1);
			}
			if(temp.right!=null){
				queue.add(temp.right);
				distenceQueue.add(hd+1);
			}
		}
		for(Integer key:map.keySet())
			System.out.print(map.get(key).key+" ");
	}
	public static void main(String[] args) {
		BottomViewOfABinaryTree tree=new BottomViewOfABinaryTree();
		tree.makeTree();
		tree.bottomView(tree.root);
	}

}
