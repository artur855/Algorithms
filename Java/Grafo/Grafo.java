package Grafo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo implements IGrafo {

	private Set<Vertice> vertices = new HashSet<Vertice>();
	private Set<Aresta> arestas = new HashSet<Aresta>();

	private List<Vertice> visitados;
	private List<Vertice> explorados;

	public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
		this.visitados = new ArrayList<Vertice>();
		this.explorados = new ArrayList<Vertice>();
	}

	/*
	 * Verifica se um grafo e completo
	 */

	@Override
	public boolean ehCompleto() {

		for (Vertice vertice : this.vertices) {
			if (this.getAdjacentes(vertice).size() == this.vertices.size() - 1) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	/*
	 * Retorna a lista de vertices adjacentes de um determinado vertice
	 */
	@Override
	public Set<Vertice> getAdjacentes(Vertice v) {
		Set<Vertice> adjacentes = new HashSet<Vertice>();

		for (Aresta aresta : this.arestas) {
			if (aresta.getA() == v) {
				adjacentes.add(aresta.getB());
			}
		}
		return adjacentes;

	}

	/*
	 * Retorna o proximo vertice nao visitado da lista de adjacentes
	 */
	private Vertice getProximo(Set<Vertice> adjacentes) {

		Vertice verticeRetorno = null;

		for (Vertice v : adjacentes) {
			if (!v.isVisitado()) {
				verticeRetorno = v;
				break;
			}

		}
		return verticeRetorno;
	}

	@Override
	public void buscaProfundidade() {
		Vertice verticeInicial = this.getNaoVisitado();

		while (verticeInicial != null) {
			this.buscaEmProfundidadeVertice(verticeInicial);
			verticeInicial = this.getNaoVisitado();
		}
	}

	/*
	 * Retorna um vertice nao visitado do conjunto de vertices do grafo
	 */
	public Vertice getNaoVisitado() {
		for (Vertice vertice : this.vertices) {
			if (vertice.isVisitado() == false) {
				return vertice;
			}
		}

		return null;
	}

	/*
	 * Executa a busca em profundidade a partide de um vertice especifico
	 */
	public void buscaEmProfundidadeVertice(Vertice v) {
		visitados = new ArrayList<>();
		explorados = new ArrayList<>();

		Stack<Vertice> pilha = new Stack<Vertice>();
		v.setVisitado(true);
		this.visitados.add(v);
		pilha.push(v);

		while (!pilha.isEmpty()) {
			Set<Vertice> adjacentes = this.getAdjacentes(pilha.lastElement());
			Vertice w = getProximo(adjacentes);
			if (w != null) {
				w.setVisitado(true);
				this.visitados.add(w);
				pilha.push(w);
			} else {
				this.explorados.add(pilha.lastElement());
				pilha.pop();
			}
		}
	}

	/*
	 * Imprime o grafo
	 */
	@Override
	public String toString() {

		String retorno = "";

		for (Vertice v : vertices) {
			retorno += v.toString() + "[ ";

			Set<Vertice> adjacentes = this.getAdjacentes(v);

			for (Vertice adj : adjacentes) {
				retorno += adj.toString() + " ";
				if (adj.isVisitado()) {
					retorno += "(*) ";
				} else {
					retorno += "( ) ";
				}
			}

			retorno += "]\n";

		}

		retorno += "\n";
		retorno += "Ordem Visitados: " + this.visitados.toString();
		retorno += "\n";
		retorno += "Ordem Explorados: " + this.explorados.toString();

		return retorno;
	}

	@Override
	public boolean ehRegular() {
		Set<Vertice> aux = getAdjacentes(vertices.iterator().next());
		for (Vertice vertice : this.vertices) {
			if (this.getAdjacentes(vertice).size() == aux.size()) {
				continue;
			} else {
				return false;
			}
		}

		return true;

	}

	@Override
	public boolean ehConexo() {
		for (Vertice vertice : vertices) {
			vertice.setVisitado(false);
		}
		Vertice v = this.getNaoVisitado();
		int conexo = 0;
		while (v != null) {
			buscaLarguraVertice(v);
			v = getNaoVisitado();
			conexo++;
		}
		if (conexo - 1 == 0) {
			System.out.println("O grafo é conexo");
			return true;
		} else {
			System.out.println("O grafo possui " + (conexo) + " componentes conexas");
			return false;
		}
	}

	@Override
	public void buscaLargura() {
		Vertice v = this.getNaoVisitado();
		while (v != null) {
			buscaLarguraVertice(v);
			v = getNaoVisitado();
		}
	}

	public void buscaLarguraVertice(Vertice v) {

		Queue<Vertice> fila = new LinkedList<Vertice>();
		v.setVisitado(true);
		fila.add(v);
		visitados.add(v);
		while (!fila.isEmpty()) {
			Set<Vertice> aux = getAdjacentes(fila.peek());
			for (Vertice w : aux) {
				if (!w.isVisitado()) {
					w.setVisitado(true);
					visitados.add(w);
					fila.add(w);
				}
			}
			explorados.add(fila.poll());

		}
	}

	public Set<Aresta> prim() {
		Set<Vertice> conjuntoS = new HashSet<Vertice>();
		Set<Aresta> arvore = new HashSet<>();
		conjuntoS.add(vertices.iterator().next());
		while (!conjuntoS.containsAll(vertices)) {
			Aresta aresta = menorAresta(conjuntoS);
			conjuntoS.add(this.arestaTocando(conjuntoS, aresta));
			arvore.add(aresta);
		}
		double valorArvore = 0;
		for (Aresta aresta : arvore) {
			valorArvore += aresta.getPeso();
		}
		System.out.println("O valor da arvore geradora minima é de: " + valorArvore);
		return arvore;

	}

	public Aresta menorAresta(Set<Vertice> conjuntoS) {
		double menorValor = 99999999.0;
		Aresta menorAresta = null;
		for (Vertice v : conjuntoS) {
			Set<Vertice> aux = this.getAdjacentes(v);
			for (Vertice w : aux) {
				if (!conjuntoS.contains(w)) {
					double peso = this.retornarPeso(v, w);
					if (peso < menorValor) {
						menorValor = peso;
						menorAresta = this.getAresta(v, w);
					}
				}

			}
		}
		return menorAresta;
	}

	public double retornarPeso(Vertice a, Vertice b) {
		for (Aresta aresta : arestas) {
			if (aresta.getA().equals(a) && aresta.getB().equals(b)) {
				return aresta.getPeso();
			} else if (aresta.getA().equals(b) && aresta.getB().equals(a)) {
				return aresta.getPeso();
			}
		}
		return 0;
	}

	public Aresta getAresta(Vertice a, Vertice b) {
		for (Aresta aresta : arestas) {
			if (aresta.getA().equals(a) && aresta.getB().equals(b)) {
				return aresta;
			} else if (aresta.getA().equals(b) && aresta.getB().equals(a)) {
				return aresta;
			}
		}
		return null;
	}

	public Vertice arestaTocando(Set<Vertice> conjuntoS, Aresta aresta) {
		if (conjuntoS.contains(aresta.getA()) && !conjuntoS.contains(aresta.getB())) {
			return aresta.getB();
		} else if (conjuntoS.contains(aresta.getB()) && !conjuntoS.contains(aresta.getA())) {
			return aresta.getA();
		}
		return null;
	}

	public void menorCaminho(Vertice v) {
		Set<Vertice> conjuntoS = new HashSet<>();
		conjuntoS.add(v);
		for (Vertice vertice : vertices) {
			if (vertice.getNome().equals(v.getNome())) {
				vertice.setDist(0);
				vertice.setPath(null);
			} else {
				vertice.setDist(9999999);
				vertice.setPath(null);
			}
		}
		while (!conjuntoS.containsAll(vertices)) {
			Vertice u = this.getProximo(conjuntoS);
			u.setVisitado(true);
			visitados.add(u);
			Set<Vertice> adjacentes = this.getAdjacentes(u);
			for (Vertice w : adjacentes) {
				if (w.getDist() > u.getDist() + this.retornarPeso(w, u)) {
					w.setDist(u.getDist() + this.retornarPeso(u, w));
					w.setPath(u);
				}
			}
			Vertice aux = this.menorDistancia(conjuntoS);
			conjuntoS.add(aux);
			explorados.add(aux);

		}

		System.out.printf("Vertice:\tS\tdist:\t       path:\n");
		for (Vertice w : vertices) {
			if (w.getPath() == null) {
				System.out.printf("   %s\t\tSim\t%5.2f\t        %s\n", w.getNome(), w.getDist(), "-");
			} else {
				System.out.printf("   %s\t\tSim\t%5.2f\t        %s\n", w.getNome(), w.getDist(), w.getPath().getNome());
			}
		}

	}

	// retorna o mais proximo que nao pertence ao conjunto S
	public Vertice menorDistancia(Set<Vertice> conjuntoS) {
		double menor = 99999;
		Vertice aux = null;
		for (Vertice v : vertices) {
			if (!conjuntoS.contains(v)) {
				if (menor >= v.getDist()) {
					aux = v;
					menor = v.getDist();
				}
			}
		}
		return aux;
	}

	public List<Vertice> getExplorados() {
		return explorados;
	}

	public void inverterArestas() {
		for (Aresta aresta : arestas) {
			aresta.inverterAresta();
		}

	}

	public int ehFortementeConexo() {
		buscaProfundidade();
		Vertice ultimo = explorados.get(explorados.size() - 1);
		for (Vertice vertice : this.vertices) {
			vertice.setVisitado(false);
		}
		this.inverterArestas();
		this.buscaEmProfundidadeVertice(ultimo);
		this.inverterArestas();
		boolean conexo = true;
		for (Vertice v : vertices) {
			if (!explorados.contains(v)) {
				conexo = false;
			}
		}
		return conexo ? 1 : 0;
	}

	public void gerarDependencia() {
		for (Vertice v : this.vertices) {
			Set<Vertice> dependentes = getAdjacentes(v);
			for (Vertice vertice : dependentes) {
				vertice.setDependencia(vertice.getDependencia() + 1);
			}
		}
	}

	public String ordenacaoTopologica() {
		String ordem = "";
		gerarDependencia();
		Queue<Vertice> independentes = new LinkedList<>();
		for (Vertice vertice : vertices) {
			if (vertice.getDependencia() == 0) {
				independentes.add(vertice);
			}
		}
		while (!independentes.isEmpty()) {
			Vertice n = independentes.poll();
			ordem += n.getNome() + " ";
			Set<Vertice> adjacentes = getAdjacentes(n);
			for (Vertice vertice : adjacentes) {
				vertice.setDependencia(vertice.getDependencia() - 1);
				if (vertice.getDependencia() == 0) {
					independentes.add(vertice);
				}
			}

		}
		String[] test = ordem.split(" ");
		if (test.length != vertices.size()) {
			ordem = "Ordenacao nao e possivel";
		}

		return ordem;
	}

	public List<Vertice> getIndependentes() {
		List<Vertice> independentes = new ArrayList<>();
		for (Vertice v : vertices) {
			if (v.getDependencia() == 0) {
				independentes.add(v);
			}
		}
		return independentes;
	}

	public String ordenacaoAgrupada(int tmnGrupo) {
		List<String> semestres = new ArrayList<>();
		String ordem = "";
		gerarDependencia();
		List<Vertice> independentes = new ArrayList<>();
		for (Vertice vertice : vertices) {
			if (vertice.getDependencia() == 0) {
				independentes.add(vertice);
			}
		}
		while (!independentes.isEmpty()) {
			List<Vertice> aux = new ArrayList<>(independentes);
			for (Vertice v : aux) {
				Set<Vertice> adjacentes = getAdjacentes(v);
				for (Vertice vertice : adjacentes) {
					vertice.setDependencia(vertice.getDependencia() - 1);
					if (vertice.getDependencia() == 0) {
						independentes.add(vertice);
					}
				}
			}
			for (int i = 0; i < aux.size(); i++) {
				ordem = ordem + aux.get(i).getNome() + " ";
				if (ordem.split(" ").length == tmnGrupo) {
					semestres.add(ordem);
					ordem = "";
				}
			}
			semestres.add(ordem);
			ordem = "";
			for(Vertice v : aux) {
				independentes.remove(v);
			}
		}
		int i = 1;
		for (String str : semestres) {
			if(!str.equals("")) {
			ordem = ordem + "Semestre " + (i++) + ": " + str + "\n";
		}}

		
		return ordem;
	}

}
