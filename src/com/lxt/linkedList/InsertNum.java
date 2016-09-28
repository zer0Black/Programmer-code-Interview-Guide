package com.lxt.linkedList;

/**
 * 向有序的环形单链表中插入新节点
 * 题目：一个环形单链表从头节点head开始不降序，同时由
 *       最后的节点指回头节点。给定这样一个环形单链表
 *       的头节点head和一个整数num，请生成节点值为num
 *       的新节点，并插入到这个环形链表中，保证调整后
 *       的链表依然有序。
 * @author zer0
 *
 */
public class InsertNum {

	public static Node insertNum(Node head, int num){
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
				
		if (head.value >= num) {
			//找到最后一个节点
			Node cur = head.next;
			Node tail = head;
			while(cur != head){
				cur = cur.next;
				tail = cur; 
			}
			tail.next = node;
			node.next = head;
			return node;
		}
		
		if (head.next == head && head.value < num) {
			head.next = node;
			node.next = head;
			return head;
		}
		
		Node cur = head.next;
		Node pre = head;
		while(cur != head){
			if (num >= pre.value && num <= cur.value) {
				pre.next = node;
				node.next = cur;
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		return head;
	}
	
	public static Node insertNum2(Node head, int num){
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		
		Node pre = head;
		Node cur = head.next;
		while(cur != head){
			if (pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node1;
		
		Node node = insertNum2(node1, 0);
		Node cur = node.next;
		System.out.print(node.value + " ");
		while(cur!=node){
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
	}
	
}
