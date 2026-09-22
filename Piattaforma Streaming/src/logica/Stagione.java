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
      * @throws IllegalArgumentException se un valore non e valido
     */
    public Stagione(int numeroEpisodi, String nomeSceneggiatore, String trama, int numeroStagione) {
          setNumeroEpisodi(numeroEpisodi);
          setNomeSceneggiatore(nomeSceneggiatore);
          setTrama(trama);
          setNumeroStagione(numeroStagione);
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
    * @throws IllegalArgumentException se il numero non e positivo
     */
    public void setNumeroEpisodi(int numeroEpisodi) {
        if (numeroEpisodi <= 0) {
            throw new IllegalArgumentException("Il numero di episodi deve essere positivo.");
        }
        this.numeroEpisodi = numeroEpisodi;
    }

    /**
     * Imposta il nome dello sceneggiatore.
     *
     * @param nomeSceneggiatore nuovo nome dello sceneggiatore
    * @throws IllegalArgumentException se il nome e nullo o vuoto
     */
    public void setNomeSceneggiatore(String nomeSceneggiatore) {
        if (nomeSceneggiatore == null || nomeSceneggiatore.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome dello sceneggiatore non puo essere vuoto.");
        }
        this.nomeSceneggiatore = nomeSceneggiatore;
    }

    /**
     * Imposta la trama.
     *
     * @param trama nuova trama della stagione
    * @throws IllegalArgumentException se la trama e nulla o vuota
     */
    public void setTrama(String trama) {
        if (trama == null || trama.trim().isEmpty()) {
            throw new IllegalArgumentException("La trama non puo essere vuota.");
        }
        this.trama = trama;
    }

    /**
     * Imposta il numero della stagione.
     *
     * @param numeroStagione nuovo numero della stagione
    * @throws IllegalArgumentException se il numero non e positivo
     */
    public void setNumeroStagione(int numeroStagione) {
        if (numeroStagione <= 0) {
            throw new IllegalArgumentException("Il numero della stagione deve essere positivo.");
        }
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
