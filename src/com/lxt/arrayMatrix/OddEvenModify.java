package com.lxt.arrayMatrix;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 * 题目：给定一个长度不小于2的数组arr，实现一个函数调整arr，
 *      要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
 * @author lixuetao
 *
 */
public class OddEvenModify {

	public static void modify(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		
		int oddIndex = 1; //奇数下标
		for(int i=0; i < arr.length && oddIndex < arr.length; i+=2){
			while(((i & 1) == 0) && ((arr[i] & 1) == 1) && oddIndex < arr.length){
				int tmp = arr[oddIndex];
				arr[oddIndex] = arr[i];
				arr[i] = tmp;
				oddIndex+=2;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,2,4,6,8,10};
		modify(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
