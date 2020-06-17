package DSA.udemy.queue;

public class MyQueueLinkList<E> implements MyQueue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public E enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if(this.last == null) this.first = this.last = newNode;
        this.last.next = newNode;
        this.last = newNode;
        this.size++;
        return element;
    }

    @Override
    public E dequeue() {
        if(this.first == null) return null;
        Node<E> first = this.first;
        if(this.first == this.last) this.first = this.last = null;
        this.first = first.next;
        this.size--;
        return first.data;
    }

    @Override
    public E peek() {
        return this.first.data;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
