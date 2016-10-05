package com.lxt.tree;

/**
 * 先序、中序和后序数组两两组合重构二叉树
 * 题目：已知一颗二叉树的所有节点值都不同，给定这颗二叉树正确的先序、中序和后序数组。
 *       请分别用三个函数实现任意两种数组集合重构原来的二叉树，并返回重构二叉树的头
 *       节点
 * @author zer0
 *
 */
public class RebuildTree {
	
	/**
	 * 前序中序结合
	 * @param pre
	 * @param in
	 * @return
	 * 2016年10月5日
	 */
	public static TreeNode preInToTree(int[] pre, int[] in){
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}
		return preIn(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	
	private static TreeNode preIn(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
		if (preStart > preEnd) {
			return null;
		}
		
		int root = pre[preStart];
		//到中序数据中找根节点
		int i = inStart;
		for(;i < inEnd; i++){
			if (in[i] == root) {
				break;
			}
		}

		TreeNode rootNode = new TreeNode(root);
		rootNode.left = preIn(pre, in, preStart+1, preStart + i - inStart, inStart, i-1);
		rootNode.right = preIn(pre, in, preStart + i - inStart + 1, preEnd, i+1, inEnd);
		
		return rootNode;
	}
	
	/**
	 * 后序中序结合
	 * @param pre
	 * @param in
	 * @return
	 * 2016年10月5日
	 */
	public static TreeNode posInToTree(int[] pos, int[] in){
		if (pos == null || in == null || pos.length == 0 || in.length == 0) {
			return null;
		}
		return posIn(pos, in, 0, pos.length-1, 0, in.length-1);
	}
	
	private static TreeNode posIn(int[] pos, int[] in, int posStart, int posEnd, int inStart, int inEnd){
		if (posStart>posEnd) {
			return null;
		}
		
		int root = pos[posEnd];
		//到中序数据中找根节点
		int i = inStart;
		for(;i < inEnd; i++){
			if (in[i] == root) {
				break;
			}
		}
		
		TreeNode rootNode = new TreeNode(root);
		rootNode.left = posIn(pos, in, posStart, posStart + i - inStart - 1, inStart, i+1);
		rootNode.right = posIn(pos, in, posStart+i-inStart, posEnd-1, i+1, inEnd);
		return rootNode;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6};
		int[] in = {4,2,5,1,6,3};
		TreeNode node = preInToTree(pre, in);
		PrintTreeIntuitive.printTree(node);
	}
}
