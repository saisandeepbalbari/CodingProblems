/**
 * 
 */
package graphs;

import java.util.ArrayList;

import Queues.Queue;
/**
 * @author Sai Sandeep Balbari
 *
 */
public class DirectedGraph<T> {

	/**
	 * @param args
	 */
	private static class Vertex<T> {
		private T name;
		private ArrayList<Vertex<T>> children;
		
		Vertex (T name) {
			this.name = name;
			this.children = new ArrayList<Vertex<T>>();
		}
	}
	
	public ArrayList<Vertex<T>> vertices;
	
	DirectedGraph() {
		this.vertices = new ArrayList<Vertex<T>>();
	}
	
	public DirectedGraph<T> addVertex(DirectedGraph<T> G, T name) {
		
		Vertex<T> temp = new Vertex<T>(name);
		
		G.vertices.add(temp);
		return G;
	}
	
	public DirectedGraph<T> addEdge(DirectedGraph<T> G, T first, T second) {
		
		int firstIndex=0, secondIndex=0, i;
		for(i=0; i<G.vertices.size(); i++) {
			if(G.vertices.get(i).name == first)
				firstIndex = i;
			if(G.vertices.get(i).name == second)
				secondIndex = i;
		}
		
		G.vertices.get(firstIndex).children.add(G.vertices.get(secondIndex));
		
		return G;
	}
	
	public void getAdjacent(DirectedGraph<T> G, T vertex) {
		
		int firstIndex=0, i;
		for(i=0; i<G.vertices.size(); i++) {
			if(G.vertices.get(i).name == vertex)
				firstIndex = i;
		}
		System.out.println("Printing the adjacent vertices of " + G.vertices.get(firstIndex).name);
		for(int j=0; j<G.vertices.get(firstIndex).children.size(); j++) {
			System.out.print("\t" + G.vertices.get(firstIndex).children.get(j).name);
		}
		System.out.println();
	}
	
//	public removeVertex(){}
	
//	public removeEdge(){}
	
	public void DFS(DirectedGraph<T> G, Vertex<T> vertex, ArrayList<T> visited) {
		System.out.print("\t"+vertex.name);
		visited.add(vertex.name);
		for(int i=0; i<vertex.children.size(); i++) {
			if(!visited.contains(vertex.children.get(i).name))
				DFS(G, vertex.children.get(i), visited);
		}
	}
	
	public void DepthFirstSearch(DirectedGraph<T> G, T start) {
		
		System.out.println("Depth First Traversal starting from " + start + " :");
		int startIndex = 0, i;
		for(i=0; i<G.vertices.size(); i++) {
			if(G.vertices.get(i).name == start) {
				startIndex = i;
				break;
			}
		}
		ArrayList<T> visited = new ArrayList();
		G.DFS(G, G.vertices.get(startIndex), visited);
	}
	
	public void BreadthFirstSearch(DirectedGraph<T> G, T start) {
		
		System.out.println("Breadth First Traversal starting from " + start + " :");
		int startIndex = 0, i;
		for(i=0; i<G.vertices.size(); i++) {
			if(G.vertices.get(i).name == start)
				startIndex = i;
		}
		Queue<Vertex<T>> Q = new Queue<Vertex<T>>();
		Queue<T> BFS = new Queue<T>();
		Q.insert(G.vertices.get(startIndex));
		BFS.insert(G.vertices.get(startIndex).name);
		Vertex<T> currentVertex;
		while(!Q.isEmpty()) {
			currentVertex = Q.delete();
			for(int j=0; j<currentVertex.children.size(); j++) {
				if(BFS.elementExists(currentVertex.children.get(j).name) == false) {
					Q.insert(currentVertex.children.get(j));
					BFS.insert(currentVertex.children.get(j).name);
				}
			}
			System.out.print("\t" + currentVertex.name);
		}
		while(!Q.isEmpty()) {
			Q.delete();
		}
		while(!BFS.isEmpty()) {
			BFS.delete();
		}
		System.out.println();
	}
	
	public void printNodes(DirectedGraph<T> G) {
		int totalVertices = 0;
		System.out.println("Vertices:");
		for(int i=0; i<G.vertices.size(); i++) {
			System.out.print("\t"+G.vertices.get(i).name);
			totalVertices++;
		}
		System.out.println();
		System.out.println("Total Vertices in the Graph:" + totalVertices);
	}
	
	public void printEdges(DirectedGraph<T> G) {
		int totalEdges = 0;
		System.out.println("Directed Edges:");
		for(int i=0; i<G.vertices.size(); i++) {
			for(int j=0; j<G.vertices.get(i).children.size(); j++) {
				System.out.println("\t"+G.vertices.get(i).name + "--->" + G.vertices.get(i).children.get(j).name);
			}
			totalEdges = totalEdges + G.vertices.get(i).children.size();
		}
		System.out.println("Total Edges in the Graph: "+ totalEdges);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DirectedGraph<String> G = new DirectedGraph<String>();

		G = G.addVertex(G, "a");
		G = G.addVertex(G, "b");
		G = G.addVertex(G, "c");
		G = G.addVertex(G, "d");
		G = G.addVertex(G, "e");
		G = G.addVertex(G, "f");
		G = G.addEdge(G, "a", "b");
		G = G.addEdge(G, "a", "c");
		G = G.addEdge(G, "c", "b");
		G = G.addEdge(G, "b", "d");
		G = G.addEdge(G, "c", "d");
		G = G.addEdge(G, "c", "e");
		G = G.addEdge(G, "d", "e");
		G = G.addEdge(G, "e", "f");
		G.printNodes(G);
		G.printEdges(G);
		G.BreadthFirstSearch(G, "a");
		G.BreadthFirstSearch(G, "d");
		G.BreadthFirstSearch(G, "c");
		G.BreadthFirstSearch(G, "b");
		G.getAdjacent(G, "c");
		G.DepthFirstSearch(G, "a");
	}
}
