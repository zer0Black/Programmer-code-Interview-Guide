package com.lxt.tree;

/**
 * 通过有序数组生成平衡搜索二叉树
 * 题目：给定一个有序数组sortArr，已知其中没有重复值，但这个有序数组生成
 *      一颗平衡搜索二叉树，并且该搜索二叉树中序遍历的结果与sortArr一致
 * @author lixuetao
 *
 */
public class BalanceSearchTree {

	/**
	 * 用中间数作为头结点，左边的所有数为左子树，右边所有数为右子树
	 * @param sortArr
	 * @return
	 */
	public static TreeNode generalTree(int[] sortArr){
		if(sortArr == null || sortArr.length == 0){
			return null;
		}
		int start= 0;
		int end = sortArr.length-1;
		return generalCore(sortArr, start, end); 
	}
	
	private static TreeNode generalCore(int[] sortArr, int start, int end){
		if (start > end) {
			return null;
		}
		
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(sortArr[mid]);
		node.left = generalCore(sortArr, start, mid-1);
		node.right = generalCore(sortArr, mid+1, end);
		
		return node;
	}
	
}
