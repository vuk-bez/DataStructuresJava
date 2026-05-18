package Red.Ulancan;

import java.util.EmptyStackException;

public class RedUlancan {
    CvorSU front;
    CvorSU rear;

    public RedUlancan() {
        front = null;
        rear = null;
    }

    public void push(int info) {
        if(front == null) {
            front = new CvorSU(info, null, null);
            rear = front;
            return;
        }
        if (front == rear) {
            front = new CvorSU(info, rear, null);
            rear.setPrev(front);
            return;
        }

        CvorSU temp = new CvorSU(info);
        CvorSU sljedeci = front;

        sljedeci.setPrev(temp);
        temp.setNext(sljedeci);
        temp.setPrev(null);

        front = temp;
    }

    public int pop() {
        if (rear == null) {
            throw new EmptyStackException();
        }
        if (front == rear) {
            CvorSU temp = rear;
            rear = front = null;
            return temp.getInfo();
        }

        CvorSU prethodni = rear.getPrev();
        prethodni.setNext(null);
        int info = rear.getInfo();
        rear = prethodni;
        return info;

    }

    public int peek() {
        if (rear == null) {
            throw new EmptyStackException();
        }
        return rear.getInfo();
    }

    public boolean isEmpty() {
        if (front == null) return true;
        return false;
    }

    public String toString() {
        CvorSU brojac = front;
        String rez = "";
        while(brojac != null) {
            rez += brojac.getInfo();
            rez += ", ";
            brojac = brojac.getNext();
        }
        return rez;
    }
}


