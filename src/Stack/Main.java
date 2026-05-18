package Stack;

import Stack.Sekvencijalan.StackSekvencijalan;
import Stack.Ulancan.StackUlancan;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner ulaz = new Scanner(System.in);
    // ZAD. 1.
    /*
     Napisati program koji u datom izrazu, koji se sastoji od otvorenih i zatvorenih malih zagrada,
     brojem 0 mijenja otvorene zagrade koje su pravilno zatvorene, brojem 1 mijenja zatvorene zagrade
     za koje postoji odgovarajuća otvorena zagrada, a brojem -1  nepravilno postavljene otvorene i zatvorene zagrade.
     Napomena: Maksimalan broj poena donosi rješenje složenosti O(n), gdje je n broj zagrada.
     */

    public static void zad1() {
        String s = "";
        s = ulaz.nextLine();
        int[] output = new int[s.length()];
        StackSekvencijalan stack = new StackSekvencijalan(100);

        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    output[stack.pop()] = 0;
                    output[i] = 1;
                } else {
                    output[i] = -1;
                }
            }
        }

        while (!stack.isEmpty()) {
            output[stack.pop()] = -1;
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
        }

    }
    // ZAD. 2.
    /*
      Napisati program koji učitava dva prirodna broja M i N (ne staju obavezno u tip int ili long), a zatim štampa njihov zbir.
     */
    public static void zad2() {
        String b1 = ulaz.nextLine();
        String b2 = ulaz.nextLine();
        char[] rez = new char[b1.length() + 10];
        StackSekvencijalan stack = new StackSekvencijalan(100);
        int j = rez.length - 1;

        for (int i = b1.length()-1; i >= 0; i--) {
            int c1 = b1.charAt(i) - '0';
            int c2 = b2.charAt(i) - '0';
            if (stack.isEmpty() && c1 + c2 > 9) {
                rez[j--] = (char)(((c1+c2)-10) + '0');
                stack.push(1);
            } else if (!stack.isEmpty() && c1 + c2 + 1 > 9) {
                rez[j--] = (char)(((c1+c2+1)-10) + '0');
                stack.push(1);
                stack.pop();
            } else if (!stack.isEmpty() && c1 + c2 + 1 <= 9) {
                rez[j--] = (char)((c1+c2+1) + '0');
                stack.pop();
            } else {
                rez[j--] = (char)((c1+c2) + '0');
            }
        }
        int zadnjaCif = 0;
        while (!stack.isEmpty()) {
            zadnjaCif++;
            stack.pop();
        }
        if (zadnjaCif != 0) {
            rez[j--] = (char)(zadnjaCif + '0');
        }

        for (int i = 0; i < rez.length; i++) {
            if(rez[i] >= '0' &&  rez[i] <= '9') System.out.print(rez[i]);
        }
    }
    // ZAD. 3.
    /*
    Napisati program koji učitava niz cijelih brojeva A dužine N, a zatim napisati
    funkciju koja za svaki element niza štampa prvi veći element koji se nalazi poslije
    njega u nizu. Za elemente za koje ne postoji takav element, štampati -1.
     */
    public static void zad3() {
        int n = ulaz.nextInt();
        int[] niz = new int[n];
        int[] rez = new int[n];
        StackSekvencijalan stack = new StackSekvencijalan(n);
        for (int i = 0; i < n; i++) {
            niz[i] = ulaz.nextInt();
        }

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && niz[i] > niz[stack.peek()]) {
                rez[stack.pop()] = niz[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            rez[stack.pop()] = -1;
        }

        for (int i = 0; i < rez.length; i++) {
            System.out.print(rez[i] + " ");
        }
    }

    public static int zad4() {
        int n1 = ulaz.nextInt();
        int n2 = ulaz.nextInt();
        int n3 = ulaz.nextInt();
        int[] niz1 = new int[n1];
        int[] niz2 = new int[n2];
        int[] niz3 = new int[n3];
        for (int i = 0; i < n1; i++) {
            niz1[i] = ulaz.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            niz2[i] = ulaz.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            niz3[i] = ulaz.nextInt();
        }

        StackSekvencijalan s1 = new StackSekvencijalan(n1);
        StackSekvencijalan s2 = new StackSekvencijalan(n2);
        StackSekvencijalan s3 = new StackSekvencijalan(n3);

        for (int i = 0; i < n1; i++) {
            if (s1.isEmpty()) {
                s1.push(niz1[i]);
            } else {
                s1.push(niz1[i]+s1.peek());
            }
        }

        for (int i = 0; i < n2; i++) {
            if (s2.isEmpty()) {
                s2.push(niz2[i]);
            } else {
                s2.push(niz2[i]+s2.peek());
            }
        }

        for (int i = 0; i < n3; i++) {
            if (s3.isEmpty()) {
                s3.push(niz3[i]);
            } else {
                s3.push(niz3[i]+s3.peek());
            }
        }

        while (!(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) && !(s1.peek() == s2.peek() && s2.peek() == s3.peek() && s1.peek() == s3.peek())) {
            int max = Math.max(s1.peek(), Math.max(s2.peek(), s3.peek()));
            if (s1.peek() == max) s1.pop();
            else if (s2.peek() == max) s2.pop();
            else s3.pop();
        }
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            return -1;
        } else {
            return s1.pop();
        }
    }

    public static void InfixToPostfix() {
        String s = ulaz.nextLine();
        String rez = "";
        Stack<Character> stack = new Stack<>();
        int broj = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int cifra = s.charAt(i) - '0';
                if (!(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') && i != (s.length() - 1)) {
                    broj = broj*10 + cifra;
                    rez += String.valueOf(broj);
                    rez += " ";
                    broj = 0;
                } else {
                    broj = broj*10 + cifra;
                }
            }
            if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                    rez += stack.pop();
                    rez += " ";
                }
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    rez += stack.pop();
                    rez += " ";
                }
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            if(s.charAt(i) == ')') {
                while(stack.peek() != '(') {
                    rez += stack.pop();
                    rez += " ";
                }
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            rez += stack.pop();
            rez += " ";
        }

        System.out.println(rez);
    }

    public static void main(String[] args) {
        //zad1();
        //zad2();
        //zad3();
        //System.out.println(zad4());
        //InfixToPostfix();
    }
}
