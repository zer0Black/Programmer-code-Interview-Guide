package com.lxt.tree;

/**
 * LeetCode 129
 * Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * @author lixuetao
 *
 */
public class SumNumbers {
	
	 //走一遍前序遍历即可完成
	 public static int sumNumbers(TreeNode root) {
		 int sum = 0;
		 return dfs(root, sum);
	 }
	 
	 private static int dfs(TreeNode root, int sum){
		 if(root == null){
			 return 0;
		 }
		 
		 if(root.left == null && root.right == null){
			 return sum * 10 + root.value;
		 }	 
		 return dfs(root.left, sum * 10 + root.value) + dfs(root.right, sum * 10 + root.value);
	 }
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		
		root1.left = root2;
		root1.right = root3;
		
		System.out.println(sumNumbers(root1));
	}
}
