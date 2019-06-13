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
	private List<Vertex<Object>> vertices; // Listado de vertices
	private List<Edge> edges; // Listado de edges
	private Set<Vertex<Object>> controlledVertex; // Corresponde a vértices ya contados en un trayecto
	private Set<Vertex<Object>> uncontrolledVertex; // Corresponde a los vértices no contados en el trayecto
	private Map<Vertex<Object>, Vertex<Object>> predecessors; // Vértices neighbours del trayecto
	private Map<Vertex<Object>, Double> distances; // Guarda la distancia de un vertex hacia todos los demás


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
	 * Permite averiguar si un vertex se encuentra ya contado dentro del trace
	 * 
	 * @param vertex
	 *            nodo que se desea comparar
	 * @return True si se encuentra dentro de los nodos controlados
	 */
	private boolean isControlled(Vertex<Object> vertex) {
		return controlledVertex.contains(vertex);
	}

	/**
	 * Obtiene la distancia de los destinos dentro del trayecto
	 * 
	 * @param arrivalP
	 *            Nodo hacia el cual se desea ir
	 * @return La distancia entre v�rtices de la edge
	 */
	private double getShortestDistance(Vertex<Object> arrivalP) {
		Double dist = distances.get(arrivalP);
		if (dist == null)
			return Double.MAX_VALUE;
		return dist;
	}

	/**
	 * Permite obtener la distancia más corta de un vertex a otro
	 * 
	 * @param vertices
	 *            este set permite generar un listado de los diferentes nodos
	 *            mapeados para configurar la salida más corta
	 * @return Los v�rtices por los cuales es más corto el camino
	 */
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
	 * Permite obtener los neighbours de un trace desde un punto a otro del grafo
	 * 
	 * @param pVertex
	 *            Que funcionará como centroide para obtener sus neighbours
	 * @return Listado de vértices que conforman un camino en común
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
	 * Obtiene la distancia entre 2 vertices de ubicaciones distintas
	 * 
	 * @param start
	 *            Vértice del cuál se parte
	 * @param arrival
	 *            Vértice de destino
	 * @return La distancia para ser guardada dentro de las distances como una
         longitud
	 */
	private double getDistance(Vertex<Object> start, Vertex<Object> arrival) {
		for (Edge edge : edges) {
			if (edge.getStartingPoint().equals(start) && edge.getArrivalPoint().equals(arrival))
				return edge.getDistance();
		}
		throw new RuntimeException("The vertices are not joined");
	}

	/**
	 * Permite generar la distancia más corta entre 2 vertices. Esta distancia está
	 * dada por medio del conjunto de información de los métodos anteriores
	 * 
	 * @param pVertex
	 *            Vértice del cual se desea obtener una distancia mínima
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
	 * Este método permite generar un mapeo general a partir de un nodo centroide.
	 * Este centroide será el nodo de partida y todos los demás nodos serán los de
 llegada. De manera automática se podran obtener las diferentes distances
 hacia cada uno de los nodos.
 
 Este métodos se debe ejecutar antes que getPathList().
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
	 * Permite generar un listado de nodos mediante los cuales se llegará al destino
	 * mediante una distancia más corta.
	 * 
	 * Este método debe ejecutarse desupués de runGraph();
	 * 
	 * @param arrivalP
	 *            Corresponde al vértice destino al cuál se desea llegar a partir de
	 *            uno conocido
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
