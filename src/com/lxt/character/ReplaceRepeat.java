package com.lxt.character;

/**
 * 替换字符串中连续出现的指定字符串
 * 题目：给定三个字符串str， from和to。已知from字符串中无重复字符，
 *      把str中所有from的子串全部替换成to字符串，对连续出现from的
 *      部分要求只替换一个to字符串，返回最终的结果字符串
 * @author lixuetao
 *
 */
public class ReplaceRepeat {
	
	/**
	 * 把str中所有和from相同的字符串都替换为空字符，
	 * 再根据空字符替换成to
	 * @param str
	 * @param from
	 * @param to
	 * @return
	 */
	public static String replace(String str, String from, String to){
		if(str == null || from == null || to == null || str.length() == 0 || from.length() == 0){
			return str;
		}
		
		char[] chars = str.toCharArray();
		char[] charf = from.toCharArray();
		
		int index = 0; //from的指针
		for(int i = 0; i < chars.length; i++){
			if (chars[i] == charf[index++]) {
				if (index == charf.length) {
					int end = i;
					int len = charf.length;
					while(len-- != 0){
						chars[end--] = 0;
					}
					index = 0; //将str中和from相同部分替换为空字符以后，需要重置index指针
				}
			}else {
				if (chars[i] == charf[0]) {
					i--;
				}
				index = 0;
			}
		}
		
		String res = "";
		String cur = "";
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0) {
				cur = cur + String.valueOf(chars[i]);
			}
			if(chars[i] == 0 && (i == 0 || chars[i-1] != 0)){
				res = res + cur + to;
				cur = "";
			}
		}
		
		if(!cur.equals("")){
			res += cur;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String str = "12abcabca4babc";
		String from = "abc";
		String to = "x";
		System.out.println(replace(str, from, to));
	}
	
}
