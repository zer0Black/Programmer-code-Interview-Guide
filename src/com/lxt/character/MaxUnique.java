package com.lxt.character;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到字符串的最长无重复字符子串
 * @author zer0
 *
 */
public class MaxUnique {

	public static int maxUnique(String s){
		 if(s == null || s.length() == 0){
	            return 0;
	        }
	        
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        int pre = -1;
	        int len = 0;
	        char[] chars = s.toCharArray();
	        
	        for(int i = 0; i < chars.length; i++){
	            if(map.containsKey(chars[i])){
	            	int index = map.get(chars[i]);
	            	pre = Math.max(index, pre);
	            }
	            len = Math.max(len, i - pre);
	            map.put(chars[i], i);
	        }
	        
	        return len;
	}
	
	public static void main(String[] args) {
		String string = "an++--vivaj";
//		String string = "aab";
//		String string = "gehmbfqmozbpripibusbezagafqtypz";
//		String string = "dqirnnnchguccmkluloyzunslxhgxjyazitnxgreplhrzreuessdofxacgicpgcpqyengvrvjamitscxk";
		System.out.println(maxUnique(string));
	}
	
}
