package DSA.udemy.hashtables;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyHashTable<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size;
    private final Node<K, V>[] table;

    public MyHashTable() {
        this.table = (Node<K,V>[])new Node[DEFAULT_INITIAL_CAPACITY];
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> DEFAULT_INITIAL_CAPACITY);
    }

    public V put(K key, V value) {
        int hash = (this.table.length -1 & hash(key));
        Node<K, V> newNode = new Node<>(key, value, null);
        Node<K, V> node = this.table[hash];
        if(node == null) {
            this.table[hash] = newNode;
            this.size++;
        }else {
            if(key.equals(node.key)) {
                this.table[hash] = newNode;
            } else {
                while (true) {
                    if(node.next == null) {
                        node.next = newNode;
                        this.table[hash] = node;
                        this.size++;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        return value;
    }

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> node = this.table[hash];
        return node != null ? node.value : null;
    }

    public Set<K> keys() {
        Set<K> keys = new HashSet<>();
        for (Node<K, V> kvNode : table) {
            if(kvNode != null) keys.add(kvNode.key);
        }
        return keys;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final String toString() { return key + "=" + value; }
    }
}
