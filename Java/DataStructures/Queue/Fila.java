package DataStructures.Queue;

import java.util.Iterator;

public class Fila<T> implements IFila<T> {
	private NoFila<T> inicio, fim;
	private int tamanho;

	public Fila() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public Iterator<T> iterator() {
		IteratorFila<T> it = new IteratorFila<T>(inicio);

		return it;
	}

	@Override
	public void enfileirar(T elemento) {
		NoFila<T> novoNo = new NoFila<T>(elemento);
		if (tamanho == 0) {
			inicio = fim = novoNo;

		} else {
			fim.setProximo(novoNo);
			fim = novoNo;
		}
		tamanho++;
	}

	@Override
	public T desenfileirar() {
		if (tamanho == 0) {
			throw new NullPointerException();
		}
		T valor = inicio.getValor();
		inicio = inicio.getProximo();
		tamanho--;
		return valor;
	}

	@Override
	public T primeiro() {
		return inicio.getValor();
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public boolean vazia() {
		return tamanho == 0;
	}

	@Override
	public void limpar() {
		inicio = fim = new NoFila<T>(null);
		tamanho = 0;
	}

	public NoFila<T> primeiroNo() {
		return inicio;
	}

}
