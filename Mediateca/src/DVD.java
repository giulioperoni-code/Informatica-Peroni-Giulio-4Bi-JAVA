public class DVD extends Materiale {
    public int durata;

    public DVD() {
    }

    public DVD(String codice, String titolo, int durata) {
        super(codice, titolo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return super.toString() + ", Durata: " + durata;
    }
}
