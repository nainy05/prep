package com.feb;

public class MergeArrays {
	
	 public static void main(String[] args) 
	    {
	        MergeArrays mergearray = new MergeArrays();
	         
	        /* Initialize arrays */
	        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
	        int N[] = {5, 7, 9, 25};
	        int n = N.length;
	        int m = mPlusN.length - n;
	 
	        /*Move the m elements at the end of mPlusN*/
	        mergearray.moveToEnd(mPlusN, m + n);
	 
	        /*Merge N[] into mPlusN[] */
	        mergearray.merge(mPlusN, N, m, n);
	 
	        /* Print the resultant mPlusN */
	        mergearray.printArray(mPlusN, m + n);
	    }

	private void printArray(int[] mPlusN, int length) {
		for (int j = 0; j < length; j++) {
			System.out.print(mPlusN[j] + " ");
		}
	}

	private void merge(int[] mPlusN, int[] N, int m, int n) {
		int i = 0,  j = n, k = 0;
		while(i < n && j < m+n){
			if(N[i] < mPlusN[j]){
				mPlusN[k++] = N[i++];
			}
			else{
				mPlusN[k++] = mPlusN[j++];
			}
		}
		while(i < n){
			mPlusN[k++] = N[i++];
		}
	}

	private void moveToEnd(int[] mPlusN, int length) {
		int index = length-1;
		for (int i = length-1; i >= 0; i--) {
			if(mPlusN[i] != -1){
				mPlusN[index] = mPlusN[i];
				index--;
			}
		}
	}

}
