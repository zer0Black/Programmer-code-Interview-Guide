package com.lxt.arrayMatrix;

/**
 * 子数组的最大累加和问题
 * 题目:给定一个数组arr，返回子树组的最大累加和。
 * @author lixuetao
 *
 */
public class MaxSum {

	/*
	 * 依次相加，当和小于0的时候，之前的子数组和加上后面的数 小于 后面的数，
	 * 所以之前的子数组和置为0
	 */
	public static int getMax(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
			sum = sum < 0 ? 0 : sum;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,-2,3,5,-2,6,-1};
		System.out.println(getMax(arr));
	}
	
}
