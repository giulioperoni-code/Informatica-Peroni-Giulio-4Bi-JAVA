/**
 * Rappresenta un cliente della biblioteca.
 */
public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private Prestito[] prestiti;
    private int numeroPrestiti;

    /**
     * Costruisce un nuovo cliente.
     *
     * @param id l'identificativo del cliente
     * @param nome il nome del cliente
     * @param cognome il cognome del cliente
     */
    public Cliente(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.prestiti = new Prestito[100];
        this.numeroPrestiti = 0;
    }

    /**
     * Imposta l'identificativo del cliente.
     *
     * @param id il nuovo identificativo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce l'identificativo del cliente.
     *
     * @return l'identificativo del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il nome del cliente.
     *
     * @param nome il nuovo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il nome del cliente.
     *
     * @return il nome del cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il cognome del cliente.
     *
     * @param cognome il nuovo cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce il cognome del cliente.
     *
     * @return il cognome del cliente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Aggiunge un prestito alla lista dei prestiti del cliente.
     *
     * @param prestito il prestito da aggiungere
     */
    void aggiungiPrestito(Prestito prestito) {
        if (numeroPrestiti < prestiti.length) {
            prestiti[numeroPrestiti] = prestito;
            numeroPrestiti++;
        }
    }

    /**
     * Restituisce i prestiti associati al cliente.
     *
     * @return un array contenente i prestiti del cliente
     */
    Prestito[] getPrestiti() {
        Prestito[] risultato = new Prestito[numeroPrestiti];
        for (int i = 0; i < numeroPrestiti; i++) {
            risultato[i] = prestiti[i];
        }
        return risultato;
    }

    /**
     * Restituisce il numero di prestiti attualmente associati al cliente.
     *
     * @return il numero di prestiti del cliente
     */
    int getNumeroPrestiti() {
        return numeroPrestiti;
    }

    /**
     * Restituisce una rappresentazione testuale del cliente.
     *
     * @return una stringa riepilogativa del cliente
     */
    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome='" + nome + "', cognome='" + cognome + "'}";
    }
}
