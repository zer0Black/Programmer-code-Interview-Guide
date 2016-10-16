package com.lxt.character;

/**
 * 字符串中数字子串的求和
 * 题目：给定一个字符串str，求其中全部数字串所代表的数字之和
 * @author zer0
 *
 */
public class NumSum {
	
	public static int numSum(String str){
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		int res = 0;
		int num = 0;
		int cur = 0; //当前字符的数字
		boolean isNeg = false;
		
		char[] chrs = str.toCharArray();
		for (int i = 0; i < chrs.length; i++) {
			cur = chrs[i] - '0';
			if (cur >= 0 && cur <= 9) {
				num = num * 10 + (isNeg ? -cur  : cur);
			}else {
				res += num;
				num = 0;
				if (chrs[i] == '-') {
					if (i-1>=0 && chrs[i-1] == '-') {
						isNeg = !isNeg;
					}else {
						isNeg = true;
					}
				}else {
					isNeg = false;
				}
			}
		}
		
		res += num;
		return res;
	}
	
	public static void main(String[] args) {
		String str = "a-2-4ah-12s-j-A257fje---2-3";
		System.out.println(numSum(str));
	}
	
}
