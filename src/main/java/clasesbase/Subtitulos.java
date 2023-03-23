package clasesbase;

public class Subtitulos {
    public String idioma;

    public Subtitulos(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @Override
    public String toString() {
        return "Subtitulos{" + "idiomas=" + idioma + '}';
    }

    
    
    
}
