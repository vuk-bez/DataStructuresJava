package CirkularnaLista;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println(lista.toString());
        lista.addFirst(5);
        lista.addLast(4);
        lista.addFirst(3);
        System.out.println(lista.toString());
        lista.deleteFirst(4);
        lista.addLast(7);
        System.out.println(lista.toString());
        lista.deleteFirst(3);
        lista.addLast(8);
        lista.addFirst(90);
        System.out.println(lista.toString());

        lista.addFirst(5);
        System.out.println(lista.toString());
        lista.deleteLast(5);
        System.out.println(lista.toString());
    }
}
