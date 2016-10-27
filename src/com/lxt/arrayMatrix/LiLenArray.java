package com.lxt.arrayMatrix;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 最长可整合子数组的长度
 * 题目：先给出可整合数组的定义。如果一个数组在排序之后，
 *      每相领两个数差的绝对值都为1，则该数组 为可整合数组。
 * 例如：[5,3,4,6,2]排序之后为[2,3,4,5,6]，符合每相领两个数
 *       差的绝对值都为1，所以这个数组为可整合数组。
 * @author zer0
 *
 */
public class LiLenArray {

	/**
	 * 暴力解，给所有子数组排序，求解
	 * 总共有O(N²)个数组，每次排序O(NlogN)，所以时间复杂度为O(N3logN)
	 * @param arr
	 * @return
	 * 2016年10月27日
	 */
	public static int getLIL1(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int len = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = i; j < arr.length; j++){
				if (isLI(arr, i, j)) {
					len = Math.max(len, j-i+1);
				}
			}
		}
		return len;
	}
	
	//判断是否是可整合子数组
	private static boolean isLI(int[] arr, int i, int j){
		int[] newArray = Arrays.copyOfRange(arr, i, j+1);
		Arrays.sort(newArray);
		for(int k = 1; k < newArray.length; k++){
			if (newArray[k-1] != newArray[k]-1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 依然暴力解，但判断是否为可整合子数组的时候，采用O(1)的方法
	 * 判断子数组是否重复，不重复，则找到最大值和最小值，判断最大值和最小值相减+1是否为子数组长度
	 * 是的话，即为可整合子数组
	 * @param arr
	 * @return
	 * 2016年10月27日
	 */
	public static int getLIL2(int[] arr){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int len = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++){
			int maxValue = Integer.MIN_VALUE;
			int minValue = Integer.MAX_VALUE;
			set.clear();
			for(int j = i; j < arr.length; j++){
				if (set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
				maxValue = Math.max(maxValue, arr[j]);
				minValue = Math.min(minValue, arr[j]);
				if (maxValue - minValue == j-i) {
					len = Math.max(len, j-i+1);
				}
			}
		}
		
		return len;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {5,5,3,2,6,4,3};
		System.out.println(getLIL1(arr));
		System.out.println(getLIL2(arr));
	}
}
