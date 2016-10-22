package com.lxt.character;

/**
 * 找到被指的新类型字符
 * 题目：新类型字符定义如下：
 *      1、新类型字符是长度为1或者2的字符串
 *      2、表现形式可以仅是小写字符，例如："e";也可以是大写字母+小写字母，例如："Ab";
 *         还可以是大写字母加大写字母，例如："DC"
 *      现在给定一个字符串str，str一定是若干新类型字符正确组合的结果。再给定一个整数k，
 *      代表str的位置，请返回被k位置指中的新类型字符。
 * @author lixuetao
 *
 */
public class PointNewChar {

	public static String pointNewChar(String str, int k){
		if(str == null || str.length()==0 || k < 0 || k>= str.length()){
			return "";
		}
		
		char[] chars = str.toCharArray();
		int uNum = 0;
		for(int i = k-1; i >= 0; i--){
			if(chars[i] < 'A' || chars[i] > 'Z'){
				break;
			}
			uNum++;
		}
		
		if((uNum & 1) == 1){
			return str.substring(k-1, k+1);
		}
		
		if ((uNum & 1) == 0 && (chars[k] >= 'A' && chars[k] <= 'Z')) {
			return str.substring(k, k+2);
		}
		
		return str.substring(k, k+1);
	}
	
	public static void main(String[] args) {
		String str = "aaABCDEcBCg";
		int k = 10;
		
		System.out.println(pointNewChar(str, k));
	}
	
}
