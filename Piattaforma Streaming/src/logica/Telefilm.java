package logica;

import java.util.Arrays;

/**
 * Rappresenta un telefilm e l'insieme delle sue stagioni.
 */
public class Telefilm {
    /** Nome del telefilm. */
    private String nome;
    /** Stato della produzione del telefilm. */
    private Stato stato;
    /** Genere del telefilm. */
    private Genere genere;
    /** Stagioni che compongono il telefilm. */
    private Stagione[] stagioni;

    /**
     * Crea un telefilm vuoto con valori predefiniti.
     */
    public Telefilm() {
        this("", Stato.IN_CORSO, Genere.DRAMMATICO, new Stagione[0]);
    }
    /**
     * Crea un telefilm con i dati specificati.
     *
     * @param nome nome del telefilm
     * @param stato stato della produzione
     * @param genere genere del telefilm
     * @param stagioni stagioni del telefilm
     */
    public Telefilm(String nome, Stato stato, Genere genere, Stagione[] stagioni) {
        this.nome = nome;
        this.stato = stato;
        this.genere = genere;
        this.stagioni = stagioni;
    }
    /**
     * Calcola il numero medio di episodi per stagione.
     *
     * @return media degli episodi, oppure 0 se non ci sono stagioni
     */
    public double mediaEpisodi() {
        if (stagioni.length == 0) {
            return 0.0;
        }
        int totaleEpisodi = 0;
        for (Stagione stagione : stagioni) {
            totaleEpisodi += stagione.getNumeroEpisodi();
        }
        return (double) totaleEpisodi / stagioni.length;
    }

    /**
     * Verifica se uno sceneggiatore ha lavorato in almeno una stagione.
     *
     * @param nomeSceneggiatore nome dello sceneggiatore da cercare
     * @return true se lo sceneggiatore e presente, false altrimenti
     */
    public boolean haSceneggiatore(String nomeSceneggiatore) {
        for (Stagione stagione : stagioni) {
            if (stagione.getNomeSceneggiatore().equalsIgnoreCase(nomeSceneggiatore)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ordina le stagioni in ordine crescente in base al loro numero.
     */
    public void ordinaStagioniPerNumero() {
        // Ordinamento a bolle (bubble sort) in base al numero di stagione
        for (int i = 0; i < stagioni.length - 1; i++) {

            for (int j = 0; j < stagioni.length - 1 - i; j++) {

                if (stagioni[j].getNumeroStagione() > stagioni[j + 1].getNumeroStagione()) {
                    // scambio le due stagioni di posizione

                    Stagione temp = stagioni[j];
                    stagioni[j] = stagioni[j + 1];
                    stagioni[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Imposta il nome del telefilm.
     *
     * @param nome nuovo nome del telefilm
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta lo stato della produzione.
     *
     * @param stato nuovo stato della produzione
     */
    public void setStato(Stato stato) {
        this.stato = stato;
    }

    /**
     * Imposta il genere del telefilm.
     *
     * @param genere nuovo genere del telefilm
     */
    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    /**
     * Imposta le stagioni del telefilm.
     *
     * @param stagioni nuovo insieme di stagioni
     */
    public void setStagioni(Stagione[] stagioni) {
        this.stagioni = stagioni;
    }

    /**
     * Restituisce il nome del telefilm.
     *
     * @return nome del telefilm
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce lo stato della produzione.
     *
     * @return stato della produzione
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * Restituisce il genere del telefilm.
     *
     * @return genere del telefilm
     */
    public Genere getGenere() {
        return genere;
    }

    /**
     * Restituisce le stagioni del telefilm.
     *
     * @return array delle stagioni
     */
    public Stagione[] getStagioni() {
        return stagioni;
    }

    /**
     * Restituisce una rappresentazione testuale del telefilm.
     *
     * @return dati del telefilm in formato testuale
     */
    @Override
    public String toString() {
        return "Telefilm [getNome()=" + getNome() + ", getStato()=" + getStato() + ", getGenere()=" + getGenere()
                + ", getStagioni()=" + Arrays.toString(getStagioni()) + "]";
    }


    

}
