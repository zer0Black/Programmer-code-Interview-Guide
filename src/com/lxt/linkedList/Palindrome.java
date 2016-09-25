package com.lxt.linkedList;

import java.util.Stack;

import org.omg.CORBA.NO_IMPLEMENT;

import sun.reflect.generics.tree.Tree;

/**
 * 判断一个链表是否是回文结构
 * @author zer0
 *
 */
public class Palindrome {

	/**
	 * 方案1：用stack存下整个链表，stack刚好把链表逆序
	 *        对比stack和链表的值，全能匹配上则证明是
	 *        回文结构
	 * 时间复杂度O(n),空间复杂度O(n)
	 * @param head
	 * @return
	 * 2016年9月25日
	 */
	public static boolean isPalindrome1(Node head){
		if (head == null) {
			return false;
		}
		
		Stack<Integer> stack = new Stack<>();
		Node cur = head;
		while(cur != null){
			stack.push(cur.value);
			cur = cur.next;
		}
		
		cur = head;
		while(cur != null && !stack.isEmpty()){
			if (stack.pop() != cur.value) {
				return false;
			}
			cur = cur.next;
		}
		
		return true;
	}
	
	/**
	 * 方案2：用stack存下右半部分，对比stack和链表左半部分的值，
	 * 		    全能匹配上则证明是回文结构
	 * 时间复杂度O(n),空间复杂度O(n/2)
	 * @param head
	 * @return
	 * 2016年9月25日
	 */
	public static boolean isPalindrome2(Node head){
		if (head == null) {
			return false;
		}
		
		Node slow = head.next;
		Node fast = head;
		//用快慢指针先找出右半部分的首节点
		while(fast.next != null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Stack<Integer> stack = new Stack<>();
		while(slow != null){
			stack.push(slow.value);
			slow = slow.next;
		}
		
		Node cur = head;
		while(!stack.isEmpty() && cur != null){
			if (stack.pop() != cur.value) {
				return false;
			}
			cur = cur.next;
		}
		
		return true;
	}
	
	/**
	 * 方案3：调整链表右半部分反转，然后从链表头和尾同时向中间走。
	 *        比较，如果不相同则返回false。走到中间节点停止。
	 *        比较完再把链表调回去
	 * 时间复杂度O(n),空间复杂度O(1)
	 * @param head
	 * @return
	 * 2016年9月25日
	 */
	public static boolean isPalindrome3(Node head){
		if (head == null) {
			return false;
		}

		//找出中间节点
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//反转链表，最后pre指向尾节点
		Node pre = null;
		Node cur = slow;
		while(cur != null){
			Node next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		boolean res = true;
		Node first = head;
		Node last = pre;
		//从头和尾分别向中间走
		while(first != null && last != null){
			if (first.value != last.value) {
				res = false;
				break;
			}
			first = first.next;
			last = last.next;
		}
		
		//把链表调回来
		last = pre;
		pre = null;
		while(last != null){
			Node next = last.next;
			last.next = pre;
			pre = last;
			last = next;
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(3);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println(isPalindrome3(node1));
	}
	
}
