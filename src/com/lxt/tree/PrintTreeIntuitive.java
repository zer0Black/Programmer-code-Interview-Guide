package com.lxt.tree;

/**
 * 如何较为直观的打印二叉树
 * 题目：二叉树可以用常规的三种遍历结果来描述其结构，但是不够直观，
 *       尤其是二叉树中右重复值的时候，仅通过三种遍历的结果来构造
 *       二叉树的真实结构更是难上加难，有时候根本不可能。给定一颗
 *       二叉树的头节点head，已知二叉树节点值的类型为32位整型，请
 *       实现一个打印二叉树的函数，可以直观的展示树的形状，也便于
 *       画出真实的结构
 * @author zer0
 *
 */
public class PrintTreeIntuitive {

	public static void printTree(TreeNode head){
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}
	
	public static void printInOrder(TreeNode head, int height, String to, int len){
		if (head == null) {
			return;
		}
		
		printInOrder(head.right, height+1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM)/2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height+1, "^", len);
	}
	
	private static String getSpace(int num){
		String space = " ";
		StringBuffer buffer = new StringBuffer("");
		for(int i = 0; i < num; i++){
			buffer.append(space);
		}
		return buffer.toString();
	}
	
}
