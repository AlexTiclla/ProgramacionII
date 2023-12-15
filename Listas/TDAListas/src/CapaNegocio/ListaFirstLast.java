package CapaNegocio;

public class ListaFirstLast {

    Nodo F;
    Nodo L;
    int cant;
    
    public ListaFirstLast() {
        this.F = null;
        this.L = null;
        this.cant = 0;
    }
    
    public boolean vacia() {
        return (L == null);
    }
    
    public void insertarPrimero(int elemento) {
        if (vacia()) {
            Nodo nodo = new Nodo();
            nodo.setDato(elemento);
            F = nodo;
            L = nodo;
            
        } else {
            Nodo nodo = new Nodo();
            nodo.setDato(elemento);
            nodo.setEnlace(F);
            F = nodo;
            
        }
        
    }
    
    public int obtenerPrimero(){
        if (!vacia()) {
            
            return this.F.getDato();
        }else{
            throw new RuntimeException("La lista esta vacia");
        }
    }
    
    public int obtenerUltimo(){
          if (!vacia()) {
            
            return this.L.getDato();
        }else{
            throw new RuntimeException("La lista esta vacia");
        }
    }
    
    
    

    public void insertarUltimo(int elemento) {
        if (vacia()) {
            Nodo nodo = new Nodo();
            nodo.setDato(elemento);
            F = nodo;
            this.L = nodo;
            
        } else {
            Nodo nodo = new Nodo();
            nodo.setDato(elemento);
            this.L.setEnlace(nodo);
            this.L = nodo;
            
        }
        
    }
    
    public void eliminarUltimo() {
        if (!this.vacia()) {
            
            if (L != F) {
                
                Nodo aux = F;
                while (aux.getEnlace() != this.L) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(null);
                this.L = aux;
            } else {
                this.L = null;
                this.F = null;
                
            }
            
        }
    }
    
    public void eliminarPrimero(){
        if (!vacia()) {
            Nodo aux = F;
            F = F.getEnlace();
            aux.setEnlace(null);
            
        }
    }
    
    @Override
    public String toString() {
        String S = "Lista-> <";
        Nodo aux = F;
        while (aux != null) {
            S = S + aux + ",";
            aux = aux.getEnlace();            
        }
        S = S + ">";
        return S;
    }
    
    public static void main(String[] args) {
        ListaFirstLast lista = new ListaFirstLast();
        lista.insertarUltimo(10);
        lista.insertarUltimo(11);
        lista.insertarUltimo(12);
        lista.insertarUltimo(13);
        lista.insertarUltimo(14);
        lista.insertarPrimero(12);
        System.out.println(lista.toString());
        lista.eliminarUltimo();
        lista.eliminarUltimo();
        lista.eliminarUltimo();
        lista.insertarUltimo(10);
        System.out.println(lista.toString());
        lista.eliminarPrimero();
  
      
        System.out.println(lista.toString());
        
    }
    
}
