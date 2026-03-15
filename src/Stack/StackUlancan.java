package Stack;

public class StackUlancan {
    CvorSU glava = new CvorSU();

    public boolean stackEmpty() {
        return this.glava.next == null;
    }

    public void push(int x) {
        CvorSU temp = new CvorSU();
        temp.next = this.glava;
        this.glava = temp;
        temp.info = x;
    }

    public int pop() {
        if (this.glava.next == null) {
            return -1;
        } else {
            int x = this.glava.info;
            this.glava = this.glava.next;
            return x;
        }
    }
}
