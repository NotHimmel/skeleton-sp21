package deque;

public interface Deque<T> {
    public int size = 0;
    public default int size() {
        return size;
    }

    public default boolean isEmpty() {
        return size == 0;
    }
}
