package clasesbase;

import enums.Sexo;

public class Actores{
    //Atributos 
    private String nombre;
    private String apellidos;
    private Sexo s;
    private int edad;
    private String premios;
    //Constructor 
    public Actores(String nombre, String apellidos, Sexo s, int edad, String premios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.s = s;
        this.edad = edad;
        this.premios = premios;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public String getPremios() {
        return premios;
    }
    
    public Sexo getSexo() {
    	return s;
    }
    
    public int getEdad() {
        return edad;
    }
    //Setters
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSexo(Sexo s) {
        this.s = s;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public void setPremios(String premios) {
        this.premios = premios;
    }
    //toString
    @Override
    public String toString() {
        return "Actor "+ nombre + " " + apellidos +" de edad "+ edad +" ha ganado " + premios;
    }
     
}