/**
 * 
 */
package com.lxt.linkedList;

/**
 * 交换链表中的两个节点
 * @author zer0
 *
 */
public class SwapNode {

	 public static Node swapNodes(Node head, int v1, int v2) {
	        
	        if(head == null){
	            return null;
	        }
	        
	        Node dummy = new Node(-1);//头结点
	        dummy.next = head;
	        
	        Node preL = dummy;
	        Node curL = head;
	        
	        Node preR = null;
	        Node curR = null;
	        
	        while(curL != null && (curL.value != v1 && curL.value != v2)){
	            preL = curL;
	            curL = curL.next;
	        }
	        
	        if(curL != null){
	            preR = curL;
	            curR = preR.next;
	        }
	        
	        while(curR != null && (curR.value != v1 && curR.value != v2)){
	            preR = curR;
	            curR = curR.next;
	        }
	        
	        //交换
	        if(curR != null && curL != null){
	        	if (preR != curL) {
	        		Node tmpCur = curR.next;
		            curR.next = curL.next;
		            curL.next = tmpCur;
				}else{
					Node tmpCur = curR.next;
					curR.next = curL;
					curL.next = tmpCur;
				}
	        
	        }
	        
	        return dummy.next;
	
	 }
	 
	 public static void main(String[] args) {
		
		 Node node1 = new Node(1);
		 Node node2 = new Node(2);
		 Node node3 = new Node(3);
		 Node node4 = new Node(4);
		 
		 node1.next = node2;
		 node2.next = node3;
		 node3.next = node4;
		 
		 swapNodes(node1, 2, 3);
	}
	 
}
