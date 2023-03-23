package menus;

import java.util.Arrays;
import java.util.Scanner;


import clasesbase.Categorias;

public class MenuCategorias {
	Scanner sc = new Scanner(System.in);
	private String nombre;
	private String descripcion;
	
	public Object[] altas(Object[] nuevo) {
		/* Se pide un Arrays de objetos Categorias
		 * Se añade una Categoria al Array
		 * Se devuelve el Array 
		 */
		System.out.println("Introduce el nombre de la nueva categoria:");
		String nombre = sc.nextLine();
		
		System.out.println("Introduce la descripcion de la categoria: ");
		String descripcion = sc.nextLine();
	
		nuevo = Arrays.copyOf(nuevo, nuevo.length+1);
		nuevo[nuevo.length-1] = new Categorias(nombre,descripcion);
		
		return nuevo;
	}

	public Object [] bajas(int posicion,Object[] nuevo) {
		/*
		int indice;
		for(int i=0;i<nuevo.length;i++) {
			if(busqueda.equals(nuevo.length)) {
				indice = i;
				System.out.println("nombre: "+nuevo[i]);
			}
		}
			System.arraycopy(busqueda, indiceborrado+1, t, indiceBorrado, t.length-indiceBorado-1);
			t = Arrays.copyOf(t, t.length-1) 
		*/
		return nuevo;
	}
	
		
	public Object [] modificadiones(int posicion,Object[] nuevo) {
		// TODO Auto-generated method stub
		return nuevo;
	}

	public void busquedas(Object[] nuevo) {
		
		int opcion = 100;
		while(opcion != -1)
		System.out.println("~~Elige atributo para buscar~~"
				+ "\n[1]Nombre"
				+ "\n[2]Descripcion"
				+ "\n[3]Atras");
		opcion = sc.nextInt();
		
		switch(opcion){
			case 1:{
				System.out.println("Introduce el nombre de la nueva categoria:");
				String nombre = sc.nextLine();
				
				for(int i = 0;i<nuevo.length;i++){
		            if(nombre==((Categorias) nuevo[i]).getNombre())
		                System.out.println(nuevo[i]);
		        }
				break;
			}
			
			case 2:{
				System.out.println("Introduce la descripcion de la categoria: ");
				String descripcion = sc.nextLine();
				for(int i = 0;i<nuevo.length;i++){
		            if(descripcion==((Categorias) nuevo[i]).getDescripcion())
		                System.out.println(nuevo[i]);
		         
		        }
				break;
			}
		}
	}
}

