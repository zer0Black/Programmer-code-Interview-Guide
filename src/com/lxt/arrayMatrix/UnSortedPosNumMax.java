package com.lxt.arrayMatrix;

/**
 * 未排序正数数组中累加和为给定值的最长子数组长度
 * 题目：给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。
 *       求arr的所有子数组中所有元素相加和为k的最长子数组长度。
 * @author zer0
 *
 */
public class UnSortedPosNumMax {
	
	/**
	 * 快慢指针，快指针先走，和慢指针相加。和大于k，慢指针走，边走边减
	 * @param arr
	 * @param k
	 * @return
	 * 2016年10月28日
	 */
	public static int getMaxLength(int[] arr, int k){
		if (arr == null || arr.length == 0 || k <= 0) {
			throw new RuntimeException("error");
		}
		
		int slow = 0;
		int fast = 0;
		int sum = 0;
		
		int max = 0;
		while(fast < arr.length){
			if (sum < k) {
				sum += arr[fast++];
			}else if (sum > k) {
				sum -= arr[slow++];
			}else {
				max = Math.max(max, fast - slow + 1);
				sum -= arr[slow++];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,1,1,1};
		int k = 3;
		
		System.out.println(getMaxLength(arr, k));
	}

}
