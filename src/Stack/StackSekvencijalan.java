package Stack;

public class StackSekvencijalan {

    int[] niz;
    char[] karakteri;
    int top;

    public StackSekvencijalan(int n) {
        this.niz = new int[n];
        this.top = -1;
    }

    public StackSekvencijalan(int n, char[] karakteri) {
        this.karakteri = new char[n];
        this.top = -1;
    }

    public void push(int info) {
        if (this.top == this.niz.length - 1) {
            System.out.println("Stek je pun!");
        } else {
            ++this.top;
            this.niz[this.top] = info;
        }
    }

    public void pushChar(char info) {
        if (this.top == this.karakteri.length - 1) {
            System.out.println("Stek je pun!");
        } else {
            ++this.top;
            this.karakteri[this.top] = info;
        }
    }

    public int pop() {
        if (this.top == -1) {
            System.out.println("Stek je prazan");
            return -1;
        } else {
            int x = this.niz[this.top];
            --this.top;
            return x;
        }
    }

    public char popChar() {
        if (this.top == -1) {
            System.out.println("Stek je prazan");
            return '~';
        } else {
            char x = this.karakteri[this.top];
            --this.top;
            return x;
        }
    }

    public boolean stackEmpty() {
        return this.top == -1;
    }

    public int stackVrh() {
        return this.top == -1 ? -1 : this.niz[this.top];
    }
}
