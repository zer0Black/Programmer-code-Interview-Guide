/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：pop/push/getMin 操作的时间复杂度都是O(1)
 * @author zer0
 *
 */
public class MinStack {
	
	private Stack<Integer> datas = new Stack<>();
	private Stack<Integer> mins = new Stack<>(); //保存最小值的栈
	
	public void push(Integer value){
		datas.push(value);
		if (mins.isEmpty()) {
			mins.push(value);
		}else if(getMin() >= value){
			mins.push(value);
		}else {
			mins.push(getMin());
		}
	}
	
	public Integer pop(){
		if (datas.isEmpty() || mins.isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		mins.pop();
		return datas.pop();
	}
	
	public Integer peek(){
		if (datas.isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return datas.peek();
	}
	
	public Integer getMin(){
		if (mins.isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		return mins.peek();
	}
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(3);
		minStack.push(2);
		minStack.push(5);
		minStack.push(2);
		minStack.push(7);
		
		System.out.println(minStack.pop());
		System.out.println(minStack.getMin());
	}

}
