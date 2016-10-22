package com.lxt.sort;

/**
 * 冒泡排序
 * @author zer0
 *
 */
public class BubbleSort {
	
	public static void bubbleSort1(int[] arr){
		if (arr == null || arr.length==0) {
			return;
		}
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length - i - 1; j++){
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			System.out.format("%5d", arr[i]);
		}
	}
	
	
	//错误写法
//	public static void bubbleSort2(int[] arr){
//		if (arr == null || arr.length==0) {
//			return;
//		}
//		
//		for(int i = 0; i < arr.length-1; i++){
//			for(int j = i; j < arr.length - 1; j++){
//				if (arr[j] < arr[j+1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = tmp;
//				}
//			}
//		}
//		
//		for(int i = 0; i < arr.length; i++){
//			System.out.format("%5d", arr[i]);
//		}
//	}
	
	public static void main(String[] args) {
		int[] arr = {23,56,11,94,6,22,98,103,66,85,43};
		bubbleSort1(arr);
		System.out.println();
//		bubbleSort2(arr);
	}

}
