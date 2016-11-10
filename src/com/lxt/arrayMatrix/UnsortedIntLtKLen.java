package com.lxt.arrayMatrix;

/**
 * 未排序数组中累加和小于或等于给定值的最长子数组长度
 * @author zer0
 *
 */
public class UnsortedIntLtKLen {

	/*
	 * sum[i]为arr[0...i]位置的 和
	 * 再用一个数组helpArr记录所有位置的左边最大和
	 * 所以helpArr是有序的，可用二分查找到大于等于某个值的最左出现位置
	 */
	public static int getMaxLength(int[] arr, int k){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		int[] helpArr = new int[arr.length + 1];
		int sum = 0;
		helpArr[0] = sum;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			helpArr[i+1] = Math.max(helpArr[i], sum);
		}
		
		sum = 0;
		int len = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			int tmp = getLeftPos(helpArr, sum - k);
			len = Math.max(len, tmp==-1?0:i-tmp+1);
		}
		return len;
	}
	
	private static int getLeftPos(int[] arr, int k){
		int left = -1;
		int right = arr.length;
		while(left+1 < right){
			int mid = (right - left)/2 + left;
			if (arr[mid] < k) {
				left = mid;				
			}else {
				right = mid;
			}
		}
		
//		if (left+1 >= arr.length || arr[left+1] != k) {
//			return -1;
//		}
		
		return left + 1;
	}
	
	public static void main(String[] args) {
		int[] arr= {3,-2,-4,0,6};
		int k = -2;
		System.out.println(getMaxLength(arr, k));
	}
}
