/**
 * 
 */
package com.lxt.linkedList;

/**
 * 打印两个有序链表的公共部分
 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * @author zer0
 *
 */
public class PrintCommonPart {

	/**
	 * 只要值相同就算公共部分
	 * @param head1
	 * @param head2
	 * 2016年9月22日
	 */
	public static void printCommonPart(Node head1, Node head2){
		while(head1 != null && head2 != null){
			if (head1.value > head2.value) {
				head2 = head2.next;
			}else if (head1.value < head2.value) {
				head1 = head1.next;
			}else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	
}
