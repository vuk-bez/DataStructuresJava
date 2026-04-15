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
                    while (!(sjever > matr.length) && matr[sjever][j] != 1 || matr[sjever][j] != 2) {
                        pomocna[sjever][j] = 1;
                        sjever++;
                        if(sjever == matr.length){
                            break;
                        }
                    }
                    int jug = i-1;
                    while (!(jug < 0) && matr[jug][j] != 1 || matr[jug][j] != 2) {
                        pomocna[jug][j] = 1;
                        jug--;
                        if(jug < 0){
                            break;
                        }
                    }
                    int istok = j-1;
                    while (!(istok < 0) && matr[i][istok] != 1 || matr[i][istok] != 2) {
                        pomocna[i][istok] = 1;
                        istok--;
                        if(istok < 0){
                            break;
                        }
                    }
                    int zapad = i+1;
                    while (matr[i][zapad] != 1 || matr[i][zapad] != 2) {
                        pomocna[i][zapad] = 1;
                        zapad++;
                        if(zapad == matr[0].length){
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

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matr = new int[n][m];
        ucitajMatrice(matr);
        System.out.println(zad1(matr));
    }
}
