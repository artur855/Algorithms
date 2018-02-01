package DataStructures.Stack;

import java.util.Iterator;

public class IteratorPilha<T> implements Iterator<T> {
	private NoPilha<T> aux;

	public IteratorPilha(NoPilha<T> inicio) {
		this.aux = inicio;
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
