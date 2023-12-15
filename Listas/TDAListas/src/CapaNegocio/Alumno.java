package Negocio1;

import java.io.Serializable;

public class Alumno implements Comparable, Serializable {
    
    int CI;
    int registro;
    String nombre;
    boolean sexo;
    int edad;
    
    public Alumno() {
        
    }
    
    public Alumno(int CI, int registro, String nombre, boolean sexo, int edad) {
        this.CI = CI;
        this.registro = registro;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return (sexo == true)? "Masculino": "Femenino";
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        String s = "";
        s = s + "Registro: " + getRegistro() +"\nCI: " + getCI() + "\nNombre:" + getNombre() 
              + "\nSexo: " + getSexo() + "\nEdad: " + getEdad() + "\n";
        return s;
    }
    
    @Override
    public int compareTo(Object o) {
        Alumno A = (Alumno)o;
        return ((getRegistro()<A.getRegistro())? -1: (getRegistro()>A.getRegistro())? 1: 0); 
    }
    
    public static void main(String[] args) {
        
        Alumno A = new Alumno(8873925, 220104099, "Benjamin", true, 20);
        Alumno B = new Alumno(8637241, 220045181, "Lizeth", false, 21);
        
        System.out.println(A);
        System.out.println(B);
        
    }
    
}
