package com.lxt.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 * @author lixuetao
 *
 */
public class BucketSort {

	public static void bucketSort(int[] arr){
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++){
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		int bucketNum = (max - min) / arr.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for(int i = 0; i < bucketNum; i++){
			bucketArr.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < arr.length; i++){
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}
		
		for(int i = 0; i < bucketArr.size(); i++){
			Collections.sort(bucketArr.get(i));
		}
		
		System.out.println(bucketArr.toString());
		
	}
	
	public static void main(String[] args) {
		int arr[] = {23,90,35,12,108,42,59,109,110,120,118,123,124,23,82,97,27,77};
		bucketSort(arr);
	}
	
}
