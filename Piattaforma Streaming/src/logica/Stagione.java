package logica;

public class Stagione {

    private int numeroEpisodi;
    private String nomeSceneggiatore;
    private String trama;
    private int numeroStagione;

    /**
     * 
     * @param numeroEpisodi numero di eopisodi della stagione
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

    public Stagione() {
        this.numeroEpisodi = 0;
        this.nomeSceneggiatore = "";
        this.trama = "";
        this.numeroStagione = 0;
    }

    // setter

    public void setNumeroEpisodi(int numeroEpisodi) {
        this.numeroEpisodi = numeroEpisodi;
    }

    public void setNomeSceneggiatore(String nomeSceneggiatore) {
        this.nomeSceneggiatore = nomeSceneggiatore;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public void setNumeroStagione(int numeroStagione) {
        this.numeroStagione = numeroStagione;
    }

    

    public int getNumeroEpisodi() {
        return numeroEpisodi;
    }

    public String getNomeSceneggiatore() {
        return nomeSceneggiatore;
    }

    public String getTrama() {
        return trama;
    }

    public int getNumeroStagione() {
        return numeroStagione;
    }

    @Override
    public String toString() {
        return "Stagione [numeroEpisodi=" + numeroEpisodi + ", nomeSceneggiatore=" + nomeSceneggiatore + ", trama="
                + trama + ", numeroStagione=" + numeroStagione + "]";
    }

}
