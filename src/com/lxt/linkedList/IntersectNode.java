package com.lxt.linkedList;
/**
 * 两个单链表相交的一系列问题
 * 题目：单链表可能有环，也可能无环。给定两个单链表的头节点
 *       head1和head2，这两个链表可能相交也可能不相交。请
 *       实现一个函数，如果两个链表相交，返回相交的第一个
 *       节点；如果不相交，返回null即可
 * 要求：如果链表1长度N，链表2长度M，时间复杂度达到O(N+M)，
 * 		 空间复杂度O(1)
 * @author zer0
 *
 */
public class IntersectNode {
	
	/**
	 * 判断链表是否有环，若有，则返回入环节点
	 * @param head
	 * @return
	 * 2016年9月27日
	 */
	public static Node getLoopNode(Node head){
		if(head == null) return null;
		Node slow = head;
		Node fast = head;
		Node p = null; //碰撞节点P
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				p = slow;
				break;
			}
		}
		
		while(head != null && p != null){
			head = head.next;
			p = p.next;
			if (head == p) {
				break;
			}
		}
		
		return p;
	}
	
	/**
	 * 都没环的情况
	 * @param head1
	 * @param head2
	 * @return
	 * 2016年9月27日
	 */
	public static Node noLoop(Node head1, Node head2){
		if (head1 == null || head2 == null) {
			return null;
		}
		
		int len1 = 0;
		Node cur1 = head1;
		while(cur1 != null){
			len1++;
			cur1 = cur1.next;
		}
		
		int len2 = 0;
		Node cur2 = head2;
		while(cur2 != null){
			len2++;
			cur2 = cur2.next;
		}
		
		int k = len1-len2;
		cur1 = k>0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		k = Math.abs(k);
		while(k!=0){
			k--;
			cur1 = cur1.next;
		}
		
		while(cur1 != cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		return cur1;
	}
	
	/**
	 * 都有环的情况
	 * @param head1
	 * @param head2
	 * @return
	 * 2016年9月27日
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
		if (head1 == null || head2 == null || loop1 == null || loop2 == null) {
			return null;
		}
		
		//两种情况，一种是在环外相交，一种是在环内相交
		if(loop1 == loop2){
			int len1 = 0;
			Node cur1 = head1;
			while(cur1 != loop1){
				len1++;
				cur1 = cur1.next;
			}
			
			int len2 = 0;
			Node cur2 = head2;
			while(cur2 != loop2){
				len2++;
				cur2 = cur2.next;
			}
			
			int k = len1-len2;
			cur1 = k>0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			k = Math.abs(k);
			while(k!=0){
				k--;
				cur1 = cur1.next;
			}
			
			while(cur1 != cur2){
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			
			return cur1;
		}else {
			Node cur = loop1.next;
			while(cur != loop1){
				if (cur == loop2) {
					return loop1;
				}
				cur = cur.next;
			}
			return null;
		}
	}
	
	public static Node getIntersectNode(Node head1, Node head2){
		if (head1 == null || head2 == null) {
			return null;
		}
		
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}else if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		
		return null;
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
		node6.next = node3;
		
		node7.next = node8;
		node8.next = node9;
		node9.next = node5;
		
		Node node = getIntersectNode(node1, node7);
		if (node!=null) {
			System.out.println("相交节点为" + node.value);
		}else {
			System.out.println("无相交节点");
		}
		
	}
}
