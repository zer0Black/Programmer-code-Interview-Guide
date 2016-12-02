package com.lxt.dp;

/**
 * 煤球数目
 * 有一堆煤球，堆成三角棱锥形。具体：
 * 第一层放1个，
 * 第二层3个（排列成三角形），
 * 第三层6个（排列成三角形），
 * 第四层10个（排列成三角形），
 * ...
 * 如果一共有100层，共有多少个煤球？
 * @author zer0
 *
 */
public class TotalNum {

	public static int totalNum1(int n){
		int res = 0;
		int sum = 0;
		for(int i = n; i > 0; i--){
			for(int j = i; j > 0; j--){
				sum += j;
			}
			res += sum;
			sum = 0;
		}
		return res;
	}
	
	//等差数列解法
	public static int totalNum2(int n){
		int res = 0;
		for(int i = 1; i <= n; i++){
			res += ((1+i) * i) / 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println(totalNum2(n));
	}
}
