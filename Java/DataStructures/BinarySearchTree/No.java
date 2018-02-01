package DataStructures.BinarySearchTree;

public class No<K, V> {
	private No<K, V> pai;
	private No<K, V> filhoEsq;
	private No<K, V> filhoDir;
	private K chave;
	private V valor;

	public No(K chave, V valor) {
		this.chave = chave;
		this.valor = valor;
		this.pai = null;
		this.filhoEsq = null;
		this.filhoDir = null;
	}

	public No(K chave, V valor, No<K, V> pai) {
		this.chave = chave;
		this.valor = valor;
		this.pai = pai;
		this.filhoEsq = null;
		this.filhoDir = null;
	}

	public No<K, V> getPai() {
		return pai;
	}

	public void setPai(No<K, V> pai) {
		this.pai = pai;
	}

	public No<K, V> getFilhoEsq() {
		return filhoEsq;
	}

	public void setFilhoEsq(No<K, V> filhoEsq) {
		this.filhoEsq = filhoEsq;
	}

	public No<K, V> getFilhoDir() {
		return filhoDir;
	}

	public void setFilhoDir(No<K, V> filhoDir) {
		this.filhoDir = filhoDir;
	}

	public K getChave() {
		return chave;
	}

	public void setChave(K chave) {
		this.chave = chave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public boolean ehFolha() {
		return this.filhoDir == null && this.filhoEsq == null;
	}

	public boolean ehRaiz() {
		return this.pai.equals(null);
	}
}
