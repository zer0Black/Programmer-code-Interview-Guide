package com.lxt.tree;

/**
 * 根据后序数组重建搜索二叉树
 * 题目：给定一个整型数组arr，已知其中没有重复值，判断arr是否
 *       可能是节点值类型为整型的搜索二叉树后序遍历的结果。
 * 进阶：如果整型数组arr中没有重复值，且已知是一颗搜索二叉树的
 * 	             后序遍历结果，通过数组arr重构二叉树
 * @author zer0
 *
 */
public class IsPostArrayAndBuild {
	
	public static boolean isPostArray(int[] posArray){
		if (posArray == null || posArray.length == 0) {
			return false;
		}
		int end = posArray.length;
		int start = 0;
		return vertifyCore(posArray, start, end);
	}
	
	private static boolean vertifyCore(int[] posArray, int start, int end){
		int root = posArray[end - 1];
		int i = start;
		
		//end-1是因为不能走到根节点
		for(; i < end-1; i++){
			if (posArray[i] > root) {
				break;
			}
		}
		
		int j = i;
		for(; j < end-1; j++){
			if (posArray[i] < root) {
				return false;
			}
		}
		
		boolean left = true;
		//左边还有
		if(i > 0 && start != i){
			left = vertifyCore(posArray, start, i);
		}
		
		boolean right = true;
		if (i < end-1) {
			right = vertifyCore(posArray, i, j);
		}
		
		return left && right;
	}
	
	/**
	 * 根据搜索二叉树后序遍历结果重构搜索二叉树
	 * @param posArray
	 * @return
	 * 2016年10月3日
	 */
	public static TreeNode rebuildTree(int[] posArray) {
		if (posArray == null || posArray.length == 0) {
			return null;
		}
		
		int start = 0;
		int end = posArray.length;
		return rebuildCore(posArray, start, end);
	}
	
	private static TreeNode rebuildCore(int[] posArray, int start, int end){
		int root = posArray[end-1];
		int i = start;
		
		TreeNode rootNode = new TreeNode(root);
		for(; i < end - 1; i++){
			if(posArray[i] > root){
				break;
			}
		}
		
		if (i > 0 && start != i) {
			rootNode.left = rebuildCore(posArray, start, i);
		}
		
		if (i < end-1) {
			rootNode.right = rebuildCore(posArray, i, end-1);
		}
		
		return rootNode;
	}
	
	public static void main(String[] args) {
		int[] postArray = {2,4,3,7,10,9,6};
		
		System.out.println(isPostArray(postArray));
		TreeNode root = rebuildTree(postArray);
		PrintTreeIntuitive.printTree(root);
	}
	
}
