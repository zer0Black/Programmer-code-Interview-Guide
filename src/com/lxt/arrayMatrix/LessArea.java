package com.lxt.arrayMatrix;

/**
 * 在数组中找到一个局部最小的位置
 * 题目：定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr长度为N(N>1)时，如果
 *      arr[0]<arr[1],那么arr[0]是局部最小；如果arr[N-1] < arr[N-2]，那么arr[N-1] 
 *      是局部最小。如果0<i<N-1，既有arr[i] < arr[i-1],又有arr[i] < arr[i+1]，那么
 *      arr[i]是局部最小。
 *      给定无需数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需要返回arr中任意
 *      一个局部最小出现的位置即可
 * @author lixuetao
 *
 */
public class LessArea {

	/*
	 * 根据定义顺序遍历
	 */
	public static int getLessIndex1(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		
		if (arr[arr.length -1] < arr[arr.length-2]) {
			return arr.length-1;
		}
		
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
				return i;
			}
		}
		
		throw new RuntimeException("找不到局部最小位置");
	}
	
	/*
	 * 二分法求解
	 * 二分法并不只是适用于有序情况，
	 * 只要能确定二分两侧中，有一侧肯定存在要找的内容，就可用二分
	 */
	public static int getLessIndex2(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		
		if (arr[arr.length -1] < arr[arr.length-2]) {
			return arr.length-1;
		}
		
		int left = 0;
		int right = arr.length - 1;
		while(left+1 < right){
			int mid = (right - left)/2 + left;
			if (arr[mid] > arr[mid-1]) {
				right = mid;
			}else if (arr[mid] > arr[mid + 1]) {
				left = mid;
			}else {
				return mid;
			}
		}
		
		throw new RuntimeException("找不到局部最小位置");
	}
	
	public static void main(String[] args) {
		int[] arr = {7,6,8,7,8,5,4,5};
		System.out.println(getLessIndex1(arr));
		System.out.println(getLessIndex2(arr));
	}
}
