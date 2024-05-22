package Stack;

import java.util.EmptyStackException;

public class Stack {
    int top;
    int[] stack;

    private int size;

    public Stack(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void changeSize(int i) {
        size += i;
    }
    public void push(int val) {
        stack[top] = val;
        top++;
        changeSize(1);
    }

    public int pop() {
        if (getSize() == 0) throw new EmptyStackException();
        int toBeReturned = stack[top - 1];
        top--;
        changeSize(-1);
        return toBeReturned;
    }
    public int top() {
        if (getSize() == 0) throw new EmptyStackException();
        return stack[top - 1];
    }
}
