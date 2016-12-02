package com.lxt.graph;

import java.util.LinkedList;

import sun.net.www.content.audio.wav;

/**
 * @author zer0
 *
 */
public class BroadFirstSearch {
	
	public static void bfs(Graph g){
		if (g == null) {
			return;
		}
		
		boolean[] isVisited=new boolean[g.getNumOfVertex()];
		for(int i = 0; i < g.getNumOfVertex(); i++){
			if (!isVisited[i]) {
				bfs(g, isVisited, i);
			}
		}
	}

	private static void bfs(Graph g, boolean[] isVisited, int i){
		System.out.println(g.getVertexValue(i) + " ");
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(i);
		
		isVisited[i] = true;
		
		while(!queue.isEmpty()){
			int cur = queue.removeFirst();
			int next = g.getFirstNeighbor(cur);
			while(next != -1){
				if (!isVisited[next]) {
					System.out.println(g.getVertexValue(next));
					isVisited[next] = true;
					queue.addLast(next);
				}
				next=g.getNextNeighbor(cur, next);
			}
		}
	}
	
}
