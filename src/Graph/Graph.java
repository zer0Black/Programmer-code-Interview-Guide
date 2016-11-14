package Graph;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList vertexList; //存储点
	private int[][] edges; //领接矩阵，存储边
	private int numOfEdges; //边的数目
	
	public Graph(int n){
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
	}
	
	public int getNumOfVertex(){
		return vertexList.size();
	}
	
	public int getNumOfEdges(){
		return numOfEdges;
	}
	
	@SuppressWarnings("unchecked")
	public void insertVertex(Object vertex){
		vertexList.add(vertexList.size(), vertex);
	}
	

	
}
