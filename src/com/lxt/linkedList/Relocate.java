package com.lxt.linkedList;

/**
 * 按照左右半区的方式重新组合单链表
 * 题目：给定一个单链表的头部节点head，链表长度为N，如果N为偶数，
 *      那么前N/2个节点算作左半区，后N/2个节点算作右半区；如果
 *      N为奇数，那么前N/2个节点算作左半区，后N/2+1个节点算作
 *      右半区。左半区记为 L1→L2→L3... 右半区记为R1→R2→R3...   
 *      将单链表调整为L1→R1→L2→R2→L3→R3的形式
 * @author zer0
 *
 */
public class Relocate {

	public static Node relocate(Node head){
		if (head == null || head.next == null) {
			return head;
		}
		
		Node slow = head;
		Node fast = head.next;
		while(fast.next !=null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node right = slow.next;
		slow.next = null;
		return mergeLR(head, right);
	}
	
	public static Node mergeLR(Node left, Node right){
		Node head = left;
		//右半区一定比左半区长或者相等，所以只判断左半区
		while(left.next != null){
			Node next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
		return head;
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
		
		Node node = relocate(node1);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
}
