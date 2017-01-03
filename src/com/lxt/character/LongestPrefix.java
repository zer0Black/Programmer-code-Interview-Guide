package com.lxt.character;

public class LongestPrefix {

	class TrieNode{
        TrieNode[] child;
        int count; //记录该字符出现的次数
        int end; //记录结尾的字符串个数
        
        public TrieNode(){
            count = 0;
            child = new TrieNode[58];
            end = 0;
        }
    }
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        
        int strNum = strs.length;
        TrieNode root = new LongestPrefix().new TrieNode();
        
        for(int i = 0; i < strNum; i++){
        	TrieNode mark = root;
            char[] chars = strs[i].toCharArray();
            if(chars.length==0){
                return "";
            }
            for(int k = 0; k < chars.length; k++){
                int index = chars[k] - 'A';
                if(mark.child[index] == null){
                    mark.child[index] = new LongestPrefix().new TrieNode();
                }
                mark = mark.child[index];
            }
            mark.end++;
        }
        
        TrieNode mark = root;
        String res = "";
        
        while(mark != null){
            int count = 0;
            int pos = 0;
            //遍历字节点，看看是否只有一个有数
            for(int i = 0; i < mark.child.length; i++){
                if(mark.child[i] != null){
                    count++;
                    pos = i;
                }
            }
            if(count == 1){
                res = res + (char)(pos + 'A');
                mark = mark.child[pos];
            }else{
                break;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		String[] strs = {"ABCD", "AB", "ABC", "ABCE"};
		System.out.println(longestCommonPrefix(strs));
	}
	
}
