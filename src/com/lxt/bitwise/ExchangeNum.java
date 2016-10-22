package com.lxt.bitwise;

/**
 * 不用额外变量交换两个整数
 * @author lixuetao
 *
 */
public class ExchangeNum {

	public static void exchangeNum(int a, int b){
		/**
		 * 异或运算解决
		 * a和b异或运算得到a、b所有的差异信息c
		 * a对c求异或得到b
		 * b对c求异或得到a
		 * 
		 * 所以
		 * a = a^b
		 * b = a^b;
		 * a = a^b;
		 */
		
		a = a^b;
		b = a^b;
		a = a^b;
		
	}
	
}
