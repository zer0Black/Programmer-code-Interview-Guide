package com.lxt.tree;

public class MinDepth {

	public static int minDepth(TreeNode root) {
        // write your code here
        if(root == null){ 
            return 0;
        }
        
        if (root.left == null && root.right == null){  
            return 1;  
        } 
        
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left < right ? left + 1: right + 1;
        
    }
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		
//		root1.left = root2;
		root1.right = root2;
		root2.left = root3;
		
		System.out.println("minDepth=" + minDepth(root1));
	}
	
}
