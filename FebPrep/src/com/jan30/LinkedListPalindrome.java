package com.jan30;

import java.util.Stack;

class LinkedList{
	ListNode head;
	
	public void push(char data){
		if(head == null)
			head = new ListNode(data);
		else{
			ListNode current = head;
			while(current.next != null)
				current = current.next;
			current.next = new ListNode(data);
		}
	}
	
	public void printList(ListNode node){
		if(node == null){
			System.out.println();
			return;
		}
		System.out.print(node.data + "");
		printList(node.next);
	}

	//start and end of linkedlist
	ListNode start; ListNode end;
	
	private boolean isPalindrome(ListNode end) {
		if(end == null)
			return true;
		if(!isPalindrome(end.next))
			return false;
		
		if(start.data != end.data)
			return false;
		
		start = start.next;
		
		return true;
	}
	
	public boolean isPalindrome(){
		if(head == null)
			return true;
		start = head;
		end = head;
		return isPalindrome(end);
	}
	
	public boolean isPalindromeUsingStack(){
		if(head == null)
			return true;
		Stack<Character> s = new Stack<>();
		ListNode current = head;
		while(current != null){
			s.push(current.data);
			current = current.next;
		}
		return false;
	}
}

class ListNode{
	char data;
	ListNode next;
	ListNode(char d){
		data = d;
	}
}

public class LinkedListPalindrome {
	public static void main(String[] args) {
		 /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
        for (int i = 0; i < str.length; i++) 
        {
            llist.push(str[i]);
            llist.printList(llist.head);
            if (llist.isPalindrome() != false) 
            {
                System.out.println("Is Palindrome");
                System.out.println("");
            } 
            else
            {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }
	}
}
