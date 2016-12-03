package com.lxt.sort;

public class MedianHeap {

	public static int[] median(int[] arr, int k){
		if(arr == null || arr.length == 0 || k <= 0 || k > arr.length){
			return null ;
		}
		
		int[] kHeap = new int[k];
		for(int i = 0; i < k; i++){
			kHeap[i] = arr[i];
		}
		for (int i = k/2; i >= 0; i--) {
//			minHeapify(kHeap, i, k-1); //前k个大的数
			maxHeapify(kHeap, i, k-1); //前k个小的数
		}
		
		
		for(int i = k; i < arr.length; i++){
//			if(arr[i] > kHeap[0]){
			if(arr[i] < kHeap[0]){
				kHeap[0] = arr[i];
//				minHeapify(kHeap, 0, k-1);
				maxHeapify(kHeap, 0, k-1);
			}
		}
		
		return kHeap;
	}
	
	private static void minHeapify(int[] arr, int index, int heapSize){
		int child = index * 2 + 1;
		int minTemp = arr[index];
		while(child <= heapSize){
			if(child + 1 <= heapSize && arr[child] > arr[child+1]){
				child++;
			}
			
			if(arr[child] >= minTemp){
				break;
			}
			
			arr[index] = arr[child];
			index = child;
			child = index * 2 + 1;
		}
		arr[index] = minTemp;
	}
	
	/**
	 * 堆调整
	 * @param arr
	 * @param index 要调整的节点
	 * @param heapSize 堆大小
	 * 2016年11月11日
	 */
	private static void maxHeapify(int[] arr, int index, int heapSize){
		int maxTemp = arr[index];
		int child = index * 2 + 1;
		
		while(child <= heapSize){
			if (child + 1 <= heapSize && arr[child] < arr[child + 1]) {
				child++;
			}
			
			if (maxTemp >= arr[child]) {
				break;
			}
			
			arr[index] = arr[child];
			index = child;
			child = child * 2 + 1;
		}
		
		arr[index] = maxTemp; 
	}
	
	   public static void main(String[] args) {
			int nums[] = {7,9,4,5,3,6,7};
//			int nums[] = {2,1,3,4,2,3,1,5,0};
			int[] res= median(nums, 4);
			for(int i = 0; i<res.length; i++){
				System.out.print(res[i] + " ");
			}
		}
}
