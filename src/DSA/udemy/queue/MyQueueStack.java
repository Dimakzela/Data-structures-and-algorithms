package DSA.udemy.queue;

import DSA.udemy.stack.MyStack;
import DSA.udemy.stack.MyStackLinkedList;

public class MyQueueStack<E> implements MyQueue<E> {
    private final MyStack<E> stack = new MyStackLinkedList<>();
    private E top;

    @Override
    public E enqueue(E element) {
        if(this.stack.isEmpty())
            this.top = element;
        return stack.push(element);
    }

    @Override
    public E dequeue() {
        MyStack<E> tmp = new MyStackLinkedList<>();
        while (!this.stack.isEmpty())
            tmp.push(this.stack.pop());
        E toRemove = tmp.pop();
        this.top = tmp.peek();
        while (!tmp.isEmpty())
            stack.push(tmp.pop());
        return toRemove;
    }

    @Override
    public E peek() {
        return this.top;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }

    @Override
    public int size() {
        return this.stack.size();
    }

}
