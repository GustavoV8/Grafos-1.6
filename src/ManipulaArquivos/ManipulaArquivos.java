package ManipulaArquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import Grafo.Arestas;
import Grafo.Vertices;

public class ManipulaArquivos {
	//Variavel responsavel por conter a quantidade de linhas do arquivo
	private int qtdLinhas;
	//Vetor responsavel por receber cada linha do arquivo
	private String[] linhasArquivo;	
	//Variavel que pega o total de linhas
	private LineNumberReader linhaLeitura;
	
	/**
	 * Metodo que faz a leitura do arquivo e faz as validacoes iniciais
	 * @param nomeArquivoEntrada
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public boolean lerArquivo(String nomeArquivoEntrada) throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivoEntrada));
		File arquivoleitura = new File(nomeArquivoEntrada);
		linhaLeitura = new LineNumberReader(new FileReader(nomeArquivoEntrada));
		//Ignora as linhas em branco
		linhaLeitura.skip(arquivoleitura.length());
		
		this.qtdLinhas = linhaLeitura.getLineNumber();
		//Verifica se o arquivo esta vazio ou nao
		if(this.qtdLinhas <= 1){
			System.out.println("REJEITA - ARQUIVO DE ENTRADA VAZIO");
			return false;
		}
		//Inicia o vetor linhasArquivos com o total de linhas do arquivo
		this.linhasArquivo = new String[this.qtdLinhas];
		
		int i = 0;
		//Loop que recebe cada linha do arquivo entrada
		String linha;
		while((linha = buffRead.readLine()) != null){
			//Verifica se a linha esta vazia ou nao
			if(!linha.isEmpty()){
				this.linhasArquivo[i] = linha;
				i++;
			}	
		}		
		buffRead.close();
		return true;
	}
	
	/**
	 * Metodo que faz a leitura dos vertices
	 * @param <Vertives>
	 * */
	public List<Vertices> lerVertices(){
		//faz a manipulação da linha do vertice tirando o (;) do final;
		String linha = new String(linhasArquivo[0]);
		linha = linha.replace(";", "");
		String[] vertices = new String[linha.length()-3];
		int posicaovertice = 0;
		
		//Depois da linha ja manipulada coloco apenas os valores num vetor auxiliar
		for(int i = 0; i < linha.length(); i++){
			if(linha.charAt(i) != ' '){
				vertices[posicaovertice] = ""+linha.charAt(i);
				posicaovertice++;
			}
		}
		
		//For que instancia uma classe Vertice pra cada vertice no arquivo de entrada
		List<Vertices> vertice = new ArrayList<Vertices>();
		int ajuda;
		for(int i = 0; i < vertices.length; i++){
			ajuda = Integer.parseInt(vertices[i]);
			vertice.add(new Vertices(ajuda));
		}
		return vertice;
	}
	
	/**
	 * Metodo que ler se o grafo é ou nao direcionado
	 * 
	 * */
	public boolean lerDirecionada(){
		//faz a manipulação da linha do vertice tirando o (;) do final;
		String linha = new String(linhasArquivo[1]);
		linha = linha.replace(";", "");
		//Converte a String para boolean
		boolean direcionada = Boolean.parseBoolean(linha);
		return direcionada;
	}
	
	/**
	 * Metodo que ler se o grafo contem ou nao pesos nas suas arestas
	 * 
	 * */
	public boolean lerPesos(){
		//faz a manipulação da linha do vertice tirando o (;) do final;
		String linha = new String(linhasArquivo[2]);
		linha = linha.replace(";", "");
		//Converte a String para boolean
		boolean pesos = Boolean.parseBoolean(linha);
		return pesos;
	}
	
	/**
	 * Metodo que ler as arestas do grafo
	 * @param <Arestas>
	 * 
	 * */
	public List<Arestas> lerArestas(){
		//Variaveis auxiliares
		List<Arestas> arestas = new ArrayList<Arestas>();
		Vertices origem = new Vertices(0);
		Vertices destino = new Vertices(0);
		int pesos = 1;
		int posicao = 3;
		
		//While responsavel por ler as linhas referentes as arestas ate encontrar o primeiro comando de busca
		while(linhasArquivo[posicao].charAt(0) != 'D'){
			
			//Faz a manipulação das linhas para retirar do final o (;)
			String linha = new String(linhasArquivo[posicao]);
			linha = linha.replace(",", "");
			String[] aresta = new String[linha.length()];
			int posicaoaresta = 0;
			
			//Depois da linha ja manipulada coloco apenas os valores num vetor auxiliar
			for(int i = 0; i < linha.length(); i++){
				if(linha.charAt(i) != ' '){
					aresta[posicaoaresta] = ""+linha.charAt(i);
					posicaoaresta++;
				}
			}
			
			int ajuda = 0;
			String numero;
			
			//For que instancia uma classe Aresta pra cada aresta no arquivo de entrada
			for(int i = 0; i < aresta.length; i++){
				if(i == 0){
					//Converte String em Integer
					ajuda = Integer.parseInt(aresta[i]);
					origem = new Vertices(ajuda);
				}else if(i == 1){
					//Converte String em Integer
					ajuda = Integer.parseInt(aresta[i]);
					destino = new Vertices(ajuda);
				}else if(i == 2 && lerPesos() == true){
					//Concatena os valores dos pesos
					numero = aresta[i]+aresta[i+1];
					//Converte String em Integer
					ajuda = Integer.parseInt(numero);
					pesos = ajuda;
				}
				ajuda = 0;
			}
			arestas.add(new Arestas(origem,destino,pesos));
			posicao++;
		}
		return arestas;
	}
	
	/**
	 *Metodo que lê primeiro comando de DISTANCIA no arquivo de entrada 
	 * @param List<List<Integer>>
	 * 
	 * */
	public List<List<Integer>> lerDistancias(){
		
		//Lista de lista de valores inteiros que sao os vertices
		List<List<Integer>> distancia = new ArrayList<List<Integer>>();
		//Variaveis auxiliares
		int posicao = 0;
		
		//For responsavel por ler as linhas do arquivo
		for(int i = 0; i < linhasArquivo.length-1; i++){
			//Pega linha por linha e adiciona na variavel
			String linha = linhasArquivo[i];
			String valores = linha.substring(0, 3);
			//Confere se o primeiro caracter e 'D' de DISTANCIA
			if(valores.equals("DIS") || valores.equals("dis")){
				//Para cada comando de DISTANCIA instancia uma nova lista de vertices
				List<Integer> vertices = new ArrayList<Integer>();
				//Manipula a linha do arquivo pegando apenas os vertices
				valores = linha.substring(10);
				String[] ajuda = valores.split(";");
				ajuda = ajuda[0].split(" ");
				
				//For responsavel por converter String para Integer e depois insere na lista distancia
				for(int j = 0; j < ajuda.length; j++){
					//Converte String em Integer
					posicao = Integer.parseInt(ajuda[j]);
					//adiciona na lista o valor ja convertido
					vertices.add(posicao);	
				}				
				distancia.add(vertices);				
			}
		}
		return distancia;
	}
	
	public List<Integer> lerProfundidade(){
		List<Integer> profundidade = new ArrayList<Integer>();
		
		for(int i = 0; i < linhasArquivo.length-1;i++){
			
			String linha = linhasArquivo[i];
			String valores = linha.substring(0,3);
			
			if(valores.equals("PRO") || valores.equals("pro")){
				//Manipula a linha do arquivo pegando apenas os vertices
				valores = linha.substring(13);
				String[] ajuda = valores.split(";");
				ajuda = ajuda[0].split(" ");
			
				for(int j = 0; j < ajuda.length;j++){
					int posicao = Integer.parseInt(ajuda[j]);
					profundidade.add(posicao);
				}
			}
		}
		return profundidade;
	}
}
