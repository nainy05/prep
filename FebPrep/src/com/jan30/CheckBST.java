package com.jan30;

class BinaryTree{
	Node root;
	
	//For BST using in-order traversal
	Node current; Node prev;
	public boolean isBSTUsingInorder() {
		current = root;
		prev = null;
		return isBSTUsingInorder(current);
	}

	private boolean isBSTUsingInorder(Node current) {
		if(current == null)
			return true;
		if(!isBSTUsingInorder(current.left))
			return false;
		if(prev == null || prev.data < current.data){
			prev = current;
			return isBSTUsingInorder(current.right);
		}
		return false;
	}

	public boolean isBST() {
		return isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	private boolean isBST(Node node, int maxValue, int minValue) {
		if(node == null)
			return true;
		if(node.data < maxValue && node.data > minValue)
			return isBST(node.left,node.data,minValue) && isBST(node.right, maxValue, node.data);
		return false;
	}

}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int d){
		data=d;
	}
}

public class CheckBST {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST ");
        
        if (tree.isBSTUsingInorder())
            System.out.println("IS BST (Inorder)");
        else
            System.out.println("Not a BST (Inorder)");

	}

}
