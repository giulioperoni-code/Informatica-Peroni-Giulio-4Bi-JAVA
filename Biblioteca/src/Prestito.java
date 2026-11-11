import java.time.LocalDate;

/**
 * Rappresenta un prestito di una copia di libro ad un cliente.
 */
public class Prestito {
    private String id;
    private LocalDate dataInizio;
    private LocalDate dataScadenza;
    private LocalDate dataRestituzione;
    private Cliente cliente;
    private CopiaLibro copiaLibro;

    /**
     * Costruisce un nuovo prestito.
     *
     * @param id l'identificativo del prestito
     * @param dataInizio la data di inizio del prestito
     * @param dataScadenza la data di scadenza del prestito
     * @param cliente il cliente che richiede il prestito
     * @param copiaLibro la copia del libro in prestito
     */
    public Prestito(String id, LocalDate dataInizio, LocalDate dataScadenza, Cliente cliente, CopiaLibro copiaLibro) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataScadenza = dataScadenza;
        this.dataRestituzione = null;
        this.cliente = cliente;
        this.copiaLibro = copiaLibro;

        this.copiaLibro.impostaInPrestito();
        this.cliente.aggiungiPrestito(this);
        this.copiaLibro.aggiungiPrestito(this);
    }

    /**
     * Restituisce l'identificativo del prestito.
     *
     * @return l'identificativo del prestito
     */
    public String getId() {
        return id;
    }

    /**
     * Restituisce la data di inizio del prestito.
     *
     * @return la data di inizio del prestito
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Restituisce la data di scadenza del prestito.
     *
     * @return la data di scadenza del prestito
     */
    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Restituisce la data di restituzione del prestito, se presente.
     *
     * @return la data di restituzione o null se il prestito è ancora attivo
     */
    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    /**
     * Restituisce il cliente che ha preso in prestito il libro.
     *
     * @return il cliente coinvolto nel prestito
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Restituisce la copia del libro coinvolta nel prestito.
     *
     * @return la copia del libro coinvolta nel prestito
     */
    public CopiaLibro getCopiaLibro() {
        return copiaLibro;
    }

    /**
     * Registra la restituzione del libro in una data specifica.
     *
     * @param data la data di restituzione
     */
    public void registraRestituzione(LocalDate data) {
        this.dataRestituzione = data;
        this.copiaLibro.impostaDisponibile();
    }

    /**
     * Verifica se il prestito è ancora attivo.
     *
     * @return true se il prestito è ancora attivo, false altrimenti
     */
    public Boolean attivo() {
        return dataRestituzione == null;
    }

    /**
     * Restituisce una rappresentazione testuale del prestito.
     *
     * @return una stringa riepilogativa del prestito
     */
    @Override
    public String toString() {
        return "Prestito{id='" + id + "', dataInizio=" + dataInizio + ", dataScadenza=" + dataScadenza +
                ", dataRestituzione=" + dataRestituzione + ", cliente=" + cliente.getNome() + " " + cliente.getCognome() +
                ", copiaLibro=" + copiaLibro.getBarcode() + "}";
    }
}
