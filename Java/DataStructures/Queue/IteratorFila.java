package DataStructures.Queue;

import java.util.Iterator;

public class IteratorFila<T> implements Iterator<T> {
	private NoFila<T> aux;

	public IteratorFila(NoFila<T> no) {
		this.aux = no;
	}

	@Override
	public boolean hasNext() {
		return aux != null;
	}

	@Override
	public T next() {
		T valor = aux.getValor();
		aux = aux.getProximo();
		return valor;
	}

}
