package com.lxt.linkedList;

import java.util.Currency;

/**
 * 反转单向链表 和 双向链表
 * @author zer0
 *
 */
public class ReverseList {

	public static Node reverseSingleList(Node head){
		if (head == null) {
			return head;
		}
		Node pre = null;
		Node cur = head;
		while(cur != null){
			Node temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
	
	public static DoubleNode reverseTwoWayList(DoubleNode head){
		if (head == null) {
			return head;
		}
		
		DoubleNode cur = head;
		DoubleNode newHead = null;
		while(cur != null){
			DoubleNode temp = cur.next;
			cur.next = cur.last;
			cur.last = temp;
			newHead = cur;
			cur = temp;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		Node res = reverseSingleList(node1);
		while(res != null){
			System.out.print(res.value + " ");
			res = res.next;
		}
		
		System.out.println();
		
		DoubleNode dNode1 = new DoubleNode(1);
		DoubleNode dNode3 = new DoubleNode(3);
		DoubleNode dNode5 = new DoubleNode(5);
		DoubleNode dNode7 = new DoubleNode(7);
		DoubleNode dNode9 = new DoubleNode(9);
		
		dNode1.next = dNode3;
		dNode3.next = dNode5;
		dNode3.last = dNode1;
		dNode5.next = dNode7;
		dNode5.last = dNode3;
		dNode7.next = dNode9;
		dNode7.last = dNode5;
		dNode9.last = dNode7;
		
		DoubleNode dRes = reverseTwoWayList(dNode1);
		while(dRes != null){
			System.out.print(dRes.value + " ");
			dRes = dRes.next;
		}
	}
}
