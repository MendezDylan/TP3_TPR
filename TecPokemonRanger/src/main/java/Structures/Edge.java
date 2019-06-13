package Structures;


public class Edge {
    private String edge_id;
    private Vertex<Object> startingPoint;
    private Vertex<Object> arrivalPoint;
    private int distance;
    private int timeInMinutes;

    /**
     * constructor
     * @param edge_id
     * @param startingPoint
     * @param arrivalPoint
     * @param distance
     */
    public Edge(String edge_id, Vertex<Object> startingPoint, Vertex<Object> arrivalPoint, int distance) {
            this.edge_id = edge_id;
            this.startingPoint = startingPoint;
            this.arrivalPoint = arrivalPoint;
            this.distance = distance;
    }

    public Edge(String edge_id, Vertex<Object> startingPoint, Vertex<Object> arrivalPoint, int distance, int timeInMinutes) {
            this.edge_id = edge_id;
            this.startingPoint = startingPoint;
            this.arrivalPoint = arrivalPoint;
            this.distance = distance;
            this.timeInMinutes = timeInMinutes;
    }

    /**
     * get para arista
     * @return arista
     */

    public String getEdge_id() {
            return edge_id;
    }
    /**
     * set para id de arista
     * @param id_arista id de arista nuevo
     */
    public void setEdge_id(String edge_id) {
            this.edge_id = edge_id;
    }
    /**
     * get del punto de partida
     * @return punto de partida (vértice)
     */
    public Vertex<Object> getStartingPoint() {
            return startingPoint;
    }
    /**
     * set del punto de partida
     * @param puntoPartida nuevo vértice
     */
    public void setStartingPoint(Vertex<Object> startingPoint) {
            this.startingPoint = startingPoint;
    }
    /**
     * get del punto de llegada
     * @return punto de llegada(vértice)
     */
    public Vertex<Object> getArrivalPoint() {
            return arrivalPoint;
    }
    /**
     * set del punto de llegada 
     * @param puntoLlegada punto nuevo de llegada (vértice)
     */
    public void setArrivalPoint(Vertex<Object> arrivalPoint) {
            this.arrivalPoint = arrivalPoint;
    }
    /**
     * get del peso de la arista
     * @return peso 
     */
    public int getDistance() {
            return distance;
    }
    /**
     * set de la distance de la arista
     * @param longitud peso nuevo de la arista
     */
    public void setDistance(int distance) {
            this.distance = distance;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

}
