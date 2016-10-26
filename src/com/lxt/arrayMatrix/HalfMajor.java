package com.lxt.arrayMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 在数组中找到出现次数大于N/k的数
 * 题目：给定一个整型数组arr，打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息
 * 进阶题目：给定一个整型数组arr和一个整数k，打印所有出现次数大于N/K的数，如果没有这样的数，打印提示信息
 * @author zer0
 *
 */
public class HalfMajor {

	/**
	 * 原问题和进阶问题都可用hash表完成，时间复杂度O(N)，空间复杂度O(N)
	 * @param arr
	 * @return
	 * 2016年10月26日
	 */
	public static void printHalfMajor1(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("传入数组不正确");
		}
		
		boolean isExist = false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		for (int i : map.keySet()) {
			if (map.get(i) > arr.length/2) {
				System.out.println(i);
				isExist = true;
			}
		}
		
		if (!isExist) {
			System.out.println("没有匹配的数字");
		}
		
	}
	
	public static void printKMajor1(int[] arr, int k){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("传入数组不正确");
		}
		
		boolean isExist = false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		for (int i : map.keySet()) {
			if (map.get(i) > arr.length/k) {
				System.out.print(i + " ");
				isExist = true;
			}
		}
		
		if (!isExist) {
			System.out.println("没有匹配的数字");
		}
	}
	
	/**
	 * 一次删掉两个不同的数，留下来的，就是出现次数超过一半的
	 * @param arr
	 * @return
	 * 2016年10月26日
	 */
	public static void printHalfMajor2(int[] arr){
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("传入数组不正确");
		}
		
		int cand = 0; //备选数
		int times = 0; // 出现的次数
		for(int i = 0; i < arr.length; i++){
			if (times == 0) {
				times = 1;
				cand = arr[i];
			}else if (arr[i] == cand) {
				times++;
			}else {
				times--;
			}
		}
		
		//再遍历一遍，确认备选数出现次数是否大于一半
		times = 0;
		for(int i = 0; i < arr.length; i++){
			if (arr[i] == cand) {
				times++;
			}
		}
		
		if (times > arr.length/2) {
			System.out.println(cand);
		}else {
			System.out.println("没有匹配的数字");
		}
	}
	
	/**
	 * 同上一函数，这次的备选数cand和计数times用一个hashMap来存，存K个cand和times
	 * 步骤1：遍历，如果hashMap小于k，则把备选数加进hashMap，
	 *       否则hashMap中所有的备选数次数-1，次数为0的备选数从hashmap中移除
	 * 步骤2：再遍历，找出hashMap中所有数在arr中准确出现的次数
	 * 步骤3：判断所有的备选数出现次数是否大于N/K
	 * @param arr
	 * @param k
	 * 2016年10月26日
	 */
	public static void printKMajor2(int[] arr, int k){
		if (arr == null || arr.length == 0 || k < 2) {
			throw new RuntimeException("传入参数不正确");
		}
		
		HashMap<Integer, Integer> cands = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if (cands.containsKey(arr[i])) {
				cands.put(arr[i], cands.get(arr[i])+1);
			}else {
				if (cands.size() < k) {
					cands.put(arr[i], 1);
				}else {
					allCandsMinusOne(cands);
				}
			}
		}
		
		HashMap<Integer, Integer> reals = getReals(cands, arr);
		boolean isExist = false;
		for (int i : reals.keySet()) {
			if (reals.get(i) > arr.length/k) {
				isExist = true;
				System.out.print(i + " ");
			}
		}
		
		System.out.println(isExist ? "" : "没有匹配的数字");
	}
	
	private static void allCandsMinusOne(HashMap<Integer, Integer> cands){
		List<Integer> removeList = new ArrayList<>();
		for (int key : cands.keySet()) {
			cands.put(key, cands.get(key)-1);
			if (cands.get(key) == 0) {
				removeList.add(key);
			}
		}
		
		for (int i = 0; i < removeList.size(); i++) {
			cands.remove(i);
		}
	}
	
	private static HashMap<Integer, Integer> getReals(HashMap<Integer, Integer> map, int[] arr){
		HashMap<Integer, Integer> reals = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			int curNum = arr[i];
			if (map.containsKey(arr[i])) {
				if (!reals.containsKey(arr[i])) {
					reals.put(curNum, 1);				
				}else {
					reals.put(curNum, reals.get(curNum)+1);
				}
			}
		}
		return reals;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,4,4,4,4,4,2,2,2,2,2,2,2,5};
		
		int[] arr2 = {1,4,7,4,3,2,2,2,3,4,4,2,2,5,7,8,8,6,5,4,3,2,2,2,4};
		int k = 4;
		
		printHalfMajor1(arr1);
		printHalfMajor2(arr1);
		printKMajor1(arr2, k);
		System.out.println();
		printKMajor2(arr2, k);
	}
}
