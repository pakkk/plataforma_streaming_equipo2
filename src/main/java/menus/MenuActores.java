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
    //Array de actores
    private Actores act[] = new Actores[0];
    
    /* Se pide un Array de objetos Actores
    * Se añade un Actor al Array
    * Se devuelve el Array 
    */
    public Object[] AltasActores(Object[] otro, String nombre, String apellidos, Sexo gender, int edad, String premios)
    {
        otro = (Actores []) act;
        otro = Arrays.copyOf(otro, otro.length + 1);
        otro[otro.length - 1] = new Actores(nombre, apellidos, gender, edad, premios);
        return otro;
    }
    
    /* Se pide un Array de objetos Actores y el nombre del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
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
    
    /* Se pide un Array de objetos Actores y el apellido del actor que se va a dar de baja
    * Se elimina un Actor del Array
    * Se devuelve el Array 
    */
    public Object[] BajasActoresPorApellidos(Object[] otro, String apellidos)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(apellidos.equalsIgnoreCase(act[i].getApellidos()))
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
    public Object[] BajasActoresPorGenero(Object[] otro, Sexo gender)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(gender.equals(act[i].getGender()))
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
    public Object[] BajasActoresPorEdad(Object[] otro, int edad)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(edad == act[i].getEdad())
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
    public Object[] BajasActoresPorPremios(Object[] otro, String premios)
    {
        otro = (Actores []) act;
        for(int i = 0; i < otro.length; i++)
        {
            if(premios.equalsIgnoreCase(act[i].getPremios()))
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
    
    /* Se pide un Array de objetos Actores,  los apellidos del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
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
    
    /* Se pide un Array de objetos Actores,  el genero del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
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
    
    /* Se pide un Array de objetos Actores,  la edad del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
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
    
    /* Se pide un Array de objetos Actores,  los premios del actor que se va a buscar y su sustitucion
    * Se modifica los objetos Actores seleccionados
    * Se devuelve el Array 
    */
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
    
    /* Se pide un Array de objetos Actores y el nombre del actor que se va a buscar
    * Se buscan los objetos Actores
    * Se devuelve el Array 
    */
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
            
            if(encontrado == false)
            {
                System.out.println("El premio " + otro[i] + " no se ha encontrado.");
            }
        }
    }
    
    
}
