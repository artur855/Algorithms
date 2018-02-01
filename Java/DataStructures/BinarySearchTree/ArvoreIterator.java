package DataStructures.BinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreIterator<K, V> implements Iterator<V> {
	private Queue<No<? super K, V>> fila;

	public ArvoreIterator(ArvoreBB<? super K,V> arvore) {
		this.fila = new LinkedList<No<? super K, V>>();
		fila.add(arvore.obterRaiz());
	}

	@Override
	public boolean hasNext() {
		return !fila.isEmpty();
	}

	@Override
	public V next() {
		No<? super K, V> no = fila.poll();
		if (no != null) {
			if (no.getFilhoEsq() != null) {
				fila.add(no.getFilhoEsq());
			}
			if (no.getFilhoDir() != null) {
				fila.add(no.getFilhoDir());
			}
			return no.getValor();
		}
		return null;
	}
}
