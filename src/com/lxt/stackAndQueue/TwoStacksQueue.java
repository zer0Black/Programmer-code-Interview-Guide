/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

/**
 * ��Ŀ����дһ���࣬������ջʵ�ֶ��У�֧�ֶ��еĻ���������add/poll/peek��
 * @author zer0
 *
 */
public class TwoStacksQueue {

	Stack<Integer> inerStack = new Stack<>();
	Stack<Integer> outStack = new Stack<>();
	
	public void add(Integer value){
		inerStack.add(value);
	}
	
	public int poll(){
		if (outStack.isEmpty()) {
			while(!inerStack.isEmpty()){
				outStack.add(inerStack.pop());
			}
		}
		
		if (outStack.isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		
		return outStack.pop();
	}
	
	public int peek(){
		if (outStack.isEmpty()) {
			while(!inerStack.isEmpty()){
				outStack.add(inerStack.pop());
			}
		}
		
		if (outStack.isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		
		return outStack.peek();
	}
	
	public boolean isEmpty(){
		if (inerStack.isEmpty() && outStack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
		for(int i = 1; i <= 10; i++){
			twoStacksQueue.add(i);
		}
		
		while(!twoStacksQueue.isEmpty()){
			System.out.println(twoStacksQueue.poll());
		}
		
		
	}
}
