package Main;

import java.io.IOException;
import Grafo.Grafo;
import LeituraDoArquivo.Leitura;

public class Main {
	public static void main(String[] args) {
		Leitura ler = new Leitura();
		String arquivo = args[0];
		
		try {
			ler.lerArquivo(arquivo);
			Grafo grafo = new Grafo(ler.lerVertices(), ler.lerArestas(), ler.lerDirecionada(), ler.lerPesos());
			System.out.println("Distancia: "+grafo.Distancia(ler.lerDistancia()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
