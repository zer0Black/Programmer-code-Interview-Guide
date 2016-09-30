package com.lxt.linkedList;

import java.util.LinkedList;
import java.util.Queue;

import com.lxt.tree.TreeNode;

/**
 * 将搜索二叉树转换为有序的双向链表
 * @author zer0
 *
 */
public class SearchTreeToDLink {

	/**
	 * 搜索二叉树中序遍历的结果即为有序的。
	 * 用一个队列保存中序遍历的结果，
	 * 然后依队列来链接成双向链表
	 * @param head
	 * @return
	 * 2016年9月27日
	 */
	public static TreeNode convert1(TreeNode head){
		if (head == null) {
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		inOrder(queue, head);
		
		TreeNode newHead = queue.poll();
		TreeNode cur = newHead;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			cur.right = node;
			node.left = cur;
			cur = node;
		}
		
		return newHead;
	}
	
	public static void inOrder(Queue<TreeNode> queue, TreeNode head){
		if (head == null) {
			return;
		}
		inOrder(queue, head.left);
		queue.add(head);
		inOrder(queue, head.right);
	}
	
	public static TreeNode convert2(TreeNode head){
		if (head == null) {
			return null;
		}
		
		TreeNode res = null;
		res = convertCore(head, res);
		
		TreeNode headNode = res;
	    while(headNode!=null & headNode.left != null){
	       headNode = headNode.left;
	    }
	        
	    return headNode;
	}
	
	public static TreeNode convertCore(TreeNode head, TreeNode res){
		TreeNode cur = head;
		if (head.left != null) {
			res = convertCore(head.left, res);
		}
		
		cur.left = res;
		if (res!=null) {
			res.right = cur;
		}
		res = cur;
		
		if (head.right != null) {
			res = convertCore(head.right, res);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode9 = new TreeNode(9);
		
		treeNode6.left = treeNode4;
		treeNode6.right = treeNode7;
		treeNode4.left = treeNode2;
		treeNode4.right = treeNode5;
		treeNode7.right = treeNode9;
		treeNode2.left = treeNode1;
		treeNode2.right = treeNode3;
		treeNode9.left = treeNode8;
		
		TreeNode node = convert1(treeNode6);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.right;
		}
	}
}
