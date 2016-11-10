package com.lxt.arrayMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路值
 * 题目：用一个整型矩阵matrix表示一个网络，1代表有路，0代表无路，每个位置只要不越界，
 *       都有上下左右四个方向，求从最左上角到最右下角的最短通路值
 * @author zer0
 *
 */
public class MinPath {
	
	public static int minPathValue(int[][] matrix){
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new RuntimeException("error");
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int res = 0;
		int[][] map = new int[row][col]; //map[i][j]代表走到i行j列的最短通路
		map[0][0] = 1;
		Queue<Integer> rQ = new LinkedList<Integer>();
		Queue<Integer> cQ = new LinkedList<Integer>();
		rQ.add(0);
		cQ.add(0);
		
		int r = 0;
		int c = 0;
		while(!rQ.isEmpty()){
			r = rQ.poll();
			c = cQ.poll();
			if (r == row - 1 && c == col - 1) {
				return map[r][c];
			}
			
			walkTo(map[r][c], r-1, c, matrix, map, rQ, cQ);
			walkTo(map[r][c], r+1, c, matrix, map, rQ, cQ);
			walkTo(map[r][c], r, c-1, matrix, map, rQ, cQ);
			walkTo(map[r][c], r, c+1, matrix, map, rQ, cQ);
		}
		
		return res;
	}
	
	private static void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ){
		if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length || m[toR][toC] != 1 || map[toR][toC] != 0) {
			return;
		}
		
		map[toR][toC] = pre + 1;
		rQ.add(toR);
		cQ.add(toC);
	}
	
	public static void main(String[] args) {
		int matrix[][] = {{1,0,1,1,1},
						  {1,0,1,0,1},
						  {1,1,1,0,1},
						  {0,0,0,0,1}};
		System.out.println(minPathValue(matrix));
	}
}
