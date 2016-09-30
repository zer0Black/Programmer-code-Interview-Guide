package com.lxt.linkedList;
/**
 * 在单链表中删除指定值的节点
 * 题目：给定一个链表的头节点head和一个整数num，
 *      请实现函数将值为num的节点全部删除
 * @author zer0
 *
 */
public class RemoveValue {

	/**
	 * 找出第一个不为num的数做头节点，
	 * 然后从头往后走，遇到num节点就删掉
	 * @param head
	 * @param num
	 * @return
	 * 2016年9月27日
	 */
	public static Node removeValue(Node head, int num){
		if (head == null) {
			return null;
		}
		
		while(head != null){
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if (cur.value == num) {
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(4);
		Node node6 = new Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		int num = 2;
		Node node = removeValue(node1, num);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
}
