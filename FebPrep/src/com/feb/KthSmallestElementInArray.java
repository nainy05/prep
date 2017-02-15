package com.feb;

class Heap{
	int capacity;
	int heapSize;
	int[] heap;
	
	public void insert(int data){
		if(heapSize > capacity){
			System.out.println("Heap limit exceeded ");
			return;
		}
		heapSize++;
		int i = heapSize-1;
		heap[i] = data;
		
		while(i > 0 && heap[i] > heap[parent(i)]){
			swap(heap,i,parent(i));
			i = parent(heap[i]);
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void heapifyDown(int i) {
		
			int largest = i;
			if(left(i) < heapSize && heap[largest] < heap[left(i)]){
				largest = left(i);
			}
			if(right(i) < heapSize && heap[largest] < heap[right(i)]){
				largest = right(i);
			}
			if(largest != i){
				swap(heap, i, largest);
				heapifyDown(largest);
			}
		
	}

	private int right(int i) {
		return 2*i+2;
	}

	private int left(int i) {
		return 2*i+1;
	}

	private int parent(int i) {
		return (i-1)/2;
	}

	Heap(int k){
		capacity = k;
		heapSize = 0;
		heap = new int[capacity];
	}
	
	public int getMax(){
		return heap[0];
	}

	public void printHeap() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public void replaceMax(int max) {
		heap[0] = max;
		heapifyDown(0);
	}
	
	
}

public class KthSmallestElementInArray {
	
	public static void main(String[] args) {
		int arr[] = {12, 3, 5, 7, 4, 19, 26};
		int kth = findKthSmallest(arr,3);
		System.out.println(kth);
	}

	private static int findKthSmallest(int[] arr,int k) {
		Heap heap = new Heap(k);
		for (int i = 0; i < k; i++) {
			heap.insert(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if(arr[i] < heap.getMax()){
				heap.replaceMax(arr[i]);
			}
		}
		heap.printHeap();
		return heap.getMax();
	}

	

}
