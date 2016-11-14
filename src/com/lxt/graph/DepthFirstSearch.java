package com.lxt.graph;

/**
 * @author zer0
 *
 */
public class DepthFirstSearch {

	public static void dfs(Graph g){
		if (g == null) {
			return;
		}
		
		boolean[] isVisited=new boolean[g.getNumOfVertex()];
		for(int i = 0; i < g.getNumOfVertex(); i++){
			if (!isVisited[i]) {
				dfs(g, isVisited, i);
			}
		}
	}
	
	private static void dfs(Graph g, boolean[] isVisited, int i){
		System.out.print(g.getVertexValue(i) + " ");
		
		isVisited[i] = true;
		
		int first = g.getFirstNeighbor(i);
		while(first != -1){
			if (!isVisited[first]) {
				dfs(g, isVisited, first);
			}
			first = g.getNextNeighbor(i, first);
		}
		
		
	}
	
	 public static void main(String args[]) {
	        int n=8,e=9;//分别代表结点个数和边的数目
	        String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
	        Graph graph=new Graph(n);
	        for(String label:labels) {
	            graph.insertVertex(label);//插入结点
	        }
	        //插入九条边
	        graph.insertEdge(0, 1, 1);
	        graph.insertEdge(0, 2, 1);
	        graph.insertEdge(1, 3, 1);
	        graph.insertEdge(1, 4, 1);
	        graph.insertEdge(3, 7, 1);
	        graph.insertEdge(4, 7, 1);
	        graph.insertEdge(2, 5, 1);
	        graph.insertEdge(2, 6, 1);
	        graph.insertEdge(5, 6, 1);
	        graph.insertEdge(1, 0, 1);
	        graph.insertEdge(2, 0, 1);
	        graph.insertEdge(3, 1, 1);
	        graph.insertEdge(4, 1, 1);
	        graph.insertEdge(7, 3, 1);
	        graph.insertEdge(7, 4, 1);
	        graph.insertEdge(6, 2, 1);
	        graph.insertEdge(5, 2, 1);
	        graph.insertEdge(6, 5, 1);
	        
	        System.out.println("深度优先搜索序列为：");
	        dfs(graph);
	        System.out.println();
	    }
	
}
