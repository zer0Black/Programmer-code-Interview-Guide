package com.lxt.sort;

public class MergeSort {
	
	/*
	 * 递归实现
	 */
	public static void mergeSort1(int[] arr, int low, int high){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		if (low < high) {
			int mid = (high - low) / 2 + low;
			mergeSort1(arr, low, mid);
			mergeSort1(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	/*
	 * 遍历实现
	 */
	public static void mergeSort2(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		for(int step = 1; step < arr.length; step <<= 1){
			int offset = step * 2;
			for(int i = 0; i < arr.length; i += offset){
				merge(arr, i, Math.min(i+step-1, arr.length-1), Math.min(i+offset-1, arr.length-1));
			}
		}
	}
	
	private static void merge(int[] arr, int left, int mid ,int right){
		int[] tmp = new int[right-left+1];
		
		int index = 0;
		int index1 = left;
		int index2 = mid+1;
		while(index1 <= mid && index2 <= right){
			if (arr[index1] > arr[index2]) {
				tmp[index++] = arr[index2++];
			} else {
				tmp[index++] = arr[index1++];
			}
		}
		
		while (index1 <= mid) {
			tmp[index++] = arr[index1++];
		}
		
		while(index2 <= right){
			tmp[index++] = arr[index2++];
		}
		
		for(int i = 0; i < tmp.length; i++){
			arr[i + left] = tmp[i];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {44,5,98,2,32,1,95,35,22,62};
		mergeSort2(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
