import java.util.Scanner;

import logica.CollezioneTelefilm;
import logica.Genere;
import logica.Stagione;
import logica.Stato;
import logica.Telefilm;

/**
 * Punto di ingresso dell'applicazione per la gestione dei telefilm.
 */
public class MainTelefilm {
    /** Impedisce l'istanziazione della classe principale. */
    private MainTelefilm() {
    }

    /**
     * Acquisisce i dati, crea un telefilm e mostra le operazioni richieste.
     *
     * @param args argomenti della riga di comando, non utilizzati
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            avviaApplicazione(scanner);
        } catch (Exception exception) {
            System.out.println("Errore: " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Esegue il flusso principale dell'applicazione.
     *
     * @param scanner scanner usato per leggere l'input
     */
    private static void avviaApplicazione(Scanner scanner) {

        String nome = leggiTesto(scanner, "Inserisci il nome del telefilm: ");
        Genere genere = leggiGenere(scanner);
        Stato stato = leggiStato(scanner);
        System.out.print("Inserisci il numero di stagioni: ");
        int numeroStagioni = Integer.parseInt(scanner.nextLine().trim());
        Stagione[] stagioni = new Stagione[numeroStagioni];

        for (int i = 0; i < numeroStagioni; i++) {
            System.out.println("\nDati della stagione " + (i + 1));
            System.out.print("Numero della stagione: ");
            int numeroStagione = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Numero di episodi: ");
            int numeroEpisodi = Integer.parseInt(scanner.nextLine().trim());
            String nomeSceneggiatore = leggiTesto(scanner, "Nome dello sceneggiatore: ");
            String trama = leggiTesto(scanner, "Trama: ");
            stagioni[i] = new Stagione(numeroEpisodi, nomeSceneggiatore, trama, numeroStagione);
        }

        Telefilm telefilm = new Telefilm(nome, stato, genere, stagioni);
        telefilm.ordinaStagioniPerNumero();

        System.out.println("\nTelefilm creato:");
        System.out.println(telefilm);
        System.out.println("Numero medio di episodi per stagione: " + telefilm.mediaEpisodi());

        String sceneggiatore = leggiTesto(scanner,
                "Inserisci uno sceneggiatore da cercare: ");
        System.out.println("Sceneggiatore presente: " + telefilm.haSceneggiatore(sceneggiatore));

        CollezioneTelefilm collezione = new CollezioneTelefilm();
        collezione.aggiungiTelefilm(telefilm);
        collezione.ordinaTelefilmPerNome();
        System.out.println("\nCollezione ordinata:");
        System.out.println(collezione);

    }

    /**
     * Legge una stringa non vuota dalla tastiera.
     *
     * @param scanner scanner usato per leggere l'input
     * @param messaggio messaggio mostrato all'utente
     * @return testo inserito dall'utente
     */
    private static String leggiTesto(Scanner scanner, String messaggio) {
        String testo;
        do {
            System.out.print(messaggio);
            testo = scanner.nextLine().trim();
        } while (testo.isEmpty());
        return testo;
    }

    /**
     * Legge e converte lo stato della produzione.
     *
     * @param scanner scanner usato per leggere l'input
     * @return stato selezionato dall'utente
     */
    private static Stato leggiStato(Scanner scanner) {
        while (true) {
            String valore = leggiTesto(scanner, "Stato (IN_CORSO o TERMINATO): ").toUpperCase();
            try {
                return Stato.valueOf(valore);
            } catch (IllegalArgumentException exception) {
                System.out.println("Stato non valido.");
            }
        }
    }

    /**
     * Legge e converte il genere del telefilm.
     *
     * @param scanner scanner usato per leggere l'input
     * @return genere selezionato dall'utente
     */
    private static Genere leggiGenere(Scanner scanner) {
        while (true) {
            String valore = leggiTesto(scanner, "Genere: ").toUpperCase();
            try {
                return Genere.valueOf(valore);
            } catch (IllegalArgumentException exception) {
                System.out.println("Genere non valido. Valori disponibili: "
                        + java.util.Arrays.toString(Genere.values()));
            }
        }
    }
}
