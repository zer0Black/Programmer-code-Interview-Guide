package com.lxt.character;

/**
 * 字符串的调整与替换
 * 题目：给定一个字符串类型的数组，chars[]，chars右半区全是空字符，左半区不含空字符。
 *       现在想将左半区所有空格字符替换成"%20"，假设chars有半区足够大，可以满足替换
 *       所需要的空间，请完成替换函数
 * @author zer0
 *
 */
public class CharReplaceSpace {
	
	public static void replace(char[] chars){
		if (chars == null || chars.length==0) {
			return;
		}
		
		int num = 0; //空格个数
		int len = 0;
		
		for(int i = 0; i < chars.length && chars[i] != 0; i++){
			if (chars[i] == ' ') {
				num++;
			}
			len++;
		}
		len--;
		int index = len + num*2; //最后一个要替换的位置
		while(index>=0 && len>=0){
			if (chars[len] != ' ') {
				chars[index--] = chars[len];
			}else{
				chars[index--] = '0';
				chars[index--] = '2';
				chars[index--] = '%';
			}
			len--;
		}
		
		System.out.println(String.valueOf(chars));
	}
	
	public static void main(String[] args) {
		char[] chars = {'1',' ','3',' ',' ','a','2',' ',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		replace(chars);
	}
	
}
