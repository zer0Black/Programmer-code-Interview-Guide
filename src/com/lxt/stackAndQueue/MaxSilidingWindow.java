package com.lxt.stackAndQueue;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 题目：有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，
 *      窗口每次向右滑动一个位置。
 *      如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值
 * @author lixuetao
 *
 */
public class MaxSilidingWindow {
	
	/**
	 * 算法原型，窗口最大值/最小值求解法。
	 * 用一个LinkedList作辅助，LinkedList开头永远保存最大值/最小值
	 * @param arr
	 * @param w 窗口大小
	 * @return
	 */
	public static int[] maxWindow(int[] arr, int w){
		 if (arr == null || arr.length == 0 || w<1) {
			return null;
		 }
		 
		 LinkedList<Integer> helps = new LinkedList<>();
		 int[] res = new int[arr.length - w + 1];
		 int index = 0; //res数组的下标
		 for(int i = 0; i < arr.length; i++){
			 while(!helps.isEmpty() && arr[helps.peekLast()] <= arr[i]){
				 helps.pollLast();
			 }
			 helps.add(i);
			 
			 if(i-w == helps.peekFirst()){
				 helps.pollFirst();
			 }
			 
			 if(i > w - 1){
				 res[index++] = arr[helps.peekFirst()];
			 }
		 }
		 
		 return res;
	 }
	
}
