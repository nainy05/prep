package com.feb;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
	//Driver code
    public static void main(String args[])
    {
        int n = 12, m = 100;
 
        // Display Stepping Numbers in
        // the range [n,m]
        displaySteppingNumbers(n,m);
    }

	private static void displaySteppingNumbers(int n, int m) {
		int steppingNumbers = 0;
		for (int i = 1; i <= 9; i++) {
			steppingNumbers += bfs(n,m,i);
		}
		System.out.println("\nNumber of Stepping numbers :: " + steppingNumbers);
	}

	private static int bfs(int n, int m, int number) {
		
		int steppingNo = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(number);
		while(!queue.isEmpty()){
			int current = queue.poll();
			if(!isSingleDigit(current) && current >= n && current <= m){
				steppingNo++;
				System.out.print(current + " ");
			}
			if(current > m){
				continue;
			}
			int lastDigit = current%10;
			int nextStepping1 = current*10 + lastDigit - 1;
			int nextStepping2 = current*10 + lastDigit + 1;
			
			if(lastDigit == 0)
				queue.add(nextStepping2);
			else if(lastDigit == 9)
				queue.add(nextStepping1);
			else{
				queue.add(nextStepping1);
				queue.add(nextStepping2);
			}
		}
		return steppingNo;
	}

	private static boolean isSingleDigit(int current) {
		if(current >-10 && current < 10)
			return true;
		return false;
	}

}
