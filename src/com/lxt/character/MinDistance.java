package com.lxt.character;

/**
 * 数组中两个字符串的最小距离
 * 题目：给定一个字符串数组strs，再给定两个字符串str1和str2，返回strs中str1和str2
 *       的最小距离，如果str1或者str2为null，或不存在strs中，返回-1
 * @author zer0
 *
 */
public class MinDistance {
	
	/**
	 * 用两个变量last1,last2记录str1和str2在strs中的位置
	 */
	public static int minDistance(String[] strs, String str1, String str2){
		if (strs == null || strs.length == 0 || str1 == null || str2 == null) {
			return -1;
		}
		
		if (str1.equals(str2)) {
			return 0;
		}
		
		int last1 = -1;
		int last2 = -2;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++){
			if (strs[i].equals(str1)) {
				min = Math.min(min, last2 != -1 ? i - last2 : min);
				last1 = i;
			}
			if (strs[i].equals(str2)) {
				min = Math.min(min, last1 != -1 ? i - last1 : min);
				last2 = i;
			}
		}
		
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	public static void main(String[] args) {
		String strs[] = {"ab", "dc", "ef", "ad", "dc", "dc","dc","ef"};
		String str1 = "ab";
		String str2 = "ef";
		System.out.println(minDistance(strs, str1, str2));
	}
	
}
