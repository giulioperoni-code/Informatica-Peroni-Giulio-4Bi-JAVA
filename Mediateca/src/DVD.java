public class DVD extends Materiale {
    public String regista;

    public DVD(String codice, String titolo, String regista) {
        super(codice, titolo);
        this.regista = regista;
    }

    @Override
    public String descrizione() {
        return super.descrizione() + ", Regista: " + regista;
    }
}
