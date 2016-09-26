package com.lxt.linkedList;
/**
 * 反转部分单链表
 * 题目：给定一个单向链表的头结点head，以及两个整数from和to，在单向链表上把第from
 *      个节点到第to个节点这一部分进行反转
 * @author lixuetao
 *
 */
public class ReversePart {

	public static Node reversePart1(Node head, int from, int to){
		if (head == null || from>=to || from<1) {
			return head;
		}
		
		Node preNode = null;
		Node posNode = null;
		
		int index = 0;
		Node cur = head;
		while(cur != null){
			index++;
			if (index == from-1) {
				preNode = cur;
			}
			if (index == to+1) {
				posNode = cur;
			}
			cur = cur.next;
		}
		
		if(index < to){
			return head;
		}
		
		Node pPre = posNode;
		cur = preNode != null ? preNode.next : head;
		while(cur != posNode){
			Node temp = cur.next;
			cur.next = pPre;
			pPre = cur;
			cur = temp;
		}
		
		if(preNode != null){
			preNode.next = pPre;
			return head;
		}else {
			return pPre;
		}
		
	}
	
	public static Node reversePart2(Node head, int from, int to){
		int len = 0;
		Node cur = head;
		Node fPre = null;
		Node tPos = null;
		while(cur != null){
			len++;
			fPre = len == from-1 ? cur : fPre;
			tPos = len == to+1 ? cur : tPos;
			cur = cur.next;
		}
		
		if (from > to || from < 1 || to > len) {
			return head;
		}
		
		cur = fPre == null ? head : fPre.next;
		Node node2 = cur.next;
		cur.next = tPos;
		Node next = null;
		while(node2 != tPos){
			next = node2.next;
			node2.next = cur;
			cur = node2;
			node2 = next;
		}
		
		if (fPre!=null) {
			fPre.next = cur;
			return head;
		}
		
		return cur;
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
		
		Node res = reversePart2(node1, 1, 4);
		while(res != null){
			System.out.print(res.value + " ");
			res = res.next;
		}
	}
	
}
