package deque;

public class ArrayDeque<T> implements Deque<T>{

    private T[] items;
    private int front;
    private int back;
    private double loadFactor;
    private int capacity;
    private int size;

    public ArrayDeque() {
        front = -1;
        back = -1;
        capacity = 2;
        items = (T[])new Object[capacity];
        loadFactor = 0.75;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void reSize() {
        if ((size + 1) >= (loadFactor * capacity)) {
            capacity *= 2;
        }
        T[] n = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            n[i] = items[i];
        }
        items = n;
    }
    public void printDeque() {
        for (int i = front; i != back; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.print("\n");
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return items[index];
    }

    public void addFirst(T item) {
        reSize();
        if (size == 0) {
            back = 1;
            front = 0;
        } else {
            for (int i = back; i >= front; i--) {
                items[i+1] = items[i];
            }
            back++;
        }
        items[0] = item;
        size++;
    }

    public void addLast(T item) {
        reSize();
        if (back == -1) {
            items[0] = item;
            back = 1;
            front = 0;
        } else {
            items[back++] = item;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0)
            return null;
        T t = items[0];

        for (int i = 0; i < size - 1; i++) {
            items[i] = items[i+1];
        }
        items[size-1] = null;
        size--;

        return t;
    }

    public T removeLast() {
        if (size == 0)
            return null;
        T t = items[back-1];
        items[--back] = null;
        size--;
        return t;
    }
}
