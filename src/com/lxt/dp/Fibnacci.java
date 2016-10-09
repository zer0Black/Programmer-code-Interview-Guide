package com.lxt.dp;

/**
 * 斐波那契系列问题的递归和动态规划
 * @author lixuetao
 *
 */
public class Fibnacci {

	static int count = 0; //统计执行次数
	
	/**
	 * 给定整数N，返回斐波那契数列的第N项
	 * 
	 * 递归法
	 * @param n
	 * @return
	 */
	public static int fibnacci1(int n){
		if(n == 0){
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		return fibnacci1(n-1) + fibnacci1(n-2);
	}
	
	/**
	 * 给定整数N，返回斐波那契数列的第N项
	 * 
	 * 遍历法(辗转相加法)
	 * @param n
	 * @return
	 */
	public static int fibnacci2(int n){
		int a = 0; //n-2
		int b = 1; //n-1
		int c = 0; //n
		
		if (n==0) {
			return a;
		}
		
		if (n==1) {
			return b;
		}
		
		for(int i = 2; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	/**
	 * 给定整数N，代表台阶数，一次可以跨两个台阶，或者一个台阶，返回有多少种走法
	 * 
	 * 类似斐波那契数列，但是
	 * n=1时，有1种走法
	 * n=2时，有2种走法(一次跨两阶，或两次跨一阶)
	 * @param n
	 * @return
	 */
	public static int footstep(int n){
		int a = 1; //n-2
		int b = 2; //n-1
		int c = 0;
		
		if (n <= 0) {
			return -1;
		}
		
		if (n <= 2) {
			return n;
		}
		
		for(int i=3; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println("斐波那契数列第"+ n + "项和为：" + footstep(n));
	}
	
}
