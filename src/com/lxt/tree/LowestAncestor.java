package com.lxt.tree;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 题目：给定一颗二叉树的头结点head，以及这棵树的两个节点O1和O2，请返回
 *      O1和O2的最近公共祖先节点
 * @author lixuetao
 *
 */
public class LowestAncestor {
	
	/**
	 * 后序遍历
	 * 遍历过程中，假定遍历到cur节点，查找以下几条规则：
	 * 1、如果cur为null或者cur=o1/o2，返回cur
	 * 2、如果cur的左边不返回null，右边也不返回null，则证明当前节点就是最近公共组选，返回cur
	 * 3、如果cur左边或者右边返回一个null，则返回不是null的那边
	 * @param root
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static TreeNode lowestAncestor(TreeNode root, TreeNode o1, TreeNode o2){
		if(root == null || root == o1 || root == o2){
			return root;
		}
		
		TreeNode left = lowestAncestor(root.left, o1, o2);
		TreeNode right = lowestAncestor(root.right, o1, o2);
		if (left != null && right != null) {
			return root;
		}
		
		return left != null ? left : right;
	}
	
}
