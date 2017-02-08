package com.lxt.tree;

import sun.reflect.generics.tree.Tree;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * Note: Time complexity should be O(height of tree).
 * @author zer0
 */
public class DeleteBSTNode {

	/**
	 * BST的特点：左子树所有节点一定比根节点小，右子树所有节点一定比根节点大
	 */
	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		
		TreeNode deleteNode = null;
		TreeNode curNode = root;
		TreeNode parentNode = null;
		while(curNode != null){
			if (curNode.value == key) {
				deleteNode = curNode;
				break;
			}
			parentNode = curNode;
			if (curNode.value > key) {	
				curNode = curNode.left;
			}else if (curNode.value < key) {
				curNode = curNode.right;
			}
		}
		
		if (curNode == null) {
			return root;
		}else if(parentNode == null) {
			return del(deleteNode);
		}else if(parentNode.left != null && parentNode.left.value == key){
			parentNode.left = del(deleteNode);
		}else if (parentNode.right != null && parentNode.right.value == key) {
			parentNode.right = del(deleteNode);
		}
		
		return root;
    }
	
	/**
	 * 删除分四种情况：
	 * 1、左右子节点都是空，直接返回空
	 * 2、只有左子树，返回左子树
	 * 3、只有右子树，返回右子树
	 * 4、左右子树都存在，则找到右子树中最小节点（最左节点）代替删除节点
	 */
	public static TreeNode del(TreeNode node){
		if (node.left == null && node.right == null) {
			return null;
		}
		
		if(node.left == null || node.right == null){
			return node.left == null ? node.right : node.left;
		}
		
		TreeNode parentNode = node;
		TreeNode curNode = parentNode.right;
		while (curNode.left != null) {
			parentNode = curNode;
			curNode = curNode.left;
		}
		node.value = curNode.value;
		if(parentNode == node){
			parentNode.right = curNode.right;
		}else {
			parentNode.left = curNode.right;
		}
		return node;
	}
	
}
