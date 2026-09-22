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
            System.out.print("Inserisci il nome del telefilm: ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci il genere: ");
            Genere genere = Genere.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Inserisci lo stato (IN_CORSO o TERMINATO): ");
            Stato stato = Stato.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Inserisci il numero di stagioni: ");
            int numeroStagioni = Integer.parseInt(scanner.nextLine());
            Stagione[] stagioni = new Stagione[numeroStagioni];

            for (int i = 0; i < numeroStagioni; i++) {
                System.out.println("\nDati della stagione " + (i + 1));
                System.out.print("Numero della stagione: ");
                int numeroStagione = Integer.parseInt(scanner.nextLine());
                System.out.print("Numero di episodi: ");
                int numeroEpisodi = Integer.parseInt(scanner.nextLine());
                System.out.print("Nome dello sceneggiatore: ");
                String nomeSceneggiatore = scanner.nextLine();
                System.out.print("Trama: ");
                String trama = scanner.nextLine();

                stagioni[i] = new Stagione(numeroEpisodi, nomeSceneggiatore, trama, numeroStagione);
            }

            Telefilm telefilm = new Telefilm(nome, stato, genere, stagioni);
            telefilm.ordinaStagioniPerNumero();

            System.out.println("\nTelefilm creato:");
            System.out.println(telefilm);
            System.out.println("Numero medio di episodi per stagione: " + telefilm.mediaEpisodi());

            System.out.print("Inserisci uno sceneggiatore da cercare: ");
            String sceneggiatore = scanner.nextLine();
            System.out.println("Sceneggiatore presente: " + telefilm.haSceneggiatore(sceneggiatore));

            CollezioneTelefilm collezione = new CollezioneTelefilm();
            collezione.aggiungiTelefilm(telefilm);
            collezione.ordinaTelefilmPerNome();
            System.out.println("\nCollezione ordinata:");
            System.out.println(collezione);
        } catch (Exception exception) {
            System.out.println("Errore: " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
