package Main;

import Grafo.ControladorGrafo;
import Grafo.Dijkstra;
import Grafo.Grafo;



public class MainClass {
	private static ControladorGrafo controlador;
	private static Grafo grafo;
	private static Dijkstra dijkstra;

	public static void main(String[] args) {
		// Primeramente, se utiliza el controlador para crear las listas de v�rtices y
		// aristas
		controlador = new ControladorGrafo();

		controlador.nuevoVertice("A", "ALELUYA");
		controlador.nuevoVertice("B", "QWERTY");
		controlador.nuevoVertice("C", "ASDFGH");
		controlador.nuevoVertice("D", "POIUYY");
		controlador.nuevoVertice("E", "MHJBOIN");

		controlador.nuevaArista("AB", 0, 1, 23.8);
		controlador.nuevaArista("BA", 1, 0, 23.8);
		controlador.nuevaArista("AD", 0, 3, 5.8);
		controlador.nuevaArista("DA", 3, 0, 5.8);
		
		controlador.nuevaArista("AC", 0, 2, 17.2);
		controlador.nuevaArista("CA", 2, 0, 17.2);

		controlador.nuevaArista("BC", 1, 2, 36.2);
		controlador.nuevaArista("CB", 2, 1, 36.2);

		controlador.nuevaArista("CD", 1, 3, 25.1);
		controlador.nuevaArista("DC", 3, 1, 25.1);
		
		controlador.nuevaArista("DE", 3, 4, 86.4);
		controlador.nuevaArista("ED", 4, 3, 86.4);


		// Luego se inicializa el grafo que actuar� directamente sobre las listas del
		// controlador
		grafo = new Grafo(controlador.getVertices(), controlador.getAristas());
		//System.out.println(grafo.toString());

		// Por �ltimo se utliza el Dijkstra para obtener la ruta m�s corta de un punto a
		// otro
		dijkstra = new Dijkstra(grafo);
		dijkstra.ejecutarGrafo(dijkstra.getVertices().get(0));
		
		///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
		System.out.println(dijkstra.getDistancias().toString());

		///OBTIENE EL CAMINO M�S CORTO A PARTIR DE get(0) a get(4) EN ESTE CASO , puede ser cualquiera
		System.out.println(dijkstra.obtenerListadoCamino(dijkstra.getVertices().get(3)));
		
		//Obtener la distancia entre dos v�rtices
		double distanciaMinima = dijkstra.getDistancias().get(dijkstra.getVertices().get(3));
		System.out.println(distanciaMinima);
	}
}
