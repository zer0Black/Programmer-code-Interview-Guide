package com.lxt.bitwise;

/**
 * 不用任何比较判断找出两个数中较大的数
 * @author lixuetao
 *
 */
public class GetMax {
	/**
	 * 考擦负数的补码、正数负数的右移等操作
	 * 32位正数的第一位是用于记录该数的正负标志
	 * 0为正数，1为负数
	 */
	public static int GetMax(int a, int b){
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return a * scA + b * scB;
	}
	
	//n为1返回0，n为0返回1
	public static int flip(int n){
		return n^1;
	}
	
	//求整数n的正负号
	public static int sign(int n){
		return flip((n >> 31) & 1);
	}
	
}
