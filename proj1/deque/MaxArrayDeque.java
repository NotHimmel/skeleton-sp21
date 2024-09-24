package deque;
import java.util.*;
public class MaxArrayDeque<T> {

    private T[] items;
    private int front;
    private int back;
    private double loadFactor;
    private int capacity;
    private int size;

    private Comparator<T> com;

    public MaxArrayDeque() {
        front = -1;
        back = -1;
        capacity = 8;
        items = (T[])new Object[capacity];
        loadFactor = 0.75;
        size = 0;
    }

    public MaxArrayDeque(Comparator<T> c) {
        front = -1;
        back = -1;
        capacity = 8;
        items = (T[])new Object[capacity];
        loadFactor = 0.75;
        size = 0;
        com = c;
    }

    public T max() {
        if (size == 0)
            return null;
        T maxEle = items[0];
        for (T t : items) {
            if (t != null && com.compare(t, maxEle) > 0) {
                maxEle = t;
            }
        }
        return maxEle;
    }

    public T max(Comparator<T> c) {
        if (size == 0)
            return null;
        T maxEle = items[0];
        for (T t : items) {
            if (t != null && c.compare(t, maxEle) > 0) {
                maxEle = t;
            }
        }
        return maxEle;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
            for (int i = back; i > front; i--) {
                items[i] = items[i - 1];
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
        size--;
        return t;
    }

    public T removeLast() {
        T t = items[back-1];
        items[--back] = null;
        size--;
        return t;
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        MaxArrayDeque<Integer> maxDeque = new MaxArrayDeque<>(comparator);

        maxDeque.addFirst(10);
        maxDeque.addFirst(20);
        maxDeque.addFirst(5);

        System.out.println("Max: " + maxDeque.max()); // 输出 20
    }

}
