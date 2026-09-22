package logica;

/**
 * Rappresenta una stagione di un telefilm.
 */
public class Stagione {

    /** Numero di episodi della stagione. */
    private int numeroEpisodi;
    /** Nome dello sceneggiatore della stagione. */
    private String nomeSceneggiatore;
    /** Trama della stagione. */
    private String trama;
    /** Numero progressivo della stagione. */
    private int numeroStagione;

    /**
     * Crea una stagione con i dati specificati.
     *
     * @param numeroEpisodi numero di episodi della stagione
     * @param nomeSceneggiatore nome dello sceneggiatore della stagione
     * @param trama trama della stagione
     * @param numeroStagione numero della stagione
     */
    public Stagione(int numeroEpisodi, String nomeSceneggiatore, String trama, int numeroStagione) {
        this.numeroEpisodi = numeroEpisodi;
        this.nomeSceneggiatore = nomeSceneggiatore;
        this.trama = trama;
        this.numeroStagione = numeroStagione;

    }

    /**
     * Crea una stagione vuota con numero predefinito pari a 1.
     */
    public Stagione() {
        this.numeroEpisodi = 0;
        this.nomeSceneggiatore = "";
        this.trama = "";
        this.numeroStagione = 1;
    }

    /**
     * Imposta il numero di episodi.
     *
     * @param numeroEpisodi nuovo numero di episodi
     */
    public void setNumeroEpisodi(int numeroEpisodi) {
        this.numeroEpisodi = numeroEpisodi;
    }

    /**
     * Imposta il nome dello sceneggiatore.
     *
     * @param nomeSceneggiatore nuovo nome dello sceneggiatore
     */
    public void setNomeSceneggiatore(String nomeSceneggiatore) {
        this.nomeSceneggiatore = nomeSceneggiatore;
    }

    /**
     * Imposta la trama.
     *
     * @param trama nuova trama della stagione
     */
    public void setTrama(String trama) {
        this.trama = trama;
    }

    /**
     * Imposta il numero della stagione.
     *
     * @param numeroStagione nuovo numero della stagione
     */
    public void setNumeroStagione(int numeroStagione) {
        this.numeroStagione = numeroStagione;
    }
    /**
     * Restituisce il numero di episodi.
     *
     * @return numero di episodi della stagione
     */
    public int getNumeroEpisodi() {
        return numeroEpisodi;
    }

    /**
     * Restituisce il nome dello sceneggiatore.
     *
     * @return nome dello sceneggiatore
     */
    public String getNomeSceneggiatore() {
        return nomeSceneggiatore;
    }

    /**
     * Restituisce la trama.
     *
     * @return trama della stagione
     */
    public String getTrama() {
        return trama;
    }

    /**
     * Restituisce il numero della stagione.
     *
     * @return numero della stagione
     */
    public int getNumeroStagione() {
        return numeroStagione;
    }

    /**
     * Restituisce una rappresentazione testuale della stagione.
     *
     * @return dati della stagione in formato testuale
     */
    @Override
    public String toString() {
        return "Stagione [numeroEpisodi=" + numeroEpisodi + ", nomeSceneggiatore=" + nomeSceneggiatore + ", trama="
                + trama + ", numeroStagione=" + numeroStagione + "]";
    }

}
