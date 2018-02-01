package DataStructures.LinkedList;

public interface ILista<T> extends Iterable<T> {
	public boolean adicionarFim(T valor);

	public boolean adicionar(int posicao, T valor);

	public T obter(int posicao);

	public T remover(int posicao);

	public boolean remover(T valor);

	public boolean contem(T valor);

	public int tamanho();

	public void limpar();

}
