package com.lxt.tree;

/**
 * 打印二叉树的边界节点
 * 给定一颗二叉树的头节点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印
 * 标准一：
 *     1、头节点为边界节点
 *     2、叶节点为边界节点
 *     3、如果节点在其所在层的最左或者最右，那么也是边界节点
 * 要求：逆时针打印
 * @author zer0
 *
 */
public class PrintEdge {
	
	/**
	 * 1、获取树高度，生成相应大小的边界map
	 * 2、用边界map存每一层的最左最右子节点
	 * 3、打印最左节点
	 * 4、打印除最左左右子节点外的所有叶节点
	 * 5、打印最右节点
	 * @param head
	 * 2016年9月29日
	 */
	public static void printEdge1(TreeNode root){
		if (root == null) {
			return;
		}
		
		int height = getHeight(root, 0);
		TreeNode[][] edgeMap = new TreeNode[height][2];
		setEdgeMap(root, 0, edgeMap);
		
		for(int i = 0; i < edgeMap.length; i++){
			System.out.print(edgeMap[i][0].value+" ");
		}
		
		printLeafNotMap(root, 0, edgeMap);
		
		for(int i = edgeMap.length - 1; i >= 0; i--){
			if (edgeMap[i][0] != edgeMap[i][1]) {
				System.out.print(edgeMap[i][1].value+" ");
			}
		}
	}
	
	/**
	 * 获取树的高度，第一次传进来的层级要为0，因为返回条件是节点为null才返回
	 * level一直加到叶节点之下的null节点
	 * @param root
	 * @param level
	 * @return
	 * 2016年9月29日
	 */
	private static int getHeight(TreeNode root, int level){
		if (root == null) {
			return level;
		}
		
		return Math.max(getHeight(root.left, level+1), getHeight(root.right, level+1));
	}
	
	private static void setEdgeMap(TreeNode node, int level, TreeNode[][] map){
		if (node == null) {
			return;
		}
		//每层的最左节点。三元表达式来防止最右节点的左子节点干扰
		map[level][0] = map[level][0] == null ? node : map[level][0];
		//每层的最右节点
		map[level][1] = node;
		
		//递归获取每一层的
		setEdgeMap(node.left, level+1, map);
		setEdgeMap(node.right, level+1, map);
	}
	
	/**
	 * 获取不在边界map中的叶节点
	 * 
	 * 2016年9月29日
	 */
	private static void printLeafNotMap(TreeNode node, int level, TreeNode[][] map){
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && node != map[level][0] && node != map[level][1]) {
			System.out.print(node.value + " ");
		}
		printLeafNotMap(node.left, level+1, map);
		printLeafNotMap(node.right, level+1, map);
	}
	
	public static void main(String[] args) {
		TreeNode TreeNode1 = new TreeNode(1);
		TreeNode TreeNode2 = new TreeNode(2);
		TreeNode TreeNode3 = new TreeNode(3);
		TreeNode TreeNode4 = new TreeNode(4);
		TreeNode TreeNode5 = new TreeNode(5);
		TreeNode TreeNode6 = new TreeNode(6);
		TreeNode TreeNode7 = new TreeNode(7);
		TreeNode TreeNode8 = new TreeNode(8);
		TreeNode TreeNode9 = new TreeNode(9);
		TreeNode TreeNode10 = new TreeNode(10);
		TreeNode TreeNode11 = new TreeNode(11);
		TreeNode TreeNode12 = new TreeNode(12);
		TreeNode TreeNode13 = new TreeNode(13);
		TreeNode TreeNode14 = new TreeNode(14);
		TreeNode TreeNode15 = new TreeNode(15);
		TreeNode TreeNode16 = new TreeNode(16);
	
		TreeNode1.left = TreeNode2;
		TreeNode1.right = TreeNode3;
		TreeNode2.right = TreeNode4;
		TreeNode3.left = TreeNode5;
		TreeNode3.right = TreeNode6;
		TreeNode4.left = TreeNode7;
		TreeNode4.right = TreeNode8;
		TreeNode5.left = TreeNode9;
		TreeNode5.right = TreeNode10;
		TreeNode8.right = TreeNode11;
		TreeNode9.left = TreeNode12;
		TreeNode11.left = TreeNode13;
		TreeNode11.right = TreeNode14;
		TreeNode12.left = TreeNode15;
		TreeNode12.right = TreeNode16;
		
		printEdge1(TreeNode1);
		
	}
}
