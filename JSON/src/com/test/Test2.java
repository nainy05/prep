package com.test;

public class Test2 {
	
	public static void main(String[] args) {
		Node root = new Node(10);
	    root.left = new Node(11);
	    root.right = new Node(9);
	    root.left.left = new Node(13);
	    root.left.right = new Node(12);
	    root.right.left = new Node(13);
	    root.right.right = new Node(8);
	 
	    System.out.println("Maximum Consecutive Increasing Path Length is ");
	         //<< maxConsecutivePathLength(root);
	}

}
