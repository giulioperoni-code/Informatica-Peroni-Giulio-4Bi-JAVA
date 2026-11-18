public class Materiale {
    public String codice;
    public String titolo;

    public Materiale() {
    }

    public Materiale(String codice, String titolo) {
        this.codice = codice;
        this.titolo = titolo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Codice: " + codice + ", Titolo: " + titolo;
    }
}
