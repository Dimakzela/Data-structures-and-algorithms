package DSA.udemy.queue;

public interface MyQueue<E> {
    E enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}
