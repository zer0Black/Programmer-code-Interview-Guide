package com.lxt.tree;

/**
 * 二叉树节点间的最大距离问题
 * 题目：从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次。
 *       当到达节点B时，路径上的节点数叫做A到B的距离
 * @author zer0
 */
public class MaxDistance {

	/**
	 * 这道题考察的是递归的改写
	 * 在递归过程中，获取到自己需要的数据，再组合成新的数据
	 */
	public static int maxDistance(TreeNode root){
		int record[] = new int[1];
		return posOrder(root, record);
	}
	
	private static int posOrder(TreeNode root, int[] record){
		if (root == null) {
			return 0;
		}
		
		int lMax = posOrder(root.left, record);
		int maxLeftLength = record[0];
		int rMax = posOrder(root.right, record);
		int maxRightLength = record[0];
		
		int maxCurLength = maxLeftLength + maxRightLength + 1;
		record[0] = Math.max(maxRightLength, maxLeftLength) + 1;
		
		return Math.max(Math.max(rMax, lMax), maxCurLength);
	}
	
}
