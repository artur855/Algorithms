package Grafo;

public class Vertice implements Comparable<Vertice> {

	private String nome;
	private boolean visitado;
	private int ordem;
	private double dist;
	private Vertice path;
	private int dependencia;

	public Vertice(String nome) {
		this.nome = nome;
		this.dependencia = 0;
	}

	public String getNome() {
		return this.nome;
	}

	public String toString() {
		return this.getNome();
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean isVisitado() {
		return this.visitado;
	}

	public int getOrdem() {
		return this.ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int compareTo(Vertice outro) {
		return this.getNome().compareTo(outro.getNome());
	}

	public double getDist() {
		return dist;
	}

	public void setDist(double distancia) {
		this.dist = distancia;
	}

	public Vertice getPath() {
		return path;
	}

	public void setPath(Vertice path) {
		this.path = path;
	}

	public int getDependencia() {
		return dependencia;
	}

	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

}
