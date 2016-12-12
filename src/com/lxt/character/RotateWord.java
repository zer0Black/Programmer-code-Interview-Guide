package com.lxt.character;

/**
 * 翻转字符串
 * 题目：给定一个字符类型的数组chas，请在单词间做逆序调整。只要做到单词顺序逆序即可。
 * 补充题目：给定一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体移动到右半区，
 *         右半区整体一到左半区
 * @author lixuetao
 *
 */
public class RotateWord {

	public static void rotateWord(char[] chars){
		if(chars==null || chars.length==0){
			return;
		}
		
		int start = 0;
		for(int i = 0; i < chars.length; i++){
			if (chars[i] == ' ') {
				reverse(chars, start, i-1);
				start=i+1;
			}
		}

		if (start < chars.length) {
			reverse(chars, start, chars.length-1);
		}
		
		reverse(chars, 0, chars.length-1);
		System.out.println(String.valueOf(chars));
	}
	
	public static void rotateLeftToRight(char[] chars, int size){
		if(chars==null || chars.length==0 || size >= chars.length || size < 0){
			return;
		}
		
		reverse(chars, 0, size-1);
		reverse(chars, size, chars.length-1);
		reverse(chars, 0, chars.length-1);
		
		System.out.println(String.valueOf(chars));
	}
	
	private static void reverse(char[] chars, int start, int end){
		char tmp = 0;
		while(start < end){
			tmp = chars[end];
			chars[end] = chars[start];
			chars[start] = tmp;
			end--;
			start++;
		}
	}
	
	public static void main(String[] args) {
//		char[] chars = {'I','\'','m',' ','a',' ','s','t','u','d','e','n','t','.'};
		char[] chars = {'W', 'o', 'r', 'l', 'd'};
		rotateWord(chars);
		
		char[] chars2 = {'A','B','C','D','E','F','G'};
		int size = 6;
		rotateLeftToRight(chars2, size);
	}
	
}
