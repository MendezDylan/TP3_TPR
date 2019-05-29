package Grafo;

/**
 * Los vertices del Dijkstra son sus nodos de información, por lo que estos
 * pueden generar dependencia con otros objetos que se deseen ubicar al grafo.
 *
 * @param <objetoGenerico>
 */
public class Vertice<objetoGenerico> {
	private String id_vertice;
	private objetoGenerico nodoInterno;

	// CONSTRUCTOR
	public Vertice(String pId, objetoGenerico pNodoInterno) {
		this.id_vertice = pId;
		this.nodoInterno = pNodoInterno;
	}
	// GETTERS Y SETTERS

	public String getId() {
		return id_vertice;
	}

	public void setId(String id) {
		this.id_vertice = id;
	}

	public objetoGenerico getNodoInterno() {
		return nodoInterno;
	}

	public void setNodoInterno(objetoGenerico nodoInterno) {
		this.nodoInterno = nodoInterno;
	}

	@Override
        /**
         * método para obtener variables en string
         */
	public String toString() {
		String msj = "";
		msj += "Vertice: ID:" + id_vertice + " ";
		msj += nodoInterno.toString();
		return msj;
	}
}
