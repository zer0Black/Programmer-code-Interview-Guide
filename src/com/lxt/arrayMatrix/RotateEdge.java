package com.lxt.arrayMatrix;

/**
 * 将正方形矩阵顺时针转动90度
 * 题目：给定一个NxN的矩阵matrix，把这个矩阵调整成顺时针转动90度后的形式
 * @author zer0
 *
 */
public class RotateEdge {
	
	//采用分圈处理的方式
	public static void rotateEdge(int[][] matrix){
		if (matrix == null || matrix.length == 0 || matrix[0].length==0) {
			return;
		}
		
		int sR = 0;
		int sC = 0;
		int eR = matrix.length-1;
		int eC = matrix[0].length-1;
		
		while(sR <= eR && sC <= eC){
			rotateCore(matrix, sR++, sC++, eR--, eC--);
		}
	}
	
	/**
	 * 一组一组变形，每个位置和下一行/列的位置交换
	 * @param matrix
	 * @param sR
	 * @param sC
	 * @param eR
	 * @param eC
	 * 2016年10月26日
	 */
	private static void rotateCore(int[][] matrix, int sR, int sC, int eR, int eC){
		int times = eC - sC;
		int tmp = 0;
		for(int i=0; i<times; i++){
			tmp = matrix[sR][sC+i];
			matrix[sR][sC+i] = matrix[eR-i][sC];
			matrix[eR-i][sC] = matrix[eR][eC-i];
			matrix[eR][eC-i] = matrix[sR+i][eC];
			matrix[sR+i][eC] = tmp;
		}
	}
	
	public static void main(String[] args) {
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateEdge(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
