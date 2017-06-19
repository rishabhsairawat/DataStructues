package binaryTree;

	class Node{
	int key;
	Node left, right;
	public Node(int item){
		key=item;
		left=right=null;
	}
}
	public class BinaryTreeRepresentationExample {
	Node root;

	BinaryTreeRepresentationExample(){
		this.root=null;
	}
	
	public static void main(String[] args) {
		BinaryTreeRepresentationExample tree=new BinaryTreeRepresentationExample();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
	  /*
			 1
          /     \
         2       3
       /  \     /  \
      4  null null null
    /  \
  null null
   */
	}

}
