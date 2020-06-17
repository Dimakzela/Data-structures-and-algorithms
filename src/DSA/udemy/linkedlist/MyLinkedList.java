package DSA.udemy.linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() { }

    public MyLinkedList(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }


    public E append(E element) {
        Node<E> tail = this.tail;
        Node<E> newNode = new Node<>(element, null, null);
        if(this.size == 0) {
            this.head = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
        return element;
    }

    public E prePend(E element) {
        Node<E> newNode = new Node<>(element, null, null);
        if(this.size == 0) {
            this.tail = newNode;
        }else {
            newNode.next = head;
        }
        this.head = newNode;
        this.size++;
        return element;
    }

    public E insert(E element, int index) {
        if(index > size) throw new ArrayIndexOutOfBoundsException("index " + index + " out of bound");
        if(index == 0) return prePend(element);
        if(index == size) return append(element);
        Node<E> newNode = new Node<>(element, null, null);
        Node<E> node = node(index);
        newNode.prev = node.prev;
        node.prev.next = newNode;
        newNode.next = node;
        this.size++;
        return element;
    }

    public E get(int index) {
        return node(index).data;
    }

    public E removeFirst() {
        Node<E> head = this.head;
        if(head == null) throw new NoSuchElementException();
        this.head = head.next;
        this.size--;
        return head.data;
    }

    public E removeLast() {
        Node<E> tail = this.tail;
        if(tail == null) throw new NoSuchElementException();
        this.tail = tail.prev;
        this.size--;
        return tail.data;
    }

    public E remove(int index) {
        if(index > size) throw new ArrayIndexOutOfBoundsException("index " + index + " out of bound");
        if(index == 0) return removeFirst();
        if(index == size) return removeLast();
        Node<E> toRemove = node(index);
        toRemove.prev.next = toRemove.next;
        toRemove.next = null;
        toRemove.prev = null;
        this.size--;
        return toRemove.data;
    }

    public Node<E> reverse() {
        if(this.size == 0) throw new NoSuchElementException();
        if(this.size == 1) return this.head;
        Node<E> head = this.head;
        this.tail = head;
        Node<E> second = this.head.next;
        while (second != null) {
            Node<E> tmp = second.next;
            second.next = head;
            head = second;
            second = tmp;
        }
        this.head.next = null;
        this.head = head;
        return this.head;
    }

    public boolean contains(E element) {
        if(this.size == 0) return false;
        Node<E> head = this.head;
        while (head != null) {
            if(head.data.equals(element)) return true;
            head = head.next;
        }
        return false;
    }

    private Node<E> node(int index) {
        if(index > size) throw new ArrayIndexOutOfBoundsException("index " + index + " out of bound");
        if(index == 0) return this.head;
        if(index == size - 1) return this.tail;
        Node<E> head = this.head;
        for(int i = 0; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    public E getFirst() {
        return this.head == null ? null : this.head.data;
    }

    public E getLast() {
        return this.tail == null ? null : this.tail.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
