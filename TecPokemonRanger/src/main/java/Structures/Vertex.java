package Structures;

/**
 * Los vertices del Dijkstra son sus nodos de información, por lo que estos
 * pueden generar dependencia con otros objetos que se deseen ubicar al grafo.
 *
 * @param <objetoGenerico>
 */


public class Vertex<objetoGenerico> {
    private String vertex_id;
    private objetoGenerico internalNode;

    // CONSTRUCTOR
    public Vertex(String vertex_id, objetoGenerico internalNode) {
            this.vertex_id = vertex_id;
            this.internalNode = internalNode;
    }
    // GETTERS Y SETTERS

    public String getId() {
            return vertex_id;
    }

    public void setId(String id) {
            this.vertex_id = id;
    }

    public objetoGenerico getInternalNode() {
            return internalNode;
    }

    public void setInternalNode(objetoGenerico internalNode) {
            this.internalNode = internalNode;
    }

    @Override
    /**
     * método para obtener variables en string
     */
    public String toString() {
            String msj = "";
            msj += vertex_id;
            return msj;
    }
}
