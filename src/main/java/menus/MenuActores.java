/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import clasesbase.Actores;
import enums.Sexo;
import java.util.Arrays;

/**
 *
 * @author alexc
 */
public class MenuActores{
    //Array de actores
    private Actores act[] = new Actores[0];
    
    //Metodo para dar de alta a los actores
    public Object[] AltasActores(Object[] otro, String nombre, String apellidos, Sexo gender, int edad, String premios)
    {
        otro = (Actores []) act;
        otro = Arrays.copyOf(otro, otro.length + 1);
        otro[otro.length - 1] = new Actores(nombre, apellidos, gender, edad, premios);
        return otro;
    }
    
    //Metodo donde se da de baja a los actores haciendo una busqueda por nombres
    public Object[] BajasActoresPorNombre(Object[] otro, String nombre)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(act[i].getNombre()))
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    public Object[] ModificacionActoresPorNombre(Object[] otro, String nombre, String nuevoNombre)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(act[i].getNombre()))
            {   
                System.out.println("Nombre antiguo: " + otro[i]);
                act[i].setNombre(nuevoNombre);
                System.out.println("Nombre nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    public Object[] ModificacionActoresPorApellidos(Object[] otro, String apellidos, String nuevosApellidos)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(act[i].getApellidos()))
            {   
                System.out.println("Apellidos antiguos: " + otro[i]);
                act[i].setApellidos(nuevosApellidos);
                System.out.println("Apellidos nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    public Object[] ModificacionActoresPorGenero(Object[] otro, Sexo gender, Sexo nuevoGender)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(act[i].getGender()))
            {   
                System.out.println("Genero antiguo: " + otro[i]);
                act[i].setGender(nuevoGender);
                System.out.println("Genero nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    public Object[] ModificacionActoresPorEdad(Object[] otro, int edad, int nuevaEdad)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == act[i].getEdad())
            {   
                System.out.println("Edad antigua: " + otro[i]);
                act[i].setEdad(nuevaEdad);
                System.out.println("Edad nueva: " + otro[i]);
            }
        }
        return otro;
    }
    
    public Object[] ModificacionActoresPorPremiois(Object[] otro, String premios, String nuevosPremios)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(act[i].getPremios()))
            {   
                System.out.println("Premios antiguos: " + otro[i]);
                act[i].setPremios(nuevosPremios);
                System.out.println("Premios nuevos: " + otro[i]);
            }
        }
        return otro;
    }
    
    public void BusquedaActoresPorNombre(Object[] otro, String nombre)
    {
        otro = (Actores []) act;
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(act[i].getNombre()))
            {   
                System.out.println("Nombre encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == true)
            {
                System.out.println("El nombre " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    public void BusquedaActoresPorApellidos(Object[] otro, String apellidos)
    {
        otro = (Actores []) act;
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(act[i].getApellidos()))
            {   
                System.out.println("Apellidos encontrados: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == true)
            {
                System.out.println("El apellido " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    public void BusquedaActoresPorGenero(Object[] otro, Sexo gender)
    {
        otro = (Actores []) act;
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(act[i].getGender()))
            {   
                System.out.println("Genero encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == true)
            {
                System.out.println("El genero " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    public void BusquedaActoresPorEdad(Object[] otro, int edad)
    {
        otro = (Actores []) act;
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == act[i].getEdad())
            {   
                System.out.println("Edad encontrada: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == true)
            {
                System.out.println("La edad " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    public void BusquedaActoresPorPremios(Object[] otro, String premios)
    {
        otro = (Actores []) act;
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(act[i].getPremios()))
            {   
                System.out.println("Premio encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == true)
            {
                System.out.println("El premio " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    
}
