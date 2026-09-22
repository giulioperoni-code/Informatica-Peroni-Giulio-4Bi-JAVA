package logica;

import java.util.Arrays;

public class CollezioneTelefilm {

    private Telefilm[] listaTelefilm;
    private int numTelefilm; // numero di telefilm effettivamente inseriti
    

    public CollezioneTelefilm(int numTelefilm) {
        this.listaTelefilm = new Telefilm[numTelefilm];
        this.numTelefilm = 0;
    }

    public CollezioneTelefilm() {
        this(10); // dimensione predefinita di 10
    }


    public void aggiungiTelefilm(Telefilm telefilm) {
        if (numTelefilm < listaTelefilm.length) {
            listaTelefilm[numTelefilm] = telefilm;
            numTelefilm++;
        } else {
            System.out.println("Impossibile aggiungere il telefilm. La collezione è piena.");
        }
    }

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


	public void setListaTelefilm(Telefilm[] listaTelefilm) {
		this.listaTelefilm = listaTelefilm;
	}

	public void setNumTelefilm(int numTelefilm) {
		this.numTelefilm = numTelefilm;
	}

	public Telefilm[] getListaTelefilm() {
		return listaTelefilm;
	}

	public int getNumTelefilm() {
		return numTelefilm;
	}

	@Override
	public String toString() {
		return "CollezioneTelefilm [getListaTelefilm()=" + Arrays.toString(getListaTelefilm()) + ", getNumTelefilm()="
				+ getNumTelefilm() + "]";
	}
    
    
    

}
