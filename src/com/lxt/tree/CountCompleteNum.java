package com.lxt.tree;

/**
 * 统计完全二叉树的节点数
 * 题目：给定一颗完全二叉树的头结点head，返回这棵树的节点个数
 * @author lixuetao
 *
 */
public class CountCompleteNum {
	
	public static int countNodes(TreeNode root){
		int high = height(root);
		int nums = 0; //节点数
		while(root != null){
			//右子树高度 只比 整棵树高度 小1，证明树左右子树的高度是一样的
			//左子树节点数用公式求出来，右子树继续递归
			if(high - 1 == height(root.right)){
				nums += 1 << high;
				root = root.right;
			}else{
				nums += 1 << high-1;
				root = root.left;
			}
			
			high--;
		}
		return nums;
	}
	
	private static int height(TreeNode root){
		return root == null ? -1 : height(root.left)+1;
	}
	
}
