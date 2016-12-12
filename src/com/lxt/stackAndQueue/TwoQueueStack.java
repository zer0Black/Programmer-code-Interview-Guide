package com.lxt.stackAndQueue;

import java.util.LinkedList;

/**
 * 两个队列实现一个栈
 * @author zer0
 *
 */
public class TwoQueueStack {

	LinkedList<Integer> linkedList = new LinkedList<>();
	LinkedList<Integer> helpList = new LinkedList<>();
	
	public void push(int i){
		linkedList.add(i);
	}
	
	public int pop(){
		while(linkedList.size() > 1){
			helpList.add(linkedList.poll());
		}
		
		int res = linkedList.poll();
		
		while(!helpList.isEmpty()){
			linkedList.add(helpList.poll());
		}
		
		return res;
	}
	
	public int peek(){
		while(linkedList.size() > 1){
			helpList.add(linkedList.poll());
		}
		
		int res = linkedList.peek();
		
		while(!helpList.isEmpty()){
			linkedList.add(helpList.poll());
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TwoQueueStack twoQueueStack = new TwoQueueStack();
		twoQueueStack.push(1);
		twoQueueStack.push(2);
		twoQueueStack.push(3);
		
		System.out.println(twoQueueStack.pop());
		System.out.println(twoQueueStack.pop());
		System.out.println(twoQueueStack.pop());
		
		twoQueueStack.push(5);
		System.out.println(twoQueueStack.peek());
	}
}
