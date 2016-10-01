package com.lxt.tree;

/**
 * 找到二叉树中的最大搜索二叉子树
 * 题目：给你一颗二叉树的头结点head，已知所有节点的值都不一样，
 * 		找到含有节点最多的搜索二叉子树，并返回子树的头节点
 * @author lixuetao
 *
 */
public class BiggestSubBST {
	
	public static TreeNode biggestSubBST(TreeNode root){
		int[] record = new int[3]; //0记录节点数，1记录最小值，2记录最大值
		return posOrder(root, record);
	}
	
	private static TreeNode posOrder(TreeNode root, int[] record){
		if(root == null){
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return null;
		}
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		int value = root.value;
		
		TreeNode lBST = posOrder(left, record);
		int lsize = record[0];
		int lmin = record[1];
		int lmax = record[2];
		
		TreeNode rBST = posOrder(right, record);
		int rsize = record[0];
		int rmin = record[1];
		int rmax = record[2];
		
		record[1] = Math.min(lmin, value);
		record[2] = Math.max(rmax, value);
	
		if(left == lBST && right == rBST && lmax < value && rmin > value){
			record[0] = lsize + rsize + 1;
			return root;
		}
		record[0] = Math.max(lsize, rsize);
		return lsize > rsize ? lBST : rBST;
	}
	
}
