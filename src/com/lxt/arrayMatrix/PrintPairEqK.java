package com.lxt.arrayMatrix;

/**
 * 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * 题目：给定排序数组arr和整数k，不重复打印arr中所有相加和为k的
 *       不降序二元组。
 * 例如：arr=[-8,-4,-3,0,1,2,3,4,5,8,9], k=10,打印结果为:[1,9]; [2,8]
 * 
 * 进阶题目：打印不降序三元组
 * @author zer0
 *
 */
public class PrintPairEqK {
	
	//二元组
	public static void printUniquePair(int[] arr, int k){
		if (arr == null || arr.length < 2) {
			return;
		}
		
		int left = 0;
		int right = arr.length - 1;
		int sum = 0;
		while(left < right){
			sum = arr[left] + arr[right];
			if (sum < k) {
				left++;
			}else if (sum > k) {
				right--;
			}else {
				if (left == 0 || arr[left - 1] != arr[left]) {
					System.out.println(arr[left] + "," + arr[right]);
				}
				right--;
				left++;
			}
		}
	}
	
	public static void printUniqueTriad(int[] arr, int k){
		if (arr == null || arr.length < 3) {
			return;
		}
		
		for(int i = 0; i < arr.length; i++){
			//保证第一个数不重复
			if(i == 0 || arr[i] != arr[i-1])
				printCore(arr, k - arr[i], i);
		}
	}
	
	/**
	 * 三元组的每个数和其后面的所有二元组相加，与k比较
	 * @param arr
	 * @param k
	 * @param i 当前遍历到的数的位置
	 */
	private static void printCore(int[] arr, int k, int i){
		int left = i;
		int right = arr.length - 1;
		int sum = 0;
		while(left < right){
			sum = arr[left] + arr[right];
			if (sum < k) {
				left++;
			}else if (sum > k) {
				right--;
			}else {
				if (left == 0 || arr[left - 1] != arr[left]) {
					System.out.println(arr[i] + "," +arr[left] + "," + arr[right]);
				}
				right--;
				left++;
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {-8,-4,-3,0,1,1,1,1,2,3,4,5,8,9,9};
		int k = 10;
		System.out.println("符合条件的二元组：");
		printUniquePair(arr, k);
		System.out.println("符合条件的三元组：");
		printUniqueTriad(arr, k);
	}
}
