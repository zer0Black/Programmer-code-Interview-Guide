package com.lxt.character;

/**
 * 字符串的统计字符串
 * 题目：给定一个字符串str，返回str的统计字符串。
 * 例如："aaabbadddffc"的统计字符串为"a_3_b_2_a_1_d_3_f_2_c_1"
 * 
 * 补充题目：给定一个字符串的统计字符串cstr，在给定一个整数index，返回cstr
 *         所代表的原始字符串上的第index个字符
 * @author lixuetao
 *
 */
public class CountString {
	
	public static String getCountString(String str){
		if(str == null || str.length() == 0){
			return str;
		}
		
		char[] chars = str.toCharArray();
		String res = String.valueOf(chars[0]);
		int num = 1; //统计相同字符出现的次数
		
		for(int i = 1; i < chars.length; i++){
			if (chars[i] == chars[i-1]) {
				num++;
			}else {
				res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
				num = 1;
			}
		}
		
		return concat(res, String.valueOf(num), "");
	}
	
	private static String concat(String s1, String s2, String s3){
		return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
	}
	
	//补充题目
	public static char getCharAt(String cstr, int index){
		if(cstr == null || cstr.length() == 0){
			return 0;
		}
		
		int sum = 0; //记录当前遍历中得到字符串数量
		int num = 0; //记录单个字符的数量
		char cur = 0;
		boolean stage = true; //true为在字符阶段，false为在统计阶段
		char[] chars = cstr.toCharArray();
		
		for(int i = 0; i < cstr.length(); i++){
			if (chars[i] == '_') {
				stage = !stage;
			}
			if (stage) {
				sum += num;
				if (sum > index) {
					return cur;
				}
				num = 0;
				cur = chars[i];
			}else{
				num = num * 10 + chars[i] - '0';
			}
		}
		
		return (sum + num) > index ? cur : 0;
	}
	
	public static void main(String[] args) {
		String str = "aaabbadddffc";
		System.out.println(getCountString(str));
	}
	
}
