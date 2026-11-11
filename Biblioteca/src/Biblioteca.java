import java.time.LocalDate;

/**
 * Gestisce il catalogo della biblioteca e i prestiti dei clienti.
 */
public class Biblioteca {
    private static final int CAPACITA = 100;

    private Cliente[] clienti;
    private Libro[] libri;
    private CopiaLibro[] copie;
    private Prestito[] prestiti;
    private int numeroClienti;
    private int numeroLibri;
    private int numeroCopie;
    private int numeroPrestiti;

    /**
     * Costruisce una nuova biblioteca con capacità fissa.
     */
    public Biblioteca() {
        this.clienti = new Cliente[CAPACITA];
        this.libri = new Libro[CAPACITA];
        this.copie = new CopiaLibro[CAPACITA];
        this.prestiti = new Prestito[CAPACITA];
        this.numeroClienti = 0;
        this.numeroLibri = 0;
        this.numeroCopie = 0;
        this.numeroPrestiti = 0;
    }

    /**
     * Registra un nuovo cliente nella biblioteca.
     *
     * @param cliente il cliente da registrare
     */
    public void registraCliente(Cliente cliente) {
        if (numeroClienti < clienti.length) {
            clienti[numeroClienti] = cliente;
            numeroClienti++;
        }
    }

    /**
     * Registra un nuovo libro nel catalogo della biblioteca.
     *
     * @param libro il libro da registrare
     */
    public void registraLibro(Libro libro) {
        if (numeroLibri < libri.length) {
            libri[numeroLibri] = libro;
            numeroLibri++;
        }
    }

    /**
     * Registra una nuova copia di un libro.
     *
     * @param copia la copia da registrare
     */
    public void registraCopia(CopiaLibro copia) {
        if (numeroCopie < copie.length) {
            copie[numeroCopie] = copia;
            numeroCopie++;
        }
    }

    /**
     * Effettua un prestito verificando disponibilità e stato del cliente.
     *
     * @param idPrestito l'identificativo del prestito
     * @param barcode il codice a barre della copia richiesta
     * @param idCliente l'identificativo del cliente
     * @param dataInizio la data di inizio del prestito
     * @param dataScadenza la data di scadenza del prestito
     */
    public void effettuaPrestito(String idPrestito, String barcode, int idCliente, LocalDate dataInizio, LocalDate dataScadenza) {
        Cliente cliente = trovaClientePerId(idCliente);
        CopiaLibro copia = trovaCopiaPerBarcode(barcode);

        if (cliente == null || copia == null) {
            System.out.println("Cliente o copia non trovati.");
            return;
        }

        if (!copia.prestabile()) {
            System.out.println("La copia non è prestabile.");
            return;
        }

        if (clienteHaPrestitiAttiviScaduti(cliente)) {
            System.out.println("Il cliente ha prestiti attivi scaduti.");
            return;
        }

        Prestito prestito = new Prestito(idPrestito, dataInizio, dataScadenza, cliente, copia);

        if (numeroPrestiti < prestiti.length) {
            prestiti[numeroPrestiti] = prestito;
            numeroPrestiti++;
        }
    }

    /**
     * Registra la restituzione di una copia di libro.
     *
     * @param barcode il codice a barre della copia restituita
     * @param data la data di restituzione
     */
    public void registraRestituzione(String barcode, LocalDate data) {
        CopiaLibro copia = trovaCopiaPerBarcode(barcode);
        if (copia == null) {
            System.out.println("Copia non trovata.");
            return;
        }

        for (int i = 0; i < numeroPrestiti; i++) {
            if (prestiti[i] != null && prestiti[i].getCopiaLibro() == copia && prestiti[i].attivo()) {
                prestiti[i].registraRestituzione(data);
                break;
            }
        }
    }

    /**
     * Elenca i prestiti attivi di un cliente.
     *
     * @param idCliente l'identificativo del cliente
     * @return un array con i prestiti attivi del cliente
     */
    public Prestito[] elencaPrestitiAttiviCliente(int idCliente) {
        Cliente cliente = trovaClientePerId(idCliente);
        if (cliente == null) {
            return new Prestito[0];
        }

        Prestito[] prestitiCliente = cliente.getPrestiti();
        Prestito[] attivi = new Prestito[prestitiCliente.length];
        int conta = 0;
        for (int i = 0; i < prestitiCliente.length; i++) {
            if (prestitiCliente[i] != null && prestitiCliente[i].attivo()) {
                attivi[conta] = prestitiCliente[i];
                conta++;
            }
        }

        Prestito[] risultato = new Prestito[conta];
        for (int i = 0; i < conta; i++) {
            risultato[i] = attivi[i];
        }
        return risultato;
    }

    /**
     * Segnala una copia come smarrita.
     *
     * @param barcode il codice a barre della copia da segnalare
     */
    public void segnalaCopiaSmarrita(String barcode) {
        CopiaLibro copia = trovaCopiaPerBarcode(barcode);
        if (copia != null) {
            copia.impostaSmarrita();
        }
    }

    /**
     * Segnala una copia come non prestabile.
     *
     * @param barcode il codice a barre della copia da segnalare
     */
    public void segnalaCopiaNonPrestabile(String barcode) {
        CopiaLibro copia = trovaCopiaPerBarcode(barcode);
        if (copia != null) {
            copia.impostaNonPrestabile();
        }
    }

    private Cliente trovaClientePerId(int idCliente) {
        for (int i = 0; i < numeroClienti; i++) {
            if (clienti[i] != null && clienti[i].getId() == idCliente) {
                return clienti[i];
            }
        }
        return null;
    }

    private CopiaLibro trovaCopiaPerBarcode(String barcode) {
        for (int i = 0; i < numeroCopie; i++) {
            if (copie[i] != null && copie[i].getBarcode().equals(barcode)) {
                return copie[i];
            }
        }
        return null;
    }

    private boolean clienteHaPrestitiAttiviScaduti(Cliente cliente) {
        Prestito[] prestitiCliente = cliente.getPrestiti();
        for (int i = 0; i < prestitiCliente.length; i++) {
            if (prestitiCliente[i] != null && prestitiCliente[i].attivo() && prestitiCliente[i].getDataScadenza().isBefore(LocalDate.now())) {
                return true;
            }
        }
        return false;
    }

}
