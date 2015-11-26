package Grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo{
	
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
	public String Distancia(List<Integer> vertices){
		 //Variaveis auxiliares
		 int pesos = 0;
		 String saida = null;
		 List<Integer> vertic = new ArrayList<Integer>();
		 vertic.addAll(vertices);
		 
		 System.out.println("Distancia: "+vertic);
		 saida = "Distancia: "+vertic+"\n";
		 for(int i = 0; i < vertic.size()-1; i++){		 
			 for(int j = 0; j < this.arestas.size();j++){
				 //IF responsavel por comparar os vertices de origem e destino quando sao iguais
				 //o peso dessa aresta e somado a varialve peso
				 if(this.arestas.get(j).getOrigem().getId() == vertic.get(i).intValue() && this.arestas.get(j).getDestino().getId() == vertic.get(i+1).intValue()){
				 	pesos += arestas.get(j).getPesos();
			 	}
			 }
		 }
		 System.out.println(pesos);
		 saida = ""+pesos;
		 return saida;
	 }
	 
	public int buscaEmProfundidade(List<Integer> vertices){
		 //Pilha da Fronteria
		 Stack<Integer> fronteira = new Stack<Integer>();
		 //Lista de vertices visitados
		 List<Integer> visitados = new ArrayList<Integer>();
		 //Variavel que recebe a origem da busca
		 int origem = vertices.get(0).intValue();
		 //Variavel que recebe o destino da busca
		 int destino = vertices.get(1).intValue();
		 //Variavel auxiliar que sera manipulada pegando sempre a nova origem
		 int aux = origem;
		 
		 //Exibe na tela o comando e os vertices de origem e destino
		 System.out.println("Profundidade: "+vertices);
		 System.out.println(origem);
		 
		 int cont = 0;
		 
		 //WHILE que ira comparar se a Variavel AUX eh igual ao destino caso nao continua a execuÃ§Ã£o do while 
		 while(aux != destino){
			 
			 //Lista responsavel por pegar os vizinhos da origem
			 List<Integer> vizinhos = new ArrayList<Integer>();
			 //For que varre as arestas para saber os vizinhos da origem
			 for(int i = 0; i < this.arestas.size();i++){
				 if(aux == this.arestas.get(i).getOrigem().getId()){
					 vizinhos.add(this.arestas.get(i).getDestino().getId());
				 }
			 }
			 //Apos achar os visinhos a origem vou visitada por eu ha coloco na lista de visitados
			 visitados.add(aux); 
			 
			 //Caso os vizinhos estejam em ordem crescente irei inverte-los para que fique em ordem decrescente
			 //caso ja estejam em ordem decrescente na se faz nada
			 for(int i = 0; i < vizinhos.size() -1;i++){
				 //If que compara se esta ou nao em ordem decrescente
				 if(vizinhos.get(i).intValue() < vizinhos.get(i+1).intValue()){
					 //Comando que inverte a lista
					 Collections.reverse(vizinhos);
				 }
			 }
			 
			 //Apos a inversao ou nao os visinhos sao inseridos na fronteira de modo que o menor valor fique no final da pilha
			 for(int i = 0; i < vizinhos.size(); i++){
				 //Adiciona os vizinhos na fronteria
				 fronteira.push(vizinhos.get(i).intValue());
			 }	
			 
			 //A variavel AUX recebe o ultimo valor inserido na fronteira que sera agora a nova origem
			 aux = fronteira.lastElement().intValue();
			 
			 //Apos AUX receber a nova origem ela e comparada com os visitados
			 for(int i = 0; i < visitados.size(); i++){
				 if(aux == visitados.get(i).intValue()){
					 //Caso o vertice ja tenha sido visitado ele retirado da fronteria
					 fronteira.pop();
					//A variavel AUX recebe o ultimo valor inserido na fronteira que sera agora a nova origem
					 aux = fronteira.lastElement().intValue();
				 }
			 }
			 //IF que exibe de forma padrao de saida
			 if(cont == 0){
				Collections.sort(fronteira);
			 	System.out.println(fronteira);
			 	Collections.reverse(fronteira);
			 }else{
				 System.out.println(fronteira);
			 }	 
			 cont++;
			 //Retira na pilha o ultimo elemento
			 fronteira.pop();
		 }
		 return 1;
	 }
	  
	public int buscaEmLargura(List<Integer> vertices1){
		 
		 //FILA FRONTEIRA;
		 Queue <Integer> fronteira = new LinkedList<Integer>();		 
		 //LISTA DE VERTICES VISITADOS;
		 List<Integer> visitados1 = new ArrayList<Integer>();		 
		 //VARIAVEL COM VERTICE DE ORIGEM;
		 int origem = vertices1.get(0).intValue();		 
		 //VARIAVEL COM VERTICE DESTINO;
		 int destino = vertices1.get(1).intValue();		
		 //VARIAVEL AUXILIAR USADA PARA RECEBER O NOVO VERTICE DE ORIGEM;
		 int aux = origem;
		 
		 //EXIBE OS VERTICES DE ORIGEM E DESTINO;
		 System.out.println("Largura: "+vertices1);
		 System.out.println(origem);
		 
		 //CONDICAO QUE COMPARA A VARIAVEL AUXILIAR (COM A ORIGEM) COM OS VIZINHOS; 
		 while(aux != destino){			 
			 //LISTA DE VIZINHOS;
			 List<Integer> vizinhos1 = new ArrayList<Integer>();
			 //CONDICAO QUE VERIFICA OS VIZINHOS;
			 for(int i = 0; i < this.arestas.size();i++)
			 		{
				 	if(aux == this.arestas.get(i).getOrigem().getId()){
					 vizinhos1.add(this.arestas.get(i).getDestino().getId());
				 	}
			 }
			 //ADICIONA A ORIGEM, APOS ENCONTRAR SEUS VIZINHOS;
			 visitados1.add(aux); 			
			//SE ORDEM DE VIZINHOS (CRESCENTE), INVERTA-OS;
			 for(int i = 0; i < vizinhos1.size() -1;i++){
				 	//VERIFICA ORDEM;
					 if(vizinhos1.get(i).intValue() >= vizinhos1.get(i+1).intValue()){
					 //EFETUA INVERCAO;
					 Collections.reverse(vizinhos1);
				 }
			 }
			 
			 for(int i = 0; i < vizinhos1.size(); i++){
				 //FRONTEIRA RECEBE VIZINHOS DA ORIGEM ATUAL;
				 fronteira.add(vizinhos1.get(i).intValue());
			 }	
			 
			 //VARIAVEL AUXILIAR RECEBE NOVA ORIGEM, ULTIMO ELEMENTO ADICIONADO NA LISTA;
			 aux = fronteira.element().intValue();			 
			 //VERIFICA SE NOVA ORIGEM ESTA NOS VISITADOS;
			 for(int i = 0; i < visitados1.size(); i++){
				 if(aux == visitados1.get(i).intValue()){
					 System.out.println(fronteira);
					 //VERTICE JA VISITADO, VERTICE REMOVIDO;
					 fronteira.remove();
					 //VARIAVEL AUXILIAR RECEBE NOVA ORIGEM, ULTIMO ELEMENTO ADICIONADO NA LISTA;
					 aux = fronteira.element().intValue();
				 }
			 }
		 //MOSTRA O RESULTADO DA BUSCA POR LARGURA;
		 System.out.println(fronteira);	 
		 fronteira.remove();	
		 }	
		 return 1;
	 }
	 
	public Vertices achaVertice(int n){
		Vertices vertice = new Vertices(0);
		for(int i = 0; i < this.getVertices().size(); i++){
			if(n == this.getVertices().get(i).getId()){
				vertice = new Vertices(this.getVertices().get(i).getId());
			}
		}
		return vertice;
	}
	
	 private final List<Vertices> nodes = new ArrayList<Vertices>(this.getVertices());
	 private final List<Arestas> edges = new ArrayList<Arestas>(this.getArestas());
	 private Set<Vertices> settledNodes;
	 private Set<Vertices> unSettledNodes;
	 private Map<Vertices, Vertices> predecessors;
	 private Map<Vertices, Integer> distance;
	
	  public void execute(Vertices origem) {
		    settledNodes = new HashSet<Vertices>();
		    unSettledNodes = new HashSet<Vertices>();
		    distance = new HashMap<Vertices, Integer>();
		    predecessors = new HashMap<Vertices, Vertices>();
		    distance.put(origem, 0);
		    unSettledNodes.add(origem);
		    while (unSettledNodes.size() > 0) {
		      Vertices node = getMinimum(unSettledNodes);
		      settledNodes.add(node);
		      unSettledNodes.remove(node);
		      findMinimalDistances(node);
		    }
	  }
	  
	  private void findMinimalDistances(Vertices node) {
		    List<Vertices> adjacentNodes = getNeighbors(node);
		    for (Vertices target : adjacentNodes) {
		      if (getShortestDistance(target) > getShortestDistance(node)
		          + getDistance(node, target)) {
		        distance.put(target, getShortestDistance(node)
		            + getDistance(node, target));
		        predecessors.put(target, node);
		        unSettledNodes.add(target);
		      }
		    }

		  }
	  
	  private int getDistance(Vertices node, Vertices target) {
		    for (Arestas edge : edges) {
		      if (edge.getOrigem().equals(node)
		          && edge.getDestino().equals(target)) {
		        return edge.getPesos();
		      }
		    }
		    throw new RuntimeException("Should not happen");
		  }

		  private List<Vertices> getNeighbors(Vertices node) {
		    List<Vertices> neighbors = new ArrayList<Vertices>();
		    for (Arestas edge : edges) {
		      if (edge.getOrigem().equals(node)
		          && !isSettled(edge.getDestino())) {
		        neighbors.add(edge.getDestino());
		      }
		    }
		    return neighbors;
		  }

		  private Vertices getMinimum(Set<Vertices> vertexes) {
		    Vertices minimum = null;
		    for (Vertices vertex : vertexes) {
		      if (minimum == null) {
		        minimum = vertex;
		      } else {
		        if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
		          minimum = vertex;
		        }
		      }
		    }
		    return minimum;
		  }

		  private boolean isSettled(Vertices vertex) {
		    return settledNodes.contains(vertex);
		  }

		  private int getShortestDistance(Vertices destination) {
		    Integer d = distance.get(destination);
		    if (d == null) {
		      return Integer.MAX_VALUE;
		    } else {
		      return d;
		    }
		  }

		  /*
		   * This method returns the path from the source to the selected target and
		   * NULL if no path exists
		   */
		  public LinkedList<Vertices> getPath(Vertices target) {
		    LinkedList<Vertices> path = new LinkedList<Vertices>();
		    Vertices step = target;
		    // check if a path exists
		    if (predecessors.get(step) == null) {
		      return null;
		    }
		    path.add(step);
		    while (predecessors.get(step) != null) {
		      step = predecessors.get(step);
		      path.add(step);
		    }
		    // Put it into the correct order
		    Collections.reverse(path);
		    return path;
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
