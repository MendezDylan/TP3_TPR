package Grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * clase para controlar el grafo
 */
public class ControladorGrafo {
	private List<Vertice<Object>> vertices;
	private List<Arista> aristas;
	private LinkedList<Vertice<Object>> trazo;

	/**
	 * Al generar el contructor se inicializan y se crean objetos de las 3 listas
	 * necesarias.
	 */
	public ControladorGrafo() {
		this.vertices = new ArrayList<Vertice<Object>>();
		this.aristas = new ArrayList<Arista>();
		this.trazo = new LinkedList<Vertice<Object>>();
	}

	/**
	 * método para obtener el trazo del grafo
	 * 
	 * @return trazo con camino
	 */
	public LinkedList<Vertice<Object>> getTrazo() {
		return trazo;
	}

	/**
	 * método para ingresar nuevo trazo
	 * 
	 * @param trazo trazo por ingresar
	 */
	public void setTrazo(LinkedList<Vertice<Object>> trazo) {
		this.trazo = trazo;
	}

	/**
	 * método para obtener vertices
	 * 
	 * @return vertices del grafo
	 */
	public List<Vertice<Object>> getVertices() {
		return vertices;
	}

	/**
	 * método para configurar vertices
	 * 
	 * @param vertices vertices nuevas para el grafo
	 */
	public void setVertices(List<Vertice<Object>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * método para obtener aristas
	 * 
	 * @return aristas
	 */
	public List<Arista> getAristas() {
		return aristas;
	}

	/**
	 * MÉtodo para ingresar aristas al grafo
	 * 
	 * @param aristas nuevas aristas
	 */
	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}

	/**
	 * Permite generar relaciones entre los v�rtices (que deben ser existentes) y
	 * las aristas
	 * 
	 * @param id_arista           ID que se le dará a las aristas
	 * @param id_lista_vertices_A ID del vértice del cuál se parte
	 * @param id_lista_vertices_B ID del vértice de llegada
	 * @param distanciaTrayecto   La distancia que hay entre el Vértice de partida
	 *                            y el v�rtice de llegada
	 */
	public void nuevaArista(String id_arista, int id_lista_vertices_A, int id_lista_vertices_B,
			double distanciaTrayecto) {

		Arista arista = new Arista(id_arista, vertices.get(id_lista_vertices_A),
				vertices.get(id_lista_vertices_B), distanciaTrayecto);
		aristas.add(arista);
	}

	/**
	 * Permite generar nuevos vértices para ser utilizados dentro del grafo
	 * 
	 * @param id_vertice  ID del vértice que se desea cear
	 * @param nodoExterno Objeto externo que se desea insertar dentro del vértice
	 */
	public void nuevoVertice(String id_vertice, Object nodoExterno) {
		Vertice<Object> vertice = new Vertice<Object>(id_vertice, nodoExterno);
		vertices.add(vertice);
	}

	/**
	 * método para obtener el id según el string de un vértice
	 * 
	 * @param id_vertice id del vértice buscado
	 * @return vértice con el valor buscado
	 */
	public Vertice<Object> obtenerVerticePorID(String id_vertice) {
		Vertice<Object> verticeNuevo = null;
		for (Vertice<Object> verticeAnidado : vertices) {
			if (verticeAnidado.getId().equals(id_vertice)) {
				verticeNuevo = verticeAnidado;
				return verticeNuevo;
			}
		}
		return null;
	}
}
