/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 要求：时间复杂度：O(N)
 * @author zer0
 *
 */
public class MaxSubMinNum {

	/**
	 * 一个队列，存最大值下标
	 * 一个队列，存最小值下标
	 * 一个变量res，存满足条件子数组
	 * @param arr
	 * @return
	 * 2016年9月22日
	 */
	public static int getNum1(int[] arr, int num){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		LinkedList<Integer> qmax = new LinkedList<>();
		LinkedList<Integer> qmin = new LinkedList<>();
		int res = 0;
		int j = 0;
		
		for(int i = 0; i < arr.length; i++){
			for(;j < arr.length; j++){
				while(!qmax.isEmpty() && arr[j] >= arr[qmax.peekLast()]){
					qmax.pollLast();
				}
				qmax.add(j);
				
				while(!qmin.isEmpty() && arr[j] <= arr[qmin.peekLast()]){
					qmin.pollLast();
				}
				qmin.add(j);
				
				//遍历直到右边界j不满足条件
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
			}
			
			//左边界过期
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			
			res+=j-i;
		}
		
		return res;
	}
	
	public static int getNum2(int[] arr, int num){
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		LinkedList<Integer> qmax = new LinkedList<>();
		LinkedList<Integer> qmin = new LinkedList<>();
		int res = 0;
		int i = 0;
		int j = 0;
		
		while(i < arr.length){
			while(j < arr.length){
				while(!qmax.isEmpty() && arr[j] >= arr[qmax.peekLast()]){
					qmax.pollLast();
				}
				qmax.add(j);
				
				while(!qmin.isEmpty() && arr[j] <= arr[qmin.peekLast()]){
					qmin.pollLast();
				}
				qmin.add(j);
				
				//遍历直到右边界j不满足条件
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			
			//左边界过期
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			
			res+=j-i;
			i++;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,1,7,4,2,9,1,6,3,2,8,2,1,6,9,5,4,7,1};
		int num = 3;
		
		System.out.println("第一种写法："+getNum1(arr, num));
		System.out.println("第二种写法："+getNum2(arr, num));
	}
	
}
