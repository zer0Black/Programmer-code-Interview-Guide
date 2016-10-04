package com.lxt.tree;

import java.util.LinkedList;


/**
 * 判断一棵树是否为完全二叉树
 * @author lixuetao
 *
 */
public class IsCBT {

	/**
	 * 层序遍历
	 * 1、如果左节点为空，右节点不为空，false；
	 * 2、如果当前节点只有左节点，没有右节点，则之后的所有节点都为叶子节点
	 *    叶子节点的左右孩子都必须为空，否则false；
	 * @param root
	 * @return
	 */
	public static boolean isCBT(TreeNode root){
		if (root == null) {
			return false;
		}
		
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		boolean leaf = false;
		
		while(!list.isEmpty()){
			TreeNode cur = list.poll();
			TreeNode lNode = cur.left;
			TreeNode rNode = cur.right;
			if(leaf && (lNode != null || rNode != null)){
				return false;
			}
			
			if (lNode == null && rNode != null) {
				return false;
			}
			
			if(lNode != null){
				list.add(lNode);
			}
			
			if(rNode != null){
				list.add(rNode);
			}else {
				leaf = true;
			}
		}
		
		return true;
	}
	
}
