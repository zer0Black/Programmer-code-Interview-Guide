/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

import com.lxt.tree.PrintNodeByLevel;
import com.lxt.tree.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Node;

/**
 * 构造数组的MaxTree
 * 题目：
 * 一个数组的MaxTree定义如下：
 * 	   数据必须没有重复元素。
 *   MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点
 *   包括MaxTree树在内且在其中每颗子树上，值最大的节点都是头。
 * 给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数。
 * 要求：时间复杂度O(N)，额外空间复杂度O(N)
 * @author zer0
 *
 */
public class MaxTree {
	
	/**
	 * 解题思路使用到 sortStackByStack 一题中的算法原型
	 * 既，使用递增/递减栈，求得i的左边最近的最小值/最大值
	 * 步骤：
	 * 1)遍历生成所有节点，放入数组中
	 * 2)使用两个哈希表，保存每个节点的左边最近最大值，和右边最近最大值
	 * 3)遍历每个节点，找出该节点的父节点，并把此节点挂在父节点下边
	 * @param arr
	 * @return
	 * 2016年9月22日
	 */
	public static TreeNode maxTree(int[] arr){
		if (arr == null || arr.length == 0) {
			return null;
		}
		
		int len = arr.length;
		TreeNode[] nodes = new TreeNode[len];
		HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
		HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();
		
		//生成所有节点
		for(int i = 0; i < len; i++){
			nodes[i] = new TreeNode(arr[i]);
		}
		
		Stack<TreeNode> maxStack = new Stack<>(); //保存最大值的栈
		
		//生成每个节点的左边 最近最大值节点
		for(int i = 0; i < len; i++){
			while(!maxStack.isEmpty() && nodes[i].value >= maxStack.peek().value){
				popStackAddMap(maxStack, lBigMap);
			}
			maxStack.push(nodes[i]);
		}
		while(!maxStack.isEmpty()){
			popStackAddMap(maxStack, lBigMap);
		}
		
		//生成每个节点的右边 最近最大值节点
		for(int i = len-1; i >= 0; i--){
			while(!maxStack.isEmpty() && nodes[i].value >= maxStack.peek().value){
				popStackAddMap(maxStack, rBigMap);
			}
			maxStack.push(nodes[i]);
		}
		while(!maxStack.isEmpty()){
			popStackAddMap(maxStack, rBigMap);
		}
		
		TreeNode head = null;
		//将节点挂在父节点上
		for(int i = 0; i < len; i++){
			TreeNode curNode = nodes[i];
			TreeNode left = lBigMap.get(curNode);
			TreeNode right = rBigMap.get(curNode);
			if (left == null && right == null) {
				head = curNode;
			}else if (left == null) {
				if (right.left == null) {
					right.left = curNode;
				}else {
					right.right = curNode;
				}
			}else if (right == null) {
				if (left.left == null) {
					left.left = curNode;
				}else {
					left.right = curNode;
				}
			}else {
				TreeNode root = left.value < right.value ? left : right;
				if (root.left == null) {
					root.left = curNode;
				}else {
					root.right = curNode;
				}
			}
		}
		
		return head;
	}
	
	private static void popStackAddMap(Stack<TreeNode> stack, HashMap<TreeNode, TreeNode> map){
		TreeNode node = stack.pop();
		if (stack.isEmpty()) {
			map.put(node, null);
		}else {
			map.put(node, stack.peek());
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,7,4,5,1,2,6};
		TreeNode root = MaxTree.maxTree(arr);
		PrintNodeByLevel.printNodeByLevel(root);
	}
}


