package Stringovi;

import java.util.Scanner;
import java.lang.Character;

public class Main {

    public static Scanner in = new Scanner(System.in);

    // ZAD 1.
    //Napisati funkciju String velikaSlova(String s) koja transformiše string s tako što
    //između svaka dva uzastopna velika slova umetne karakter ‘_’. Na primjer,
    //unijeti string s = "aBCDeF3GH", funkcija treba da transformiše u "aB_C_DeF3G_H".

    public static void zad1(String s) {
        String s2 = "";
        for(int i = 0; i < s.length(); i++) {
            if(i != 0 && s.charAt(i-1) >= 'A' && s.charAt(i-1) <= 'Z' && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                s2 += '_';
            }
            s2 += s.charAt(i);
        }
        System.out.println(s2);
    }

    // ZAD 2.
    // Napisati funkciju String umetniSlovo(String s) koja transformiše string s
    // tako što nakon svakog velikog slova u stringu umetne njemu odgovarajuće malo slovo.
    // Na primjer, unijeti string S="ProGraMiraNje", funkcija treba da transformiše u "PproGgraMmiraNnje".

    public static void zad2(String str) {
        String rez = "";
        for(int i = 0; i < str.length(); i++) {
            rez += str.charAt(i);
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                rez += Character.toLowerCase(str.charAt(i));
            }
        }
        System.out.println(rez);
    }

    // ZAD 3.
    // Napisati funkciju String samoglasnici(String s) koja transformiše string s tako što
    // između svaka dva uzastopna samoglasnika umetne karakter ‘-’. Na primjer,
    // unijeti string s = "AbcEaoU7", funkcija treba da transformiše u "AbcE-a-o-U7".

    public static void zad3(String str) {
        String rez = "";
        for(int i = 0; i < str.length(); i++) {
            char fix = Character.toLowerCase(str.charAt(i));
            char prevFix = 0;
            if(i != 0) {
                prevFix = Character.toLowerCase(str.charAt(i-1));
            }

            if((prevFix == 'a' || prevFix == 'e' || prevFix == 'i' || prevFix == 'o' || prevFix == 'u') && (fix == 'a' || fix == 'e' || fix == 'i' || fix == 'o' || fix == 'u')) {
                rez += '-';
            }
            rez += str.charAt(i);
        }
        System.out.println(rez);
    }

    // ZAD 4.
    // Napisati funkciju String cifre(String s) koja transformiše string s tako što
    // nakon svake parne cifre u stringu umetne slovo ‘P’, a nakon svake neparne
    // cifre slovo ‘N’. Na primjer, unijeti string S="ab2cg3#1",  funkcija treba da transformiše u "ab2Pcg3N#1N".

    public static void zad4(String str) {
        String rez = "";
        for(int i = 0; i < str.length(); i++) {
            char fix = str.charAt(i);
            rez += fix;
            if(Character.isDigit(fix) && (fix-'0') % 2 == 0) {
                rez += 'P';
            } else if (Character.isDigit(fix) && (fix-'0') % 2 != 0) {
                rez += 'N';
            }
        }
        System.out.println(rez);
    }

    // ZAD 5.
    // Napisati funkciju String umetniCifru(String s) koja transformiše taj string s
    // tako što nakon svake cifre veće od 0 u stringu umetne cifru za jedan manju, a
    // nakon cifre 0 umetne cifru 9. Na primjer, unijeti string s = "ab2c9#03",
    // funkcija treba da transformiše u "ab21c98#0932".

    public static void zad5(String str) {
        String rez = "";
        for(int i = 0; i < str.length(); i++) {
            char fix = str.charAt(i);
            rez += fix;
            if(Character.isDigit(fix) && (fix - '0') > 0) {
                rez += (fix - '0') - 1;
            } else if (Character.isDigit(fix) && fix == '0') {
                rez += '9';
            }
        }
        System.out.println(rez);
    }

    // ZAD 6.
    // Napisati funkciju String premjesti(string s) koja od stringa s pravi oni string
    // u kojem su samoglasnici ispred suglasnika. Možete pretpostaviti da će se s sastojati samo od malih slova.

    public static void zad6(String str) {
        String rez = "";
        for(int i = 0; i < str.length(); i++) {
            char fix = str.charAt(i);
            if(fix == 'a' || fix == 'e' || fix == 'i' || fix == 'u' || fix == 'o') {
                rez += fix;
            }
        }
        for(int i = 0; i < str.length(); i++) {
            char fix = str.charAt(i);
            if(fix != 'a' && fix != 'e' && fix != 'i' && fix != 'u' && fix != 'o') {
                rez += fix;
            }
        }
        System.out.println(rez);

    }

    // ZAD 7.
    // Napisati program koji učitava dva stringa jednake dužine i od njih pravi treći string
    // tako što u njemu naizmjenično postavlja slova iz jednog, pa drugog stringa.
    // Na primjer, za stringove “pmf“ i “abc“ rezultat treba da bude “pambfc“.

    public static void zad7(String s1, String s2) {
        String rez = "";
        for(int i = 0; i < s1.length(); i++) {
            rez += s1.charAt(i);
            rez += s2.charAt(i);
        }
        System.out.println(rez);
    }

    // ZAD 8.
    // Napisati program koji provjerava validnost unijete šifre. Šifra se smatra validnom ukoliko ima barem 8 karaktera i dodatno ispunjava sljedeće kriterijume
    //  Sadrži barem jedno veliko i barem jedno malo slovo abecede,
    //  Sadrži barem jednu cifru,
    //  Sadrži barem jedan od specijalnih karaktera iz skupa {$,#,@}.

    public static boolean zad8(String str) {
        if(str.length() < 8) return false;
        int veliko = 0, malo = 0, cifra = 0, spec = 0;
        for(int i = 0; i < str.length(); i++) {
            char fix = str.charAt(i);
            if(fix >= 'A' && fix <= 'Z') veliko++;
            else if(fix >= 'a' && fix <= 'z') malo++;
            else if(Character.isDigit(fix)) cifra++;
            else if(fix == '$' || fix == '#' || fix == '@') spec++;
        }
        if(veliko > 0 && malo > 0 && cifra > 0 && spec > 0) return true;
        else return false;
    }

    // ZAD 9.
    // Napisati funkciju String saberi(String a, String b) koja sabira binarne
    // brojeve a i b koji su zadati kao stringovi. Na primjer, ako je a=“111“ i b = “11”, rješenje je “1000”.

    public static void main(String[] args) {
        String s, s2;
        s = in.nextLine();
        //s2 = in.nextLine(); // potreban za zadatak 7
        //zad1(s);
        //zad2(s);
        //zad3(s);
        //zad4(s);
        //zad5(s);
        //zad6(s);
        //zad7(s, s2);
        System.out.println(zad8(s));
    }
}
