package menus;

import java.util.Arrays;
import clasesbase.RecomendacionPeliculas;
import enums.TipoValoracion;
public class MenuRecomendaciones{
	//Atributos
	//Atributo RecomendacionPeliculas rec []:Sirve para los cast en los metodos que se pasa un Array de objetos 
	private RecomendacionPeliculas rec [] = new RecomendacionPeliculas[0];
	//Metodos
	public Object[] RecomendacionPeliculasAltas (Object nuevo[],TipoValoracion valoracion,String comentarios)
	{
	//Este metodo se encarga de dar de alta una recomendacion en una pelicula o serie pasandole sus atributos como parametro, se devuelve el array modificado
		nuevo = (RecomendacionPeliculas []) rec;
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new RecomendacionPeliculas (valoracion,comentarios);
		return nuevo;
	}
	
	public Object[] RecomendacionBajasPorComentarios (Object nuevo[],String comentario)
	{
	//Este metodo se encarga de dar de baja a una recomendacion en una pelicula o serie mediante un comentario, es decir, busca las recomendaciones que contenga ese comentario y se borra esa recomendacion
	//A este metodo se le pasa por parametro el comentario que borrara la recomendacion, se le pasa tambien el array  de recomendaciones a modificar, se devuelve el array modificado
		nuevo = (RecomendacionPeliculas []) rec;
	//Este for recorre el array de recomendaciones buscando las recomendaciones que contenga el mismo comentario para borrarlo 
		for(int i=0;i<nuevo.length;i++)
		{
			if(comentario.equalsIgnoreCase(((RecomendacionPeliculas)nuevo[i]).getComentarios()))
			{
				System.out.println("Recomendacion borrada "+nuevo[i]);
				System.arraycopy (nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf (nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	
	public Object[] RecomendacionBajasPorValoracion(Object nuevo[],TipoValoracion valoracion)
	{
	//Este metodo se encarga de dar de baja a una recomendacion en una pelicula o serie mediante una valoracion, es decir, busca las recomendaciones que contenga esa valoracion y se borra esa recomendacion
	//A este metodo se le pasa por parametro la valoracion que borrara la recomendacion, tambien se le pasa el array de recomendaciones a modificar, se devuelve el array modificado
		nuevo = (RecomendacionPeliculas []) rec;
	//Este for recorre el array de recomendaciones buscando las recomendaciones que contenga la misma valoracion para borrarlo  
		for(int i=0;i<nuevo.length;i++)
		{
			if(valoracion.equals(((RecomendacionPeliculas)nuevo[i]).getValoracion()))
			{
				System.out.println("Recomendacion borrada "+nuevo[i]);
				System.arraycopy (nuevo, i+1, nuevo, i, nuevo.length-i-1);
				nuevo = Arrays.copyOf (nuevo, nuevo.length-1);
			}
		}
		return nuevo;
	}
	
	public Object[] RecomendacionModificacionPorComentario(Object nuevo[],String comentario,String nuevoComentario)
	{
	//Este metodo se encarga de modificar el atributo comentario por otro nuevo, se le pasa por parametro el array de recomendaciones, el comentario antiguo y el comentario nuevo a reemplazar
	//Se le devuelve el array modificado
		nuevo = (RecomendacionPeliculas []) rec;
	//Este for recorre el array de recomendaciones y busca las recomendaciones que contengan el comentario viejo para reemplazarlo por el nuevo 
		for(int i=0;i<nuevo.length;i++)
		{
			if(comentario.equalsIgnoreCase(((RecomendacionPeliculas)nuevo[i]).getComentarios()))
			{
				System.out.println("Atributo a modificar: "+nuevo[i]);
				((RecomendacionPeliculas)nuevo[i]).setComentarios(nuevoComentario);
				System.out.println("Atributo modificado: "+nuevo[i]);
			}
		}
		return nuevo;
	}
	
	public Object[] RecomendacionesModificacionPorValoracion(Object nuevo[],TipoValoracion valoracion,TipoValoracion nuevaValoracion)
	{
	//Este metodo se encarga de modificar el atributo valoracion por otro nuevo, se le pasa por parametro el array de recomendaciones, la valoracion antigua y la valoracion nueva a reemplazar
	//Se le devuelve el array modificado
		nuevo = (RecomendacionPeliculas []) rec;
	//Este for recorre el array de recomendaciones y busca las recomendaciones que contengan la valoracion vieja para reemplazarla por la nueva 
		for(int i=0;i<nuevo.length;i++)
		{
			if(valoracion.equals(((RecomendacionPeliculas)nuevo[i]).getValoracion()))
			{
				System.out.println("Atributo a modificar: "+nuevo[i]);
				((RecomendacionPeliculas)nuevo[i]).setValoracion(nuevaValoracion);
				System.out.println("Atributo modificado: "+nuevo[i]);
			}
		}
		return nuevo;
	}
	public void RecomendacionesBusquedaPorComentarios(Object nuevo[],String comentario)
	{
	//Este metodo se encarga de buscar las recomendaciones por su comentario, se le pasa por parametro el array de recomendaciones y el comentario a buscar
		nuevo = (RecomendacionPeliculas []) rec;
	//Este for recorre el array de recomendaciones y busca las recomendaciones que contengan el comentario a buscar, si no lo encuentra se notificara al usuario
		boolean encontrado = false;
		for(int i=0;i<nuevo.length;i++)
		{
			if(comentario.equalsIgnoreCase(((RecomendacionPeliculas)nuevo[i]).getComentarios()))
			{
				System.out.println("Recomendacion encontrada: "+nuevo[i]);
				encontrado = true;
			}
			if(encontrado==true)
				System.out.println("El comentario "+comentario+" no se ha podido encontrar");
		}
	}
	
	public void RecomendacionesBusquedaPorValoracion(Object nuevo[],TipoValoracion valoracion)
	{
		//Este metodo se encarga de buscar las recomendaciones por su valoracion, se le pasa por parametro el array de recomendaciones y la valoracion a buscar
			nuevo = (RecomendacionPeliculas []) rec;
		//Este for recorre el array de recomendaciones y busca las recomendaciones que contengan el comentario a buscar, si no lo encuentra se notificara al usuario 
		boolean encontrado = false;
		for(int i=0;i<nuevo.length;i++)
		{
			if(valoracion.equals(((RecomendacionPeliculas)nuevo[i]).getValoracion()))
			{
				System.out.println("Recomendacion encontrada "+nuevo[i]);
				encontrado = true;
			}
			if(encontrado==true)
				System.out.println("La valoracion "+valoracion+" no se ha podido encontrar");
		}
	}
	
}
