/**
 * Rappresenta una copia fisica di un libro presente in biblioteca.
 */
public class CopiaLibro {
    private String barcode;
    private StatoCopia stato;
    private Libro libro;
    private Prestito[] prestiti;
    private int numeroPrestiti;

    /**
     * Costruisce una copia di libro con stato specificato.
     *
     * @param barcode il codice a barre della copia
     * @param libro il libro di cui è copia
     * @param stato lo stato della copia
     */
    public CopiaLibro(String barcode, Libro libro, StatoCopia stato) {
        this.barcode = barcode;
        this.libro = libro;
        this.stato = stato;
        this.prestiti = new Prestito[100];
        this.numeroPrestiti = 0;
    }

    /**
     * Costruisce una copia di libro con stato iniziale disponibile.
     *
     * @param barcode il codice a barre della copia
     * @param libro il libro di cui è copia
     */
    public CopiaLibro(String barcode, Libro libro) {
        this(barcode, libro, StatoCopia.DISPONIBILE);
    }

    /**
     * Restituisce il codice a barre della copia.
     *
     * @return il codice a barre
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Restituisce lo stato della copia.
     *
     * @return lo stato della copia
     */
    public StatoCopia getStato() {
        return stato;
    }

    /**
     * Restituisce il libro di cui è copia.
     *
     * @return il libro associato
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Restituisce i prestiti associati alla copia.
     *
     * @return un array contenente i prestiti della copia
     */
    public Prestito[] getListaPrestiti() {
        Prestito[] risultato = new Prestito[numeroPrestiti];
        for (int i = 0; i < numeroPrestiti; i++) {
            risultato[i] = prestiti[i];
        }
        return risultato;
    }

    /**
     * Verifica se la copia è prestabile.
     *
     * @return true se la copia è disponibile, false altrimenti
     */
    public Boolean prestabile() {
        return stato == StatoCopia.DISPONIBILE;
    }

    /**
     * Imposta la copia come non prestabile.
     */
    public void impostaNonPrestabile() {
        this.stato = StatoCopia.NON_PRESTABILE;
    }

    /**
     * Imposta la copia come smarrita.
     */
    public void impostaSmarrita() {
        this.stato = StatoCopia.SMARRITA;
    }

    /**
     * Imposta la copia come disponibile.
     */
    public void impostaDisponibile() {
        this.stato = StatoCopia.DISPONIBILE;
    }

    /**
     * Aggiunge un prestito alla lista dei prestiti della copia.
     *
     * @param prestito il prestito da associare
     */
    void aggiungiPrestito(Prestito prestito) {
        if (numeroPrestiti < prestiti.length) {
            prestiti[numeroPrestiti] = prestito;
            numeroPrestiti++;
        }
    }

    /**
     * Imposta la copia come in prestito.
     */
    void impostaInPrestito() {
        this.stato = StatoCopia.IN_PRESTITO;
    }

    /**
     * Restituisce una rappresentazione testuale della copia.
     *
     * @return una stringa riepilogativa della copia
     */
    @Override
    public String toString() {
        return "CopiaLibro{barcode='" + barcode + "', stato=" + stato + ", libro=" + libro + "}";
    }
}
