package DSA.udemy.stack;

public interface MyStack<E> {
    E push(E element);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
}
