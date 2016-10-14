package com.lxt.character;

import java.util.HashMap;

/**
 * 判断两个字符串是否互为变形词
 * 题目：给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样
 *      且每种字符出现的次数也一样，那么str1和str2互为变形词。请实现函
 *      数判断两个字符串是否互为变形词
 * @author lixuetao
 *
 */
public class IsDeformation {

	public static boolean isDeformation(String str1, String str2){
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i< chars1.length; i++){
			if (map.containsKey(chars1[i])) {
				map.put(chars1[i], map.get(chars1[i])+1);
			}else {
				map.put(chars1[i], 1);
			}
		}
		
		for (int i = 0; i < chars2.length; i++) {
			
			if (!map.containsKey(chars2[i])) {
				return false;
			}else{
				int tmp = map.get(chars2[i]);
				if (tmp-1 < 0) {
					return false;
				}
				map.put(chars2[i], tmp-1);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "abcsb";
		String str2 = "sbabc";
		System.out.println(isDeformation(str1, str2));
	}
	
}
