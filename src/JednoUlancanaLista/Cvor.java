package JednoUlancanaLista;

public class Cvor {
    private int x;
    private Cvor next;

    public Cvor(int x, Cvor next) {
        this.x = x;
        this.next = next;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public Cvor getNext() {
        return next;
    }
    public void setNext(Cvor next) {
        this.next = next;
    }
}

