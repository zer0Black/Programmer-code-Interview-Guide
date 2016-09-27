package com.lxt.linkedList;

import java.util.Currency;
import java.util.Stack;

import javax.security.auth.kerberos.KerberosKey;

import javafx.scene.shape.Circle;
import sun.net.www.content.audio.x_aiff;

/**
 * 将单链表的每k个节点之间逆序
 * 题目：给定一个单链表的头结点head，实现一个调整单链表
 *       的函数，使得没K个节点之间逆序，如果最后不够K个
 *       节点一组，则不调整最后K个节点
 * @author zer0
 *
 */
public class ReverseKNode {
	
	/**
	 * 用一个栈保存链表，保存到k个就取出来组成新链表
	 * @param head
	 * @return
	 * 2016年9月27日
	 */
	public static Node reverseKNode1(Node head, int k){
		if (head == null || k <= 1) {
			return head;
		}
		
		Stack<Node> stack = new Stack<>();
		Node pre = null;
		Node cur = head;
		Node newHead = head;
		while(cur != null){
			stack.push(cur);
			Node next = cur.next;
			if (stack.size() == k) {
				//反转
				pre = resign1(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	
	/**
	 * 将栈内的值组成链表，并与原链表连起来。
	 * 并返回链表尾节点。
	 * @pre 这段链表的前一个节点
	 * @next 这段链表的下一个节点
	 */
	public static Node resign1(Stack<Node> stack, Node pre, Node next){
		Node cur = stack.pop();
		if (pre != null) {
			pre.next = cur;
		}
		while(!stack.isEmpty()){
			cur.next = stack.pop();
			cur = cur.next;
		}
		cur.next = next;
		return cur;
	}
	
	/**
	 * 用两个节点保存每k段的头节点和尾节点。数k个节点，直接反转
	 * @param head
	 * @return
	 * 2016年9月27日
	 */
	public static Node reverseKNode2(Node head, int k){
		if (head == null || k <= 1) {
			return head;
		}
		
		Node start = null; //k段头结点
		Node end = null; //k段尾节点
		
		Node pre = null;
		Node cur = head;
		Node newHead = head;
		int count = 0;
		while(cur != null){
			count++;
			end = cur;
			Node next = cur.next;
			if (count == k) {
				start = pre == null ? head : pre.next;
				newHead = newHead == head ? end : newHead;
				pre = resign2(pre, start, end, next);
				count = 0;
			}
			cur = next;
		}
		
		return newHead;
	}
	
	public static Node resign2(Node left, Node start, Node end, Node right){
		Node pre = right;
		Node cur = start;
		while(cur != right){
			Node next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		if (left != null) {
			left.next = end;
		}
		
		return start;
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
		
		Node node = reverseKNode1(node1, 1);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
}
