package Grafo;

public class Vertices implements Comparable<Vertices>{
	
	private int id;
	private boolean visitado = false;
    private Vertices pai;
	private int distancia;
	
	public Vertices(int id){
		this.id = id;
	}
	
	public Vertices(int id, int peso){
		this.id = id;
		this.distancia = peso;
	}
	
	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
    public Vertices getPai() {
		return pai;
	}

	public void setPai(Vertices pai) {
		this.pai = pai;
	}

	public void visitar (){    
        this.visitado = true;
    }
    
	public boolean verificarVisita() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public int compareTo(Vertices vertices) {
        if (this.id < vertices.id) {
            return -1;
        }
        if (this.id > vertices.id) {
            return 1;
        }
        return 0;
    }
    

	  
}
