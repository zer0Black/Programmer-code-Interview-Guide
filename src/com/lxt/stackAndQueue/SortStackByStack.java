/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 题目：一个栈元素的类型为整型，现在想将该栈从顶到底按从大到小的
 * 		顺序排序，只允许申请一个栈，除此之外，可以申请新的变量，
 * 		但不能申请额外数据结构。如何完成排序
 * @author zer0
 *
 */
public class SortStackByStack {

	public static void sortStackByStack1(Stack<Integer> stack){
		Stack<Integer> helps = new Stack<>();
		int min = Integer.MIN_VALUE;
		int len = stack.size()-1;
		System.out.println("栈长度为"+(len+1));
		for(int i = 0; i <= len ; i++){
			//将栈元素全导入辅助栈，并获取最小值
			for(int j = len - i; j >=0 && !stack.isEmpty(); j--){
				int value = stack.pop();
				if (min == Integer.MIN_VALUE) {
					min  = value;
				}else {
					min = Math.min(min, value);
				}
				helps.push(value);
			}
			
			//将最小值push回栈中
			stack.push(min);
			//将辅助栈中的元素push回原栈中，遇到最小值，则跳过
			while(!helps.isEmpty()){
				int value = helps.pop();
				if (min != value) {
					stack.push(value);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(3);
		
		System.out.println("排序前："+stack);
		SortStackByStack.sortStackByStack1(stack);
		System.out.println("排序后："+stack);
	}
	
}
