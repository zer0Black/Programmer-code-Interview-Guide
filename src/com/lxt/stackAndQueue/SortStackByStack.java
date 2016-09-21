/**
 * 
 */
package com.lxt.stackAndQueue;

import java.util.Stack;

/**
 * ��һ��ջʵ����һ��ջ������
 * ��Ŀ��һ��ջԪ�ص�����Ϊ���ͣ������뽫��ջ�Ӷ����װ��Ӵ�С��
 * 		˳������ֻ��������һ��ջ������֮�⣬���������µı�����
 * 		����������������ݽṹ������������
 * @author zer0
 *
 */
public class SortStackByStack {

	public static void sortStackByStack1(Stack<Integer> stack){
		Stack<Integer> helps = new Stack<>();
		int min = Integer.MIN_VALUE;
		int len = stack.size()-1;
		System.out.println("ջ����Ϊ"+(len+1));
		for(int i = 0; i <= len ; i++){
			//��ջԪ��ȫ���븨��ջ������ȡ��Сֵ
			for(int j = len - i; j >=0 && !stack.isEmpty(); j--){
				int value = stack.pop();
				if (min == Integer.MIN_VALUE) {
					min  = value;
				}else {
					min = Math.min(min, value);
				}
				helps.push(value);
			}
			
			//����Сֵpush��ջ��
			stack.push(min);
			//������ջ�е�Ԫ��push��ԭջ�У�������Сֵ��������
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
		
		System.out.println("����ǰ��"+stack);
		SortStackByStack.sortStackByStack1(stack);
		System.out.println("�����"+stack);
	}
	
}
