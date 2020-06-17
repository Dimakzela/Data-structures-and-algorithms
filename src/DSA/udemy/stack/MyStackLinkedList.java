package DSA.udemy.stack;

public class MyStackLinkedList<E> implements MyStack<E> {

    private Node<E> top;
    private Node<E> bottom;
    private int size;

    @Override
    public E push(E element) {
        Node<E> newNode = new Node<>(element);
        if(this.size == 0) {
            this.top = newNode;
            this.bottom = newNode;
        }else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.size++;
        return element;
    }

    @Override
    public E pop() {
        if(this.top == null) return null;
        Node<E> top = this.top;
        if(this.size == 1) {
            this.top = this.bottom = null;
        }
        this.top = top.next;
        this.size--;
        return top.data;
    }

    @Override
    public E peek() {
        if(top == null) return null;
        return this.top.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
