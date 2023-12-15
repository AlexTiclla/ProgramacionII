package Negocio2;

public class NodoDoble {
    
    int Dato;
    NodoDoble EnlaceIzq;
    NodoDoble EnlaceDer;
    
    public NodoDoble() {
        this.EnlaceIzq = null;
        this.EnlaceDer = null;
    }
    
    public NodoDoble(int Dato) {
        this.Dato = Dato;
    }

    public NodoDoble(int Dato, NodoDoble EnlaceIzq, NodoDoble EnlaceDer) {
        this.Dato = Dato;
        this.EnlaceIzq = EnlaceIzq;
        this.EnlaceDer = EnlaceDer;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public NodoDoble getEnlaceIzq() {
        return EnlaceIzq;
    }

    public void setEnlaceIzq(NodoDoble EnlaceIzq) {
        this.EnlaceIzq = EnlaceIzq;
    }

    public NodoDoble getEnlaceDer() {
        return EnlaceDer;
    }

    public void setEnlaceDer(NodoDoble EnlaceDer) {
        this.EnlaceDer = EnlaceDer;
    }

    @Override
    public String toString() {
        return (Dato + "");
    }
    
}
