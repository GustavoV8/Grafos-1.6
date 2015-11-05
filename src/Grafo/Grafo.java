package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		 int origem = vertices.get(0).intValue();
		 int destino = vertices.get(1).intValue();
		 int aux = origem;
		 fronteira.push(-1);
		 
		 System.out.println("Profundidade: "+vertices);
		 System.out.println(origem);
		 
		 int cont = 0;
		 while(aux != destino){
			 fronteira.pop();
			 List<Integer> vizinhos = new ArrayList<Integer>();
			 for(int i = 0; i < this.arestas.size();i++){
				 if(aux == this.arestas.get(i).getOrigem().getId()){
					 vizinhos.add(this.arestas.get(i).getDestino().getId());
				 }
			 }
			 visitados.add(aux); 

			 Collections.reverse(vizinhos);
			 for(int i = 0; i < vizinhos.size(); i++){
				 fronteira.push(vizinhos.get(i).intValue());
			 }	
			 
			 aux = fronteira.lastElement().intValue();
			 if(cont == 0){
				Collections.sort(fronteira);
			 	System.out.println(fronteira);
			 	Collections.reverse(fronteira);
			 }else{
				 System.out.println(fronteira);
			 }	 
			 cont++;
		 }
		 System.out.println("Encontrado: "+aux);
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
