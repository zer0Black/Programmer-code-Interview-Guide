package com.lxt.linkedList;

/**
 * 环形单链表约瑟夫问题
 * @author zer0
 *
 */
public class JosephusKill {

	public static Node josephusKill1(Node head, int m){
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		
		//获取到最后一个节点
		Node last = head;
		while(last.next != head){
			last = last.next;
		}
		
		//报数为1的时候，谁报数谁死，所以最后一个活下来
		if (m == 1) {
			return last;
		}
	
		int index = 0; //记录报数
		Node cur = head;
		while(cur.next != cur){
			index++; //报数
			//报数到要杀死的前一个人，就把第m个人杀死
			if (index == m-1) {
				cur.next = cur.next.next;
				index = 0;
			}
			cur = cur.next;
		}
		return cur;
	}
	
	public static Node josephusKill2(Node head, int m){
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		
		int tmp = 1;
		Node cur = head.next;
		while(cur != head){
			tmp++;
			cur = cur.next;
		}
		
		int fn = 0;
		for(int i = 2; i <= tmp; i++){
			fn = (fn + m) % i;
		}
		
		cur = head;
		tmp = 1; //复用变量，用来记录是否走到了最后留下的节点
		while(tmp < fn+1){ //fn从0计数，所以换算到链表中需要+1
			tmp++;
			cur = cur.next;
		}
		
		return cur;
		
	}
	
	public static void main(String[] args) {
		int m = 4;
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;
		
//		System.out.println(josephusKill1(node1, m).value);
		System.out.println(josephusKill2(node1, m).value);
	}
	
}
