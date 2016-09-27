package com.lxt.linkedList;

import java.util.HashSet;

import javafx.scene.shape.Circle;

/**
 * 删除无序单链表中值重复出现的节点
 * 题目：给定一个无序单链表的头结点head，删除其中值重复出现的节点
 * 要求：方法1，时间辅助度O(n)
 * 	             方法2，额外空间复杂度O(1)
 * @author zer0
 *
 */
public class RemoveRep {

	/**
	 * 使用哈希表存储出现过的值，遇到则删掉
	 * @param head
	 * @return
	 * 2016年9月27日
	 */
	public static Node removeRep1(Node head){
		if (head == null) {
			return null;
		}
		
		HashSet<Integer> set = new HashSet<>();
		//放入头结点
		set.add(head.value);
		Node cur = head.next;
		Node pre = head;
		while(cur != null){
			//如果删除了当前节点，pre不动
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			}else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;	
		}
		
		return head;
	}
	
	/**
	 * 每个节点和之后所有节点对比，相同则删掉
	 * @param args
	 * 2016年9月27日
	 */
	public static Node removeRep2(Node head){
		if (head == null) {
			return null;
		}
		
		Node cur = head;
		Node pre = null;
		while(cur != null){
			pre = cur;
			Node next = cur.next;
			while(next != null){
				if (next.value == cur.value) {
					pre.next = next.next;
				}else {
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
		
		return head;
	}
		
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(2);
		Node node5 = new Node(4);
		Node node6 = new Node(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		Node node = removeRep2(node1);
		while(node!=null){
			System.out.print(node.value + " ");
			node = node.next;
		}
	}
	
}
