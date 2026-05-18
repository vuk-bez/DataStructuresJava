package Red;

/*
REDOVI - linearna, homogena, dinamicka strutura sa FIFO pristupom;
*/

import Red.Ulancan.RedUlancan;
import Red.Ulancan.Stanja;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Scanner ulaz = new Scanner(System.in);
    public static void zad5() {
        int A = ulaz.nextInt();
        int B = ulaz.nextInt();
        int C = ulaz.nextInt();

        int a = 0;
        int b = 0;
        int c = 0;

        Queue<Stanja> q = new LinkedList<Stanja>();
        q.add(new Stanja(a, b, 0));
        while (!q.isEmpty()) {
            Stanja s = q.poll();
            if (s.getA() == C || s.getB() == C) {
                System.out.println(s.getBrojac());
                return;
            }
            if (s.getA() != A) {
                q.add(new Stanja(A, s.getB(), s.getBrojac()+1));
            }
            if (s.getB() != B) {
                q.add(new Stanja(s.getA(), B, s.getBrojac()+1));
            }
            if (s.getA() != 0) {
                q.add(new Stanja(0, s.getB(), s.getBrojac()+1));
            }
            if (s.getB() != 0) {
                q.add(new Stanja(s.getA(), 0, s.getBrojac()+1));
            }
            if (s.getB() != B) {
                int slobodnoB = B - s.getB();
                Stanja novo = new Stanja(0,0,s.getBrojac()+1);
                if (s.getA() > slobodnoB) {
                    novo.setA(s.getA() - slobodnoB);
                    novo.setB(B);
                } else if (a < slobodnoB) {
                    novo.setA(0);
                    novo.setB(s.getB() + s.getA());
                } else {
                    novo.setA(0);
                    novo.setB(B);
                }
                q.add(novo);
            }
            if (s.getA() != A) {
                int slobodnoA = A - s.getA();
                Stanja novo = new Stanja(0,0,s.getBrojac()+1);
                if (s.getB() > slobodnoA) {
                    novo.setB(s.getB() - slobodnoA);
                    novo.setA(A);
                } else if (s.getB() < slobodnoA) {
                    novo.setB(0);
                    novo.setA(s.getA() + s.getB());
                } else {
                    novo.setB(0);
                    novo.setA(A);
                }
                q.add(novo);
            }
        }
        System.out.println("-1");

    }
    public static void zad6() {
        int M = ulaz.nextInt();
        int N = ulaz.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int broj = q.poll();

            if (broj > N){
                break;
            }

            int zadnjaCif = broj % 10;

            if (zadnjaCif - 1 >= 0) { // 2
                q.add(broj*10 + zadnjaCif - 1);
            }
            if (zadnjaCif + 1 <= 9) {
                if (q.peek() != 1) {
                    q.add(broj*10 + zadnjaCif + 1);
                }
            }
            if (broj >= M){
               System.out.print(broj + " ");
            }

        }

    }
    public static void main(String[] args) {
        //zad5();
        zad6();
    }
}