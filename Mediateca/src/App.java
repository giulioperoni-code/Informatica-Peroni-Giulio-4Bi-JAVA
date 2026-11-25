public class App {
    public static void main(String[] args) throws Exception {
        Materiale m = new Materiale("C1", "OOP - no problem");

        System.out.println(m.descrizione());

        Libro l1 = new Libro("C2", "Ereditarietà", "Montini");
        System.out.println(l1.descrizione());

        Materiale l2 = new Libro("C3", "Polimorfismo", "Montini");
        System.out.println(l2.descrizione());
    }
}
