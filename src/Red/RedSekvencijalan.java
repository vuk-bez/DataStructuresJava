package Red;

public class RedSekvencijalan {
    int n;
    int[] niz;
    int top, rear;

    public RedSekvencijalan(int n){
        this.n = n;
        this.niz = new int[n];
        top = 0;
        rear = 0;
    }

    public void insert(int x) {
        if (top == rear && top != 0) {
            System.out.println("Red je pun");
            return;
        } else {
            niz[rear] = x;
            rear = rear % niz.length + 1;
            if(top == -1) {
                top = 0;
            }
        }
    }

    public int delete() {
        if(top == -1) {
            System.out.println("Red je prazan");
            return -1;
        } else {
            int x = niz[top];
            if(top == rear) {
                top = -1;
                rear = 0;
            } else {
                top = top % niz.length + 1;
            }
            return x;
        }
    }

    public boolean RedEmpty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    public int RedVrh() {
        if(top == -1) {
            System.out.println("Red je prazan");
            return -1;
        } else {
            return niz[top];
        }
    }
}
