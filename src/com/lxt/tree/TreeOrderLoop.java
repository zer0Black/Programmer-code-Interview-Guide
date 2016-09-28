package com.lxt.tree;

import java.util.Stack;

/**
 * 分别用递归和非递归的方式实现二叉树先序、中序、后序遍历
 * @author zer0
 *
 */
public class TreeOrderLoop {

	//递归方式
	public static void preOrderRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + " ");
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	
	public static void inOrderRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		inOrderRecur(root.left);
		System.out.print(root.value + " ");
		inOrderRecur(root.right);
	}
	
	public static void posOrderRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		posOrderRecur(root.left);
		posOrderRecur(root.right);
		System.out.print(root.value + " ");
	}
	
	public static void preOrderNoRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.value + " ");
			//先压入右节点的，再压入左节点的原因是。后压入的先打印
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}	
		}
	}
	
	public static void inOrderNoRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || root != null){
			if (root != null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				System.out.print(root.value + " ");
				root = root.right;
			}
		}
	}
	
	/**
	 * 考虑用两个栈保存，一个栈是s1保存节点进出
	 * 一个栈s2保存打印的顺序
	 * s2中要出栈的顺序应该是左右中，所以s2的入栈顺序应该是中右左
	 * @param root
	 * 2016年9月28日
	 */
	public static void posOrderNoRecur(TreeNode root){
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			root = s1.pop();
			s2.push(root);
			if (root.left != null) {
				s1.push(root.left);
			}
			if (root.right != null) {
				s1.push(root.right);
			}
		}
		
		while(!s2.isEmpty()){
			System.out.print(s2.pop().value + " ");
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		
		preOrderRecur(node1);
		System.out.println();
		preOrderNoRecur(node1);
		System.out.println();
		inOrderRecur(node1);
		System.out.println();
		inOrderNoRecur(node1);
		System.out.println();
		posOrderRecur(node1);
		System.out.println();
		posOrderNoRecur(node1);
	}
}
