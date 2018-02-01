package DataStructures.LinkedList;

import java.util.Iterator;


public class ListDupEnc<T> implements IListaDuplamenteEncadeada<T> {

    NoDupEnc<T> inicio;
    NoDupEnc<T> fim;
    int tamanho;
	private Iterrattor<T> iterator;

    public ListDupEnc() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    
    @Override
    public boolean adicionarNoInicio(T valor) {
        NoDupEnc<T> novo = new NoDupEnc<>(valor);
            
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            tamanho ++;
        return true;
    }

    @Override
    public boolean removerDoInicio() {
        if (tamanho == 0) {
            throw new NullPointerException("A lista esta vazia");
        }else if (tamanho == 1){
            inicio = fim = null;
        }else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        tamanho--;
        return true;

    }

    @Override
    public boolean removerDoFim() {
        if (tamanho == 0) {
            throw new NullPointerException("A lista esta vazia");
        } else if (tamanho == 1){
            inicio = fim = null;
        } else {
        fim = fim.getAnterior();
        fim.setProximo(null);
        tamanho--;
        }
        return true;
    }

    @Override
    public boolean adicionarFim(T valor) {

        NoDupEnc<T> aux = new NoDupEnc<T>(valor);
        if (tamanho == 0) {
            inicio = fim = aux;
            inicio.setProximo(aux);
            fim.setAnterior(aux);
        } else {
            fim.setProximo(aux);
            aux.setAnterior(fim);
            fim = aux;

        }
        tamanho++;
        return true;
    }

    @Override
    public boolean adicionar(int posicao, T valor) {
        NoDupEnc<T> novo = new NoDupEnc<>(valor);
        if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("O indície não existe");
        } else if (posicao == 0) {
            adicionarNoInicio(valor);
        } else if (posicao == tamanho-1){
            adicionarFim(valor);
        }else {
            NoDupEnc<T> aux = acharNo(posicao);
            aux.getAnterior().setProximo(novo);
            novo.setProximo(aux);
            novo.setAnterior(aux.getAnterior());
        }
        tamanho++;
        return true;

    }

    @Override
    public T obter(int posicao) {
        if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("O indice nao existe");
        } else if (posicao == 0) {
            return (T) inicio.getValor();
        } else if (posicao == tamanho-1){
            return (T) fim.getValor();
        } 
         
        return acharNo(posicao).getValor();
    }

    @Override
    public T remover(int posicao) {
        T valor = inicio.getValor();

        if (posicao >= tamanho) {
            throw new IndexOutOfBoundsException("O indice nao existe");
        } else if (posicao == 0) {
            removerDoInicio();
        } else if (posicao == tamanho - 1) {
            removerDoFim();
        } else {
            NoDupEnc<T> aux = acharNo(posicao);
            aux.getProximo().setAnterior(aux.getAnterior());
            aux.getAnterior().setProximo(aux.getProximo());
            tamanho--;

        }
        return valor;
    }

    @Override
    public boolean remover(Object obj) {

        NoDupEnc<T> aux = inicio;
        for (int i = 0; i < tamanho; i++) {
            if (aux.getProximo().equals(obj)) {
                aux.getProximo().setAnterior(aux.getAnterior());
                aux.getAnterior().setProximo(aux.getProximo());
                tamanho--;
                return true;
            } else {
                aux = aux.getProximo();
            }
        }
        return false;
    }

    @Override
    public boolean contem(Object obj) {
        NoDupEnc<T> x = inicio;
        if (tamanho == 0) {
            throw new IndexOutOfBoundsException("O indice nao existe");
        } 
        for (int i = 0; i < tamanho; i++) {
            if (x.getValor().equals(obj)) {
                return true;
            } else {
                x = x.getProximo();
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void limpar() {
        inicio = fim = null;
        tamanho = 0;
    }
    
    private NoDupEnc<T> acharNo(int indice) {
		NoDupEnc<T> aux ;
		
		if (indice > tamanho/2) {
			
			aux = fim;
			
			for (int i = tamanho; i > indice; i--)
				aux = aux.getAnterior();
					
		} else {
			
			aux = inicio;

			for (int i = 0; i < indice; i++)
				aux = aux.getProximo();
		}
		
		return aux;
	}

    
    public Object[] converterArray(){
        Object[] array = new Object[tamanho];
        NoDupEnc<T> aux = inicio;
        for (int i = 0; i < tamanho; i++){
            array[i] = aux.getValor();
            aux = aux.getProximo();
        }
        
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        iterator = new Iterrattor<T>(this);
        return iterator;
    }

    

    
}
