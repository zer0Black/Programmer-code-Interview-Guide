package com.lxt.tree;

/**
 * 在二叉树中找到一个节点的后继节点
 * 题目：该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 *      在二叉树的中序遍历中，node的下一个节点叫做node的后继节点。
 *      给定二叉树中某个节点node，请实现返回node后继节点的函数
 * @author lixuetao
 *
 */
public class NextNode {

	public static TreeNodeWithP getNextNode(TreeNodeWithP node){
		if (node == null) {
			return null;
		}
		
		TreeNodeWithP next = null;
		if (node.right != null) {
			next  = node.right;
			while(next.left != null){
				next = next.left;
			}
		}else {
			TreeNodeWithP parent = node.parent;
			//一直往上找，找到当前节点是父节点的左子节点
			while(parent != null && node == parent.right){
				node = parent;
				parent = parent.parent;
			}
			next = parent;
		}
		
		return next;
	}
	
}

class TreeNodeWithP{
	public int value;
	public TreeNodeWithP left;
	public TreeNodeWithP right;
	public TreeNodeWithP parent;
	
	public TreeNodeWithP(int data) {
		value = data;
	}
}
