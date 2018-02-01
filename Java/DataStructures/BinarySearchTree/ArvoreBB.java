package DataStructures.BinarySearchTree;


import java.util.Iterator;


public class ArvoreBB<K extends Comparable<? super K>, V> implements IArvore<K, V>, Iterable<V> {
	private	No<K, V> raiz;
	public ArvoreBB() {
		raiz = null;
	}

	@Override
	public No<K, V> inserir(K chave, V valor) {
		No<K, V> novoNo = new No<K, V>(chave, valor);
		if (raiz == null){
			raiz = new No<K, V>(chave, valor);
		} else {
			No<K, V> aux = raiz;
			while (!aux.getChave().equals(null) || !aux.getChave().equals(chave)) {

				if (chave.compareTo(aux.getChave()) > 0 && aux.getFilhoDir() == null) {
					aux.setFilhoDir(new No<K, V>(chave, valor, aux));
					break;
				} else if (chave.compareTo(aux.getChave()) < 0 && aux.getFilhoEsq() == null) {
					aux.setFilhoEsq(new No<K, V>(chave, valor, aux));
					break;
				}

				if (chave.equals(aux.getChave())) {
					aux = new No<K, V>(chave, valor, aux.getPai());
					break;
				} else if (chave.compareTo(aux.getChave()) > 0) {
					aux = aux.getFilhoDir();
				} else {
					aux = aux.getFilhoEsq();
				}

			}
		}
		return novoNo;
	}

	@Override
	public No<K, V> obterRaiz() {
		return raiz;
	}

	@Override
	public No<K, V> obterNo(K chave) {
		No<K, V> aux = raiz;
		if (raiz == null) {
			return null;
		}
		while (aux != null && !chave.equals(aux.getChave())) {
			if (chave.compareTo(aux.getChave()) > 0) {
				aux = aux.getFilhoDir();
			} else if (chave.compareTo(aux.getChave()) < 0) {
				aux = aux.getFilhoEsq();
			}
		}
		return aux;
	}
	
	@Override
	public boolean contem(K chave){
		No<K, V> aux = obterNo(chave);
		if(aux != null){
			return true;
		}
		return false;
		
	}
	@Override
	public No<K, V> remover(K chave) {
		No<K, V> aux = obterNo(chave);
		if (raiz == null) {
			return null;
		}
		if (aux.ehFolha()) {
			if (aux.getPai().getFilhoDir().equals(aux)) {
				aux.getPai().setFilhoDir(null);
				aux.setPai(null);
			} else {
				aux.getPai().setFilhoEsq(null);
				aux.setPai(null);
			}
		} else if (aux.getFilhoDir() != null && aux.getFilhoEsq() != null) {
			No<K, V> consec = aux.getFilhoDir();
			while(consec.getFilhoEsq() != null){
					consec = consec.getFilhoEsq();
			}
			K k = consec.getChave();
			V v = consec.getValor();
			remover(consec.getChave());
			aux.setChave(k);
			aux.setValor(v);
			
			
			
		} else if (aux.getFilhoDir() != null && aux.getFilhoEsq() == null) {
			if (aux.getPai().getFilhoDir().equals(aux)) {
				if (aux.getFilhoDir() != null) {
					aux.getPai().setFilhoDir(aux.getFilhoDir());
					aux.setPai(null);
				} else {
					aux.getPai().setFilhoEsq(aux.getFilhoEsq());
					aux.setPai(null);
				}
			} else {
				if (aux.getFilhoDir() != null) {
					aux.getPai().setFilhoDir(aux.getFilhoDir());
					aux.setPai(null);
				} else {
					aux.getPai().setFilhoEsq(aux.getFilhoEsq());
					aux.setPai(null);
				}
			}
		} 
		return aux;
	}

	@Override
	public void obterTodosPreOrdem(No<K, V> no) {
		if(no != null){
			System.out.print(no.getChave() + " ");
			obterTodosPreOrdem(no.getFilhoEsq());
			obterTodosPreOrdem(no.getFilhoDir());
		}
	}

	@Override
	public void obterTodosPosOrdem(No<K, V> no) {
		if(no != null){
			obterTodosPosOrdem(no.getFilhoEsq());
			obterTodosPosOrdem(no.getFilhoDir());
			System.out.print(no.getChave() + " ");
		}
	}

	@Override
	public void obterTodosEmOrdem(No<K, V> no) {
		if(no != null){
			obterTodosEmOrdem(no.getFilhoEsq());
			System.out.print(no.getChave() + " ");
			obterTodosEmOrdem(no.getFilhoDir());
		}
	}

	@Override
	public Iterator<V> iterator() {
		ArvoreIterator<K, V> it = new ArvoreIterator<>(this);
		return (Iterator<V>) it;
	}



}
