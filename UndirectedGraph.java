/**
 * 
 */
package graphs;

import java.util.ArrayList;
/**
 * @author Sai Sandeep Balbari
 *
 */
public class UndirectedGraph<T> {

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
	
	UndirectedGraph() {
		this.vertices = new ArrayList<Vertex<T>>();
	}
	
	public UndirectedGraph<T> addVertex(UndirectedGraph<T> G, T name) {
		
		Vertex<T> temp = new Vertex<T>(name);
		
		G.vertices.add(temp);
		return G;
	}
	
	public UndirectedGraph<T> addEdge(UndirectedGraph<T> G, T first, T second) {
		
		int firstIndex=0, secondIndex=0, i;
		for(i=0; i<G.vertices.size(); i++) {
			if(G.vertices.get(i).name == first)
				firstIndex = i;
			if(G.vertices.get(i).name == second)
				secondIndex = i;
		}
		
		G.vertices.get(firstIndex).children.add(G.vertices.get(secondIndex));
		G.vertices.get(secondIndex).children.add(G.vertices.get(firstIndex));
		
		return G;
	}
	
	public void printNodes(UndirectedGraph<T> G) {
		int totalVertices = 0;
		System.out.println("Vertices:");
		for(int i=0; i<G.vertices.size(); i++) {
			System.out.println("\t"+G.vertices.get(i).name);
			totalVertices++;
		}
		System.out.println("Total Vertices in the Graph:" + totalVertices);
	}
	
	public void printEdges(UndirectedGraph<T> G) {
		int totalEdges = 0;
		System.out.println("Undirected Edges:");
		for(int i=0; i<G.vertices.size(); i++) {
			for(int j=0; j<G.vertices.get(i).children.size(); j++) {
				System.out.println("\t"+G.vertices.get(i).name + "<--->" + G.vertices.get(i).children.get(j).name);
			}
			totalEdges = totalEdges + G.vertices.get(i).children.size();
		}
		System.out.print("Total Edges in the Graph: "+ totalEdges);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UndirectedGraph<String> G = new UndirectedGraph<String>();

		G = G.addVertex(G, "Sai");
		G = G.addVertex(G, "Sandeep");
		G = G.addVertex(G, "Balbari");
		G = G.addEdge(G, "Sai", "Sandeep");
		G = G.addEdge(G, "Sandeep", "Balbari");
		G.printNodes(G);
		G.printEdges(G);
	}
}
