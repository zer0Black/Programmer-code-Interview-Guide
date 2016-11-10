package com.lxt.arrayMatrix;

import java.awt.image.RescaleOp;

/**
 * 不包含本位制值的累乘数组
 * 题目：给定一个整型数组arr，返回不包含本位置值的累乘数组
 * 
 * 要求：时间复杂度O(N)，除需要返回的结果数组外，额外空间复杂度为O(1)
 * @author zer0
 *
 */
public class Product {

	/*
	 * 可用除法的方式
	 * 先得到所有位置相乘的总乘积，然后用总乘积分别除以每个数组
	 */
	public static int[] product1(int[] arr){
		if (arr == null && arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		int multi = 1;
		for(int i = 0; i < arr.length; i++){
			multi *= arr[i];
		}
		
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			res[i] = multi / arr[i];
		}
		
		return res;
	}
	
	/*
	 * 不可用除法的方式
	 * 用两个数组l[] 和 r[]分别记录从左到右累乘积 和 从右到左的累乘积
	 */
	public static int[] product2(int[] arr){
		if (arr == null && arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		int[] l = new int[arr.length];
		int[] r = new int[arr.length];
		
		int multi = 1;
		for(int i = 0; i < arr.length; i++){
			multi *= arr[i];
			l[i] = multi;
		}
		
		multi = 1;
		for(int i = arr.length-1; i >= 0; i--){
			multi *= arr[i];
			r[arr.length - 1 - i] = multi;
		}
		
		int[] res = new int[arr.length];
		res[0] = r[arr.length - 2];
		res[arr.length-1] = l[arr.length - 2];
		for(int i = 1; i < arr.length-1; i++){
			res[i] = l[i - 1] * r[arr.length - i -2];
		}
		
		return res;
	}
	
	/*
	 * 还是上面的方法
	 * 但可通过复用res数组，来剩下两个辅助数组
	 */
	public static int[] product3(int[] arr){
		if (arr == null && arr.length == 0) {
			throw new RuntimeException("error");
		}
		
		int tmp = 1;
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			tmp *= arr[i];
			res[i] = tmp;
		}
		
		tmp = 1;
		for(int i = arr.length-1; i >= 1; i--){
			res[i] = res[i-1] * tmp;
			tmp *= arr[i];
		}
		res[0] = tmp;
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,4};
		int[] res = product3(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
