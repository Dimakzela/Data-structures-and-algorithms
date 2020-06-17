package DSA.udemy.arrays;

public class MyArray<T> {
    public int length;
    private int size = 8;
    private T[] items;

    public MyArray() {
        this.length = 0;
        this.items = (T[]) new Object[size];
    }

    public T get(int index) {
        return items[index];
    }

    public T push(T data) {
        this.items[this.length] = data;
        this.length++;
        return data;
    }

    public T pop() {
        T item = this.items[this.length - 1];
        this.items[this.length - 1] = null;
        this.length--;
        return item;
    }

    public T delete(int index) {
        T item = this.items[this.length - 1];
        for(int i = index; i < this.length; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[this.length - 1] = null;
        this.length--;
        return item;
    }


    public void print() {
        for (int i = 0; i < this.length; i++) {
            System.out.println(this.items[i]);
        }
    }
}
