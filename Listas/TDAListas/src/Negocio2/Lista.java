package Negocio2;

import CapaNegocio.Nodo;

public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (L == null);
    }

    public void insertar(int elemento) {
        if (vacia()) { // La lista esta vacia
            Nodo p = new Nodo();
            p.setDato(elemento);
            L = p;
            cant++;
        } else { // Hay mas elementos en la lista
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null && aux.getDato() <= elemento) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { // Insertamos en la cabeza de la lista
                Nodo p = new Nodo();
                p.setDato(elemento);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {  // Insertamos en el cuerpo de la lista
                if (ant.getDato() != elemento) {
                    Nodo p = new Nodo();
                    p.setDato(elemento);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;
                }
            }
        }
    }

    public void insertarRepetidos(int elemento) {
        if (vacia()) { // La lista esta vacia
            Nodo p = new Nodo();
            p.setDato(elemento);
            L = p;
            cant++;
        } else { // Hay mas elementos en la lista
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { // Insertamos en la cabeza de la lista
                Nodo p = new Nodo();
                p.setDato(elemento);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {  // Insertamos en el cuerpo de la lista
                Nodo p = new Nodo();
                p.setDato(elemento);
                ant.setEnlace(p);
                p.setEnlace(aux);
                cant++;
            }
        }
    }

    public void eliminar(int elemento) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while (aux != null && aux.getDato() != elemento) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (aux != null) {
                if (ant == null) {
                    L = L.getEnlace();
                    cant--;
                } else {
                    ant.setEnlace(aux.getEnlace());
                    cant--;
                }
            }
        }
    }

    public boolean pertenece(int elemento) {
        boolean x = false;
        Nodo aux = L;
        while (aux != null && aux.getDato() != elemento) {
            aux = aux.getEnlace();
        }
        if (aux != null) {
            x = true;
        }
        return x;
    }

    public int getDato(int pos) {
        Nodo aux = L;
        for (int i = 1; i < pos; i++) {
            aux = aux.getEnlace();
        }
        return aux.getDato();
    }
    
    public int longitud() {
        return cant;
    }

    /* ==================================================================================
       ELIMINAR ELEMENTOS UNICOS  
    
       ENTRADA     --> LISTA = [1, 1, 2, 3, 3, 4, 5, 5, 7]
       RESUTADO    --> LISTA = [1, 1, 3, 3, 5, 5]
       ================================================================================== */
    
    public void eliminarUnicos() {
        if (!vacia()) {
            if (L.getEnlace() == null) {
                L = null;
                cant = 0;
            }
            Nodo ant = null;
            Nodo aux = L;
            while (aux.getEnlace() != null) {
                if (ant == null) {
                    if (aux.getDato() != aux.getEnlace().getDato()) {
                        L = aux.getEnlace();
                        ant = null;
                        aux = L;
                        cant--;
                    } else {
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                } else {
                    if (ant.getDato() != aux.getDato() && aux.getDato() != aux.getEnlace().getDato()) {
                        ant.setEnlace(aux.getEnlace());
                        aux = ant.getEnlace();
                        cant--;
                    } else {
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }
            }
            if (ant != null && ant.getDato() != aux.getDato()) {
                ant.setEnlace(null);
                cant--;
            }
        }
    }
    
    /* ==================================================================================
        INTERCALAR ELEMENTOS DE UNA LISTA
        SI ES IMPAR --> LISTA = [1, 2, 3, 4, 5, 6, 7]
        RESUTADO    --> LISTA = [1, 3, 2, 5, 4, 7, 6]
    
        SI ES PAR   --> LISTA = [1, 2, 3, 4, 5, 6, 7, 8]
        RESUTADO    --> LISTA = [2, 1, 4, 3, 6, 5, 8, 7]
       ================================================================================== */
    
    public void intercalar() {
        if (cant > 1) {
            Nodo ant;
            Nodo aux;
            if (cant % 2 == 0) {
                ant = null;
                aux = L;
            } else {
                ant = L;
                aux = ant.getEnlace();
            }
            while (aux != null) {
                Nodo sig = aux.getEnlace();
                aux.setEnlace(sig.getEnlace());
                sig.setEnlace(aux);
                if (ant == null) {
                    L = sig;
                } else {
                    ant.setEnlace(sig);
                }
                ant = aux;
                aux = aux.getEnlace();
            }
        }
    }
    
    public void intercalar2() {
        Nodo ant, aux;
        if (cant % 2 == 1) {
            ant = L;
            aux = ant.getEnlace();
        } else {
            ant = null;
            aux = L;
        }
        while (aux != null) {
            Nodo sig = aux.getEnlace();
            aux.setEnlace(sig.getEnlace());
            sig.setEnlace(aux);
            if (ant == null) {
                L = sig;
            } else {
                ant.setEnlace(sig);
            }
            ant = aux;
            aux = aux.getEnlace();
        }
    }

    // ==================================================================================
    // ==============================  METODOS RECURSIVOS  ==============================
    // ==================================================================================
    
    public void invertir() {
        invertirR(L);
    }

    private void invertirR(Nodo P) {
        if (P == null) { // Primer caso base
            // nada
        } else if (P.getEnlace() == null) { // Segundo caso base
            L = P;
        } else {  // Caso general
            invertirR(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);
        }
    }

    // =================================================================================
    // =================================================================================
    
    @Override
    public String toString() {
        String lista = "L->";
        Nodo aux = L;
        while (aux != null) {
            lista = lista + "[" + aux.getDato() + "]->";
            aux = aux.getEnlace();
        }
//        if (lista.length() > 7) {
//            lista = lista.substring(0, lista.length() - 2);
//        }
        lista = lista + "null";
        return lista;
    }

}
