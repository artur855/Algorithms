package DataStructures.LinkedList;

import java.util.Iterator;

public class Iterrattor<T> implements Iterator<T> {
	private ListDupEnc<T> list;
	private int tamanho = -1;

	public Iterrattor(ListDupEnc<T> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return tamanho < list.tamanho();
	}

	@Override
	public T next() {
		tamanho++;
		return list.obter(tamanho);
	}

}
