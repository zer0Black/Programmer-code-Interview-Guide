package com.lxt.linkedList;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 要求1：在左、中、右三个部分的内部也做顺序要求，要求每部分里
 *        的节点从左到右的顺序与原链表中节点的先后顺序一致
 * 要求2：时间复杂度O(n)，空间复杂度O(1)
 * @author zer0
 *
 */
public class ListPartition {

	/**
	 * 1)生成pivot节点pPivo，挂在链表开头
	 * 2)顺序遍历链表：
	 *   小于pivot的挂在pPivot节点左边
	 *   等于pivot的紧靠着pPivot节点右边
	 *   大于pivot的不动。
	 * 3)删除pPivot节点
	 * @param head
	 * @param pivot
	 * @return
	 * 2016年9月26日
	 */
	public static Node listPartition1(Node head, int pivot){
		if (head == null) {
			return head;
		}
		
		Node pPivot = new Node(pivot);
		Node pHead = pPivot; //最后返回的头结点，记录头结点的变换
		
		pPivot.next = head;
		
		Node cur = head;
		Node pre = pPivot;
		Node pPre = null; //pPivot的前一个节点
		int index = 0;
		while(cur != null){
			if (cur.value < pivot) {
				index++;
				Node tmp = cur;
				//删除小于pivot的节点
				Node next = cur.next;
				pre.next = cur.next;
				cur = next;
				
				//把小于pivot的节点挂在紧靠着pPivot的左边
				tmp.next = pPivot;
				
				//单独处理第一个挂在左边的节点
				//这个节点一定为头节点
				if (index == 1) {
					pHead = tmp;
				}else {
					pPre.next = tmp;
				}
				pPre = tmp;
			}else if (cur.value == pivot) {
				Node tmp = cur;
				//删除小于pivot的节点
				Node next = cur.next;
				pre.next = cur.next;
				cur = next;
				
				//把等于pivot的节点挂在紧靠着pPivot的右边
				next = pPivot.next;
				pPivot.next = tmp;
				tmp.next = next;
			}else {
				pre = cur;
				cur = cur.next;
			}
		}
		
		//最后把节点pPivot删除
		pPre.next = pPivot.next;
		
		return pHead;
	}
	
	/**
	 * 根据pivot将链表分为三部分：
	 * small：小于pivot的链表
	 * equal：等于pivot的链表
	 * big：大于pivot的链表
	 * 最后将3部分链表连起来即可
	 * @param head
	 * @param pivot
	 * @return
	 * 2016年9月26日
	 */
	public static Node listPartition2(Node head, int pivot){
		if (head == null) {
			return head;
		}
	
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		
		Node cur = head;
		while(cur != null){
			Node next = cur.next;
			if (cur.value < pivot) {
				if (sH == null) {
					sH = cur;
					sT = cur;
				}else {
					sT.next = cur;
					sT = sT.next;
				}
			}else if (cur.value == pivot) {
				if (eH == null) {
					eH = cur;
					eT = cur;
				}else {
					eT.next = cur;
					eT = eT.next;
				}
			}else {
				if (bH == null) {
					bH = cur;
					bT = cur;
				}else {
					bT.next = cur;
					bT = bT.next;
				}
			}
			
			cur = cur.next;
		}
		
		//将链表连起来
		if (sT!=null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		
		if (eT!=null) {
			eT.next = bH;
		}
		
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(4);
		Node node2 = new Node(3);
		Node node3 = new Node(1);
		Node node4 = new Node(6);
		Node node5 = new Node(2);
		Node node6 = new Node(8);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		int pivot = 5;
		
		Node node = listPartition1(node1, pivot);
		while(node != null){
			System.out.print(node.value+" ");
			node = node.next;
		}
	}
}
