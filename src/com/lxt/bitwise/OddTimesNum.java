/**
 * 
 */
package com.lxt.bitwise;

/**
 * 在其他数都出现偶数次的数组中找到出现奇数次的数
 * 题目：给定一个整型数组arr，其中只有一个数出现了奇数次，其他数
 *       都出现偶数次，打印这个数
 * 进阶：有两个数出现了奇数次，其他数出现了偶数次，打印这两个数
 * @author zer0
 *
 */
public class OddTimesNum {
	
	/**
	 * 异或运算，相同的数最后为0，把所有数都进行异或运算，
	 * 最后留下的就是出现奇数次的数
	 * @param arr
	 * @return
	 * 2016年10月23日
	 */
	public static int printOddTimesNum1(int[] arr){
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		int res = 0;
		for(int i = 0; i < arr.length; i++){
			res ^= arr[i];
		}
		
		return res;
	}
	
	/**
	 * 有两个出现奇数次的数
	 * @param args
	 * 2016年10月23日
	 */
	public static void printOddTimesNum2(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		//找出两个奇数次数的异或结果
		int res = 0;
		for(int i = 0; i < arr.length; i++){
			res ^= arr[i];
		}
		
		int count = getRightNum(res);
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i < arr.length; i++){
			if (isBit1(arr[i], count)) {
				num1 ^= arr[i];
			}else {
				num2 ^= arr[i];
			}
		}
		
		System.out.println(num1);
		System.out.println(num2);
	}
	
	//找出数的二进制表示的1出现的最右位置
	private static int getRightNum(int num){
		int count = 1;
		if ((num & 1) == 1) {
			return count;
		}else {
			count++;
		}
		return count;
	}
	
	private static boolean isBit1(int num, int count){
		num = num >> count;
		return (num & 1) == 1;
	}
	
	/**
	 * 有两个出现奇数次的数
	 * @param args
	 * 2016年10月23日
	 */
	public static void printOddTimesNum3(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
	
		int e0 = 0;
		int eOhasOne = 0;
	
		for(int curNum:arr){
			e0 ^= curNum;
		}
		
		int rightOne = e0 & (~e0 + 1);
		
		for(int cur:arr){
			if ((cur & rightOne) != 0) {
				eOhasOne ^= cur;
			}
		}
		
		System.out.println(eOhasOne + " " + (e0 ^ eOhasOne));
	}
	
	public static void main(String[] args) {
		int[] arr = {-1,4,-1,5,8,3,4,5,8,3,8,3};
		System.out.println(printOddTimesNum1(arr));
		printOddTimesNum2(arr);
		printOddTimesNum3(arr);
	}
	
}
