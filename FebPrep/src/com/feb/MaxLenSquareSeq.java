package com.feb;

public class MaxLenSquareSeq {

	public static void main(String[] args) {
		String str = "ababc";
		int maxLen = getMaxLenSquareString(str);
		System.out.println(maxLen);
	}

	private static int getMaxLenSquareString(String str) {
		int maxLen = 1;
		for (int i = 0; i < str.length(); i++) {
			//System.out.println(str.substring(0,i)+" "+ str.substring(i,str.length()));
			int currLen = getMaxLengthSquare(str.substring(0,i).toCharArray(),str.substring(i,str.length()).toCharArray());
			
			//System.out.println(currLen);
			if(currLen > maxLen)
				maxLen = currLen;
		}
		return maxLen;
	}

	private static int getMaxLengthSquare(char[] str1, char[] str2) {
		int m = str1.length;
		int n = str2.length;
		
		if(m == 0 || n == 0)
			return Integer.MIN_VALUE;
		
		int dp[][] = new int[m+1][n+1];
		
	/*	for (int i = 0; i < m; i++) {
			if(str1[i] == str2[0])
				dp[i][0] = 1;
			if(i > 0)
				dp[i][0] = dp[i-1][0];
		}
		
		if(dp[0][0] > 0){
			for (int j = 1; j < n; j++) {
				dp[0][j] = dp[0][j-1];
			}
		}*/
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Integer.max(dp[i-1][j],dp[i][j-1]);
//				System.out.println(i + " " + j);
				if(str1[i-1] == str2[j-1])
					dp[i][j] = 1 + dp[i-1][j-1];
			}
		}
		
		return 2*dp[m][n];
	}

}
