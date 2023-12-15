package Negocio2;

public class ListaDoble {

    NodoDoble Inicio;
    NodoDoble Fin;
    int cant;

    public int getCant() {
        return cant;
    }

    public ListaDoble() {
        this.Inicio = null;
        this.Fin = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (cant == 0);
    }
    
        // Metodo que devuelva la cantidad de nodos
    public int cantNodos(){
        int cant = 0;
        NodoDoble aux = Inicio;
        
        while(aux.getEnlaceDer() != Inicio){
            cant++;
            aux = aux.getEnlaceDer();
                    
        
        }
        cant++;
        return cant;
    }

    public void Insertar(int elemento) {
        if (!Existe(elemento)) {
            NodoDoble P = new NodoDoble();
            P.setDato(elemento);
            if (vacia()) {
                Inicio = P;
                Fin = P;
                cant++;
            } else {
                NodoDoble Aux = Inicio;
                while (Aux != null && Aux.getDato() < elemento) {
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

    public void Eliminar(int elemento) {
        if (!vacia()) {
            NodoDoble Aux = Inicio;
            while (Aux != null && Aux.getDato() != elemento) {
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

    public boolean Existe(int elemento) {
        boolean x = false;
        NodoDoble Aux = Inicio;
        while (Aux != null && Aux.getDato() != elemento) {
            Aux = Aux.getEnlaceDer();
        }
        if (Aux != null) {
            x = true;
        }
        return x;
    }

    public void InsertarInicio(int elemento) {
        NodoDoble nuevo = new NodoDoble();
        nuevo.setDato(elemento);
        NodoDoble Aux = Inicio;
        if (!Existe(elemento)) {
            nuevo.setEnlaceDer(Aux);
            Aux.setEnlaceIzq(nuevo);
            Inicio = nuevo;
            cant++;
        }
    }

    public void InsertarFin(int elemento) {
        NodoDoble nuevo = new NodoDoble();
        nuevo.setDato(elemento);
        if (!Existe(elemento)) {
            Fin.setEnlaceDer(nuevo);
            nuevo.setEnlaceIzq(Fin);
            Fin = nuevo;
            cant++;
        }
    }

    public void InsertarPorFin(int elemento) {
        if (!Existe(elemento)) {
            NodoDoble Nuevo = new NodoDoble();
            Nuevo.setDato(elemento);
            if (vacia()) {
                Inicio = Nuevo;
                Fin = Nuevo;
                cant++;
            } else {
                NodoDoble Aux = Fin;
                while (Aux != null && Aux.getDato() > elemento) {
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
                    } else {  // Insertar al final
                        Inicio.setEnlaceIzq(Nuevo);
                        Nuevo.setEnlaceDer(Inicio);
                        Inicio = Nuevo;
                        cant++;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String S = "[ ";
        NodoDoble Aux = Inicio;
        while (Aux != null) {
            S = S + Aux.toString() + " - ";
            Aux = Aux.getEnlaceDer();
        }
        if (S.length() > 2) {
            S = S.substring(0, S.length() - 3);
        }
        S = S + " ]";
        return S;
    }
    
    public static void main(String[] args) {
        ListaDoble listad = new ListaDoble();
        listad.Insertar(1);
        System.out.println(listad.cantNodos());
    }

}
