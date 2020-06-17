package DSA.udemy.stack;

import DSA.udemy.arrays.MyArray;

public class MyStackArray<E> implements MyStack<E> {

    private E top;
    private E bottom;
    private final MyArray<E> array;

    public MyStackArray() {
        this.array = new MyArray<>();
    }

    @Override
    public E push(E element) {
        if(this.array.length == 0) this.top = this.bottom = element;
        this.top = this.array.push(element);
        return this.top;
    }

    @Override
    public E pop() {
        if(this.array.length == 1) {
            this.top = this.bottom = null;
            return this.array.pop();
        }
        E popped = this.array.pop();
        this.top = this.array.get(this.array.length - 1);
        return popped;
    }

    @Override
    public E peek() {
        return this.top;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public boolean isEmpty() {
        return this.array.length == 0;
    }
}
