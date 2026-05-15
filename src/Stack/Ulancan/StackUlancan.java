package Stack.Ulancan;

import java.nio.BufferUnderflowException;

public class StackUlancan {

    CvorSU top;

    public StackUlancan() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int info) {

        if (this.top == null) {
            this.top = new CvorSU(info);
            return;
        }

        CvorSU temp = new CvorSU(info);
        this.top.setNext(temp);
        temp.setPrev(this.top);
        this.top = temp;

    }

    public int pop() {
        if (this.top == null) {
            throw new BufferUnderflowException();
        }
        if (this.top.getPrev() == null) {
            CvorSU temp = this.top;
            this.top = null;
            return temp.getInfo();
        }

        CvorSU prev = this.top.getPrev();
        CvorSU temp = this.top;
        prev.setNext(null);
        return temp.getInfo();

    }

    public int peek() {
        if (this.top == null) {
            throw new BufferUnderflowException();
        }
        return this.top.getInfo();
    }



}
