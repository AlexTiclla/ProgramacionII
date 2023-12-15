
package CapaNegocio;

// Implementacion basado en punteros
public class Nodo {
    int dato;
    Nodo enlace;
    
    public Nodo(){
        enlace = null;
    }
    
    public Nodo(int dato){
        this.enlace = null;
        this.dato = dato;
        
    }

    public Nodo(int dato, Nodo enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }
    
    @Override
     public String toString(){
         
      return "" + getDato();
    }
    
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo();
        Nodo nodo2 = new Nodo();
        Nodo nodo3 = new Nodo();
        
        nodo1.setDato(7);
        nodo1.setEnlace(nodo3);
        
        nodo2.setDato(5);
//        nodo2.setEnlace();
        nodo3.setDato(9); 
        nodo3.setEnlace(nodo2);
        System.out.println(nodo1.toString() + nodo1.getEnlace().toString() + nodo1.getEnlace().getEnlace().toString());
        
//        System.out.println(nodo1.toString() + nodo2.toString() + nodo3.toString());
     
        
        
        
    }
    
    
    
    
    
    
    
}
