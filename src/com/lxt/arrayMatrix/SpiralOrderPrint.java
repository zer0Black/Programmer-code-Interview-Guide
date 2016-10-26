package com.lxt.arrayMatrix;

/**
 * 转圈打印矩阵
 * 题目：给定一个整型矩阵matrix，请按照转圈的方式打印它
 * @author zer0
 *
 */
public class SpiralOrderPrint {

	public static void spiralOrderPrint(int[][] matrix){
		
		int sR = 0;
		int sC = 0;
		int eR = matrix.length-1;
		int eC = matrix[0].length-1;
		
		while(sR <= eR && sC <= eC){
			printSpiral(matrix, sR++, sC++, eR--, eC--);
		}
		
	}
	
	/**
	 * 打印矩阵的一圈
	 * @param matrix
	 * @param sR 起始行
	 * @param sC 起始列
	 * @param eR 终止行
	 * @param eC 终止列
	 * 2016年10月26日
	 */
	private static void printSpiral(int[][] matrix, int sR, int sC, int eR, int eC){
		
		if (sR == eR) {
			//打印只有一行的情况
			for(int i = sC; i <= eC; i++){
				System.out.print(matrix[sR][i] + " ");
			}
		}else if (sC == eC){
			//打印只有一列的情况
			for(int i = sR; i <= eR; i++){
				System.out.print(matrix[i][sC] + " ");
			}
		}else{
			int curR = sR;
			int curC = sC;
			//打印顶行
			while(curC != eC){
				System.out.print(matrix[curR][curC] + " ");
				curC++;
			}
			
			//打印右列
			while(curR != eR){
				System.out.print(matrix[curR][curC] + " ");
				curR++;
			}
			
			//打印底行
			while(curC != sC){
				System.out.print(matrix[curR][curC] + " ");
				curC--;
			}
			
			//打印左列
			while(curR != sR){
				System.out.print(matrix[curR][curC] + " ");
				curR--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiralOrderPrint(matrix);
	}
	
}
