package Negocio2;

import java.io.Serializable;

public class NodoDobleG <TipoDato> implements Serializable {
    
    TipoDato Dato;
    NodoDobleG<TipoDato> EnlaceIzq;
    NodoDobleG<TipoDato> EnlaceDer;
    
    public NodoDobleG() {
        this.EnlaceIzq = null;
        this.EnlaceDer = null;
    }
    
    public NodoDobleG(TipoDato Dato) {
        this.Dato = Dato;
    }

    public NodoDobleG(TipoDato Dato, NodoDobleG<TipoDato> EnlaceIzq, NodoDobleG<TipoDato> EnlaceDer) {
        this.Dato = Dato;
        this.EnlaceIzq = EnlaceIzq;
        this.EnlaceDer = EnlaceDer;
    }

    public TipoDato getDato() {
        return Dato;
    }

    public void setDato(TipoDato Dato) {
        this.Dato = Dato;
    }

    public NodoDobleG<TipoDato> getEnlaceIzq() {
        return EnlaceIzq;
    }

    public void setEnlaceIzq(NodoDobleG<TipoDato> EnlaceIzq) {
        this.EnlaceIzq = EnlaceIzq;
    }

    public NodoDobleG<TipoDato> getEnlaceDer() {
        return EnlaceDer;
    }

    public void setEnlaceDer(NodoDobleG EnlaceDer) {
        this.EnlaceDer = EnlaceDer;
    }

    @Override
    public String toString() {
        return (Dato + "");
    }
    
}
