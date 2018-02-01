package DataStructures.LinkedList;

public class NoDupEnc<T> {
    private T valor;
    private NoDupEnc<T> proximo;
    private NoDupEnc<T> anterior;
    
    public NoDupEnc (T valor){
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
    public NoDupEnc (T valor, NoDupEnc<T> proximo, NoDupEnc<T> anterior){
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDupEnc<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDupEnc<T> proximo) {
        this.proximo = proximo;
    }

    public NoDupEnc<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDupEnc<T> anterior) {
        this.anterior = anterior;
    }
  
}
