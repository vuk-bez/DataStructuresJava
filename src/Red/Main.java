package Red;

/*
REDOVI - linearna, homogena, dinamicka strutura sa FIFO pristupom;
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ulaz = new Scanner(System.in);
        int n = ulaz.nextInt();
        RedSekvencijalan red1 = new RedSekvencijalan(n);
        red1.insert(6);
        red1.insert(5);
        red1.insert(4);
        red1.insert(3);

        System.out.println(red1.delete());
        System.out.println(red1.delete());
        System.out.println(red1.delete());
        System.out.println(red1.delete());
        System.out.println(red1.RedEmpty());

    }
}