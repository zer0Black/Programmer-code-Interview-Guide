package com.lxt.bitwise;

/**
 * 在其他数中都出现k次的数组中找到只出现一次的数
 * @author zer0
 *
 */
public class OnceNumToK {
	
	// http://www.cnblogs.com/mickole/articles/3576365.html
	
	/**
	 * 把每个数字用做二进制表示。int的话只需要32位即可，所以我们新建大小为32的数组，
	 * 把每个数字的对应位加到数组的相应位置上。如果我们把只出现1次的数字（假设为a）去除，
	 * 那么最后数组里面的每一位都应该是3的倍数。所以最后数组里任一个位模3之后就是a二进制
	 * 表示中相应位的值。
	 * @param arr
	 * @param k
	 * @return
	 * 2016年10月23日
	 */
	public static int onceNum(int[] arr, int k){
		if (arr == null || arr.length == 0 || k <= 0) {
			return -1;
		}
		
		int[] nums = new int[32];
		for(int i=0; i<arr.length; i++){
			for(int j=0;j<32;j++){
				nums[j]+=(arr[i]>>j)&1;
			}
		}
		
		int ans=0;
		for(int i=0;i<32;i++){
			ans+=((nums[i]%3)<<i);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,3,2,1,4,5,5,4,3,2,1,8};
		System.out.println(onceNum(arr, 3));
	}
	
}
