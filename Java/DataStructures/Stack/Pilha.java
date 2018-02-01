package DataStructures.Stack;

import java.util.Iterator;

public class Pilha<T> implements IPilha<T>{
	private NoPilha<T> topo;
	private int tamanho;
	public Pilha() {
		this.topo = null;
		tamanho = 0;
	}
	@Override
	public Iterator<T> iterator() {
		IteratorPilha<T> it = new IteratorPilha<T>(topo);
		return it;
	}

	@Override
	public void empilhar(T elemento) {
		NoPilha<T> novoNo = new NoPilha<>(elemento);
		if(tamanho == 0){
			topo = novoNo;
		} else{
			novoNo.setProximo(topo);
			topo = novoNo;
		}
		tamanho++;
	}

	@Override
	public T desempilhar() {
		T valor = (T) topo.getValor();
		topo = topo.getProximo();
		tamanho--;
		return valor;
	}

	@Override
	public T topo() {
		return (T) topo.getValor();
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public boolean vazia() {
		return tamanho==0;
	}

	@Override
	public void limpar() {
		topo = new NoPilha<T>(null);
		tamanho = 0;
	}
}
