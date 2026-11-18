public class App {
    public static void main(String[] args) throws Exception {
        Libro libro = new Libro("L001", "Il Signore degli Anelli", "J. R. R. Tolkien");
        DVD dvd = new DVD("D001", "Interstellar", 169);

        System.out.println(libro);
        System.out.println(dvd);
    }
}
