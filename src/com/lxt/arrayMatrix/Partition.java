package com.lxt.arrayMatrix;

/**
 * 数组的partition调整
 * 题目：给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，
 *       而不用管右半部分
 * 补充题目：给定一个数组arr，其中只可能含有0,1,2三个值，实现arr的排序
 * @author zer0
 *
 */
public class Partition {

	/*
	 * 划分为两个数组，一个排序了，一个未排序
	 * 未排序数组u 边走边和 已排序数组a比较，
	 * a遍历到的元素i > u的末尾元素，则把i插入u的尾部。继续遍历
	 */
	public static void partition1(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int uIndex = 0; //未排序末尾位置
		for(int aIndex = 1; aIndex < arr.length; aIndex++){
			if (arr[aIndex] > arr[uIndex]) {
				int tmp = arr[aIndex];
				arr[aIndex] = arr[++uIndex];
				arr[uIndex] = tmp;
			}
		}
	}
	
	/*
	 * 进阶问题
	 * 划分为三个数组，0位1组，1位一组，2位一组
	 * left = -1;
	 * mid = 0;
	 * right = arr.length;
	 */
	public static void partition2(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int left = -1;
		int mid = 0;
		int right = arr.length;
		
		while(mid < right){
			if (arr[mid] == 0) {
				int tmp = arr[mid];
				arr[mid++] = arr[++left];
				arr[left] = tmp;
			}else if (arr[mid] == 2) {
				int tmp = arr[mid];
				arr[mid] = arr[--right];
				arr[right] = tmp;
			}else {
				mid++;
			}
		}
	}
	
	/*
	 * 给定k值和数组，小于k的放左边，等于k的放中间，大于k的放右边
	 */
	public static void partition3(int[] arr, int k){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int left = -1;
		int mid = 0;
		int right = arr.length;
		
		while(mid < right){
			if (arr[mid] < k) {
				int tmp = arr[mid];
				arr[mid++] = arr[++left];
				arr[left] = tmp;
			}else if (arr[mid] > k) {
				int tmp = arr[mid];
				arr[mid] = arr[--right];
				arr[right] = tmp;
			}else {
				mid++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
		partition1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		int[] arr2 = {1,0,2,1,1,2,0,2,1,0,0,2,1};
		partition2(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println();
		
		int[] arr3 = {2,3,6,1,8,3,6,5,6,5,9,9,4,2,5,8,0,4,3,5,2};
		int k = 5;
		partition3(arr3, k);
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
	}
	
}
