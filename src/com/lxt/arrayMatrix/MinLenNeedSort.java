package com.lxt.arrayMatrix;

/**
 * 需要排序的最短子数组长度
 * 题目：给定一个无序数组arr，求出需要排序的最短子数组长度
 * 例如：arr=[1,5,3,4,2,6,7] 返回4，因为只有[5,3,4,2]需要排序
 * @author zer0
 *
 */
public class MinLenNeedSort {

	/**
	 * 用一个变量noMinIndex从右到左记录 比右最小的数大的数的最左位置
	 * 用一个变量noMaxIndex从左到右记录比左最大的数小的数的最右位置
	 * @param arr
	 * @return
	 * 2016年10月26日
	 */
	public static int getMinLength(int[] arr){
		int noMinIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int i=arr.length-1; i>=0; i--){
			if (arr[i] > min) {
				noMinIndex = i;
			}
			min = Math.min(min, arr[i]);
		}
		
		if (noMinIndex == -1) {
			return 0;
		}
		
		int noMaxIndex = -1;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
			if (arr[i] < max) {
				noMaxIndex = i;
			}
			max = Math.max(max, arr[i]);
		}
		
		return noMaxIndex - noMinIndex + 1;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,5,3,4,2,6,7,8};
		System.out.println(getMinLength(arr));
	}
}
