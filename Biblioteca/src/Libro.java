/**
 * Rappresenta un libro presente nel catalogo della biblioteca.
 */
public class Libro {
    private String isbn;
    private String titolo;
    private String autore;
    private int annoPubblicazione;

    /**
     * Costruisce un nuovo libro.
     *
     * @param isbn il codice ISBN del libro
     * @param titolo il titolo del libro
     * @param autore l'autore del libro
     * @param annoPubblicazione l'anno di pubblicazione del libro
     */
    public Libro(String isbn, String titolo, String autore, int annoPubblicazione) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }

    /**
     * Imposta il codice ISBN del libro.
     *
     * @param isbn il nuovo codice ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Restituisce il codice ISBN del libro.
     *
     * @return il codice ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Imposta il titolo del libro.
     *
     * @param titolo il nuovo titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce il titolo del libro.
     *
     * @return il titolo del libro
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta l'autore del libro.
     *
     * @param autore il nuovo autore
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * Restituisce l'autore del libro.
     *
     * @return l'autore del libro
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Imposta l'anno di pubblicazione del libro.
     *
     * @param annoPubblicazione il nuovo anno di pubblicazione
     */
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    /**
     * Restituisce l'anno di pubblicazione del libro.
     *
     * @return l'anno di pubblicazione del libro
     */
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    /**
     * Restituisce una rappresentazione testuale del libro.
     *
     * @return una stringa riepilogativa del libro
     */
    @Override
    public String toString() {
        return "Libro{isbn='" + isbn + "', titolo='" + titolo + "', autore='" + autore + "', annoPubblicazione=" + annoPubblicazione + "}";
    }
}
