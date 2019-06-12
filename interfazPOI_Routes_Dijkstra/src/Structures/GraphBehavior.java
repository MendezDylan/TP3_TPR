package Structures;

import java.util.*;

/**
 * Interface que contiene los métodos de ejecución para cualquier grafo
 * 
 *
 * @param <genericObject>
 *            Este genérico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */
public interface GraphBehavior<genericObject> {
	public void runGraph(genericObject Graph);

	public LinkedList<genericObject> getPathList(genericObject arrivalP);
}
