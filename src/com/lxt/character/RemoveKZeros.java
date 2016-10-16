package com.lxt.character;

/**
 * 去掉字符串中连续出现K个0的子串
 * 题目：给定一个字符串str和一个整数k，如果str中正好有连续的K个
 *       '0'字符出现时，把k个连续的'0'字符去除，返回处理后的字
 *       符串
 * @author zer0
 *
 */
public class RemoveKZeros {

	public static String  removeKZeros(String str, int k){
		if (str == null || str.length() == 0 || k <= 0) {
			return str;
		}
		
		char[] chars = str.toCharArray();
		int tmp = 0; //记录连续的0的个数
		int index = -1; //记录要删除的子串的开始位置
		
		for(int i = 0; i < chars.length; i++){
			if (chars[i] == '0') {
				index = index == -1 ? i : index;
				tmp++;
			}else {
				if (tmp == k) {
					while(tmp-- != 0){
						chars[index] = 0;	
						index++;
					}
				}
				tmp = 0;
				index = -1;
			}
		}
		
		if (tmp == k) {
			while(tmp-- != 0){
				chars[index] = 0;
				index++;
			}
		}
		
		return String.valueOf(chars);		
	}

	public static void main(String[] args) {
		String str = "A000BCW00000C000D000";
		int k = 3;
		System.out.println(removeKZeros(str, k));
	}
	
}
