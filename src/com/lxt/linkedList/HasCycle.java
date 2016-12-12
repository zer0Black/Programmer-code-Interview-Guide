package com.lxt.linkedList;

/**
 * 给定一个链表，判断它是否有环。
 * @author zer0
 *
 */
public class HasCycle {

	public static boolean hasCycle(Node head) {  
        //快慢指针
        if(head == null){
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){          
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return true;
            }
            
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(1);
		node1.next = node2;
		
		System.out.println(hasCycle(node1));
	}
	
}
