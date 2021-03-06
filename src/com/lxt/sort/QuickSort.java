package com.lxt.sort;

import java.util.Random;

/**
 * 快速排序
 * @author zer0
 *
 */
public class QuickSort {

	public static void quickSort(int[] arr, int low ,int high){
		if (arr == null || arr.length == 0 || low >= high) {
			return;
		}
		
		int index = partition(arr, low, high);
		quickSort(arr, low, index-1);
		quickSort(arr, index+1, high);
	}
	
	public static void randomQuickSort(int[] arr, int low, int high){
		if (arr == null || arr.length == 0 || low >= high) {
			return;
		}
		
		//随机选择基准
		randomPivot(arr, low, high);
		int index = partition(arr, low, high);
		quickSort(arr, low, index-1);
		quickSort(arr, index+1, high);
		
	}
	
	
	private static void randomPivot(int[] arr, int low, int high){		
		int index = new Random().nextInt() % (high - low) + low;
		swap(arr, low, index);
	}
	
	//返回最后pivot的所在的位置
	public static int partition(int[] arr, int left, int right){
		int low = left;
		int high = right;
		int pivot = arr[low];
		
		while(low < high){
			while(low < high && arr[high] >= pivot){
				high--;
			}
			if (low < high) {
				arr[low] = arr[high];
			}
			
			while(low < high && arr[low] <= pivot){
				low++;
			}
			if (low < high) {
				arr[high] = arr[low];
			}
		}
		
		arr[low] = pivot;
		return low;
	}
	
	private static void swap(int[] arr, int point1, int point2){
		int tmp = arr[point1];
		arr[point1] = arr[point2];
		arr[point2] = tmp;
	}
	
	public static void main(String[] args) {
//		int arr[] = {44,5,98,2,32,1,95,35,22,62};
		int arr[] = {-1,-2,-3,-100,-1,-50};
		quickSort(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}
