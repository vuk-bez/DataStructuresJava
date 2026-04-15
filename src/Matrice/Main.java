package Matrice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void stampajMatrice(int matr[][]) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++ ) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ucitajMatrice(int matr[][]) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                matr[i][j] = in.nextInt();
            }
        }
    }

    public static int zad1(int matr[][]) {
        int[][] pomocna = new int[matr.length][matr[0].length];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                pomocna[i][j] = 0;
            }
        }

        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if(matr[i][j] == 2){
                    pomocna[i][j] = 1;
                    int sjever = i+1;
                    while (!(sjever > matr.length) && (matr[sjever][j] != 1 || matr[sjever][j] != 2)) {
                        pomocna[sjever][j] = 1;
                        sjever++;
                        if(sjever > matr.length){
                            break;
                        }
                    }
                    int jug = i-1;
                    while (!(jug < 0) && (matr[jug][j] != 1 || matr[jug][j] != 2)) {
                        pomocna[jug][j] = 1;
                        jug--;
                        if(jug < 0){
                            break;
                        }
                    }
                    int istok = j-1;
                    while (!(istok < 0) && (matr[i][istok] != 1 || matr[i][istok] != 2)) {
                        pomocna[i][istok] = 1;
                        istok--;
                        if(istok < 0){
                            break;
                        }
                    }
                    int zapad = i+1;
                    while (!(zapad > matr[0].length) && (matr[i][zapad] != 1 || matr[i][zapad] != 2)) {
                        pomocna[i][zapad] = 1;
                        zapad++;
                        if(zapad > matr[0].length){
                            break;
                        }
                    }
                }
            }
        }

        int brojac = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if(pomocna[i][j] == 0){
                    brojac++;
                }
            }
        }

        return brojac;
    }
    // Napisati program koji za datu kvadratnu matricu dimenzija NxN obilazi i štampa
    // njene elemente po dijagonalama paralelnim sporednoj dijagonali. Na primjer, ako je data matrica
    public static void zad2(int[][] matr) {
        int pocI = 0;
        int pocJ = 0;
        while (pocI < matr.length && pocJ < matr[0].length) {
            int i = pocI;
            int j = pocJ;
            while (i >= 0 && j >= 0) {
                System.out.print(matr[i][j] + " ");
                j--;
                i++;
            }
            pocI = 0;
            pocJ ++;
        }
        pocJ --;
        pocI ++;
        while (pocI < matr.length && pocJ >= 0) {
            int i = pocI;
            int j = pocJ;
            while (i < matr.length && j <matr[0].length) {
                System.out.print(matr[i][j] + " ");
                j--;
                i++;
            }
            pocI ++;
        }


    }

    // Napisati funkciju void filtar(int[][] slika, int k) koja nad datom slikom,
    // koja je predstavljena matricom prirodnih brojeva dimenzija mxn (m>=k, n>=k),
    // primjenjuje filtar veličine kxk i štampa rezultujuću sliku odnosno matricu.
    // Filter se primjenjuje tako što se pomjera po matrici slika i računa se prosječna
    // vrijednost elemenata matrice koje filter preklopi.
/*
    public static int prosjek(int[][]matr, int pocI, int pocJ, int k) {
        int suma = 0;
        for(int i = pocI; i < pocI + k; i++){
            for(int j = pocJ; j < pocJ + k; j++){
                suma += matr[i][j];
            }
        }

        return suma/(k*k);
    }

    public static void zad3(int[][] matr, int k) {
        int l = 0, h = 0;
        int[][] rez = new int[matr.length-k+1][matr[0].length-k+1];

        for (int i = 0; i < matr.length - k + 1; i++) {
            for (int j = 0; j < matr[0].length - k + 1; j++) {
                rez[l][h] = prosjek(matr, i, j, k);
                h++;
            }
            h = 0;
            l++;
        }

        stampajMatrice(rez);
    } */

    public static void zad4(int[][] matr) {
        int n = matr.length;
        int[] provjera = new int[n];
        Arrays.fill(provjera, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                provjera[matr[i][j]-1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (provjera[i] != n) {
                System.out.print("NE");
                return;
            }
        }
        System.out.println("DA");
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matr = new int[n][m];
        ucitajMatrice(matr);
        zad4(matr);
    }
}
