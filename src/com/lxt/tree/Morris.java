package com.lxt.tree;


/**
 * 遍历二叉树的神级方法
 * 题目：给定一颗二叉树的头节点head，完成二叉树的先序、中序和后序遍历。
 *      如果二叉树的节点数为N，要求的时间复杂度为O(N),额外空间复杂度为O(1)
 * 该题主要考察：morris遍历
 * @author zer0
 *
 */
public class Morris {

	public static void morrisPre(TreeNode root){
		if (root == null) {
			return;
		}
		
		TreeNode cur1 = root;
		TreeNode cur2 = null; //cur2记录cur1的左子树
		while(cur1 != null){
			cur2 = cur1.left;
			if (cur2 != null) {
				while(cur2.right != null && cur2.right != cur1){
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					System.out.print(cur1.value + " ");
					cur1 = cur1.left;
					continue;
				}else {
					cur2.right = null;
				}
			}else {
				System.out.print(cur1.value + " ");
			}
			cur1 = cur1.right;
		}
		System.out.println();
	}
	
	public static void morrisIn(TreeNode root){
		if (root == null) {
			return;
		}
		
		TreeNode cur1 = root;
		TreeNode cur2 = null;
		while(cur1 != null){
			cur2 = cur1.left;
			if (cur2 != null) {
				while(cur2.right != null && cur2.right != cur1){
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}else {
					cur2.right = null;
				}
			}
			System.out.print(cur1.value + " ");
			cur1 = cur1.right;
		}
		System.out.println();
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
		
		System.out.println("morris前序遍历：");
		morrisPre(node1);
		System.out.println("递归前序遍历");
		TreeOrderLoop.preOrderRecur(node1);
		System.out.println();
		System.out.println("morris中序遍历：");
		morrisIn(node1);
		System.out.println("递归中序遍历");
		TreeOrderLoop.inOrderRecur(node1);
	}
	
}
