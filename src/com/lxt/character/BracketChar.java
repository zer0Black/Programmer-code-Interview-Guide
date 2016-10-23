package com.lxt.character;

import java.util.Stack;

/**
 * 括号字符串的有效性和最长有效长度
 * 题目：给定一个字符串str，判断是不是整体有效的括号字符串
 * 补充题目：给定一个括号字符串str，返回最长的有效括号子串
 * @author zer0
 *
 */
public class BracketChar {

	public static boolean isValid1(String str){
		if (str == null || str.length() == 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++){
			if(chars[i] != '(' && chars[i] != ')'){
				return false;
			}else if (chars[i] == '(') {
				stack.push(chars[i]);
			}else if (chars[i] == ')' && stack.isEmpty()) {
				return false;
			}else if (chars[i] == ')'){
				stack.pop();
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValid2(String str){
		if (str == null || str.length() == 0) {
			return false;
		}
		
		int count = 0;
		char[] chars = str.toCharArray();
		for(int i = 0; i < chars.length; i++){
			if(chars[i] != '(' && chars[i] != ')'){
				return false;
			}else if (chars[i] == ')' && --count < 0) {
				return false;
			}else if (chars[i] == '(') {
				count++;
			}
		}
		
		return count == 0;
	}
	
	public static void main(String[] args) {
		String str1 = "()";
		String str2 = "()()(())";
		String str3 = "(()())";
		String str4 = ")()()(";
		String str5 = "()((())))(";
		System.out.println(isValid2(str1));
		System.out.println(isValid2(str2));
		System.out.println(isValid2(str3));
		System.out.println(isValid2(str4));
		System.out.println(isValid2(str5));
	}
	
}
