package com.lxt.arrayMatrix;

/**
 * 数组中子数组的最大累乘积
 * 题目：给定一个double类型的数组arr，其中的元素可正、可负、可0，返回子数组
 *      累乘的最大乘积。
 * @author lixuetao
 *
 */
public class MaxProduct {
	
	/**
	 * 求以i位置结尾的最大乘积:
	 * 1、假设i位置为正数，则i-1位置的累乘最大值 x i位置的数，即为i位置累乘最大值
	 * 2、假设i位置为负数，则i-1位置的累乘最小值 x i位置的数，即为i位置累乘最大值
	 * 3、也有可能i位置的数就是最大的数，不和i-1相乘
	 */
	public static int getMax(int[] arr){
		if(arr == null || arr.length ==0){
			throw new RuntimeException("error");
		}
		
		int res = arr[0]; //整个数组的最大累乘积
		int max = arr[0]; //以i位置结尾的最大累乘积
		int min = arr[0]; //以i位置结尾的最小累乘积
		
		for(int i = 1; i < arr.length; i++){
			int maxHere = max * arr[i];
			int minHere = min * arr[i];
			max = Math.max(Math.max(minHere, maxHere), arr[i]);
			min = Math.min(Math.min(maxHere, minHere), arr[i]);
			res = Math.max(res, max);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,-2,4,-8,-1,2,5};
		System.out.println(getMax(arr));
	}
	
}
