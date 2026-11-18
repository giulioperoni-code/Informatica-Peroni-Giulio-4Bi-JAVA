public class Libro extends Materiale {
    public String Autore;

    public Libro() {
    }

    public Libro(String codice, String titolo, String Autore) {
        super(codice, titolo);
        this.Autore = Autore;
    }

    public String getAutore() {
        return Autore;
    }

    public void setAutore(String Autore) {
        this.Autore = Autore;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autore: " + Autore;
    }
}
