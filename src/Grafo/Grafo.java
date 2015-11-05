package Grafo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo {
	
	private List<Vertices> vertices = new ArrayList<Vertices>();
	private List<Arestas> arestas = new ArrayList<Arestas>();
	private boolean direcionada;
	private boolean pesos;
	
	public Grafo(List<Vertices> vertice, List<Arestas> aresta, boolean direcionada, boolean pesos){
		this.vertices.addAll(vertice);
		this.arestas.addAll(aresta);
		this.direcionada = direcionada;
		this.pesos = pesos;
	}
	
	/**
	 * Metodo que calcula a distancia entre o vertices
	 * 
	 * */	 
	 public int Distancia(List<Integer> vertices){
		 int pesos = 0;
		 List<Integer> vertic = new ArrayList<Integer>();
		 vertic.addAll(vertices);
		 System.out.println("Distancia: "+vertic);
		 for(int i = 0; i < vertic.size()-1; i++){		 
			 for(int j = 0; j < this.arestas.size();j++){
				 if(this.arestas.get(j).getOrigem().getId() == vertic.get(i).intValue() && this.arestas.get(j).getDestino().getId() == vertic.get(i+1).intValue()){
				 	pesos += arestas.get(j).getPesos();
			 	}
			 }
		 }
		 System.out.println(pesos);
		 return pesos;
	 }
	 
	 public void buscaEmProfundidade(List<Integer> vertices){
		 
		 Stack<Integer> fronteira = new Stack<Integer>();
		 List<Integer> visitados = new ArrayList<Integer>();
		 List<Integer> vizinhos = new LinkedList<Integer>();
		 int origem = vertices.get(0).intValue();
		 int destino = vertices.get(1).intValue();
		 int aux = origem;
		 fronteira.push(-1);
		 
		 System.out.println(fronteira);
		 System.out.println("Profundidade: "+vertices);
		 System.out.println(origem);
		 
		 while(fronteira.firstElement() != destino){
			 for(int i = 0; i < this.arestas.size();i++){
				 if(fronteira.firstElement() == -1){
					 fronteira.pop();
				 }
				 if(aux == this.arestas.get(i).getOrigem().getId()){
					 visitados.add(aux);
					 System.out.println("Visitados: "+visitados);
					 fronteira.add(this.arestas.get(i).getDestino().getId());
					 System.out.println("\nFronteira: "+fronteira);
				 }
			 }
			 aux = fronteira.firstElement();
			 fronteira.pop();
			 System.out.println("Nova fronteira: "+fronteira);
			 System.out.println("\nNova Origem: "+aux);
			 break;
		 }
	 }
	 
	public List<Vertices> getVertices() {
		return vertices;
	}
	public void setVertices(List<Vertices> vertices) {
		this.vertices.addAll(vertices);
	}
	public List<Arestas> getArestas() {
		return arestas;
	}
	public void setArestas(List<Arestas> arestas) {
		this.arestas.addAll(arestas);
	}
	public boolean isDirecionada() {
		return direcionada;
	}
	public void setDirecionada(boolean direcionada) {
		this.direcionada = direcionada;
	}
	public boolean isPesos() {
		return pesos;
	}
	public void setPesos(boolean pesos) {
		this.pesos = pesos;
	}	
}
