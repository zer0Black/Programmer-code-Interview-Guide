package com.lxt.character;

/**
 * 判断两个字符串是否互为旋转词
 * 题目：如果一个字符串str，把字符串str前面任意部分挪到后面形成的字符串叫做str的旋转词。
 *       给定连个字符串a和b，判断a和b是否互为旋转词
 * @author zer0
 *
 */
public class IsRotation {

	public static boolean isRotation(String a, String b){
		if (a == null || b == null || a.length() != b.length()) {
			return false;
		}
		
		String a2 = a + a;
		return a2.contains(b);
	}
	
	public static void main(String[] args) {
		String a = "abcdefg";
		String b = "efgabcd";
		System.out.println(isRotation(a, b));
	}
	
}
