package Structures;

import java.util.List;


public class Graph {
    private List<Vertex<Object>> vertices;
    private List<Edge> edges;

    /**
     * constructor del grafo
     * 
     */
    public Graph(List<Vertex<Object>> pVertices, List<Edge> pEdges) {
            this.vertices = pVertices;
            this.edges = pEdges;
    }

    // GETTERS Y SETTERS

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

    @Override
    /**
     * método para obtener las variables en string
     */
    public String toString() {
            String msj = "";
            msj += vertices.toString();
            msj += edges.toString();
            return msj;
    }
}
