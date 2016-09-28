package com.lxt.linkedList;

/**
 * 合并两个有序单链表
 * @author zer0
 *
 */
public class MergeList {

	public static Node merge(Node head1, Node head2){
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		
		Node head = head1.value < head2.value ? head1 : head2;
		Node cur = head;
		
		Node cur1 = cur.next;
		Node cur2 = cur == head1 ? head2 : head1;
		Node pre = null;
		while(cur1 != null && cur2 != null){
			if (cur1.value < cur2.value) {
				cur.next = cur1;
				cur1 = cur1.next;
			}else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}
		
		cur.next = cur1 == null ? cur2 : cur1;
		return head;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		
		node1.next = node3;
		node3.next = node4;
		node4.next = node6;
		
		Node node2 = new Node(2);
		Node node5 = new Node(5);
		
		node2.next = node5;
		
		Node node = merge(node1, node2);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
}
