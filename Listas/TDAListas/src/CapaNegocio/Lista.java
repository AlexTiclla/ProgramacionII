package CapaNegocio;

// Lista simple 
public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public int getCant() {
        return cant;
    }

    public boolean vacia() {
        return (L == null);
    }

    // Inserta ordenado, en la cabeza, en el cuerpo, el la cola 
    public void insertar(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;

        } else {
            Nodo aux = L;
            Nodo ant = null; //nodo anterior
            while ((aux != null) && (aux.getDato() <= ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) {
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;

            } else {
                if (ant.getDato() != ele) {
                    Nodo p = new Nodo();
                    p.setDato(ele);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;

                }
            }
        }
    }
    
    public void insertarUltimo(int dato){
        Nodo p = new Nodo();
        p.setDato(dato);
        if (vacia()) {
             
             
             L = p;
             cant++;
            
            
        }else{
            Nodo aux = L;
            while(aux.getEnlace()!= null){
                aux = aux.getEnlace();
            }
            aux.setEnlace(p);
            
            

        }
        cant++;
        
    }

    public void eliminar(int ele) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() != ele)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (aux != null) { // Si encontro el elemento que queremos eliminar en la lista
                if (ant == null) { // Si es el primero
                    L = L.getEnlace();
                    cant--;
                } else { // Si esta en cualquier otra parte
                    ant.setEnlace(aux.getEnlace());
                    cant--;
                }
            }
        }
    }

    public boolean existe(int ele) {
        boolean x = false;
        if (!vacia()) {
            Nodo aux = L;
            while ((aux != null) && (aux.getDato() != ele)) {
                aux = aux.getEnlace();
            }
            if (aux != null) {
                x = true;
            }
        }
        return x;
    }

    public int getDato(int pos) { // pos 1
        // la posicion se debe verificar en el form
        Nodo aux = L;
        for (int i = 1; i < pos; i++) {
            aux = aux.getEnlace();
        }
        return (aux.getDato());
    }

 

    public void invertirIterativo() {

        if (cant > 1) {
            Nodo ant = null;
            Nodo act = L;
            Nodo pos = L.getEnlace();
            while (act != null) {
                act.setEnlace(ant);
                ant = act;
                act = pos;
                if (pos != null) {
                    pos = pos.getEnlace();
                }
            }
            L = ant;
        }
    }

    public void invertirT() {

        if (L == null) {

        } else {
            Nodo ant = null;
            Nodo aux = L;
            Nodo pos = L.getEnlace();
            while (pos != null) {
                aux.setEnlace(ant);
                ant = aux;
                aux = pos;
                pos = pos.getEnlace();
            }
            aux.setEnlace(ant);
            L = aux;

        }
    }

    public void invertir() {
        invertirR(L);
    }

    private void invertirR(Nodo P) {
        if (L == null) {

        } else if (P.getEnlace() == null) {
            L = P;
        } else {
            invertirR(P.getEnlace());
            P.getEnlace().setEnlace(P);
            P.setEnlace(null);

        }

    }

    public boolean par() {
        boolean flag = false;
        if (cant % 2 == 0) {
            flag = true;

        }
        return flag;
    }

//    public void intercambiar(){
//        if (cant > 1) {
//            intercambiarRecursivo(L);
//        }
//        
//        
//    }
    
    // Intercambia de dos en dos
    public void intercambiar2() {
        if (cant > 1) {
            Nodo aux;
            Nodo ant;
            Nodo sig;
            if (cant % 2 != 0) {
                aux = L.getEnlace();
                ant = L;

            } else {
                aux = L;
                ant = null;
            }
//            aux = L;
//            ant = null;

            while (aux != null) {

                sig = aux.getEnlace();
                if (sig != null) {
                    aux.setEnlace(sig.getEnlace());
                    sig.setEnlace(aux);
                    if (ant == null) {
                        L = sig;
                    } else {
                        ant.setEnlace(sig);
                    }
                }
                ant = aux;
                aux = aux.getEnlace();
            }
        }
    }
    
        public void intercambiar3() {
        if (cant > 1) {
            Nodo aux;
            Nodo ant;
            Nodo sig;
            if (cant % 2 != 0) {
                aux = L.getEnlace();
                ant = L;

            } else {
                aux = L;
                ant = null;
            }
//            aux = L;
//            ant = null;

            while (aux != null) {

                sig = aux.getEnlace();
                if (sig != null) {
                    aux.setEnlace(sig.getEnlace());
                    sig.setEnlace(aux);
                    if (ant == null) {
                        L = sig;
                    } else {
                        ant.setEnlace(sig);
                    }
                }
                ant = aux;
                aux = aux.getEnlace();
            }
        }
    }

    // Metodo recursivo No finalizado 
    public void intercambiarRecursivo(Nodo p) {
        if (vacia()) {

        } else if (L.getEnlace() == null) {
            L = p;

        } else {
            if (cant % 2 == 0) {
                intercambiarRecursivo(p.getEnlace().getEnlace());
                Nodo aux = p.getEnlace();
                p.setEnlace(aux.getEnlace());
                aux.setEnlace(p);

            } else {
                intercambiarRecursivo(p.getEnlace());

            }

        }

    }
    
    public void practica2(){
        if (cant > 1) {
            Nodo act = L;
           // Nodo act = ant.getEnlace();
            //Nodo nuevo = new Nodo();
            int dato;
            Nodo nuevo;
            while(act.getEnlace() != null){
                if ((act.getDato() > 0 && act.getEnlace().getDato() < 0)||(act.getDato() < 0 && act.getEnlace().getDato() > 0)) {
                    nuevo = new Nodo();
                    dato = act.getDato() - act.getEnlace().getDato();
                    nuevo.setDato(Math.abs(dato));
                    nuevo.setEnlace(act.getEnlace());
                    act.setEnlace(nuevo);
                    act = nuevo.getEnlace();
//                    if (nuevo.getEnlace().getEnlace() == null) {
//                      
//                        
//                    }else{
//                        act = nuevo;
//                    }
                    
                    cant++;
                    
                    
                }else{
                
                    act = act.getEnlace();
                }

                
            }
            
        }
        
    
    }
    
       @Override
    public String toString() {
        String S = "L-> <";
        Nodo aux = L;
        while (aux != null) {
            S = S + aux.getDato() + ",";
            aux = aux.getEnlace();
        }
        S = S + ">";
        return S;
    }

    public static void main(String[] args) {
        Lista LI = new Lista();
        LI.insertarUltimo(1);
        LI.insertarUltimo(2);
        LI.insertarUltimo(3);
        LI.insertarUltimo(4);
        LI.insertarUltimo(5);
        LI.insertarUltimo(6);
        LI.insertarUltimo(7);
        LI.insertarUltimo(8);
        System.out.println(LI.toString());
//        LI.insertar(1);
//
//        LI.insertar(5);
//        LI.insertar(8);
//        LI.insertar(3);
//        LI.insertar(2);
//        LI.insertar(11);
//         LI.insertar(13);
//         LI.insertar(14);
        LI.intercambiar2();

        System.out.println(LI.toString());

        //System.out.println(LI.toString());
//        System.out.println(LI.getDato(7));
//        LI.invertir();
//        System.out.println(LI.toString());
    }

}
