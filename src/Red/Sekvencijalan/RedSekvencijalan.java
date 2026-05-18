package Red.Sekvencijalan;

public class RedSekvencijalan {
    int front;
    int rear;
    int[] red;

    public RedSekvencijalan(int dim) {
        front = 0;
        rear = 0;
        red = new int[dim];
    }

    public void push(int info) {
        if(rear == front && front != 0) {
            throw new StackOverflowError();
        }
        if(rear >= red.length && front != 0) {
            rear = 0;
            red[rear] = info;
            return;
        }
        red[rear++] = info;
    }

    public int pop() {
        if(front == rear && rear == 0) {
            throw new StackOverflowError();
        }
        if (front == red.length - 1) {
            int info = red[front];
            front = 0;
            return info;
        }

        return red[front++];
    }

    public int peek() {
        if(rear == 0) {
            throw new StackOverflowError();
        }
        return red[front];
    }

    public boolean isEmpty() {
        if (front == rear && rear == 0) {
            return true;
        }
        return false;
    }

}
