package Negocio2;

import java.io.Serializable;

public class ListaDobleG<TipoDato extends Comparable> implements Serializable {
    
    NodoDobleG<TipoDato> Inicio;
    NodoDobleG<TipoDato> Fin;
    int cant;

    public ListaDobleG() {
        this.Inicio = null;
        this.Fin = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (cant == 0);
    }

    public void Insertar(TipoDato elemento) {
        if (!Existe(elemento)) {
            NodoDobleG P = new NodoDobleG();
            P.setDato(elemento);
            if (vacia()) {
                Inicio = P;
                Fin = P;
                cant++;
            } else {
                NodoDobleG<TipoDato> Aux = Inicio;
                while (Aux != null && Aux.getDato().compareTo(elemento) < 0) {
                    Aux = Aux.getEnlaceDer();
                }
                if (Aux == Inicio) { // Inserta al inicio de la lista
                    P.setEnlaceDer(Aux);
                    Aux.setEnlaceIzq(P);
                    Inicio = P;
                    cant++;
                } else {  // Inserta en el cuerpo de la lista
                    if (Aux != null) {
                        P.setEnlaceDer(Aux);
                        P.setEnlaceIzq(Aux.getEnlaceIzq());
                        Aux.getEnlaceIzq().setEnlaceDer(P);
                        Aux.setEnlaceIzq(P);
                        cant++;
                    } else {  // Inserta al final de la lista
                        Fin.setEnlaceDer(P);
                        P.setEnlaceIzq(Fin);
                        Fin = P;
                        cant++;
                    }
                }
            }
        }
    }

    public void Eliminar(TipoDato elemento) {
        if (!vacia()) {
            NodoDobleG<TipoDato> Aux = Inicio;
            while (Aux != null && Aux.getDato().compareTo(elemento) != 0) {
                Aux = Aux.getEnlaceDer();
            }
            if (Aux != null) {
                if (Aux.getEnlaceIzq() == null && Aux.getEnlaceDer() != null) { // Elimina el inicio
                    Inicio = Aux.getEnlaceDer();
                    Inicio.setEnlaceIzq(null);
                    cant--;
                } else {
                    if (Aux.getEnlaceDer() != null) {  // Elimina en el cuerpo
                        Aux.getEnlaceIzq().setEnlaceDer(Aux.getEnlaceDer());
                        Aux.getEnlaceDer().setEnlaceIzq(Aux.getEnlaceIzq());
                        cant--;
                    } else {
                        if (Aux.getEnlaceIzq() == null && Aux.getEnlaceDer() == null) { // Elimina si hay un solo elemento
                            Inicio = null;
                            Fin = null;
                            cant--;
                        } else {  // Elimina el final
                            Fin = Aux.getEnlaceIzq();
                            Fin.setEnlaceDer(null);
                            cant--;
                        }
                    }
                }
            }
        }
    }

    public boolean Existe(TipoDato elemento) {
        boolean x = false;
        NodoDobleG<TipoDato> Aux = Inicio;
        while (Aux != null && Aux.getDato().compareTo(elemento) != 0) {
            Aux = Aux.getEnlaceDer();
        }
        if (Aux != null) {
            x = true;
        }
        return x;
    }

    public void InsertarInicio(TipoDato elemento) {
        NodoDobleG<TipoDato> nuevo = new NodoDobleG();
        nuevo.setDato(elemento);
        NodoDobleG Aux = Inicio;
        if (!Existe(elemento)) {
            nuevo.setEnlaceDer(Aux);
            Aux.setEnlaceIzq(nuevo);
            Inicio = nuevo;
            cant++;
        }
    }

    public void InsertarFin(TipoDato elemento) {
        NodoDobleG<TipoDato> nuevo = new NodoDobleG();
        nuevo.setDato(elemento);
        if (!Existe(elemento)) {
            Fin.setEnlaceDer(nuevo);
            nuevo.setEnlaceIzq(Fin);
            Fin = nuevo;
            cant++;
        }
    }

    public void InsertarPorFin(TipoDato elemento) {
        if (!Existe(elemento)) {
            NodoDobleG<TipoDato> Nuevo = new NodoDobleG();
            Nuevo.setDato(elemento);
            if (vacia()) {
                Inicio = Nuevo;
                Fin = Nuevo;
                cant++;
            } else {
                NodoDobleG<TipoDato> Aux = Fin;
                while (Aux != null && Aux.getDato().compareTo(elemento) == 1) {
                    Aux = Aux.getEnlaceIzq();
                }
                if (Aux == Fin) {  // Inserta al final
                    Nuevo.setEnlaceIzq(Aux);
                    Aux.setEnlaceDer(Nuevo);
                    Fin = Nuevo;
                    cant++;
                } else {
                    if (Aux != null) { // Inserta en el cuerpo
                        Nuevo.setEnlaceDer(Aux.getEnlaceDer());
                        Nuevo.setEnlaceIzq(Aux);
                        Aux.getEnlaceDer().setEnlaceIzq(Nuevo);
                        Aux.setEnlaceDer(Nuevo);
                        cant++;
                    } else {
                        Inicio.setEnlaceIzq(Nuevo);
                        Nuevo.setEnlaceDer(Inicio);
                        Inicio = Nuevo;
                        cant++;
                    }
                }
            }
        }
    }
    
    public String Mostrar() {
        String S = "";
        NodoDobleG<TipoDato> Aux = Inicio;
        while (Aux != null) {
            S = S + Aux.toString() + "\n";
            Aux = Aux.getEnlaceDer();
        }
        if (S.length() > 2) {
            S = S.substring(0, S.length() - 3);
        }
        return S;
    }

    @Override
    public String toString() {
        String S = "[ ";
        NodoDobleG<TipoDato> Aux = Inicio;
        while (Aux != null) {
            S = S + Aux.toString() + ", ";
            Aux = Aux.getEnlaceDer();
        }
        if (S.length() > 2) {
            S = S.substring(0, S.length() - 2);
        }
        S = S + " ]";
        return S;
    }
    
}
