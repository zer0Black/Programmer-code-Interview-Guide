/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 题目：一个栈依次压人1/2/3/4/5，那么从栈顶到栈底分别为5/4/3/2/1。
 *      将这个栈转置后，从栈顶到栈底为1/2/3/4/5，也就是实现栈中的元素逆序，
 *      但只能用递归函数来实现，不能用其他数据结构。
 * @author zer0
 *
 */
public class ReverseStack {
	
	/**
	 * 获取栈底元素并移除
	 * @param stack
	 * @return 栈底值
	 * 2016年9月21日
	 */
	private static int getLastAndRemove(Stack<Integer> stack){
		int res = stack.pop();
		if (stack.isEmpty()) {
			return res;
		}
		int last = getLastAndRemove(stack);
		stack.push(res);
		return last;
	}
	
	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()) {
			return;
		}
		int i = getLastAndRemove(stack);
		reverse(stack);
		stack.push(i);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
	
		System.out.print("逆序前：");
		System.out.print(stack+" ");
		
		ReverseStack.reverse(stack);
		
		System.out.println();
		System.out.print("逆序后：");
		System.out.print(stack+" ");
	}
}
