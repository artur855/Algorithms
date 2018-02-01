package Grafo;

public class Aresta {

	private Vertice a, b;
	private double peso;
	
	public Aresta(Vertice a, Vertice b, double peso) {
		this.a = a;
		this.b = b;
		this.peso = peso;
	}


	public Vertice getA() {
		return a;
	}

	public Vertice getB() {
		return b;
	}

	public double getPeso() {
		return peso;
	}

	public void inverterAresta() {
		Vertice aux = a;
		a = b;
		b = aux;
	}
	
	public String toString() {
		  return this.a.getNome() + " " + this.b.getNome();
	}

}
