package com.lxt.graph;

import java.util.LinkedList;

/**
 * LeetCode 207
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CanFinish {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 0 
           || prerequisites == null){
            return false;
        }
        
        int zeroInDegree[] = new int[numCourses];
 
        for(int i = 0;i < prerequisites.length; i++) {  
            zeroInDegree[prerequisites[i][1]] ++;  
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
         for(int i = 0; i < numCourses; i++) {  
            if(zeroInDegree[i] == 0){
                queue.add(i);   
            }   
        }
        
        int count = queue.size(); //统计入度为0的节点
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int i = 0; i < prerequisites.length; i++) {  
                if(vertex == prerequisites[i][0]) {
                    int delEdge = prerequisites[i][1];
                    zeroInDegree[delEdge]--;
                    if(zeroInDegree[delEdge] == 0) {  
                        queue.add(delEdge);
                        count++;
                    }  
                } 
            }
        }
        
        return count == numCourses;
        
    }
	
	public static void main(String[] args) {
		int nums = 2;
		int[][] a = {{1,0}};
		
		System.out.println(canFinish(nums, a));
	}
	
}
