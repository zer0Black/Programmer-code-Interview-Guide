package com.lxt.tree;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 * @author zer0
 *
 */
public class BSTTopoSize {

	/**
	 * 每个节点都去找一遍自己的最大拓扑结构
	 * 时间复杂度O(n²)
	 * @param root
	 * @return
	 * 2016年10月2日
	 */
	public static int bstTopoSize1(TreeNode root){
		if (root == null) {
			return 0;
		}
		int max = maxTopo(root, root);
		max = Math.max(bstTopoSize1(root.left), max);
		max = Math.max(bstTopoSize1(root.right), max);
		return max;
	}
	
	public static int maxTopo(TreeNode root, TreeNode n){
		if (root != null && n != null && isBSTTree(root, n.value)) {
			return maxTopo(root, n.left) + maxTopo(root, n.right) + 1;
		}
		return 0;
	}
	
	public static boolean isBSTTree(TreeNode root, int value){
		if (root == null) {
			return false;
		}
		if (root.value == value) {
			return true;
		}
		
		return value < root.value ? isBSTTree(root.left, value) : isBSTTree(root.right, value);
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(6);
		TreeNode treeNode2 = new TreeNode(1);
		TreeNode treeNode3 = new TreeNode(12);
		TreeNode treeNode4 = new TreeNode(0);
		TreeNode treeNode5 = new TreeNode(3);
		TreeNode treeNode6 = new TreeNode(10);
		TreeNode treeNode7 = new TreeNode(13);
		TreeNode treeNode8 = new TreeNode(4);
		TreeNode treeNode9 = new TreeNode(14);
		TreeNode treeNode10 = new TreeNode(20);
		TreeNode treeNode11 = new TreeNode(16);
		TreeNode treeNode12 = new TreeNode(2);
		TreeNode treeNode13 = new TreeNode(5);
		TreeNode treeNode14 = new TreeNode(11);
		TreeNode treeNode15 = new TreeNode(15);
		
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.left = treeNode4;
		treeNode2.right = treeNode5;
		treeNode3.left = treeNode6;
		treeNode3.right = treeNode7;
		treeNode6.left = treeNode8;
		treeNode6.right = treeNode9;
		treeNode7.left = treeNode10;
		treeNode7.right = treeNode11;
		treeNode8.left = treeNode12;
		treeNode8.right = treeNode13;
		treeNode9.left = treeNode14;
		treeNode9.right = treeNode15;
		
		PrintTreeIntuitive.printTree(treeNode1);
		System.out.println(bstTopoSize1(treeNode1));
	}
}
