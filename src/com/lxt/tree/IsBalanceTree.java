package com.lxt.tree;

/**
 * 判断二叉树是否为平衡二叉树
 * 平衡二叉树性质：要么是一颗空树，要么任何一个节点的左右子树高度差的绝对值不超过1.
 * @author zer0
 *
 */
public class IsBalanceTree {

	//改写后序遍历的递归
	public static boolean isBalance(TreeNode root){
		boolean[] record = new boolean[1];
		record[0] = true;
		getHeight(root, 1, record);
		return record[0];
	}
	
	/**
	 * @param root
	 * @param level 树的深度
	 * @param record record[0]用来记录是否为平衡二叉树，
	 *               一旦record[0]被置为false，立刻退出递归
	 *               record可以看做一个全局变量
	 * @return
	 * 2016年10月3日
	 */
	public static int getHeight(TreeNode root, int level,boolean[] record){
		if (root == null) {
			return level;
		}
		
		int lH = getHeight(root.left, level + 1, record);
//		if (!record[0]) {
//			return level;
//		}
		
		int rH = getHeight(root.right, level+1, record);
//		if (!record[0]) {
//			return level;
//		}
		
		if (Math.abs(lH-rH) > 1) {
			record[0] = false;
			return level;
		}
		return Math.max(lH, rH);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node5;
		node4.left = node7;
		
		System.out.println(isBalance(node1));
	}
	
}
