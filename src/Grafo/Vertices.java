package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertices implements Comparable<Vertices>{
	
	private int id;
	private List<Vertices> verticesVizinhos = new ArrayList<Vertices>();
	private List<Arestas> arestas = new ArrayList<Arestas>();
	
	public Vertices(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Vertices> getVerticesVizinhos() {
		return verticesVizinhos;
	}

	public void setVerticesVizinhos(List<Vertices> verticesVizinhos) {
		this.verticesVizinhos = verticesVizinhos;
	}

	public List<Arestas> getArestas() {
		return arestas;
	}

	public void setArestas(List<Arestas> arestas) {
		this.arestas = arestas;
	}	
	
	@Override
	public int compareTo(Vertices vertice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
