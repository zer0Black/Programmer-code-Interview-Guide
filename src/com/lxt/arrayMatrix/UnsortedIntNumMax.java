package com.lxt.arrayMatrix;

import java.util.HashMap;

/**
 * 未排序数组中累加和为给定值的最长子数组系列问题
 * @author zer0
 *
 */
public class UnsortedIntNumMax {

	/*
	 * 求i位置的最长子数组d[i]，相当于求d[i] - k的位置
	 * 用一个hashmap来记录和
	 */
	public static int getMaxLength(int[] arr, int k){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		HashMap<Integer, Integer> map = new HashMap<>(); //键为和，值为sum最早出现的位置
		map.put(0, -1);
		int len = 0;
		int sum = 0;
		for(int i=0; i < arr.length; i++){
			sum += arr[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			
			if (map.containsKey(sum - k)) {
				len = Math.max(len, i - map.get(sum - k));
			}
		}
		
		return len;
	}
	
}
