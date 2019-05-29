package Grafo;

import java.util.*;

/**
 * Interface que contiene los métodos de ejecución para cualquier grafo
 * 
 *
 * @param <objeoGenerico>
 *            Este genérico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */
public interface ComportamientoGrafo<objeoGenerico> {
	public void ejecutarGrafo(objeoGenerico Grafo);

	public LinkedList<objeoGenerico> obtenerListadoCamino(objeoGenerico pDestino);
}
