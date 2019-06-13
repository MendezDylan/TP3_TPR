package Structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * clase para controlar el grafo
 */
public class GraphControl {
    private List<Vertex<Object>> vertices;
    private List<Edge> edges;
    private LinkedList<Vertex<Object>> trace;

    /**
     * Al generar el contructor se inicializan y se crean objetos de las 3 listas
     * necesarias.
     */
    public GraphControl() {
            this.vertices = new ArrayList<Vertex<Object>>();
            this.edges = new ArrayList<Edge>();
            this.trace = new LinkedList<Vertex<Object>>();
    }

    /**
     * método para obtener el trace del grafo
     * 
     * @return trace con camino
     */
    public LinkedList<Vertex<Object>> getTrace() {
            return trace;
    }

    /**
     * método para ingresar nuevo trace
     * 
     * @param trazo trace por ingresar
     */
    public void setTrace(LinkedList<Vertex<Object>> trace) {
            this.trace = trace;
    }

    /**
     * método para obtener vertices
     * 
     * @return vertices del grafo
     */
    public List<Vertex<Object>> getVertices() {
            return vertices;
    }

    /**
     * método para configurar vertices
     * 
     * @param vertices vertices nuevas para el grafo
     */
    public void setVertices(List<Vertex<Object>> vertices) {
            this.vertices = vertices;
    }

    /**
     * método para obtener edges
     * 
     * @return edges
     */
    public List<Edge> getEdges() {
            return edges;
    }

    /**
     * MÉtodo para ingresar edges al grafo
     * 
     * @param aristas nuevas edges
     */
    public void setEdges(List<Edge> edges) {
            this.edges = edges;
    }

    /**
     * Permite generar relaciones entre los v�rtices (que deben ser existentes) y
 las edges
     * 
     * @param id_arista           ID que se le dará a las edges
     * @param id_lista_vertices_A ID del vértice del cuál se parte
     * @param id_lista_vertices_B ID del vértice de llegada
     * @param distanciaTrayecto   La distancia que hay entre el Vértice de partida
     *                            y el v�rtice de llegada
     */
    public void newEdge(String edge_id, int vertex_list_A, int vertex_list_B,
                    int routeDistance) {
            Edge edge = new Edge(edge_id, vertices.get(vertex_list_A),
                    vertices.get(vertex_list_B), routeDistance);

            edges.add(edge);
    }

    public void newMapEdge(String edge_id, int vertex_list_A, int vertex_list_B,
                    int routeDistance, int routeEstimatedTime) {
            Edge edge1 = new Edge(edge_id, vertices.get(vertex_list_A),
                    vertices.get(vertex_list_B), routeDistance, routeEstimatedTime);
            Edge edge2 = new Edge(edge_id, vertices.get(vertex_list_B), 
                    vertices.get(vertex_list_A),routeDistance, routeEstimatedTime);

            edges.add(edge1);
            edges.add(edge2);
    }
    
    public void openMapEdges(String edge_id, int vertex_list_A, int vertex_list_B,
                    int routeDistance, int routeEstimatedTime) {
            Edge edge = new Edge(edge_id, vertices.get(vertex_list_A),
                    vertices.get(vertex_list_B), routeDistance, routeEstimatedTime);
            
            edges.add(edge);
    }

    /**
     * Permite generar nuevos vértices para ser utilizados dentro del grafo
     * 
     * @param vertexID  ID del vértice que se desea cear
     * @param externalNode Objeto externo que se desea insertar dentro del vértice
     */
    public void newVertex(String vertexID, Object externalNode) {
            Vertex<Object> vertex = new Vertex<Object>(vertexID, externalNode);
            vertices.add(vertex);
    }

    /**
     * método para obtener el id según el string de un vértice
     * 
     * @param vertexID id del vértice buscado
     * @return vértice con el valor buscado
     */
    public Vertex getVertexWithID(String vertexID) {
            Vertex newVertex = null;
            for (Vertex nestedVertex : vertices) {
                    if (nestedVertex.getId().equals(vertexID)) {
                            newVertex = nestedVertex;
                            return newVertex;
                    }
            }
            return null;
    }

    public Edge getEdgeWithID(String edgeID){
        Edge newEdge = null;
            for (Edge nestedEdge : edges) {
                    if (nestedEdge.getEdge_id().equals(edgeID)) {
                            newEdge = nestedEdge;
                            return newEdge;
                    }
            }
            return null;
    }
}
