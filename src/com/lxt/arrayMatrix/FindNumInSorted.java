package com.lxt.arrayMatrix;

/**
 * 在行列都排好序的矩阵中找数
 * 题目：给定一个有NxM的整型矩阵matrix和一个整数k，matrix的每一行和每一列都是排好序的。
 *      实现一个函数，判断k是否在matrix中。
 * 要求：时间复杂度O(N+M) 空间复杂度O(1)
 * @author lixuetao
 *
 */
public class FindNumInSorted {
	
	/**
	 * 从矩阵左下角cor开始找，大于cor，往右，小于cor，往上。
	 * @param matrix
	 * @param k
	 * @return
	 */
	public static boolean isContains(int[][] matrix, int k){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		int row = matrix.length-1;
		int col = matrix[0].length-1;
		
		
		int curR = row;
		int curC = 0;
		
		while(curR >= 0 && curC <= col){
			int cor = matrix[curR][curC];
			if (cor < k) {
				curC++;			
			}else if(cor > k){
				curR--;
			}else {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,5},
				          {2,3,4,7},
				          {4,4,4,8},
				          {5,7,7,9}};
		int k = 1;
		System.out.println(isContains(matrix, k));
	}
	
}
