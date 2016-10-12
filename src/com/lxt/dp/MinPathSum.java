package com.lxt.dp;

/**
 * 矩阵最小路径和
 * 题目：给定一个矩阵m，从左上角开始每次只能向右或向下走，最后到达右下角的位置，
 *       路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * @author zer0
 *
 */
public class MinPathSum {

//  错误写法
//	public static int minPathSum1(int[][] m){
//		if (m==null || m.length == 0 || m[0].length == 0) {
//			return 0;
//		}
//		
//		int row = m.length;
//		int col = m[0].length;
//		int dp[][] = new int[row+1][col+1];
//	
//		for(int i = 1; i <= row; i++){
//			for(int j = 1; j <= col; j++){
//				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i-1][j-1];
//			}
//		}
//		
//		System.out.println("dp数组为");
//		for (int i = 0; i <= row; i++) {
//			for (int j = 0; j <= col; j++) {
//				System.out.format("%5d", dp[i][j]);
//			}
//			System.out.println();
//		}
//		
//		return dp[row][col];
//	}
	
	public static int minPathSum1(int[][] m){
		if(m == null || m.length == 0 || m[0].length == 0){
			return 0;
		}
		
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for(int i = 1; i < row; i++){
			dp[i][0] = dp[i-1][0] + m[i][0];
		}
		for(int j = 1; j < row; j++){
			dp[0][j] = dp[0][j-1] + m[0][j];
		}
		
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
			}
		}
		
		System.out.println("dp数组为");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.format("%5d", dp[i][j]);
			}
			System.out.println();
		}
		
		return dp[row-1][col-1];
	}
	
	/**
	 * 空间优化方式
	 * @return
	 * 2016年10月12日
	 */
	public static int maxPathSum2(int[][] m){
		if (m==null || m.length == 0 || m[0].length == 0) {
			return 0;
		}
		
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		
		boolean rowmore = m.length == more;
		
		int dp[] = new int[less];
		dp[0] = m[0][0];
		for(int i = 1; i < less; i++){
			dp[i] = dp[i-1] + (rowmore ? m[0][i] : m[i][0]);
		}
		
		for(int i=1; i < more; i++){
			dp[0] = dp[0] + (rowmore ? m[i][0] : m[0][i]);
			for(int j=1; j < less; j++){
				dp[j] = Math.min(dp[j], dp[j-1]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
		
		for(int i = 0; i < less; i++){
			System.out.format("%5d", dp[i]);
		}
		System.out.println();
		
		return dp[less-1];
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,3,5,9},
					 {8,1,3,4},
					 {5,0,6,1},
					 {8,8,4,0}};
		
		System.out.println("最小路径和为"+minPathSum1(m));
		System.out.println();
		System.out.println("最小路径和为"+maxPathSum2(m));
	}
	
}
