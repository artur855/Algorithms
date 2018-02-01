package Grafo;

import java.util.Set;

public interface IGrafo {

	// Retorna true se o grafo for completo e false caso contrário
	public boolean ehCompleto();

	// Retorna true se o grafo for conexo e false caso contrario
	public boolean ehConexo();

	// Retorna true se o grafo for regular e false caso contrario
	public boolean ehRegular();

	// Retorna um conjunto com todos os adjancetes de um vértice
	public Set<Vertice> getAdjacentes(Vertice v);

	/*
	 * Retorna uma string que representa o grafo na forma:
	 * 
	 * v2 [ v1 v3 ] v1 [ v2 v3 ] v3 [ v2 v1 ]
	 * 
	 * Por exemplo, nesse caso V2 é adjacente a v1 e v3.
	 * 
	 */
	public String toString();

	// Executa a busca em Largura
	public void buscaLargura();

	// Executa a busca em profundidade
	public void buscaProfundidade();

}
