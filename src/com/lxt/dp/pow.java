package com.lxt.dp;

/**
 * 二分求幂
 * @author zer0
 *
 */
public class pow {
	
	public static double pow(int n, int k){
		return k > 0 ? powCore(n, k) : 1 / powCore(n, k * -1);
	}
	
	private static double powCore(int n, int k){
		if (n == 0) {
			return 1;
		}
		
		double res = 1;
		while(k != 0){
			if ((k & 1) == 1) {
				res *= n;
			}
			
			k >>= 1;
			n *= n;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 2;
		int k = -3;
		System.out.println(pow(n, k));
	}
	
}
