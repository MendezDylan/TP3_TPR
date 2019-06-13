package Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Dijkstra implements GraphBehavior<Vertex<Object>> {
	private List<Vertex<Object>> vertices; // List of  vertices
	private List<Edge> edges; // List of edges
	private Set<Vertex<Object>> controlledVertex; // Corresponds to vertices already counted in a path
	private Set<Vertex<Object>> uncontrolledVertex; // correspond to vertices not counted along the path
	private Map<Vertex<Object>, Vertex<Object>> predecessors; // Neighbours vertices of a path
	private Map<Vertex<Object>, Double> distances; // Save distance


	public Dijkstra(Graph Grafo) {
		this.vertices = new ArrayList<Vertex<Object>>(Grafo.getVertices());
		this.edges = new ArrayList<Edge>(Grafo.getEdges());
	}

	// GETTERS AND SETTERS

    public List<Vertex<Object>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex<Object>> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Set<Vertex<Object>> getControlledVertex() {
        return controlledVertex;
    }

    public void setControlledVertex(Set<Vertex<Object>> controlledVertex) {
        this.controlledVertex = controlledVertex;
    }

    public Set<Vertex<Object>> getUncontrolledVertex() {
        return uncontrolledVertex;
    }

    public void setUncontrolledVertex(Set<Vertex<Object>> uncontrolledVertex) {
        this.uncontrolledVertex = uncontrolledVertex;
    }

    public Map<Vertex<Object>, Vertex<Object>> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(Map<Vertex<Object>, Vertex<Object>> predecessors) {
        this.predecessors = predecessors;
    }

    public Map<Vertex<Object>, Double> getDistances() {
        return distances;
    }

    public void setDistances(Map<Vertex<Object>, Double> distances) {
        this.distances = distances;
    }

    
	

	/**
	 * 
         *   It allows to find out if a vertex is already counted within the trace
	 * 
	 */
	private boolean isControlled(Vertex<Object> vertex) {
		return controlledVertex.contains(vertex);
	}

	/**
	 * 
         * Get the distance of the destinations within the journey 
	 * 
	 */
	private double getShortestDistance(Vertex<Object> arrivalP) {
		Double dist = distances.get(arrivalP);
		if (dist == null)
			return Double.MAX_VALUE;
		return dist;
	}

	/**

* Allows you to obtain the shortest distance from one vertex to another	 */

	private Vertex<Object> getMinimum(Set<Vertex<Object>> vertices) {
		Vertex<Object> minimum = null;
		for (Vertex<Object> vertex : vertices) {
			if (minimum == null)
				minimum = vertex;
			else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum))
					minimum = vertex;
			}
		}
		return minimum;
	}

	/**
* It allows to obtain the neighbors of a trace from one point to another of the graph
	 */
	private List<Vertex<Object>> getNeighbours(Vertex<Object> pVertex) {
		List<Vertex<Object>> neighbours = new ArrayList<Vertex<Object>>();
		for (Edge edge : edges) {
			if (edge.getStartingPoint().equals(pVertex) && !isControlled(edge.getArrivalPoint()))
				neighbours.add(edge.getArrivalPoint());
		}
		return neighbours;
	}

	/**
	 * 
         *   get the distance between 2 vertices from different locations
	 * 
	 */
	private double getDistance(Vertex<Object> start, Vertex<Object> arrival) {
		for (Edge edge : edges) {
			if (edge.getStartingPoint().equals(start) && edge.getArrivalPoint().equals(arrival))
				return edge.getDistance();
		}
		throw new RuntimeException("The vertices are not joined");
	}

	/**
         *   It allows to generate the shortest distance between 2 vertices. This distance is
         *   given by means of the information set of the method
	 */
	private void getMinimumDistance(Vertex<Object> pVertex) {
		List<Vertex<Object>> neighbourVertices = getNeighbours(pVertex);
		for (Vertex<Object> arrivalVertex : neighbourVertices) {
			if (getShortestDistance(arrivalVertex) > getShortestDistance(pVertex) + getDistance(pVertex, arrivalVertex)) {
				distances.put(arrivalVertex,getShortestDistance(pVertex) + getDistance(pVertex, arrivalVertex));
				predecessors.put(arrivalVertex, pVertex);
				uncontrolledVertex.add(arrivalVertex);
			}
		}
	}

	/**
* This method allows generating a general mapping from a centroid node.
* This centroid will be the starting node and all other nodes will be those of
 arrival. The different distances can be automatically obtained
 to each of the nodes.
	 */
	public void runGraph(Vertex<Object> pVertex) {
		controlledVertex = new HashSet<Vertex<Object>>();
		uncontrolledVertex = new HashSet<Vertex<Object>>();
		distances = new HashMap<Vertex<Object>, Double>();
		predecessors = new HashMap<Vertex<Object>, Vertex<Object>>();
		distances.put(pVertex, 0.0);
		uncontrolledVertex.add(pVertex);
		while (uncontrolledVertex.size() > 0) {
			Vertex<Object> vertex = getMinimum(uncontrolledVertex);
			controlledVertex.add(vertex);
			uncontrolledVertex.remove(vertex);
			getMinimumDistance(vertex);
		}
	}

	/**

* Allows generating a list of nodes through which the destination will be reached
* through a shorter distance.
	 * 
	 * 
	 */
	public LinkedList<Vertex<Object>> getPathList(Vertex<Object> arrivalP) {
		LinkedList<Vertex<Object>> dijkstraPath = new LinkedList<Vertex<Object>>();
		Vertex<Object> trace = arrivalP;
		if (predecessors.get(trace) == null){
                    return null;
                }
		dijkstraPath.add(trace);
		while (predecessors.get(trace) != null) {
			trace = predecessors.get(trace);
			dijkstraPath.add(trace);
		}                
                Collections.reverse(dijkstraPath);
		return dijkstraPath;
	}
}
