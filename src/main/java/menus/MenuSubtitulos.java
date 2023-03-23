package menus;

import java.util.Arrays;
import java.util.Scanner;

public class MenuSubtitulos {
    Scanner sc = new Scanner(System.in);
    String[] sub;
    String[] subtituloGenerales;

    public MenuSubtitulos() {
        sub = new String[0];
    }
// Menus para los idiomas
    public String[] subtitulosPermitidos() {
        subtituloGenerales = Subtitulos.idiomas;
        String opciones;
        boolean salir = false;

        System.out.println("Selecciona los Subtitulos de tu pelicula");
        System.out.println("1. Español");
        System.out.println("2. Ingles");
        System.out.println("3. Aleman");
        System.out.println("4. Portugues");
        System.out.println("5. Frances");
        System.out.println("6. Japones");
        System.out.println("7. Chino");
//altas de los idiomas
        while (salir == false) {
            opciones = sc.next();
            if (opciones.equals("1")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[0];
            }
            if (opciones.equals("2")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[1];
            }
            if (opciones.equals("3")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[2];
            }
            if (opciones.equals("4")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[3];
            }
            if (opciones.equals("5")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[4];
            }
            if (opciones.equals("6")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[5];
            }
            if (opciones.equals("7")) {
                sub = Arrays.copyOf(sub, sub.length + 1);
                sub[sub.length - 1] = subtituloGenerales[6];
            }
            while (!opciones.equalsIgnoreCase("si") && !opciones.equalsIgnoreCase("no")) {
                System.out.println("Desea añadir mas subtitulos ");
                opciones = sc.next();

                if (opciones.equalsIgnoreCase("si")) {
                    salir = false;
                } else if (opciones.equalsIgnoreCase("no")) {
                    salir = true;
                } else {
                    System.out.println("error a decidir, vuelve a decidir");
                }
            }
        }
        return sub;
    }

    public String[] bajasSubtitulo(String[] subtitulo, int pos) {
//bucle para poner el subtitulo que queremos al final de array y eliminarlo
        for (int i = 0; i < subtitulo.length; i++) {
            if (i == pos) {
                System.out.println("El subtitulo eliminado es: " + subtitulo[pos]);
                System.arraycopy(subtitulo, pos + 1, subtitulo, pos, subtitulo.length - pos - 1);
                subtitulo = Arrays.copyOf(subtitulo, subtitulo.length - 1);
            }
        }
        return subtitulo;
    }

    public String[] modificacionesSubtitulo(String[] subtitulo, int pos) {
//bucle para la modificacion
        for (int i = 0; i < subtitulo.length; i++) {
            subtituloGenerales = Subtitulos.idiomas;
            String opciones;
            boolean salir = false;
            if (i == pos) {
                System.out.println("Selecciona los Subtitulos de tu pelicula");
                System.out.println("1. Español");
                System.out.println("2. Ingles");
                System.out.println("3. Aleman");
                System.out.println("4. Portugues");
                System.out.println("5. Frances");
                System.out.println("6. Japones");
                System.out.println("7. Chino");

                while (salir == false) {
                    opciones = sc.next();
                    if (opciones.equals("1")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[0];
                    }
                    if (opciones.equals("2")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[1];
                    }
                    if (opciones.equals("3")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[2];
                    }
                    if (opciones.equals("4")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[3];
                    }
                    if (opciones.equals("5")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[4];
                    }
                    if (opciones.equals("6")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[5];
                    }
                    if (opciones.equals("7")) {
                        sub = Arrays.copyOf(sub, sub.length + 1);
                        sub[sub.length - 1] = subtituloGenerales[6];
                    }
                }
            }
        }
        return subtitulo;
    }
    //busqueda de subtitulo
    public void busquedaSubtitulo(String [] subtitulos){
        String sub;
        System.out.println("Introduce el subtitulo a buscar");
        sub = sc.next();

        for (String i : subtitulos) {
            if (i.equalsIgnoreCase(sub)){
                System.out.println(i);
                break;
            }
        }
    }
}