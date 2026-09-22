import java.util.Scanner;
import logica.Genere;
import logica.Stato;
import logica.Stagione;
import logica.Telefilm;
import logica.CollezioneTelefilm;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String nome = "Breaking Bad";
        Stato stato = Stato.TERMINATO;
        Genere genere = Genere.DRAMMATICO;

        System.out.print("Inserisci il numero di stagioni: ");
        int numeroStagioni = scanner.nextInt();

        Stagione[] stagioni = new Stagione[numeroStagioni];
        for (int i = 0; i < numeroStagioni; i++) {
            System.out.print("Inserisci il numero della stagione " + (i + 1) + ": ");
            int numeroStagione = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimasto

            System.out.print("Inserisci il nome dello sceneggiatore della stagione " + (i + 1) + ": ");
            String nomeSceneggiatore = scanner.nextLine();

            System.out.print("Inserisci il numero di episodi della stagione " + (i + 1) + ": ");
            int numeroEpisodi = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimasto

            stagioni[i] = new Stagione(numeroEpisodi, nomeSceneggiatore, "", numeroStagione);
        }
        // Creazione del telefilm
        Telefilm telefilm = new Telefilm(nome, stato, genere, stagioni);

        // Stampa delle informazioni del telefilm
        System.out.println(telefilm);

        // Calcolo della media degli episodi
        double mediaEpisodi = telefilm.mediaEspisodi();
        System.out.println("Media episodi per stagione: " + mediaEpisodi);

        // Ordinamento delle stagioni per numer

    }

    public static boolean sceneggiaotre(String nomeSceneggiatore) {
        for (Stagione stagione : stagioni) {
            if (stagione.getNomeSceneggiatore().equalsIgnoreCase(nomeSceneggiatore)) {
                return true;
            }
        }
        return false;
    }

}
