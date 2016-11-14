package com.lxt.sort;

/**
 * @author zer0
 *
 */
public class HeapSort {

	public static void heapSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return;
		}
		
		//构建堆
		buildMaxHeap(arr);
		//末尾与头部交换，交换后调整最大堆
		for(int i = arr.length - 1; i > 0; i--){
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			maxHeapify(arr, 0, i);
		}
	}
	
	private static void buildMaxHeap(int[] arr){
		for(int i = (arr.length - 2) / 2; i >= 0; i--){
			maxHeapify(arr, i, arr.length-1);
		}
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
		
		while(child < heapSize){
			if (child + 1 < heapSize && arr[child] < arr[child + 1]) {
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
		int arr[] = {44,5,98,2,32,1,95,35,22,62};
		heapSort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
