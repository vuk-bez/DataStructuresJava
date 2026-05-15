package Stack.Sekvencijalan;

import java.util.EmptyStackException;

public class StackSekvencijalan {
    int info;
    int top;
    int[] stack;

    public StackSekvencijalan(int dim) {
        this.stack = new int[dim];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(int data) {
        if (top == stack.length) {
            throw new StackOverflowError();
        }

        stack[top++] = data;
    }

    public int pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }

        return stack[--top];
    }

    public int peek() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

}
