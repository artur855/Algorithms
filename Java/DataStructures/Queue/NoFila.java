package DataStructures.Queue;

public class NoFila<T> {
	private T valor;
	private NoFila<T> proximo;
	
	public NoFila(T valor) {
		this.valor = valor;
		this.proximo =null;
	}
	
	public NoFila(T valor, NoFila<T> proximo) {
		this.valor = valor;
		this.proximo =proximo;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public NoFila<T> getProximo() {
		return proximo;
	}
	public void setProximo(NoFila<T> proximo) {
		this.proximo = proximo;
	}
	
	
	
	
	
	
}
