/**
 * 
 */
package com.lxt.tree;

import java.util.LinkedList;

/**
 * 层序遍历二叉树，每一行打印一层
 * @author zer0
 *
 */
public class PrintNodeByLevel {

	/**
	 * 层序遍历的升级，在层序遍历的基础上，需要记录每层需要打印的节点
	 * 用一个变量cur记录当前层需要打印的节点
	 * 用一个变量next记录下一层添加的节点数
	 * 当cur变为0，证明当前层打印完，打印换行符，跳到下一层
	 * 
	 * 2016年9月22日
	 */
	public static void printNodeByLevel(TreeNode head){
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(head);
		int cur = 1;
		int next = 0;
		
		while(list.size() > 0){
			TreeNode node = list.pollFirst();
			cur--;
			System.out.printf("%5d", node.value);
			
			if (node.left != null) {
				list.add(node.left);
				next++;
			}
			
			if (node.right != null) {
				list.add(node.right);
				next++;
			}
			
			if (cur == 0) {
				System.out.println();
				cur = next;
				next = 0;
			}
		}
	}
	
}
