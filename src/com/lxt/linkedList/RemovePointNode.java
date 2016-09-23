/**
 * 
 */
package com.lxt.linkedList;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * 删除链表的中间节点和a/b处的节点
 * @author zer0
 *
 */
public class RemovePointNode {

	public Node removeMidNode(Node head){
		if (head == null || head.next == null) {
			return head;
		}
		
		//如果只有两个节点，移除第一个节点
		if (head.next.next == null) {
			return head.next;
		}
		
		//快慢指针，快指针先走两步，再一起走，则慢指针指向中间节点的前一节点
		Node cur = head.next.next;
		Node pre = head;
		
		while(cur.next != null && cur.next.next != null){
			pre = pre.next;
			cur = cur.next.next;
		}
		
		pre.next = pre.next.next;
		return head;
	}
	
	
	
}
