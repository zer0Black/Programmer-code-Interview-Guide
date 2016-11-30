package com.lxt.arrayMatrix;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {

	public static List<List<Integer>> permuteUnique(int[] nums) {
        // 全排列就是从第一个数字起每个数分别与它后面的数字交换
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permuteCore(nums, res, 0);
        return res;
    } 
    
    private static void permuteCore(int[] nums, List<List<Integer>> res, int index){
        if(index == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        
        for(int i = index; i < nums.length; i++){
        	System.out.print(i+ " ");
            if(isContainer(nums, index, i)){
                continue;
            }
            swap(nums, index, i);
            permuteCore(nums, res, index+1);
            swap(nums, index, i);
        }
    }
    
    private static boolean isContainer(int[] nums, int index, int i){
        for(int j = index; j < i; j++){
            if(nums[i] == nums[j]){
                return true;
            }
        }
        return false;
    }
    
    private static void swap(int[] nums, int n1, int n2){
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
	
    public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = permuteUnique(nums);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
