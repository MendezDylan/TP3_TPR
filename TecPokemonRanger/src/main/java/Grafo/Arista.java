package Grafo;

/**
 * Esta clase posee el comportamiento que tendrá el Dijkstra en el momento de
 * ser ejecutado
 */
public class Arista {
	private String id_arista;
	private Vertice<Object> puntoPartida;
	private Vertice<Object> puntoLlegada;
	private double longitud;

	/**
         * constructor
         * @param pId_arista id de la arista
         * @param pPartida punto de partida (vértice)
         * @param pLlegada punto de llegada (vértice)
         * @param pLongitud peso de la relación
         */
	public Arista(String pId_arista, Vertice<Object> pPartida, Vertice<Object> pLlegada, double pLongitud) {
		this.id_arista = pId_arista;
		this.puntoPartida = pPartida;
		this.puntoLlegada = pLlegada;
		this.longitud = pLongitud;
	}
	/**
         * get para arista
         * @return arista
         */

	public String getId_arista() {
		return id_arista;
	}
        /**
         * set para id de arista
         * @param id_arista id de arista nuevo
         */
	public void setId_arista(String id_arista) {
		this.id_arista = id_arista;
	}
        /**
         * get del punto de partida
         * @return punto de partida (vértice)
         */
	public Vertice<Object> getPuntoPartida() {
		return puntoPartida;
	}
        /**
         * set del punto de partida
         * @param puntoPartida nuevo vértice
         */
	public void setPuntoPartida(Vertice<Object> puntoPartida) {
		this.puntoPartida = puntoPartida;
	}
        /**
         * get del punto de llegada
         * @return punto de llegada(vértice)
         */
	public Vertice<Object> getPuntoLlegada() {
		return puntoLlegada;
	}
        /**
         * set del punto de llegada 
         * @param puntoLlegada punto nuevo de llegada (vértice)
         */
	public void setPuntoLlegada(Vertice<Object> puntoLlegada) {
		this.puntoLlegada = puntoLlegada;
	}
        /**
         * get del peso de la arista
         * @return peso 
         */
	public double getLongitud() {
		return longitud;
	}
        /**
         * set de la longitud de la arista
         * @param longitud peso nuevo de la arista
         */
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	/**
         * método para obtener un string con todas la variables
         * @return string con variables de la instancia
         */
	public String toString() {
		String msj = "";
		msj += "ID: " + id_arista + "\n";
		msj += "VERTICE PARTIDA: \n";
		msj += puntoPartida.toString();
		msj += puntoLlegada.toString();
		msj += "Longitud: " + longitud;
		return msj;
	}
}
