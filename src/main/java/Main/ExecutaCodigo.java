/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Grafo.Grafo;
import Grafo.Vertices;
import ManipulaArquivos.ManipulaArquivos;

/**
 *
 * @author Gustavo Henrique
 */
public class ExecutaCodigo{
	
	ManipulaArquivos ler = new ManipulaArquivos();
	private String Diretorio;
	private String nomeArquivo;
	
	public ExecutaCodigo(String diretorio, String nomeArquivo){
		this.Diretorio = diretorio;
		this.nomeArquivo = nomeArquivo;
	}
	
	public void Grafo() throws IOException{
		if(ler.lerArquivo(Diretorio + nomeArquivo)){
			FileWriter saida = new FileWriter(new File(Diretorio + "saida.txt"));
			String texto = null;
			Grafo grafo = new Grafo(ler.lerVertices(), ler.lerArestas(), ler.lerDirecionada(), ler.lerPesos());
            ler.criarGrafo(Diretorio);
            
            List<List<Integer>> resultado =  new ArrayList<List<Integer>>();    
            //Exibe as distancias
            resultado.addAll(ler.lerDistancias());
            for(int i = 0; i < resultado.size(); i++){
            	texto = "Distancia: "+resultado.get(i)+"\n";
            	texto += grafo.Distancia(resultado.get(i))+"\n";
            	saida.write(texto.toString());
            }
            //Limpar a lista
            resultado.clear();
            
            //Exibe Profundidade
            resultado.addAll(ler.lerProfundidade());
            for(int i = 0; i < resultado.size();i++){
            	saida.write(grafo.buscaEmProfundidade(resultado.get(i)));
            }
            
            //Limpar a lista
            resultado.clear();
            
            //Busca em Largura
            resultado.addAll(ler.lerLargura());
            for(int i = 0; i < resultado.size(); i++){
            	saida.write(grafo.buscaEmLargura(resultado.get(i)));
            }
            //Limpar a lista
            resultado.clear();
//            
//            resultado.addAll(ler.lerMenorCaminho());
//            LinkedList<Vertices> caminho = new LinkedList<Vertices>();
//            Vertices verticesOrigem = new Vertices(resultado.get(0).get(0).intValue());
//            Vertices verticesDestino = new Vertices(resultado.get(0).get(1).intValue());
//            grafo.execute(verticesOrigem);
//    	      caminho = grafo.getPath(verticesDestino);
//    	      saida.write(caminho.toString());
    	    
    	    saida.close();
		}
	}
	public static void main(String[] args) {
		
	}
}
