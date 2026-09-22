package logica;

import java.util.Arrays;

/**
 * Gestisce una collezione a capacita fissa di telefilm.
 */
public class CollezioneTelefilm {

    /** Array che contiene i telefilm della collezione. */
    private Telefilm[] listaTelefilm;
    /** Numero di telefilm effettivamente inseriti. */
    private int numTelefilm; // numero di telefilm effettivamente inseriti
    

    /**
     * Crea una collezione con la capacita indicata.
     *
     * @param numTelefilm capacita massima della collezione
     * @throws IllegalArgumentException se la capacita non e positiva
     */
    public CollezioneTelefilm(int numTelefilm) {
        if (numTelefilm <= 0) {
            throw new IllegalArgumentException("La capacita deve essere positiva.");
        }
        this.listaTelefilm = new Telefilm[numTelefilm];
        this.numTelefilm = 0;
    }

    /**
     * Crea una collezione con capacita predefinita pari a 10 telefilm.
     */
    public CollezioneTelefilm() {
        this(10); // dimensione predefinita di 10
    }
    /**
     * Aggiunge un telefilm alla prima posizione libera.
     *
     * @param telefilm telefilm da aggiungere
     */
    public void aggiungiTelefilm(Telefilm telefilm) {
        if (numTelefilm < listaTelefilm.length) {
            listaTelefilm[numTelefilm] = telefilm;
            numTelefilm++;
        } else {
            System.out.println("Impossibile aggiungere il telefilm. La collezione è piena.");
        }
    }

    /**
     * Ordina i telefilm inseriti in ordine alfabetico per nome.
     */
    public void ordinaTelefilmPerNome() {
        // Ordinamento a bolle (bubble sort) delle prime numTelefilm posizioni
        for (int i = 0; i < numTelefilm - 1; i++) {
            for (int j = 0; j < numTelefilm - 1 - i; j++) {
                if (listaTelefilm[j].getNome().compareToIgnoreCase(listaTelefilm[j + 1].getNome()) > 0) {
                    // scambio i due telefilm di posizione
                    Telefilm temp = listaTelefilm[j];
                    listaTelefilm[j] = listaTelefilm[j + 1];
                    listaTelefilm[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Imposta l'array dei telefilm.
     *
     * @param listaTelefilm nuovo array dei telefilm
     * @throws IllegalArgumentException se l'array e nullo
     */
	public void setListaTelefilm(Telefilm[] listaTelefilm) {
        if (listaTelefilm == null) {
            throw new IllegalArgumentException("La lista dei telefilm non puo essere nulla.");
        }
		this.listaTelefilm = listaTelefilm;
	}

    /**
     * Imposta il numero di telefilm inseriti.
     *
     * @param numTelefilm nuovo numero di telefilm inseriti
     * @throws IllegalArgumentException se il numero non e compreso nella capacita dell'array
     */
	public void setNumTelefilm(int numTelefilm) {
        if (numTelefilm < 0 || numTelefilm > listaTelefilm.length) {
            throw new IllegalArgumentException("Il numero di telefilm non e valido.");
        }
		this.numTelefilm = numTelefilm;
	}

    /**
     * Restituisce l'array dei telefilm.
     *
     * @return array dei telefilm
     */
	public Telefilm[] getListaTelefilm() {
		return listaTelefilm;
	}

    /**
     * Restituisce il numero di telefilm inseriti.
     *
     * @return numero di telefilm inseriti
     */
	public int getNumTelefilm() {
		return numTelefilm;
	}

    /**
     * Restituisce una rappresentazione testuale della collezione.
     *
     * @return dati della collezione in formato testuale
     */
	@Override
	public String toString() {
		return "CollezioneTelefilm [getListaTelefilm()=" + Arrays.toString(getListaTelefilm()) + ", getNumTelefilm()="
				+ getNumTelefilm() + "]";
	}
    
    
    

}
