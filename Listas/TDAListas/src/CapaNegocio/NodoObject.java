package CapaNegocio;

public class NodoObject {
    
    Object dato;
    NodoObject enlace;
    
    public NodoObject() {
        this.enlace = null;
    }
    
    public NodoObject(Object dato, NodoObject enlace) {
        this.dato = dato;
        this.enlace = enlace;
    }

    public Object getDato() {
        return this.dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoObject getEnlace() {
        return this.enlace;
    }

    public void setEnlace(NodoObject enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "dato = " + dato + " --> enlace = " + enlace;
    }
    
}