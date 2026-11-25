public class App {
    public static void main(String[] args) throws Exception {
        Materiale m = new Materiale("C1", "OOP - no pronplem");

        System.out.println(m.descrizione());

        Libro l1 = new Libro("C2", "Ereditarietà", "Montini");
        System.out.println(l1.descrizione());
    }
}
