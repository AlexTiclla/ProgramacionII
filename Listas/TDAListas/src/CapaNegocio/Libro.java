package Negocio1;

import java.io.Serializable;

public class Libro implements Comparable, Serializable {
    
    int codigo;
    String titulo;
    String autor;
    int edicion;
    int año;
    String editorial;
    int numeroPag;
    


    public Libro(int codigo, String titulo, String autor, int edicion, int año, String editorial, int numeroPag) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.año = año;
        this.editorial = editorial;
        this.numeroPag = numeroPag;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nTitulo: " + titulo + "\nAutor: " + autor 
                + "\nEdición: " + edicion + "\nAño: " + año + "\nEditorial: " + editorial 
                + "\nNúmero de Paginas: " + numeroPag + "\n";
    }
    
    @Override
    public int compareTo(Object o) {
        Libro A = (Libro)o;
        return ((getCodigo()<A.getCodigo())? -1: (getCodigo()>A.getCodigo())? 1: 0);
    }
    
}
