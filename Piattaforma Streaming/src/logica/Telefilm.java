package logica;

import java.util.Arrays;

public class Telefilm {
    private String nome;
    private Stato stato;
    private Genere genere;
    private Stagione[] stagioni;

    public Telefilm() {
        this("", Stato.IN_CORSO, Genere.DRAMMATICO, new Stagione[0]);
    }
    
    public Telefilm(String nome, Stato stato, Genere genere, Stagione[] stagioni) {
        this.nome = nome;
        this.stato = stato;
        this.genere = genere;
        this.stagioni = stagioni;
    }


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

    public boolean haSceneggiatore(String nomeSceneggiatore) {
        for (Stagione stagione : stagioni) {
            if (stagione.getNomeSceneggiatore().equalsIgnoreCase(nomeSceneggiatore)) {
                return true;
            }
        }
        return false;
    }

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


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setStagioni(Stagione[] stagioni) {
        this.stagioni = stagioni;
    }

    public String getNome() {
        return nome;
    }

    public Stato getStato() {
        return stato;
    }

    public Genere getGenere() {
        return genere;
    }

    public Stagione[] getStagioni() {
        return stagioni;
    }

    @Override
    public String toString() {
        return "Telefilm [getNome()=" + getNome() + ", getStato()=" + getStato() + ", getGenere()=" + getGenere()
                + ", getStagioni()=" + Arrays.toString(getStagioni()) + "]";
    }


    

}
