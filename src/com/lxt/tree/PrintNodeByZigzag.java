package com.lxt.tree;

import java.util.LinkedList;

/**
 * 以Z字形的方式打印树
 * @author zer0
 *
 */
public class PrintNodeByZigzag {

	public static void printZigzag(TreeNode root){
		if (root == null) {
			return;
		}
		
		boolean ltor = true; //打印的方向，true为从左到右，false为从右到左
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		int cur = 1; //当前层要打印的节点数
		int next = 0; //下一层要打印的节点数
		
		printOrentation(ltor);
		while(!list.isEmpty()){
			if (ltor) {				
				TreeNode printNode = list.pollFirst();
				System.out.print(printNode.value + " ");
				cur--;
				
				if (printNode.left != null) {
					list.addLast(printNode.left);
					next++;
				}
				if (printNode.right != null){
					list.addLast(printNode.right);
					next++;
				}
			}else {
				TreeNode printNode = list.pollLast();
				System.out.print(printNode.value + " ");
				cur--;
				
				if (printNode.right != null) {
					list.addFirst(printNode.right);
					next++;
				}
				if (printNode.left != null) {
					list.addFirst(printNode.left);
					next++;
				}
			}
			
			if (cur == 0 && !list.isEmpty()) {
				cur = next;
				next = 0;
				ltor = !ltor;
				System.out.println();
				printOrentation(ltor);
			}
		}
		
	}
	
	private static void printOrentation(boolean ltor){
		System.out.print(ltor ? "left to right:": "right to left:");
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.left = node5;
		node4.left = node7;
		
		printZigzag(node1);
	}
	
}
