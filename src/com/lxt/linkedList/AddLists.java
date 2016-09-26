package com.lxt.linkedList;

import java.util.Stack;

import javax.crypto.Cipher;

import sun.java2d.pipe.SpanShapeRenderer.Simple;
import sun.nio.cs.ext.ISCII91;

/**
 * 两个单链表生成相加链表
 * 题目：假设链表中每一个节点的值都在0~9之间，那么
 *       链表整体就可以代表一个整数。
 * 例如：9→3→7，可以代表整数937
 * 给定两个这种链表的头结点head1和head2，请生成代表两个整数相加值的结果链表
 * 例如：链表1为9→3→7，链表2为6→3，最后生成的新结果链表为1→0→0→0
 * @author zer0
 *
 */
public class AddLists {

	/**
	 * 链表的尾节点是个位数，尾节点向头节点走，位数递增。
	 * 用两个stack保存两个节点值。然后每次取出栈顶（链表尾）
	 * 相加，进位则保存进位值，并生成新节点。
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 * 2016年9月26日
	 */
	public static Node addLists1(Node head1, Node head2){
		if (head1 == null && head2 == null) {
			return null;
		}else if (head1 != null && head2 == null) {
			return head1;
		}else if (head2 != null && head1 == null) {	
			return head2;
		}
		
		Node cur = head1;
		Stack<Integer> stack1 = new Stack<>();
		while(cur != null){
			stack1.push(cur.value);
			cur = cur.next;
		}
		
		Stack<Integer> stack2 = new Stack<>();
		cur = head2;
		while(cur != null){
			stack2.push(cur.value);
			cur = cur.next;
		}
		
		Node newHead = null; //相加后新生成链表的头结点
		boolean co = false; //进位标识符
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			int num1 = stack1.pop();
			int num2 = stack2.pop();
			if (num1 >= 10 || num2 >= 10) {
				throw new RuntimeException("链表值不正确");
			}
			int sum = num1 + num2;
			if(co){
				sum++;
			}
			
			if (sum >= 10) {
				sum-=10;
				co = true;
			}else {
				co = false;
			}
			
			Node sumNode = new Node(sum);
			sumNode.next = newHead;
			newHead = sumNode;
		}
		
		if (!stack1.isEmpty()) {
			int sum = stack1.pop();
			if (co) {
				sum++;
			}
			if (sum >= 10) {
				sum-=10;
				co = true;
			}else {
				co = false;
			}
			Node sumNode = new Node(sum);
			sumNode.next = newHead;
			newHead = sumNode;
		}
		
		if (!stack2.isEmpty()) {
			int sum = stack2.pop();
			if (co) {
				sum++;
			}
			if (sum >= 10) {
				sum-=10;
				co = true;
			}else {
				co = false;
			}
			Node sumNode = new Node(sum);
			sumNode.next = newHead;
			newHead = sumNode;
		}
		
		if (co) {
			Node node = new Node(1);
			node.next = newHead;
			newHead = node;
		}
		
		return newHead;
	}
	
	/**
	 * 与上述函数一模一样，但实现方式不同
	 * 此种实现方式更优雅
	 * @param head1
	 * @param head2
	 * @return
	 * 2016年9月26日
	 */
	public static Node addLists2(Node head1, Node head2){
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		while(head1 != null){
			stack1.push(head1.value);
			head1 = head1.next;
		}
		
		while(head2 != null){
			stack2.push(head2.value);
			head2 = head2.next;
		}
		
		int ca = 0; //进位
		Node node = null;
		Node pre = null;
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			int n1 = stack1.isEmpty() ? 0 : stack1.pop();
			int n2 = stack2.isEmpty() ? 0 : stack2.pop();
			int n = n1+n2+ca;
			pre = node;
			node = new Node(n%10);
			node.next = pre;
			ca = n/10;
		}
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		
		return node;
	}
	
	public static Node addLists3(Node head1, Node head2){
		if (head1 == null && head2 == null) {
			return null;
		}else if (head1 != null && head2 == null) {
			return head1;
		}else if (head2 != null && head1 == null) {	
			return head2;
		}
		
		head1 = reversList(head1);
		head2 = reversList(head2);
		
		int ca = 0;
		Node node = null;
		Node pre = null;
		while(head1 != null || head2 != null){
			int n1 = head1 == null ? 0 : head1.value;
			int n2 = head2 == null ? 0 : head2.value;
			int n = n1 + n2 +ca;
			pre = node;
			node = new Node(n%10);
			node.next = pre;
			ca = n / 10;
			
			head1 = head1 == null ? null : head1.next;
			head2 = head2 == null ? null : head2.next;
		}
		
		if (ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		
		reversList(head1);
		reversList(head2);
		
		return node;
	}
	
	public static Node reversList(Node head){
		Node pre = null;
		Node cur = head;
		while(cur != null){
			Node next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(4);
		Node node4 = new Node(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
	
		Node node5 = new Node(9);
		Node node6 = new Node(8);
		Node node7 = new Node(7);
		Node node8 = new Node(5);
		Node node9 = new Node(5);
		
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		
		Node root = addLists3(node1, node5);
		while(root != null){
			System.out.print(root.value+" ");
			root = root.next;
		}
	}
	
}
