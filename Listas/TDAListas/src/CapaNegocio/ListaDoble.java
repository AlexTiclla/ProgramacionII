/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author aticl
 */
public class ListaDoble {

    NodoD Primero;
    NodoD Ultimo;
    int cant;

    public ListaDoble() {
        this.Primero = null;
        this.Ultimo = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (Primero == null);

    }

    // Inserta un dato ordenadamente
    public void insertar(int dato) {
        if (vacia()) {
            insertarPrimero(dato);
        } else {
            NodoD aux = Primero;
            while ((aux != null) && (aux.getDato() < dato)) {
                aux = aux.getSiguiente();
            }
            if (aux == Primero) {
                if (aux.getDato() != dato) {

                    insertarPrimero(dato);
                }

            } else if (aux == null) {
                insertarUltimo(dato);
            } else if (aux.getDato() != dato) {
                    NodoD nodo = new NodoD();
                    nodo.setDato(dato);
                    aux.getAnterior().setSiguiente(nodo);
                    nodo.setAnterior(aux.getAnterior());
                    aux.setAnterior(nodo);
                    nodo.setSiguiente(aux);
                    cant++;

                }

            

        }

    }

    public void insertarUltimo(int dato) {
        NodoD nodo = new NodoD();
        nodo.setDato(dato);
        if (vacia()) {

            Primero = nodo;
            Ultimo = nodo;

        } else { // > 0

            Ultimo.setSiguiente(nodo);
            nodo.setAnterior(Ultimo);
            Ultimo = nodo;
        }
        cant++;
    }

    // Inserta un dato a la lista en la ultima posicion
    public void insertarPrimero(int dato) {
        NodoD nodo = new NodoD();
        nodo.setDato(dato);
        if (vacia()) {

            Primero = nodo;
            Ultimo = nodo;

        } else { // > 0

            nodo.setSiguiente(Primero);
            Primero.setAnterior(nodo);
            Primero = nodo;

        }
        cant++;
    }
    
    // Metodo que devuelva la cantidad de nodos
    public int cantNodos(){
        int cant = 0;
        NodoD aux = Primero;
        
        while(aux.getSiguiente()!= null){
            cant++;
            aux = aux.getSiguiente();
        
        }
        cant++;
        
        return cant;
    }

    @Override
    public String toString() {
        NodoD aux = Primero;
        String S = "Lista-> [ " + Primero.getAnterior() + "<-->";
        while (aux != null) {
            S = S + aux.getDato() + "<-->";
            aux = aux.getSiguiente();
        }
        S = S + "]";
        return S;
    }

    public static void main(String[] args) {
        ListaDoble listadoble = new ListaDoble();
        listadoble.insertar(7);
        listadoble.insertar(2);
        listadoble.insertar(66);
        listadoble.insertar(10);
       // System.out.println(listadoble.toString());
        listadoble.insertar(3);
        listadoble.insertar(5);
        System.out.println(listadoble.toString());
        System.out.println(listadoble.cantNodos());
        
        

//        listadoble.insertarPrimero(5);
//        listadoble.insertarPrimero(5);
//        System.out.println(listadoble.toString());
    }

}
