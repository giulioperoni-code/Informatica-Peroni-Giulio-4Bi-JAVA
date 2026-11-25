public class Libro extends Materiale {
    public String Autore;

    public Libro(String codice, String titolo, String Autore) {
        super(codice, titolo);
        this.Autore = Autore;
    }

}
