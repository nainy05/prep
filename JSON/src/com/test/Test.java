package com.test;

import java.util.HashSet;

class Node{
	int data;
	Node left,right;
	
	Node(int d){
		data = d;
	}
}

public class Test {
	
	public static void main(String[] args) {
		 	Node root = new Node(8);
		    root.left    = new Node(9);
		    root.right   = new Node(4);
		    root.left.left = new Node(9);
		    root.left.right = new Node(5);
		    root.left.right.left = new Node(1);
		    root.left.right.right = new Node(12);
		    root.left.right.right.right = new Node(2);
		    root.right.right = new Node(11);
		    root.right.right.left = new Node(3);
		    if(isPathSum(root)) 
		    	System.out.println("Yes"); 
		    else
		    	System.out.println("No");
	}

	private static boolean isPathSum(Node root) {
		if(root == null)
			return false;
		HashSet<Integer> currentPath = new HashSet<>();
		return isPathSum(root.left,currentPath,root.data) || isPathSum(root.right, currentPath,root.data);
		
	}

	private static boolean isPathSum(Node root, HashSet<Integer> currentPath, int data) {
		if(root == null)
			return false;
		
		int diff = data - root.data;
		if(currentPath.contains(diff))
			return true;
		
		currentPath.add(root.data);
		
		boolean pairExists = isPathSum(root.left, currentPath, data) || isPathSum(root.right, currentPath, data);
		
		currentPath.remove(root.data);
		
		return pairExists;
	}
}
