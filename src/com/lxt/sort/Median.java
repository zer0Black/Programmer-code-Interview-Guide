/**
 * 
 */
package com.lxt.sort;

/**
 * 给定一个未排序的整数数组，找到其中位数。
 * 中位数是排序后数组的中间值，如果数组的个数是偶数个，
 * 则返回排序后数组的第N/2个数。
 * @author zer0
 *
 */
public class Median {

	public static int median(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return nums[medianCore(nums, 0, nums.length-1, 1 - 1)];
    }
    
    private static int medianCore(int[] nums, int left, int right, int nth){
        int index= partition(nums, left, right);
        if(index == nth){
            return index;
        }else if(index > nth){
            return medianCore(nums, left, index-1, nth);
        }else{
            return medianCore(nums, index+1, right, nth);
        }
    }
    
    private static int partition(int[] nums, int left, int right){
        int low = left;
        int high = right;
        int pivot = nums[low];
        
        while(low < high){
            while(low < high && nums[high] <= pivot){
                high--;
            }
            nums[low] = nums[high];
            
            while(low < high && nums[low] >= pivot){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
    
    public static void main(String[] args) {
		int nums[] = {7,9,4,5};
//		int nums[] = {-1,-2,-3,-100,-1,-50};
		System.out.println(median(nums));
	}
	
}
