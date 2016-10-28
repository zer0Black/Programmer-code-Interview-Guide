package com.lxt.arrayMatrix;

/**
 * 自然数数组的排序
 * 题目：给定一个长度为N的整型数组arr，其中有N个互不相等的自然数1~N，请实现arr的排序，
 *      但不要把下表0~N-1位置上的数直接赋值替换成1~N
 * 要求：时间复杂度为O(N)，空间复杂度O(1)
 * @author lixuetao
 *
 */
public class NumSort {

	public static void sort1(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		for(int i = 0; i < arr.length; i++){
			int tmp=arr[i];
			while(arr[i] != i+1){
				int next = arr[tmp-1];
				arr[tmp-1] = tmp;
				tmp = next;
			}
		}
	}
	
	public static void sort2(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		for(int i = 0; i < arr.length; i++){
			while(arr[i] != i+1){
				int tmp = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,6,1,5,4};
		sort2(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
