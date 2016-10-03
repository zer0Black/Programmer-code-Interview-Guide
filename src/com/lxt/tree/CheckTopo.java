package com.lxt.tree;

/**
 * 判断t1树是否包含t2树全部的拓扑结构
 * @author zer0
 *
 */
public class CheckTopo {

	//t1做前序遍历，遇到节点与t2头结点相同时，t1跟着t2做前序遍历
	//在遍历过程中，一旦t1和t2节点值不一样，则返回false
	public static boolean contains(TreeNode t1, TreeNode t2){
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}
	
	public static boolean check(TreeNode t1, TreeNode t2){
		if (t2 == null) {
			return true;
		}
		
		if (t1 == null || t1.value != t2.value) {
			return false;
		}
		
		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}
	
}
