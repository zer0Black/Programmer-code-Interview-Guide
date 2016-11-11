package com.lxt.bitwise;

/**
 * 整数的二进制表达中1的个数
 * @author lixuetao
 *
 */
public class CountBitOne {

	public static int count1(int num){
		int res = 0;
		while(num != 0){
			res += num & 1;
			num >>>= 1;
		}
		return res;
	}
	
	public static int count2(int num){
		int res = 0;
		while(num != 0){
			num = num & (num-1);
			res++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int num = 7;
		System.out.println(count1(num));
	}
}
