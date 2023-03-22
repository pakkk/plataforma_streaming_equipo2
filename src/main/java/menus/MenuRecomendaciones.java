package menus;
import Interfaces.Menu;

import java.util.Arrays;
import java.util.Scanner;
import clasesbase.RecomendacionPeliculas;
import enums.TipoValoracion;
public class MenuRecomendaciones implements Menu{
	//Atributos
	private Scanner sc = new Scanner (System.in);
	private RecomendacionPeliculas rec [] = new RecomendacionPeliculas [0];
	private TipoValoracion valoracion;
	private String comentarios;
	//Constructor
	public MenuRecomendaciones ()
	{
		
	}
	//Metodos
	public Object[] altas(Object[] nuevo) {
	//Metodo para dar de alta una recomedacion en una pelicula o serie
		String opcion="";
		nuevo = (RecomendacionPeliculas []) rec;
		System.out.println("Selecciona la valoracion de su pelicula o serie: \n"
				+ "Opcion 1:Positiva \n"
				+ "Opcion 2:Negativa ");
		while(!opcion.equals("1") || !opcion.equals("2"))
		{
			opcion = sc.next();
			if(opcion.equals("1"))
				valoracion = TipoValoracion.POSITIVA;
			else if(opcion.equals("2"))
				valoracion = TipoValoracion.NEGATIVA;
			else
				System.out.println("Error al seleccionar escoja de nuevo");
		}
		System.out.println("Introduzca los comentarios de su pelicula o serie");
		comentarios = sc.next();
		
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new RecomendacionPeliculas(valoracion,comentarios);
		
		return nuevo;
	}

	public Object[] bajas(int posicion, Object nuevo []) {
	//Metodo para dar de baja a una recomendacion de una pelicula o serie 
		nuevo = (RecomendacionPeliculas []) rec;
		for (int i = 0;i<nuevo.length;i++)
		{
			if(i==posicion)
			{
				System.out.println("Atributos borrados " + rec[i]);
				System.arraycopy (nuevo, posicion+1, nuevo, posicion, nuevo.length-posicion-1);
				nuevo = Arrays.copyOf(nuevo, nuevo.length-1);
				break;
			}
		}
		return nuevo;
	}

	public Object[] modificadiones(int posicion,Object nuevo []) {
	//Metodo para modificar una recomendacion de una pelicula o serie
		nuevo = (RecomendacionPeliculas []) rec;
		String opcion="";
		for(int i=0;i<nuevo.length;i++)
		{
			if(i==posicion)
			{
				System.out.println("Selecciona la valoracion de su pelicula o serie: \n"
						+ "Opcion 1:Positiva \n"
						+ "Opcion 2:Negativa ");
				while(!opcion.equals("1") || !opcion.equals("2"))
				{
					opcion = sc.next();
					if(opcion.equals("1"))
						valoracion = TipoValoracion.POSITIVA;
					else if(opcion.equals("2"))
						valoracion = TipoValoracion.NEGATIVA;
					else
						System.out.println("Error al seleccionar escoja de nuevo");
				}
				System.out.println("Introduzca los comentarios de su pelicula o serie");
				comentarios = sc.next();
				nuevo[i] = new RecomendacionPeliculas (valoracion,comentarios);
				break;
			}
		}
		return nuevo;
		
	}

	public void busquedas(Object nuevo []) {
	//Metodo para buscar una recomendacion de una pelicula o serie 
		nuevo = (RecomendacionPeliculas []) rec;
		String opcion="";
		System.out.println("Seleccione una opcion en el criterio de busqueda: \n"
				+ "Opcion 1.-Busqueda de valoraciones \n"
				+ "Opcion 2.-Busqueda de comentarios");
		while(!opcion.equals("1") && !opcion.equals("2"))
		{
			opcion = sc.next();
			if(opcion.equals("1"))
			{
				System.out.println("Escoja entre valoracion positiva o negativa");
				opcion = sc.next();
				while(!opcion.equalsIgnoreCase("positiva") && !opcion.equalsIgnoreCase("negativa"))
				{
					System.out.println("Error al escoger, buelva a introducir que valoracion desea buscar (positiva/negativa)");
					opcion = sc.next();
				}
				if(opcion.equalsIgnoreCase("positiva"))
				{
					valoracion = TipoValoracion.POSITIVA;
					for(int i = 0;i<nuevo.length;i++)
					{
						if(valoracion.equals(((RecomendacionPeliculas)nuevo[i]).getValoracion()))				
						{
							System.out.println("Tu busqueda coincide con " + nuevo[i]);
						}
					}
				}else
				{
					valoracion = TipoValoracion.NEGATIVA;
					for(int i = 0;i<nuevo.length;i++)
					{
						if(valoracion.equals(((RecomendacionPeliculas)nuevo[i]).getValoracion()))				
						{
							System.out.println("Tu busqueda coincide con " + nuevo[i]);
						}
					}
				}
			}else if (opcion.equals("2"))
			{
				System.out.println("Introduzca el comentario a buscar");
				comentarios = sc.next();
				for(int i = 0;i<nuevo.length;i++)
				{
					if(comentarios.equals(((RecomendacionPeliculas)nuevo[i]).getComentarios()))
					{
						System.out.println("Tu busqueda coincide con " + nuevo [i]);
					}
				}
			}else
				System.out.println("Error al introfucir las opciones de busqueda, vuelva a introducirlas");
			
			
		}	
		
		
	}

}
