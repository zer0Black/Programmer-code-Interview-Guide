package com.lxt.linkedList;

/**
 * 单链表的选择排序
 * @author zer0
 *
 */
public class SelectionSort {

	public static Node selectionSort(Node head){
		if (head == null) {
			return null;
		}
		
		Node small = null;
		Node smallPre = null;
		Node cur = head; //未排序链表头部
		Node tail = null; //排序链表末尾
		while(cur != null){
			small = cur;
			smallPre = getSmallestPre(small);
			if (smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur == small ? cur.next : cur;
			if (tail == null) {
				head = small;
			}else {
				tail.next = small;
			}
			
			tail = small;
		}
		
		return head;
	}
	
	public static Node getSmallestPre(Node head){
		Node small = head;
		Node smallPre = null;
		Node cur = head.next;
		Node pre = head;
		
		while(cur != null){
			if (cur.value < small.value) {
				smallPre = pre;
				small = cur;
			}
			//后移
			pre = cur;
			cur = cur.next;
		}
		
		return smallPre;
	}
	
}
