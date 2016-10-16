package com.lxt.character;

/**
 * 在有序但含有空的数组中查找字符串
 * 题目：给定一个字符串数组strs，在strs中有些位置为null，但在不为null的位置上，
 *      其字符串是按照字典顺序有小到大一次出现的，再给定一个字符串str，请返回str
 *      在strs中出现的最左的位置
 * @author lixuetao
 *
 */
public class InOrderSearchStr {
	
	public static int getIndex1(String[] strs, String str){
		if (strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		
		int start = -1;
		int end = strs.length;
		int res = -1;
		int i = 0;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if (strs[mid] != null && strs[mid].equals(str)) {
				res = mid;
				end = mid;
			}else if(strs[mid] != null){
				if (strs[mid].compareTo(str) < 0) {
					start = mid;
				}else{
					end = mid;
				}
			}else{
				i = mid;
				while(strs[i] == null && --i >= start+1);
				if (i < start+1 || strs[i].compareTo(str) < 0) {
					start = mid;
				}else{
					res = strs[i].equals(str) ? i : res;
					end = i - 1;
				}
			}
		}
		return res;
	}
	
	public static int getIndex2(String[] strs, String str){
		if (strs == null || strs.length == 0 || str == null) {
			return -1;
		}
		
		int start = -1;
		int end = strs.length;
		int i = 0;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(strs[mid] != null){
				if (strs[mid].compareTo(str) < 0) {
					start = mid;
				}else{
					end = mid;
				}
			}else{
				i = mid;
				while(strs[i] == null && --i >= start+1);
				if (i < start+1 || strs[i].compareTo(str) < 0) {
					start = mid;
				}else{
					end = i;
				}
			}
		}
		
		if (start+1 >= strs.length || !strs[start+1].equals(str)) {
			return -1;
		}
		
		return start+1;
	}
	
	public static void main(String[] args) {
		String[] strs = {null, "a", null, "a", null, null, null, "c","c",null,"c","d"};
		String str = "b";
		System.out.println(getIndex1(strs, str));
		System.out.println(getIndex2(strs, str));
	}
	
}
