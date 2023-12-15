
package CapaNegocio;



import java.util.ArrayList;
public class ListaEnlazadaBasadaEnVectores{
    private ArrayList<Nodo> nodos;
    private int primerElemento;
    private int ultimoElemento;

    public ListaEnlazadaBasadaEnVectores() {
        nodos = new ArrayList<>();
        nodos.add(new Nodo(0, -1));
        primerElemento = -1;
        ultimoElemento = -1;
    }
    
    public void agregarElemento(int valor){
        int nuevoindice = nodos.size();
        nodos.add(new Nodo(valor, -1));
        if (ultimoElemento == -1) {
            primerElemento = nuevoindice;
            ultimoElemento = nuevoindice;
            
            
        }else{
            nodos.get(ultimoElemento).siguiente = nuevoindice;
            ultimoElemento = nuevoindice;
        }
    }
    
    
    public void imprimirLista(){
        int actual = primerElemento;
        while (actual != -1){
            System.out.println(nodos.get(actual).valor + "->");
            actual = nodos.get(actual).siguiente;
            
        }
        System.out.println("Null");
    }
    
    public static void main(String[] args) {
        ListaEnlazadaBasadaEnVectores lista = new ListaEnlazadaBasadaEnVectores();
        lista.agregarElemento(10);
        lista.agregarElemento(20);
        lista.agregarElemento(30);
        lista.imprimirLista();
    }
    
    

}
