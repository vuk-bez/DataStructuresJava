package CirkularnaLista;

import java.nio.BufferUnderflowException;

public class Lista {
    Cvor rep;

    public Lista() {
        this.rep = null;
    }

    public void addFirst(int x) {

        if (this.rep == null) {
            rep = new Cvor(x, null);
            rep.setNext(this.rep);
            return;
        }

        Cvor temp = new Cvor(x, rep.getNext());
        rep.setNext(temp);
    }

    public void addLast(int x) {

        if (this.rep == null) {
            rep = new Cvor(x, null);
            rep.setNext(this.rep);
            return;
        }
        Cvor temp = new Cvor(x, rep.getNext());
        rep.setNext(temp);
        rep = temp;

    }

    @Override
    public String toString() {
        if (this.rep == null) {
            return "Lista je prazna";
        }

        Cvor it = rep.getNext();
        String rez = "";

        do {
            rez += it.getX();
            if (it == rep) {
                break;
            }
            rez += "->";
            it = it.getNext();

        } while (it != rep.getNext());

        return rez;
    }

    public boolean deleteFirst(int x) {

        if (this.rep == null) {
            System.out.println("Lista je prazna");
            return false;
        }

        Cvor it = rep.getNext();
        do {
            if(it.getNext().getX() == x) {
                break;
            }
            it = it.getNext();
        } while(it != rep.getNext());

        if (it.getNext() == rep && it.getNext().getX() == x) {
            it.setNext(rep.getNext());
            rep = it;
            return true;
        } else if (it.getNext().getX() == x) {
            it.setNext(it.getNext().getNext());
            return true;
        }
        return false;
    }

    public boolean deleteLast(int x) {
        if (this.rep == null) {
            System.out.println("Lista je prazna");
            return false;
        }

        Cvor it = rep;
        Cvor poslednji = null;
        do {
            if(it.getNext().getX() == x) {
                poslednji = it;
            }
            it = it.getNext();

        } while (it != rep);

        if (poslednji != null && poslednji.getNext() == rep && poslednji.getNext().getX() == x) {
            poslednji.setNext(poslednji.getNext().getNext());
            rep = poslednji;
            return true;
        } else if (poslednji != null && poslednji.getNext().getX() == x) {
            poslednji.setNext(poslednji.getNext().getNext());
            return true;
        }
        return false;
    }

}
