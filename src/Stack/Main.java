package Stack;

import java.util.Scanner;

public class Main {
    public static Scanner ulaz;

    public static void ulazNiz(int[] niz) {
        for(int i = 0; i < niz.length; ++i) {
            niz[i] = ulaz.nextInt();
        }

    }

    public static void zad1(int n, int[] temp) {
        int[] rezultat = new int[n];
        StackSekvencijalan s1 = new StackSekvencijalan(n);

        for(int i = 0; i < n; ++i) {
            while(!s1.stackEmpty() && temp[s1.stackVrh()] < temp[i]) {
                s1.pop();
            }

            if (s1.stackEmpty()) {
                rezultat[i] = i;
            } else {
                rezultat[i] = i - s1.stackVrh() - 1;
            }

            s1.push(i);
        }

        for(int i = 0; i < n; ++i) {
            System.out.print(rezultat[i] + " ");
        }

    }

    public static void zad2(String rijec) {
        char[] rijec1 = rijec.toCharArray();
        StackSekvencijalan s1 = new StackSekvencijalan(rijec1.length, rijec1);

        for(int i = 0; i < rijec1.length; ++i) {
            s1.pushChar(rijec1[i]);
        }

        for(int i = 0; i < rijec1.length; ++i) {
            System.out.print(s1.popChar());
        }

    }

    public static void zad3(int n, int[] niz) {
        int[] rezultat = new int[n];
        StackSekvencijalan s1 = new StackSekvencijalan(n);

        for(int i = 0; i < n; ++i) {
            while(!s1.stackEmpty() && niz[i] > niz[s1.stackVrh()]) {
                int index = s1.pop();
                rezultat[index] = niz[i];
            }

            s1.push(i);
        }

        while(!s1.stackEmpty()) {
            rezultat[s1.pop()] = -1;
        }

        for(int i = 0; i < n; ++i) {
            System.out.print(rezultat[i] + " ");
        }

    }

    public static void main(String[] args) {
        int n = ulaz.nextInt();
        int[] niz = new int[n];
        ulazNiz(niz);
        zad3(n, niz);
    }

    static {
        ulaz = new Scanner(System.in);
    }
}
