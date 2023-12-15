
package Negocio1;

import java.io.Serializable;

public class NodoGP <TipoDato> implements Serializable {
    
    TipoDato dato;
    NodoGP<TipoDato> enlace;
    
    public NodoGP() {
        this.enlace = null;
    }
    
    public NodoGP(TipoDato dato) {
        this.dato = dato;
        this.enlace = null;
    }

    public TipoDato getDato() {
        return this.dato;
    }

    public void setDato(TipoDato dato) {
        this.dato = dato;
    }

    public NodoGP<TipoDato> getEnlace() {
        return this.enlace;
    }

    public void setEnlace(NodoGP<TipoDato> enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return  (dato + "" + '\n');
    }
    
}
