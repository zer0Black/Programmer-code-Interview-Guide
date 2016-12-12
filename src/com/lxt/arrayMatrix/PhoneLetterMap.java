package com.lxt.arrayMatrix;

/**
 * 电话号码对应英文单词
 * 题目：电话的号码盘一般可以用于输入字母。如用2可以输入A/B/C，用3可以输入D/E/F等。
 *       对于号码5869872，可以依次输出其代表的所有字母组合。如：JTMWTPA，JTMWTPB
 *       1、您是否可以根据这样的对应关系设计一个程序，尽可能快从这些字母组合中找到
 *          一个有意义的单词来表述一个电话号码呢？如：可以用单词"computer"来描述号
 *          码26678837
 *       2、对于一个电话号码，是否可以用一个单词来代表？怎样才是最快的方法呢？
 * @author zer0
 *
 */
public class PhoneLetterMap {
	
	static char[][] c = {
			{},
			{},
			{'A', 'B', 'C'},
			{'D', 'E', 'F'},
			{'G', 'H', 'I'},
			{'J', 'K', 'L'},
			{'M', 'N', 'O'},
			{'P', 'Q', 'R', 'S'},
			{'T', 'U', 'V'},
			{'W', 'X', 'Y', 'Z'},
	};
	
	static int total[] = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
	
	public static void letterToNumber(int[] telNum){
		if (telNum == null || telNum.length == 0) {
			return;
		}
		
		int telLength = telNum.length;
		int[] answer = new int[telLength];
				
		while(true){
			for(int i = 0; i < telLength; i++)
				System.out.print(c[telNum[i]][answer[i]]);
			System.out.println();
			
			int k = telLength-1;
			while(k >= 0){
				if (answer[k] < total[telNum[k]] - 1) {
					answer[k]++;
					break;
				}else {
					answer[k] = 0;
					k--;
				}
			}
			
			if (k < 0) {
			 break;	
			}
		}
	}
	
	public static void main(String[] args) {
		int[] telNum = {2,6,};
		letterToNumber(telNum);
	}
}
