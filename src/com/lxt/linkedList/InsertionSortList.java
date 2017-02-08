package com.lxt.linkedList;

/**
 * LeetCode 147 Insertion Sort List
 * Sort a linked list using insertion sort.
 * Subscribe to see which companies asked this question.
 * @author zer0
 *
 */
public class InsertionSortList {
	
	public static Node insertionSortList(Node head) {
		if (head == null) {
			return head;
		}
        Node sortedNode = new Node(-1);
        Node cur = null;

        while(head != null){
        	cur = sortedNode;
        	while(cur.next != null && cur.next.value < head.value){
        		cur = cur.next;
        	}
        	Node next = head.next;
        	head.next = cur.next;
        	cur.next = head;
        	head = next;
        }
        return sortedNode.next;
    }
	
}
