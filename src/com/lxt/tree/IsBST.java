package com.lxt.tree;

import java.util.Stack;

/**
 * 判断一棵树是否为搜索二叉树
 * @author lixuetao
 *
 */
public class IsBST {

	/**
	 * 搜索二叉树的中序遍历结果为递增序列，如果中途遇到递减情况，则返回false
	 * 
	 * 递归实现
	 * @param root
	 * @return
	 */
	public static boolean isBSTByRecur(TreeNode root){
		if(root == null){
			return false;
		}
		
		return inOrder(root, new TreeNode(Integer.MIN_VALUE));
	}
	
	private static boolean inOrder(TreeNode root, TreeNode pre){
		if (root == null) {
			return false;
		}
		
		boolean left = true;
		if(root.left != null){
			left = inOrder(root.left, pre);
		}
		
		
		if (pre!=null && pre.value > root.value) {
			return false;
		}
		pre.value = root.value;
		
		boolean right = true;
		if (root.right != null) {
			right = inOrder(root.right, pre);
		}
		
		return left && right;
	}
	
	/**
	 * 遍历实现
	 * @param args
	 */
	public static boolean isBSTByNoRecur(TreeNode root){
		if (root == null) {
			return false;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		while(!stack.isEmpty() || root!=null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				if (pre!=null && root.value < pre.value) {
					return false;
				}
				pre = root;
				root = root.right;
			}
		}
		return true;
	}
	
	/**
	 * morris遍历实现
	 * @param args
	 */
	public static boolean isBSTByMorris(TreeNode root){
		if(root == null){
			return false;
		}
		
		TreeNode pre = null;
		TreeNode cur1 = root;
		TreeNode cur2 = null;
		boolean res = true;
		while(cur1 != null){
			cur2 = cur1.left;
			if (cur2 != null) {
				while(cur2.right != null && cur2.right != cur1){
					cur2 = cur1.right;
				}
				if(cur2.right == null){
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				}else {
					cur2.right = null;
				}
			}
			
			if(pre!= null && pre.value > cur1.value){
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] postArray = {2,4,3,7,10,9,8};
		TreeNode root = IsPostArrayAndBuild.rebuildTree(postArray);
//		root.left.value = 11;
		PrintTreeIntuitive.printTree(root);
		
		System.out.println("是否为二叉树:"+isBSTByNoRecur(root));
	}
	
}
