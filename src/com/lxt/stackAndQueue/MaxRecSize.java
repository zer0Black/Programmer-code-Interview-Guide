/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 求最大子矩阵大小
 * 题目：给定一个整型矩阵map，其中的值只有0和1两种，
 * 		 求其中全是1的所有矩形区域中，最大的矩形区域为1的数量
 * 例如：1  1  1  0
 *      其中，最大的矩形区域有3个1，所以返回3
 *      
 *      1  0  1  1
 *      1  1  1  1
 *      1  1  1  0
 *      其中，最大的矩形区域有6个1，所以返回6
 * @author zer0
 *
 */
public class MaxRecSize {

	/**
	 * 求直方图的最大子矩形
	 * 使用到的原型也是:
	 *     使用递增/递减栈，求得i的左边最近的最小值/最大值
	 * @param arr
	 * @return
	 * 2016年9月22日
	 */
	private static int largestAreaFromArr(int[] arr){
		if (arr == null || arr.length ==0) {
			return 0;
		}
		
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < arr.length; i++){
			while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
				int cur = stack.pop(); 
				int lmin = stack.isEmpty() ? -1 : stack.peek();//左边最小值
				res = Math.max(res, (i - lmin - 1) * arr[cur]);
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int cur = stack.pop();
			int lmin = stack.isEmpty() ? -1 : stack.peek();
			res = Math.max(res, (arr.length-1 - lmin - 1) * arr[cur]);
		}
		
		return res;
	}
	
	/**
	 * 把二维数组的从上到下，每行按列累加成一维数组（如果当前列为0，则为0）
	 * 一维数组的每列代表 从本行往上数连续的1的个数。
	 * 
	 * 把每一次的遍历，转换为 求直方图的最大子矩形 的问题
	 * @param map
	 * @return
	 * 2016年9月22日
	 */
	public static int maxRecSize(int[][] map){
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		
		int row = map.length;
		int col = map[0].length;
	
		int res = 0;
		int arr[] = new int[col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				arr[j] = map[i][j] == 0 ? 0 : arr[j] + 1;
			}
			res = Math.max(res, largestAreaFromArr(arr));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int map[][] = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println(maxRecSize(map));
	}
	
}
