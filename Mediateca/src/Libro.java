public class Libro extends Materiale {
    public String autore;

    public Libro(String codice, String titolo, String autore) {
        super(codice, titolo);
        this.autore = autore;
    }

    @Override
    public String descrizione() {
        return super.descrizione() + ", Autore: " + autore;
    }
}
