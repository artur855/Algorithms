package DataStructures.BinarySearchTree;

public interface IArvore<K, V> {
	No<K, V> inserir(K chave, V valor);

	No<K, V> obterRaiz();

	No<K, V> obterNo(K chave);

	No<K, V> remover(K chave);

	boolean contem(K chave);

	void obterTodosPreOrdem(No<K, V> no);

	void obterTodosPosOrdem(No<K, V> no);

	void obterTodosEmOrdem(No<K, V> no);

}
