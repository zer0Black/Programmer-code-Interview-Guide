package com.lxt.bitwise;

/**
 * 只用位运算不用算数运算实现整数的加减乘除运算
 * @author lixuetao
 *
 */
public class bitwiseArithmetic {

	/**
	 * a做为异或的结果 ^
	 * b做为进制的结果 &<<1
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b){
		int sum = a;
		while(b != 0){
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}
	
	/**
	 * 减去一个数，等于加上这个数的相反数 a-b = a+(-b)
	 * 二进制运算中，取相反数等于 取反+1的结果
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minus(int a, int b){
		b = add(~b,	1);
		return add(a, b);
	}
	
	/**
	 * 乘法axb，即b个a相加(注意处理负号)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int multi1(int a, int b){
		int count = b;
		if (((b >> 31) & 1) == 1) {
			count = add(~b, 1);
		}
		int res = 0;
		while(count != 0){
			res = add(res, a);
			count = minus(count, 1);
		}
		
		if (((b >> 31) & 1) == 1) {
			res = add(~res, 1);
		}
		
		return res;
	}
	
	/**
	 * 一个数 <<（左移）n位，相当于 乘于2的n次方。axb可以将b转化为数个2的n/m/k次方。
	 * 只需要判断b中所有位置是否为1，为1的即是要乘的
	 * @param args
	 */
	public static int multi2(int a, int b){
		int res = 0;
		
		int tmp = b;
		if (((b >> 31) & 1) == 1) {
			tmp = add(~b, 1);
		}
		
		while(tmp != 0){
			if ((tmp&1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			tmp >>= 1;
		}
		
		if (((b >> 31) & 1) == 1) {
			res = add(~res, 1);
		}
		
		return res;
	}
	
	//未处理负数情况
	public static int divide(int a, int b){
		if (b == 0) {
			return -1;
		}
		
		int res = 0;
		while(a >= b){
			a = minus(a, b);
			res = add(res, 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int a = 128;
		int b = 23;
		System.out.println(add(a,b));
		System.out.println(minus(a, b));
		System.out.println(multi1(a, b));
		System.out.println(multi2(a, b));
		System.out.println(divide(a, b));
	}
}
