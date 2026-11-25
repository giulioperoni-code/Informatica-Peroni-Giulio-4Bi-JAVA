public class Materiale {
    public String codice;
    public String titolo;

    public Materiale(String codice, String titolo) {
        this.codice = codice;
        this.titolo = titolo;
    }

    public String descrizione() {
        return "Codice: " + codice + ", Titolo: " + titolo;
    }

}
