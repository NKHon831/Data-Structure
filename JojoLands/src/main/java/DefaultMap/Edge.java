/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DefaultMap;

/**
 *
 * @author Asus
 */
public class Edge<T extends Comparable<T>, N extends Comparable <N>> {
    Vertex<T,N> toVertex;
    N weight;
    Edge<T,N> nextEdge;
	
    public Edge()	{
        this(null,null,null);
    }
	
    public Edge(Vertex<T,N> destination, N w, Edge<T,N> a){
        toVertex = destination;
	weight = w;
        nextEdge = a;
    }
        
}
