package menus;

import clasesbase.Actores;
import enums.Sexo;
import java.util.Arrays;

/**
 *
 * @author alex
 */

//Clase que se encarga de almacenar los metodos de altas, bajas, consultas y busquedas de Actores
public class MenuActores{
   
    /* Se pide un Array de objetos Actores
    * Se añade un Actor al Array
    * Se devuelve el Array 
    */
    public Actores[] AltasActores(Actores[] otro, String nombre, String apellidos, Sexo gender, int edad, String premios)
    {
        otro = Arrays.copyOf(otro, otro.length + 1);
        otro[otro.length - 1] = new Actores(nombre, apellidos, gender, edad, premios);
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y el nombre del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Actores[] BajasActoresPorNombre(Actores[] otro, String nombre)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(otro[i].getNombre()))
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y el apellido del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Actores[] BajasActoresPorApellidos(Actores[] otro, String apellidos)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(otro[i].getApellidos()))
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y el genero del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Actores[] BajasActoresPorGenero(Actores[] otro, Sexo gender)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(otro[i].getGender()))
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y la edad del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Actores[] BajasActoresPorEdad(Actores[] otro, int edad)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == otro[i].getEdad())
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y los premios del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Actores[] BajasActoresPorPremios(Actores[] otro, String premios)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(otro[i].getPremios()))
            {   
                System.out.println("Actores dados de baja: " + otro[i]);
                System.arraycopy (otro, i+1, otro, i, otro.length-i-1);
                otro = Arrays.copyOf (otro, otro.length-1) ;
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores,  el nombre del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
    public Actores[] ModificacionActoresPorNombre(Actores[] otro, String nombre, String nuevoNombre)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(otro[i].getNombre()))
            {   
                System.out.println("Nombre antiguo: " + otro[i]);
                otro[i].setNombre(nuevoNombre);
                System.out.println("Nombre nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores,  los apellidos del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
    public Actores[] ModificacionActoresPorApellidos(Actores[] otro, String apellidos, String nuevosApellidos)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(otro[i].getApellidos()))
            {   
                System.out.println("Apellidos antiguos: " + otro[i]);
                otro[i].setApellidos(nuevosApellidos);
                System.out.println("Apellidos nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores,  el genero del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
    public Actores[] ModificacionActoresPorGenero(Actores[] otro, Sexo gender, Sexo nuevoGender)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(otro[i].getGender()))
            {   
                System.out.println("Genero antiguo: " + otro[i]);
                otro[i].setGender(nuevoGender);
                System.out.println("Genero nuevo: " + otro[i]);
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores,  la edad del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
    public Actores[] ModificacionActoresPorEdad(Actores[] otro, int edad, int nuevaEdad)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == otro[i].getEdad())
            {   
                System.out.println("Edad antigua: " + otro[i]);
                otro[i].setEdad(nuevaEdad);
                System.out.println("Edad nueva: " + otro[i]);
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores,  los premios del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
    public Actores[] ModificacionActoresPorPremiois(Actores[] otro, String premios, String nuevosPremios)
    {
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(otro[i].getPremios()))
            {   
                System.out.println("Premios antiguos: " + otro[i]);
                otro[i].setPremios(nuevosPremios);
                System.out.println("Premios nuevos: " + otro[i]);
            }
        }
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y el nombre del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
    public void BusquedaActoresPorNombre(Actores[] otro, String nombre)
    {
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(nombre.equalsIgnoreCase(otro[i].getNombre()))
            {   
                System.out.println("Nombre encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El nombre " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actores y los apellidos del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
    public void BusquedaActoresPorApellidos(Actores[] otro, String apellidos)
    {
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(otro[i].getApellidos()))
            {   
                System.out.println("Apellidos encontrados: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El apellido " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actores y el genero del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
    public void BusquedaActoresPorGenero(Actores[] otro, Sexo gender)
    {
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(otro[i].getGender()))
            {   
                System.out.println("Genero encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El genero " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actores y la edad del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
    public void BusquedaActoresPorEdad(Actores[] otro, int edad)
    {
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == otro[i].getEdad())
            {   
                System.out.println("Edad encontrada: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("La edad " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    /* Se pide un Array de objetos Actores y ls premios del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
    public void BusquedaActoresPorPremios(Actores[] otro, String premios)
    {
        boolean encontrado = false;
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(otro[i].getPremios()))
            {   
                System.out.println("Premio encontrado: " + otro[i]);
                encontrado = true;
            }
            
            if(encontrado == false)
            {
                System.out.println("El premio " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    
}
