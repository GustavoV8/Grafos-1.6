package Grafo;

public class Vertices{
	
	private int id;
	private boolean visitado = false;
    private Vertices pai;
	private int distancia;
	
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

	public Vertices(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
