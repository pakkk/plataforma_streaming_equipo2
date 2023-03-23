package menus;

import java.util.Arrays;
import java.util.Scanner;


import clasesbase.Categorias;

public class MenuCategorias 
{
	
	  //Clase que se encarga de almacenar los metodos de altas, bajas, consultas y busquedas de Categorias
	 
	
	
	
	public Object[] CategoriaAltas(Object[] nuevo,String nombre, String descripcion) 
	{
		/* Se pide un Arrays de objetos Categorias
		 * Se añade una Categoria al Array
		 * Se devuelve el Array 
		 */
		
	
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new Categorias(nombre,descripcion);
		
		return nuevo;
	}

	public Object [] CategoriasBajasNombre(String nombre,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Categorias, y el nombre de la categoria que se va a dar de baja
		 * Se elimina los objetos categorias seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(nombre.equalsIgnoreCase(((Categorias) nuevo[i]).getNombre()))  
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	
	public Object [] CategoriasBajasDescripcion(String descripcion,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Categorias, y la descripcion de la categoria que se va a dar de baja
		 * Se elimina los objetos categorias seleccionados
		 * Se devuelve el Array 
		 */
		
		for(int i=0;i<nuevo.length;i++) 
		{
			if(descripcion.equalsIgnoreCase(((Categorias) nuevo[i]).getDescripcion())) 
			{
				System.out.println("Atributos borrado " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;			
			}
		}
			
		
		return nuevo;
	}
	
		
	public Object [] CategoriasModificadionesPorNombre(Object[] nuevo, String nombre,String nuevoNombre) 
	{
		/* Se pide un Arrays de objetos Categorias,  el nombre de la categoria que se va a buscar y su sustitucion
		 * Se elimina los objetos categorias seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(nombre.equalsIgnoreCase(((Categorias) nuevo[i]).getNombre())) {
	        	System.out.println("Descripcion "+ nombre +" modificados por " + nuevoNombre);
	            ((Categorias)nuevo[i]).setNombre(nuevoNombre);
	        }
	    }		
		return nuevo;
	}
	
	public Object [] CategoriasModificadionesPorDescripcion(Object[] nuevo, String descripcion,String nuevaDescripcion) 
	{
		/* Se pide un Arrays de objetos Categorias,  la Descripcion de la categoria que se va a buscar y su sustitucion
		 * Se elimina los objetos categorias seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(descripcion.equalsIgnoreCase(((Categorias) nuevo[i]).getNombre())) 
	        {
	        	System.out.println("Descripcion "+ descripcion +" modificados por " + nuevaDescripcion);
	            ((Categorias)nuevo[i]).setNombre(nuevaDescripcion);
	        }
	    }		
		return nuevo;
	}
	
	

	public void CategoriasBusquedasNombre(Object[] nuevo,String nombre) 
	{
		/* Se pide un Arrays de objetos Categorias y  el nombre de la categoria que se va a buscar 
		 * Se busca los objetos categorias 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(nombre.equalsIgnoreCase(((Categorias) nuevo[i]).getNombre())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+nombre+" no existe");
	}
	public void CategoriasBusquedasDescripcion(Object[] nuevo, String descripcion) 
	{
		/* Se pide un Arrays de objetos Categorias y  el Descripcion de la categoria que se va a buscar 
		 * Se busca los objetos categorias 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;	
		for(int i = 0;i<nuevo.length;i++)
		{	
			
	        if(descripcion.equalsIgnoreCase(((Categorias) nuevo[i]).getDescripcion())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }

		}
        if (encontrado==false) 
        	System.out.println("Su descripcion "+descripcion+" no existe");
        
	}
}

