package com.feb;

import java.util.Stack;

public class SortStack {
	
	public static void main(String[] args) {
		int[] arr = {-3, 14, 18, -5, 30 };
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		System.out.println("Stack before sorting : ");
		printStack(stack);
		
		sortStack(stack);
		System.out.println("Stack after sorting : ");
		printStack(stack);
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		int current = stack.pop();
		sortStack(stack);
		insertInSortedStack(stack,current);
		
	}

	private static void insertInSortedStack(Stack<Integer> stack, int current) {
		if(stack.isEmpty() || stack.peek() <= current)
			stack.push(current);
		else{
			int topElement = stack.pop();
			insertInSortedStack(stack, current);
			stack.push(topElement);
		}
	}

	public static void printStack(Stack<Integer> stack){
		for (Integer integer : stack) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	
}