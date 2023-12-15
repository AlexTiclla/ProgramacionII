/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author aticl
 */
public class NodoD {
    NodoD anterior;
    NodoD siguiente;
    int dato;
    
    public NodoD(){
        this.anterior = null;
        this.siguiente = null;       
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoD siguiente) {
        this.siguiente = siguiente;
    }

    public NodoD getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoD anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NodoD{" + "dato=" + getDato() + '}';
    }
    
//    @Override
//    public String toString() {
//        return "NodoD{" + "anterior=" + anterior + ", dato=" + dato + ", siguiente=" + siguiente +  '}';
//        
//        
//        
//        
//    }

    public static void main(String[] args) {
        NodoD nodo1 = new NodoD();
        NodoD nodo2 = new NodoD();
        NodoD nodo3 = new NodoD();
        
        nodo1.setDato(1);
        nodo2.setDato(2);
        nodo3.setDato(3);
        nodo1.setSiguiente(nodo2);
        nodo2.setAnterior(nodo1);
        nodo2.setSiguiente(nodo3);
        nodo3.setAnterior(nodo2);
        
        System.out.println(nodo1.getSiguiente().toString());
        
   
    }
    
    
    
    
    
    
}
