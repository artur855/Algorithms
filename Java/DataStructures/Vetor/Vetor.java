package DataStructures.Vetor;

public class Vetor<T> implements IVetor<T>{
    Object[] vetor;
    
    
    public void criarMaior(){
        Object[] novo = new Object[2 * vetor.length];
        for(int i =0 ; i < vetor.length ; i++){
            novo[i] = vetor[i];
            
        }
        vetor = novo;
    }
    
    public Vetor() {
    	vetor = new Object[10];
    }
    
    public Vetor(int tamanhoInicial) {
    	vetor = new Object[tamanhoInicial];
    }

    @Override
    public boolean adicionar(T valor) {
        
        vetor[0] = valor;
        return true;
    }

    @Override
    public boolean adicionar(int posicao, T valor) {
        if (posicao > vetor.length){
           criarMaior();
                   
        }
        vetor[posicao] = valor;
        return true;
    }

    @Override
    public T remover(int posicao) {
        T aux = (T) vetor[posicao];
        vetor[posicao] = null;
        return aux;
    }

    @Override
    public boolean remover(T valor) {
        for(int i =0; i < vetor.length; i++){
            if(vetor[i] == valor){
                vetor[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contem(T valor) {
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == valor){
            	return true;
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return vetor.length;
    }

    @Override
    public void limpar() {
        vetor = new Object[10];
    }

	@Override
	public T obter(int posicao) {
		if(posicao < 0) {
			
            return null;
		}
        else if(posicao > vetor.length) {
        	
            return null;
        }
        return (T) vetor[posicao];
	}
    
    
    
    
}
