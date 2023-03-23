package menus;

import java.util.Arrays;
import clasesbase.Directores;
import enums.Sexo;

public class MenuDirectores 
{
	
	//Clase que se encarga de almacenar los metodos de altas, bajas, consultas y busquedas de Directores
	 
	
	
	
	public Object[] DirectoresAltas(Object[] nuevo,String nombre, String apellidos, Sexo gender, int edad, String premios) 
	{
		/* Se pide un Arrays de objetos Directores y sus atributos
		 * Se añade un Director al Array
		 * Se devuelve el Array 
		 */
		
	
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new Directores(nombre,apellidos,gender,edad,premios);
		
		return nuevo;
	}

	public Object [] DirectoresBajasNombre(String nombre,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Directores, y el nombre del director que se va a dar de baja
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(nombre.equalsIgnoreCase(((Directores) nuevo[i]).getNombre()))  
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	
	public Object [] DirectoresBajasApellidos(String apellido,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Directores, y el Apellidos del director que se va a dar de baja
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(apellido.equalsIgnoreCase(((Directores) nuevo[i]).getApellido()))  
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	
	public Object [] DirectoresBajasGenero(Sexo genero,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Directores, y el genero del director que se va a dar de baja
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(genero.equals(((Directores) nuevo[i]).getGender()))  
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	public Object [] DirectoresBajasEdad(int edad,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Directores, y el edad del director que se va a dar de baja
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(edad ==((Directores) nuevo[i]).getEdad())
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	
	
			
	
	public Object [] DirectoresBajasPremios(String premios,Object[] nuevo) 
	{
		/* Se pide un Arrays de objetos Directores, y el premios del director que se va a dar de baja
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i=0;i<nuevo.length;i++) 
		{
			if(premios.equalsIgnoreCase(((Directores) nuevo[i]).getPremios()))  
			{
				System.out.println("Atributos borrados " + nuevo[i]);
				System.arraycopy(nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1) ;
				
			}
		}
			
		
		return nuevo;
	}
	
	
	
		
	public Object [] DirectoresModificadionesPorNombre(Object[] nuevo, String nombre,String nuevoNombre) 
	{
		/* Se pide un Arrays de objetos Directores,  el nombre de la Director que se va a buscar y su sustitucion
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(nombre.equalsIgnoreCase(((Directores) nuevo[i]).getNombre())) {
	        	System.out.println("Descripcion "+ nombre +" modificados por " + nuevoNombre);
	            ((Directores)nuevo[i]).setNombre(nuevoNombre);
	        }
	    }		
		return nuevo;
	}
	
	public Object [] DirectoresModificadionesPorApellido(Object[] nuevo, String apellido,String nuevoApellido) 
	{
		/* Se pide un Arrays de objetos Directores,  el apellido de la Director que se va a buscar y su sustitucion
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(apellido.equalsIgnoreCase(((Directores) nuevo[i]).getApellido())) {
	        	System.out.println("Descripcion "+ apellido +" modificados por " + nuevoApellido);
	            ((Directores)nuevo[i]).setApellido(nuevoApellido);
	        }
	    }		
		return nuevo;
	}
	
	public Object [] DirectoresModificadionesPorGenero(Object[] nuevo, Sexo genero,Sexo nuevoGenero) 
	{
		/* Se pide un Arrays de objetos Directores,  el genero de la Director que se va a buscar y su sustitucion
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(genero.equals(((Directores) nuevo[i]).getGender())) {
	        	System.out.println("Descripcion "+ genero +" modificados por " + nuevoGenero);
	            ((Directores)nuevo[i]).setGender(nuevoGenero);
	        }
	    }		
		return nuevo;
	}
	
	public Object [] DirectoresModificadionesPorEdad(Object[] nuevo, int edad,int nuevoEdad) 
	{
		/* Se pide un Arrays de objetos Directores,  el Edad de la Director que se va a buscar y su sustitucion
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(edad==(((Directores) nuevo[i]).getEdad())) {
	        	System.out.println("Descripcion "+ edad +" modificados por " + nuevoEdad);
	            ((Directores)nuevo[i]).setEdad(nuevoEdad);
	        }
	    }		
		return nuevo;
	}
	
	public Object [] DirectoresModificadionesPorPremios(Object[] nuevo, String premios,String nuevoPremios) 
	{
		/* Se pide un Arrays de objetos Directores,  el premios de la Director que se va a buscar y su sustitucion
		 * Se elimina los objetos Director seleccionados
		 * Se devuelve el Array 
		 */
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(premios.equalsIgnoreCase(((Directores) nuevo[i]).getPremios())) {
	        	System.out.println("Descripcion "+ premios +" modificados por " + nuevoPremios);
	            ((Directores)nuevo[i]).setPremios(nuevoPremios);
	        }
	    }		
		return nuevo;
	}
	
	
	
	

	public void DirectoresBusquedasNombre(Object[] nuevo,String nombre) 
	{
		/* Se pide un Arrays de objetos Directores y  el nombre de la Director que se va a buscar 
		 * Se busca los objetos Director 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(nombre.equalsIgnoreCase(((Directores) nuevo[i]).getNombre())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+nombre+" no existe");
		
	}
	public void DirectoresBusquedasApellido(Object[] nuevo,String apellido) 
	{
		/* Se pide un Arrays de objetos Directores y  el apellidos de la Director que se va a buscar 
		 * Se busca los objetos Director 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(apellido.equalsIgnoreCase(((Directores) nuevo[i]).getApellido())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+apellido+" no existe");

	}
	
	public void DirectoresBusquedasGenero(Object[] nuevo,Sexo genero) 
	{
		/* Se pide un Arrays de objetos Directores y  el genero de la Director que se va a buscar 
		 * Se busca los objetos Director 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(genero.equals(((Directores) nuevo[i]).getGender())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+genero+" no existe");
	}
	public void DirectoresBusquedasEdad(Object[] nuevo,int edad) 
	{
		/* Se pide un Arrays de objetos Directores y  el edad de la Director que se va a buscar 
		 * Se busca los objetos Director 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(edad==(((Directores) nuevo[i]).getEdad())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+edad+" no existe");
	}
	public void DirectoresBusquedasPremios(Object[] nuevo,String premios) 
	{
		/* Se pide un Arrays de objetos Directores y  los premios de la Director que se va a buscar 
		 * Se busca los objetos Director 
		 * Se muestra por pantalla 
		 */		
		boolean encontrado = false;
		for(int i = 0;i<nuevo.length;i++)
		{
	        if(premios.equalsIgnoreCase(((Directores) nuevo[i]).getPremios())) 
	        {
	            System.out.println(nuevo[i]);
	            encontrado = true;
	        }
	    }		
		if (encontrado==false) 
        	System.out.println("El nombre "+premios+" no existe");
	}
		
}
