/**
 * 
 */
package com.lxt.linkedList;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * @author zer0
 *
 */
public class RemoveLastKthNode {

	/**
	 * 使用双指针，快指针先走K步，然后一起走，直到快指针为null
	 * 用一个pre指针来保存需要删除节点的前一个节点
	 * @param head
	 * @param lastKth
	 * 2016年9月22日
	 */
	public static Node singleListRemoveLstKth(Node head, int lastKth){
		if (head == null || lastKth < 1) {
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		Node pre = null;
		
		while(lastKth>0){
			if (fast == null) {
				return head;
			}
			fast = fast.next;
			lastKth--;
		}
		
		while(fast != null){
			pre = slow;
			slow = slow.next;
			fast = fast.next;
		}
		
		if (fast == null && pre == null) {
			head = head.next;
			return head;
		}
		
		//移除倒数第k个节点
		pre.next = slow.next;
		return head;
		
	}
	
	public static DoubleNode twoWayListRemoveLstKth(DoubleNode head, int lastKth){
		if (head == null || lastKth < 1) {
			return head;
		}
		
		DoubleNode slow = head;
		DoubleNode fast = head;
		
		while(lastKth>0){
			if (fast == null) {
				return head;
			}
			fast = fast.next;
			lastKth--;
		}
		
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		if (slow.last != null) {
			slow.last.next = slow.next;
		}else {
			head = head.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		int k = 2;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		Node root = singleListRemoveLstKth(node1, k);
		System.out.print("单链表：");
		while(root != null){
			System.out.print(root.value+" ");
			root = root.next;
		}
		
		System.out.println();
		
		DoubleNode doubleNode1 = new DoubleNode(1);
		DoubleNode doubleNode2 = new DoubleNode(2);
		DoubleNode doubleNode3 = new DoubleNode(3);
		DoubleNode doubleNode4 = new DoubleNode(4);
		DoubleNode doubleNode5 = new DoubleNode(5);
		
		doubleNode1.next = doubleNode2;
		doubleNode2.next = doubleNode3;
		doubleNode2.last = doubleNode1;
		doubleNode3.next = doubleNode4;
		doubleNode3.last = doubleNode2;
		doubleNode4.next = doubleNode5;
		doubleNode4.last = doubleNode3;
		doubleNode5.last = doubleNode4;
		
		DoubleNode doubleRoot = twoWayListRemoveLstKth(doubleNode1, k);
		System.out.print("双链表：");
		while(doubleRoot != null){
			System.out.print(doubleRoot.value+" ");
			doubleRoot = doubleRoot.next;
		}
	}
}
