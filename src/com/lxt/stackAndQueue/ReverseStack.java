/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * ��ν��õݹ麯����ջ��������һ��ջ
 * ��Ŀ��һ��ջ����ѹ��1/2/3/4/5����ô��ջ����ջ�׷ֱ�Ϊ5/4/3/2/1��
 *      �����ջת�ú󣬴�ջ����ջ��Ϊ1/2/3/4/5��Ҳ����ʵ��ջ�е�Ԫ������
 *      ��ֻ���õݹ麯����ʵ�֣��������������ݽṹ��
 * @author zer0
 *
 */
public class ReverseStack {
	
	/**
	 * ��ȡջ��Ԫ�ز��Ƴ�
	 * @param stack
	 * @return ջ��ֵ
	 * 2016��9��21��
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
	
		System.out.print("����ǰ��");
		System.out.print(stack+" ");
		
		ReverseStack.reverse(stack);
		
		System.out.println();
		System.out.print("�����");
		System.out.print(stack+" ");
	}
}
