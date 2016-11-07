package com.lxt.arrayMatrix;

import java.util.Arrays;

/**
 * 数组中未出现的最小正整数
 * 题目：给定一个无序整型数组arr，找到数组中未出现的最小正整数
 * @author zer0
 *
 */
public class MissNum {

	public static int missNum1(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		Arrays.sort(arr);
		int i = 1;
		
		if (arr[0] > 1) {
			return 1;
		}
		
		for(; i < arr.length; i++){
			if (arr[i] - 1 != arr[i-1] && arr[i] > 1) {
				return arr[i]-1;
			}
		}
		
		return arr[i]+1;
	}

	/*
	 * 元神归位方法：
	 * 遍历所有数，把每个数放到自己对应的下标（如果存在）
	 */
	public static int missNum2(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		for(int i = 0; i < arr.length; i++){
			if (arr[i] != i+1 && arr[i] > 0 && arr[i] <= arr.length) {
				int tmp = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = tmp;
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			if (arr[i] != i+1) {
				return i+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {2,4,5};
		int[] arr2 = {-1,-2,1,2,3,2,5};
		int[] arr3 = {1,2,3,4,6,7,8};
		
		System.out.println(missNum2(arr1));
		System.out.println(missNum2(arr2));
		System.out.println(missNum2(arr3));
	}
	
}
