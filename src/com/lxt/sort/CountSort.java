package com.lxt.sort;

/**
 * 计数排序
 * @author lixuetao
 *
 */
public class CountSort {

	public static void countSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int max = 0;
		for(int i = 0; i < arr.length; i++){
			max = Math.max(arr[i], max);
		}
		
		int help[] = new int[max+1];
		
		for(int i = 0; i < arr.length; i++){
			help[arr[i]]++;
		}
		
		int index = 0;
		for(int i = 0; i < help.length; i++){
			while(help[i]-- > 0){
				arr[index++] = i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,1,8,4,9,5,4,2,3};
		countSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
