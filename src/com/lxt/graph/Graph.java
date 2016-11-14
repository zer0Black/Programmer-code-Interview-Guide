package com.lxt.graph;

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
	
	public void insertEdge(int v1, int v2, int weight){
		edges[v1][v2] = weight;
		numOfEdges++;
	}
	
	public Object getVertexValue(int i){
		return vertexList.get(i);
	}
	
	public int getEdge(int v1, int v2){
		return edges[v1][v2];
	}
	
	public void deleteEdge(int v1, int v2){
		edges[v1][v2] = 0;
		numOfEdges--;
	}
	
	public int getFirstNeighbor(int index){
		for(int i = 0; i < vertexList.size(); i++){
			if (edges[index][i] > 0) {
				return i;
			}
		}
		return -1;
	}
	
	public int getNextNeighbor(int v1, int v2){
		for(int i = v2+1; i < vertexList.size(); i++){
			if (edges[v1][i] > 0) {
				return i;
			}
		}
		return -1;
	}
	
}
