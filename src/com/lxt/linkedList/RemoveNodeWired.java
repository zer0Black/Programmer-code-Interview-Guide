package com.lxt.linkedList;

/**
 * 一种怪异的节点删除方式
 * 题目：链表节点值类型为int型，给定一个链表中的节点node，
 *       但不给定整个链表的头节点。如何在链表中删除node?
 *       请实现这个函数，并分析这么会出现哪些问题
 * 要求：时间复杂度O(1)
 * @author zer0
 *
 */
public class RemoveNodeWired {

	/**
	 * 由于没有头节点，是获取不到要删除节点的前一节点的。
	 * 所以要直接删除deleteNode是不可能的。
	 * 
	 * 可以考虑删除deleteNode的后一个节点，然后把后一个
	 * 节点的值赋予deleteNode节点。也算是删除了deleteNode了
	 * 
	 * 但是无法解决最后一个节点的问题。不能直接把最后一个节
	 * 点赋值为null
	 * @param deleteNode
	 * 2016年9月28日
	 */
	public static void RemoveNodeWired(Node deleteNode){
		if (deleteNode == null) {
			return;
		}
		
		Node next = deleteNode.next;
		if (next == null) {
			throw new RuntimeException("不能删除最后一个节点");
//			deleteNode = null;  错误的方式，null在系统中是一个特定区域，必须由pre节点指向才行
		}else {
			deleteNode.next = next.next;
			deleteNode.value = next.value;
		}
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
		
		RemoveNodeWired(node3);
		while(node1!=null){
			System.out.print(node1.value + " ");
			node1 = node1.next;
		}
	}
}
