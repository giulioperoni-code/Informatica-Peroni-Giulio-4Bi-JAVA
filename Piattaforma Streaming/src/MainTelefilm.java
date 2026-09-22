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

        String nome = leggiTesto(scanner, "Inserisci il nome del telefilm: ");
        Genere genere = leggiGenere(scanner);
        Stato stato = leggiStato(scanner);
        int numeroStagioni = leggiInteroPositivo(scanner, "Inserisci il numero di stagioni: ");
        Stagione[] stagioni = new Stagione[numeroStagioni];

        for (int i = 0; i < numeroStagioni; i++) {
            System.out.println("\nDati della stagione " + (i + 1));
            int numeroStagione = leggiInteroPositivo(scanner, "Numero della stagione: ");
            int numeroEpisodi = leggiInteroPositivo(scanner, "Numero di episodi: ");
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

        scanner.close();
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
     * Legge dalla tastiera un numero intero positivo.
     *
     * @param scanner scanner usato per leggere l'input
     * @param messaggio messaggio mostrato all'utente
     * @return numero intero positivo inserito dall'utente
     */
    private static int leggiInteroPositivo(Scanner scanner, String messaggio) {
        while (true) {
            try {
                System.out.print(messaggio);
                int valore = Integer.parseInt(scanner.nextLine().trim());
                if (valore > 0) {
                    return valore;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Inserisci un numero intero positivo.");
        }
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
