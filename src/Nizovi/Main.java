package Nizovi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void stampaNiza(int a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void unosNiza(int a[]) {
        for(int i = 0; i < a.length; i++) { // za zadatak 15 ovdje mora biti a.length - 1
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

    // ZAD 8.
    // Ako je polinom dat nizom svojih koeficijenata (npr. niz [2, 1, 5, 4]
    // predstavlja polinom 2+x+5x2+4x3), napisati funkciju float polinom(float a[], float x)
    // koji izračunava vrijednost polinoma u tački x.

    public static int zad8(int a[], int x) {

        int vrijednost = 0;
        for(int i = 0; i < a.length; i++) {
            vrijednost += a[i] * (int)Math.pow(x, i);
        }

        return vrijednost;
    }

    // ZAD 9.
    //Napisati program koji u datom nizu cijelih brojeva a pronalazi sve indekse i takve da
    //važi da je suma elemenata niza prije elementa a[i] jednaka sumi elemenata nakon tog elementa.
    //Ukoliko takav indeks ne postoji, štampati -1. Na primjer, ako je dat niz a=[ 0, -3, 5, -4, -2, 3, 1, 0]
    //indeksi koji ispunjavaju ovaj uslov su 0,3 i 7.

    public static void zad9(int a[]) {
        int prefiksneSume[] = new int[a.length];
        prefiksneSume[0] = 0;
        for(int i = 1; i < a.length; i++) {
            prefiksneSume[i] = prefiksneSume[i-1] + a[i-1];
        }
        int suma = 0;
        int indicator = 1;
        for(int i = a.length - 1; i >= 0; i--) {
            if(i != a.length - 1) {
                suma += a[i + 1];
            }
            if(suma == prefiksneSume[i]) {
                System.out.print(i + " ");
                indicator = 0;
            }
        }
        if(indicator == 1) System.out.println(-1);
    }

    // ZAD 10.
    //Napisati funkciju void rotiraj(int a[], int k) koja rotira elemente
    //niza a ciklično ulijevo za k mjesta. Na primjer, ako je niz
    //a: [3, 12, 7, 25, 6, 19, 31, 22] i k=3, nakon primjene ove funkcije niz treba da
    //izgleda ovako: [25, 6, 19, 31, 22, 3, 12, 7].

    public static void zad10(int a[], int k) {
        int pomocni[] = new int[k];
        for(int i = 0; i < k; i++) {
            pomocni[i] = a[i];
        }
        for(int i = k; i < a.length; i++) {
            a[i - k] = a[i];
        }
        for(int i = a.length - k; i < a.length; i++) {
            a[i] = pomocni[i - (a.length - k)];
        }
    }

    // ZAD 11.
    // Napisati program koji učitava niz cijelih brojeva i provjerava
    // da li u tom nizu ima duplikata (elemenata koji se javljaju više od jednog puta).
    public static boolean zad11(int a[]) {
        Arrays.sort(a);
        for(int i = 1; i < a.length; i++) {
            if(a[i] == a[i-1]){
                return true; // postoje duplikati
            }
        }
        return false; // ne postoje
    }

    // ZAD 12.
    //Napisati program koji učitava niz od n prirodnih brojeva.
    //Svaki element niza je broj manji ili jednak n. Program treba da odštampa sve
    //prirodne brojeve manje ili jednake n koji se ne pojavljuju u unesenom nizu.

    public static void zad12(int a[]) {
        Arrays.sort(a);
        int pojavljivanje[] = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            pojavljivanje[a[i] - 1] ++;
        }
        for(int i = 0; i < a.length; i++) {
            if (pojavljivanje[i] == 0) {
                System.out.print(i+1 + " ");
            }
        }
    }

    // ZAD 13.
    //Napisati funkciju void premjesti(int a[]) koja parne elemente niza cijelih brojeva
    //a premješta na početak, a neparne na kraj.
    // Na primjer niz a: [2, 14, 25, 31, 26, 29, 47, 35]
    // treba transformisati u niz [2, 14, 26, 25, 29, 31, 47, 35].

    public static void zad13(int a[]) {
        int parni = 0, neparni = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0 ) parni++;
            else neparni++;
        }
        int nizP[] = new int[parni]; int k = 0;
        int nizN[] = new int[neparni]; int j = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) {
                nizP[k] = a[i];
                k++;
            } else {
                nizN[j] = a[i];
                j++;
            }
        }
        for(int i = 0; i < a.length; i++) {
            if(i < parni) a[i] = nizP[i];
            else a[i] = nizN[i-parni];
        }
    }

    //ZAD 14.
    //Napisati program koji u datom nizu cijelih brojeva a pronalazi
    //i štampa podniz čija je suma maksimalna. Na primjer, ako je dat
    //niz a=[ -2, 1, -3, 4, -1, 2, 1, -5, 4], podniz sa maksimalnom
    //sumom je [4, -1, 2, 1], dok je za niz a=[ 8, -7, -3, 5, 6, -2, 3, -4, 2]
    //traženi podniz [5, 6, -2, 3].

    public static void zad14(int a[]) {
        int maxSuma = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for(int i = 0; i < a.length; i++) {
            int suma = 0;
            for(int j = i; j < a.length; j++) {
                suma += a[j];
                if(suma > maxSuma) {
                    maxSuma = suma;
                    start = i;
                    end = j;
                }
            }
        }
        for(int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // ZAD 15.
    //Napisati funkciju void ubaci(int a[], int r) koja ubacuje broj r u sortiran niz a.
    public static void zad15(int a[], int x) {
        int i;
        for(i = a.length-2; i >= 0 && a[i] >= x; i--) {
            a[i+1] = a[i];
        }
        a[i+1] = x;

    }
    public static void main(String[] args) {
        int n;
        n = in.nextInt();
        int niz[] = new int[n]; // za zadatak 15 ovdje mora da stoji n+1, a ne n
        //int niz2[] = new int[n];
        unosNiza(niz);
        //unosNiza(niz2);

        // ----- TESTOVI ZADATAKA ----- //
        //System.out.println(zad1(niz));
        //System.out.println(zad2(niz));
        //System.out.println(zad3(niz, 5));
        //stampaNiza(zad4(niz));
        //zad5(niz);
        //stampaNiza(zad6(niz, niz2, 12));
        //zad7(niz);
        //System.out.println(zad8(niz, 3));
        //zad9(niz);
        //zad10(niz, 3); stampaNiza(niz);
        //System.out.println(zad11(niz));
        //zad12(niz);
        //zad13(niz); stampaNiza(niz);
        //zad14(niz);
        //zad15(niz, 18); stampaNiza(niz); //pogledati napomene kod int niz i unosa niza;
    }
}
