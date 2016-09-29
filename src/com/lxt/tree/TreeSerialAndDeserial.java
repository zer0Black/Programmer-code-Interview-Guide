package com.lxt.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化
 * @author zer0
 *
 */
public class TreeSerialAndDeserial {

	//通过前序遍历序列化和反序列化
	public static String preSerialTree(TreeNode root){
		if (root == null) {
			return "#!";
		}
		
		String res = root.value + "!";
		res += preSerialTree(root.left);
		res += preSerialTree(root.right);
		return res;
	}
	
	public static TreeNode deserialTree(String str){
		String[] strs = str.split("!");
		LinkedList<String> list = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		return preReconTree(list);
	}
	
	private static TreeNode preReconTree(LinkedList<String> list){
		String str = list.poll();
		if (str.equals("#")) {
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.valueOf(str));
		root.left = preReconTree(list);
		root.right = preReconTree(list);
		return root;
	}
	
	//通过层序遍历序列化和反序列化
	public static String levelSerialTree(TreeNode root){
		if (root == null) {
			return null;
		}
		
		String res = "";
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		res += root.value + "!";
		while(!list.isEmpty()){
			TreeNode cur = list.poll();
			if (cur.left != null) {
				res += cur.left.value + "!";
				list.add(cur.left);
			}else {
				res += "#!";
			}
			
			if (cur.right != null) {
				res += cur.right.value + "!";
				list.add(cur.right);
			}else {
				res += "#!";
			}
		}
		
		return res;
	}
	
	public static TreeNode levelDeserialTree(String str){
		String[] strs = str.split("!");
		LinkedList<String> list = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		
		TreeNode root = generalNodeByString(list.poll());
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		
		while(!queue.isEmpty() && !list.isEmpty()){
			TreeNode cur = queue.poll();
			cur.left = generalNodeByString(list.poll());
			cur.right = generalNodeByString(list.poll());
			if (cur.left != null) {
				queue.add(cur.left);
			}
			
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
		
		return root;
	}
	
	private static TreeNode generalNodeByString(String str){
		if (str.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(str));
	}
	
	//通过后序遍历序列化和反序列化
	public static String posSerialTree(TreeNode root){
		if (root == null) {
			return "#!";
		}
		
		String res = "";
		res += posSerialTree(root.left);
		res += posSerialTree(root.right);
		res += root.value + "!";
		
		return res;
	}
	
	public static TreeNode posDeserialTree(String str){
		String[] strs = str.split("!");
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < strs.length; i++) {
			stack.push(strs[i]);
		}
		
		return posReconTree(stack);
	}
	
	private static TreeNode posReconTree(Stack<String> stack){
		String str = stack.pop();
		if (str.equals("#")) {
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.valueOf(str));
		root.right = posReconTree(stack);
		root.left = posReconTree(stack);
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode3.left = treeNode5;
		treeNode3.right = treeNode6;
		
		
		String posStr = posSerialTree(treeNode1);
		System.out.println(posStr);
		TreeNode root = posDeserialTree(posStr);
		TreeOrderLoop.preOrderRecur(root);
	}
	
}
