package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Grafo.Grafo;
import ManipulaArquivos.ManipulaArquivos;

public class Main {
	public static void main(String[] args) {
		ManipulaArquivos ler = new ManipulaArquivos();
		String arquivoDeEntrada = args[0];
		String arquivoDeSaida = args[1];
		
		try {
			if(ler.lerArquivo(arquivoDeEntrada)){
				Grafo grafo = new Grafo(ler.lerVertices(), ler.lerArestas(), ler.lerDirecionada(), ler.lerPesos());
				
				//Exibe as distancias
//				List<List<Integer>> resultado =  new ArrayList<List<Integer>>();
//				resultado.addAll(ler.lerDistancias());				
//				for(int i = 0; i < resultado.size(); i++){
//					grafo.Distancia(resultado.get(i));
//				}
				
				grafo.buscaEmProfundidade(ler.lerProfundidade());
				
				//ler.lerProfundidade();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
