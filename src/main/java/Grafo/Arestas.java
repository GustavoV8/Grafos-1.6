package Grafo;

public class Arestas {
	private Vertices origem;
	private Vertices destino;
	private int pesos;
	
	public Arestas(Vertices origem, Vertices destino, int pesos){
		this.origem = origem;
		this.destino = destino;
		this.pesos = pesos;
	}

	public Vertices getOrigem() {
		return origem;
	}

	public void setOrigem(Vertices origem) {
		this.origem = origem;
	}

	public Vertices getDestino() {
		return destino;
	}

	public void setDestino(Vertices destino) {
		this.destino = destino;
	}

	public int getPesos() {
		return pesos;
	}

	public void setPesos(int pesos) {
		this.pesos = pesos;
	}
	
	@Override
	public String toString() {
		return origem + " " + destino;
	}
}
