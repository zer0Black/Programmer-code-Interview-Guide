package com.lxt.tree;

/**
 * 字典树的实现
 * @author zer0
 *
 */
public class TrieTree {
	
	class TrieNode{
		public int path;
		public int end;
		public TrieNode[] map;
		
		public TrieNode() {
			path = 0;
			end = 0;
			map = new TrieNode[26];
		}
	}
	
	private TrieNode root;
	
	public TrieTree() {
		root = new TrieNode();
	}
	
	public void insert(String word){
		if (word == null) {
			return;
		}
		
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for(int i = 0; i < chs.length; i++){
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				node.map[index] = new TrieNode();
			}
			node = node.map[index];
			node.path++;
		}
		node.end++;
	}
	
	public boolean search(String word){
		if (word == null) {
			return false;
		}
		
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for( int i = 0; i < chs.length; i++){
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		
		return node.end != 0;
	}
	
	public void delete(String word){
		if (search(word)) {
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0; i < chs.length; i++){
				index = chs[i] - 'a';
				if (node.map[index].path-- == 1) {
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}
	
}
