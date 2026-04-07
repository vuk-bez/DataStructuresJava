package Nizovi;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void stampaNiza(int a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void unosNiza(int a[]) {
        for(int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
    }

    // ZAD 1.
    //Napisati funkciju int zad1(int a[]) koja izračunava maksimalni element u nizu.
    public static int zad1(int a[]) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    //ZAD 2.
    //Napisati funkciju float prosjek(int a[]) koja izračunava srednju vrijednost niza cijelih brojeva.
    public static float zad2(int a[]) {
        float prosjek = 0;
        for(int i = 0; i < a.length; i++) {
            prosjek += a[i];
        }
        prosjek = (float)prosjek/a.length;
        return prosjek;
    }

    //ZAD 3.
    // Napisati funkciju int prebroj(int a[], int k)  koja izračunava
    // koliko ima parnih brojeva većih od unesenog broja k u nizu cijelih brojeva a.

    public static int zad3(int a[], int k) {
        int brojac = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0 && a[i] > k) {
                brojac++;
            }
        }
        return brojac;
    }

    // ZAD 4.
    // Napisati program koji učitava broj n i niz cijelih brojeva a dužine n.
    // Zatim se na osnovu ovog niza formira i ispisuje niz b u kojem se svaki element duplira.
    // Na primjer, za niz a: [1, 2, 3], niz b je: [1, 1, 2, 2, 3, 3].

    public static int[] zad4(int a[]) {
        int b[] = new int[a.length*2];
        int j = 0;
        for(int i = 0; i < a.length; i++) {
            b[j] = a[i];
            b[++j] = a[i];
            j++;
        }
        return b;
    }

    // ZAD 5.
    // Napisati program koji od niza cijelih brojeva a formira nizove b i c,
    // tako da su elementi niza b parni elementi niza a, a elementi niza c neparni elementi.

    public static void zad5(int a[]) {
        int parni = 0;
        int neparni = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) parni++;
            else neparni++;
        }

        int b[] = new int[neparni];
        int c[] = new int[parni];
        int j = 0, k = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) {
                c[j] = a[i];
                j++;
            } else {
                b[k] = a[i];
                k++;
            }
        }

        System.out.println("Neparni: ");
        stampaNiza(b);
        System.out.println(); // novi red
        System.out.println("Parni: ");
        stampaNiza(c);

    }

    //ZAD 6.
    // Dato je n intervala pomoću nizova realnih brojva a i b: (a[0], b[0]), (a[1], b[1]), …, (a[n-1], b[n-1]).
    // Napisati program koji formira niz c u kojem se nalaze indeksi intervala kojima pripada unesena tačka x.

    public static int[] zad6(int a[], int b[], int x) {
        int brojac = 0;

        for(int i = 0; i < a.length; i++) { // napomena! a i b su istih duzina
            if(a[i] < x && x < b[i]) {
                brojac ++;
            }
        }

        int c[] = new int[brojac];
        int j = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] < x && x < b[i]) {
                c[j++] = i;
            }
        }

        return c;
    }

    // ZAD 7.
    // Napisati funkciju boolean sortiran(int a[])
    // koji provjerava da li je dati niz sortiran i ako jeste ispisuje u kom poretku je sortiran.

    public static boolean zad7(int a[]) {
        int opadajuci = 1;
        int rastuci = 1;

        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] < a[i+1]) opadajuci = 0;
            if(a[i] > a[i+1]) rastuci = 0;
        }

        if(rastuci == 1) {
            System.out.println("Rastuci je sortiran");
            return true;
        } else if (opadajuci == 1) {
            System.out.println("Opadajuci je sortiran");
            return true;
        } else {
            System.out.println("Nije sortiran");
            return false;
        }
    }


    public static void main(String[] args) {
        int n;
        n = in.nextInt();
        int niz[] = new int[n];
        //int niz2[] = new int[n];
        unosNiza(niz);
        //unosNiza(niz2);

        //System.out.println(zad1(niz));
        //System.out.println(zad2(niz));
        //System.out.println(zad3(niz, 5));
        //stampaNiza(zad4(niz));
        //zad5(niz);
        //stampaNiza(zad6(niz, niz2, 12));
        zad7(niz);

    }
}
