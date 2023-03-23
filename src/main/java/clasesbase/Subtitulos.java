package clasesbase;

import java.util.Arrays;

public class Subtitulos {
    public String[] idiomas;

    public Subtitulos(String[] idiomas) {
        this.idiomas = new String[0];
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Subtitulos{" + "idiomas=" + Arrays.toString(idiomas) + '}';
    }

    
    
    
}
