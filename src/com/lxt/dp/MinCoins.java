package com.lxt.dp;

/**
 * 换钱的最少货币数
 * 题目：给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币。每种
 *      面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求组成aim的最少
 *      货币数
 * 补充题目：如果数组arr中每个值仅代表一张钱的面值。求组成aim的最少货币数
 * @author lixuetao
 *
 */
public class MinCoins {

	//此题是完全背包问题 和 01背包问题
	
	public static int minCoins1(int[] arr, int aim){
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int max = 6666;
		int dp[][] = new int[arr.length][aim+1]; //dp[i][j]代表任意arr[0..i]组成j时的最小货币数
		//dp[i][0] 表示组成面试为0时，只需要0张任意货币
		//dp[0][j] 表示组成面值j时，需要的最小货币数
		for(int j = 1; j <= aim; j++){
			dp[0][j] = max;
			if(j - arr[0] >= 0 && dp[0][j-arr[0]] != max){
				dp[0][j] = dp[0][j-arr[0]] + 1;
			}
		}
		
		for(int i = 1; i < arr.length; i++){
			for(int j = 1; j <= aim; j++){
				int left = max;
				if(j - arr[i] >= 0 && dp[i][j-arr[i]] != max){
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-arr[i]]+1);
					left = dp[i][j-arr[i]]+1;
				}
				dp[i][j] = Math.min(dp[i-1][j], left);
			}
		}
		
		System.out.println("dp数组为");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < aim+1; j++) {
				System.out.format("%5d", dp[i][j]);
			}
			System.out.println();
		}
		
		return dp[arr.length-1][aim] != max? dp[arr.length-1][aim] : -1;
	}
	
	//控件优化
	public static int minCoins1Opt(int arr[], int aim){
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		
		int dp[] = new int[aim+1];
		int n = arr.length;
		int max = 6666;
		for(int j = 1; j <= aim; j++){
			dp[j] = max;
			if (j - arr[0] >= 0 && dp[j-arr[0]] != max) {
				dp[j] = dp[j-arr[0]]+1;
			}
		}
		
		int tmp = 0;
		for(int i = 1; i < n; i++){
			for(int j = 1; j <= aim; j++){
				tmp = max;
				if(j - arr[i] >= 0 && dp[j-arr[i]] != max){
					tmp = dp[j-arr[i]] + 1;
				}
				dp[j] = Math.min(tmp, dp[j]);
			}
		}
		
		for(int i = 0 ; i <= aim; i++){
			System.out.format("%5d", dp[i]);
		}
		System.out.println();
		
		return dp[aim] != max ? dp[aim] : -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,4,5};
		int aim = 11;
		System.out.println("最小货币数"+minCoins1(arr, aim));
		System.out.println();
		System.out.println("最小货币数"+minCoins1Opt(arr, aim));
	}
}
