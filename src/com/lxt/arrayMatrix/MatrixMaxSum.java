package com.lxt.arrayMatrix;

/**
 * 子矩阵的最大累积和问题
 * 题目：给定一个矩阵matrix，其中的值有正有负有0，返回子矩阵的最大累加和
 * @author lixuetao
 *
 */
public class MatrixMaxSum {
	
	/*
	 * 类似于子数组的最大累加和问题
	 * 只需要把二维数组转换为一维数组即可
	 */
	public static int getMax(int[][] matrix){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new RuntimeException("error");
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < row; i++){
			int arr[] = new int[col];
			for(int j = i; j < row; j++){
				sum = 0;
				for(int k = 0; k < col; k++){
					arr[k] += matrix[j][k];
					sum += arr[k];
					max = Math.max(max, sum);
					sum = sum < 0 ? 0 : sum;
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = {{-90,48,78},
				          {64,-40,64},
				          {-81,-7,66}};
		System.out.println(getMax(matrix));
	}
	
}
