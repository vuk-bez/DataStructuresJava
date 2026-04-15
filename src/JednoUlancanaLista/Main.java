package JednoUlancanaLista;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
            // TESTIRANJE
        Lista test = new Lista();
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        test.addFirst(4);
        test.addLast(13);
        System.out.println(test.getFirst());
        System.out.println(test.getLast());
        test.stampajListu();
        //System.out.println();
        //test.dodaj1();
        //test.stampajListu();
        System.out.println();
        //test.dodaj2(2);
        //test.stampajListu();
        //test.dodaj3(2, 10);
        //test.stampajListu();
        test.obrisi(1, 1);
        test.stampajListu();
        System.out.println(test.pronadjiSredinu());

        LinkedList<Integer> lista = new LinkedList<>();


    }
}
