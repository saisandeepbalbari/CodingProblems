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
	
//	public removeVertex();
	
//	public removeEdge();
	
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
		Vertex<T> currentVertex;
		while(!Q.isEmpty()) {
			currentVertex = Q.delete();
			BFS.insert(currentVertex.name);
			for(int j=0; j<currentVertex.children.size(); j++) {
				if(BFS.elementExists(currentVertex.children.get(j).name) == false) {
					Q.insert(currentVertex.children.get(j));
					System.out.println(currentVertex.children.get(j).name + " is not present in BFS Queue");
				}
			}
			System.out.println(currentVertex.name);
		}
	}
	
	public void printNodes(DirectedGraph<T> G) {
		int totalVertices = 0;
		System.out.println("Vertices:");
		for(int i=0; i<G.vertices.size(); i++) {
			System.out.println("\t"+G.vertices.get(i).name);
			totalVertices++;
		}
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
//		G.printNodes(G);
//		G.printEdges(G);
		G.BreadthFirstSearch(G, "a");
//		G.BreadthFirstSearch(G, "d");
//		G.BreadthFirstSearch(G, "c");
	}
}
