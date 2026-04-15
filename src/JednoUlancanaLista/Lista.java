package JednoUlancanaLista;

import java.nio.BufferUnderflowException;

public class Lista {

    Cvor glava;

    public Lista() {
        this.glava = null;
    }

    public void addFirst(int x) {

        if (glava == null) {
            this.glava = new Cvor(x, null);
            return;
        }

        glava = new Cvor(x, glava);
    }

    public int getFirst() {
        if (glava == null) {
            throw new BufferUnderflowException();
        }

        return glava.getX();
    }

    public void addLast(int x) {

        if (glava == null) {
            glava = new Cvor(x, null);
            return;
        }

        Cvor temp = glava;

        while (temp.getNext() != null) {
                temp = temp.getNext();
        }
        Cvor rez = new Cvor(x, null);
        temp.setNext(rez);
    }

    public int getLast() {
        if (glava == null) {
            throw new BufferUnderflowException();
        }
        Cvor temp = glava;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getX();
    }

    public void stampajListu() {
        if (glava == null) {
            throw new BufferUnderflowException();
        }
        Cvor temp = glava;
        while (temp != null) {
            System.out.print(temp.getX() + " ");
            temp = temp.getNext();
        }
    }

    public void dodaj1() {
        if (glava == null) {
            throw new BufferUnderflowException();
        }

        Cvor temp = glava;
        while (temp.getNext() != null) {
            Cvor razlika = new Cvor(temp.getX() - temp.getNext().getX(), temp.getNext());
            temp.setNext(razlika);
            temp = temp.getNext().getNext();
        }
    }

    public void dodaj2 (int k) {
        if(glava == null) {
            throw new BufferUnderflowException();
        }
        Cvor temp = glava;
        while(temp != null) {
            if(temp.getX() % k == 0) {
                Cvor dodatak = new Cvor(-1, temp.getNext());
                temp.setNext(dodatak);
                temp = temp.getNext();
            }
            temp = temp.getNext();
        }
    }
    // dodaj3(int a, int b) koja dodaje nakon svakog čvora čija je vrijednost veća od a, a manja od b dodaje nulu,
    public void dodaj3(int a, int b) {
        if(glava == null) {
            throw new BufferUnderflowException();
        }
        Cvor temp = glava;
        while(temp != null) {
            if(temp.getX() > a && temp.getX() < b) {
                Cvor dodatak = new Cvor(0, temp.getNext());
                temp.setNext(dodatak);
                temp = temp.getNext();
            }
            temp = temp.getNext();
        }
    }

    // obrisi(int d, int k) koji iz liste briše sve čvorove koji se čija je apsolutna razlika sa brojem d manja od k,

    public void obrisi(int d, int k) {
        if(glava == null) {
            throw new BufferUnderflowException();
        }
        Cvor temp = glava;
        Cvor prev = null;
        while(temp != null) {
            if(Math.abs(temp.getX() - d) < k) {
                if(prev != null) {
                    prev.setNext(temp.getNext());
                    temp = temp.getNext();
                    continue;
                }
            }
            prev = temp;
            temp = temp.getNext();
        }
    }

    //pronadjiSredinu() koja vraća vrijednost čvora koji se nalazi na sredini liste. Pokušati implementaciju bez izračunavanja dužine liste. (Hint: koristiti dvije pomoćne reference),

    public int pronadjiSredinu() {
        Cvor temp = glava;
        int i = 0;
        while(temp != null) {
            i++;
            temp = temp.getNext();
        }
        int j = 0;
        temp = glava;
        while (j < i/2) {
            temp = temp.getNext();
            j++;
        }
        return temp.getX();
    }
}
