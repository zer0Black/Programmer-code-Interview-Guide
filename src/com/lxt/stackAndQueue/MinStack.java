/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

/**
 * ��Ŀ��ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ���ջ����СԪ�صĲ���
 * Ҫ��pop/push/getMin ������ʱ�临�Ӷȶ���O(1)
 * @author zer0
 *
 */
public class MinStack {
	
	private Stack<Integer> datas = new Stack<>();
	private Stack<Integer> mins = new Stack<>(); //������Сֵ��ջ
	
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
			throw new RuntimeException("ջΪ��");
		}
		mins.pop();
		return datas.pop();
	}
	
	public Integer peek(){
		if (datas.isEmpty()) {
			throw new RuntimeException("ջΪ��");
		}
		return datas.peek();
	}
	
	public Integer getMin(){
		if (mins.isEmpty()) {
			throw new RuntimeException("ջΪ��");
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
