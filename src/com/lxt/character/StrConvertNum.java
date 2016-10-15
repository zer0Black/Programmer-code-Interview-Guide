package com.lxt.character;

/**
 * 将整数字符串转成整数值
 * @author zer0
 *
 */
public class StrConvertNum {
	
	//由于边界判断的原因，最小值的绝对值比最大值 大1
	//所以以负数的方式计算字符串。最后根据 是否为负的标识符来取得正负正确的字符串
	public static int strConvertInt(String str){
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		char[] chars = str.toCharArray();
		boolean isNeg = false;
		
		int num = 0;
		
		if (chars[0] == '-') {
			isNeg = true;
		}else if (chars[0] <= '0' || chars[0] > '9') {
			return 0;
		}else {
			num = '0' - chars[0];
		}
		
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		
		for(int i = 1; i < str.length(); i++){
			int cur = '0' - chars[i];
			if (cur < -9 || cur > 0) {
				return 0;
			}
			
			if (num < minq || (num == minq && cur < minr)) {
				return 0;
			}
			
			num = num * 10 + cur;
		}
		
		if (!isNeg && num == Integer.MIN_VALUE) {
			return 0;
		}
		
		return isNeg ? num : -num;
	}
	
	public static void main(String[] args) {
		String str1 = "-29378";
		String str2 = "03924";
		String str3 = "32ABZ";
		String str4 = "93-289";
		String str5 = "9287472";
		String str6 = "-2147483648";
		
		System.out.println(strConvertInt(str1));
		System.out.println(strConvertInt(str2));
		System.out.println(strConvertInt(str3));
		System.out.println(strConvertInt(str4));
		System.out.println(strConvertInt(str5));
		System.out.println(strConvertInt(str6));
		
	}
	
}
