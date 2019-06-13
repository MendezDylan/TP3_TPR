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
     * get for edge
     * @return arista
     */

    public String getEdge_id() {
            return edge_id;
    }
    /**
     * set for edge's id
     * @param id_arista id de arista nuevo
     */
    public void setEdge_id(String edge_id) {
            this.edge_id = edge_id;
    }
    /**
     * get split point
     * @return punto de partida (vértice)
     */
    public Vertex<Object> getStartingPoint() {
            return startingPoint;
    }
    /**
     * set split point
     * @param puntoPartida nuevo vértice
     */
    public void setStartingPoint(Vertex<Object> startingPoint) {
            this.startingPoint = startingPoint;
    }
    /**
     * get arrival point
     * @return punto de llegada(vértice)
     */
    public Vertex<Object> getArrivalPoint() {
            return arrivalPoint;
    }
    /**
     * set arrival point
     * @param puntoLlegada punto nuevo de llegada (vértice)
     */
    public void setArrivalPoint(Vertex<Object> arrivalPoint) {
            this.arrivalPoint = arrivalPoint;
    }
    /**
     * get edge's weight
     * @return peso 
     */
    public int getDistance() {
            return distance;
    }
    /**
     * set edge's weight
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
