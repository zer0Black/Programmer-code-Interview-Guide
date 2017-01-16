package com.lxt.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 467. Unique Substrings in Wraparound String
 * 
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", 
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * Now we have another string p. Your job is to find out how many unique non-empty substrings 
 * of p are present in s. In particular, your input is the string p and you need to output 
 * the number of different non-empty substrings of p in the string s.
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 */
public class FindSubstringInWraproundString {

	//暴力法，找出所有p的子串，依次查找是否在s中
	public static int findSubStrInWrapStr1(String p){
		int res = 0;
		Set<String> strSet = new HashSet<>();
		for(int i = 0; i < p.length(); i++){
			for(int j = i+1; j <= p.length(); j++){
				strSet.add(p.substring(i, j));
			}
		}
		
		for (String str : strSet) {
			char[] subP = str.toCharArray();
			if (subP.length == 1) {
				res++;
			}else{
				int maxLength = 1;
				for(int i = 0; i < subP.length-1; i++){
					if(subP[i] + 1 == subP[i+1] || subP[i] - 25 == subP[i+1]){
						maxLength ++;
					}else{
						break;
					}
				}
				if(maxLength == subP.length){
					res++;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * dp法
	 * s的特点是 abcdefg... 26个字母循环
	 * 当一个字符串满足条件，则他的子串都满足条件。
	 * 假设一个满足条件的字符串的长度为5，则所有满足条件的字符串个数为 5 + 4 + 3 + 2 + 1；
	 * 
	 * 用一个26大小的数组作为状态，状态表示：从当前字母开始，满足条件的最长字符串长度。
	 * @param p
	 * @return
	 */
	public static int findSubStrInWrapStr2(String p){
		char[] pArr = p.toCharArray();
		int[] counts = new int[26]; //dp数组，保存每个数字起始的最长的字符串，他的子串都是符合要求的最长子串。
		int maxLength = 0;
		for(int i = 0; i < pArr.length; i++){
			if(i > 0 && (pArr[i-1] + 1 == pArr[i] || pArr[i-1] - 25 == pArr[i])){
				maxLength++;
			}else{
				maxLength = 1;
			}
			counts[pArr[i] - 'a'] = Math.max(counts[pArr[i] - 'a'], maxLength);
		}
		int res = 0;
		for(int i = 0; i < counts.length; i++){
			res += counts[i];
		}
		return res;	
	}
	
	public static void main(String[] args) {
		String p = "zab";
		System.out.println(findSubStrInWrapStr2(p));
	}
	
}
