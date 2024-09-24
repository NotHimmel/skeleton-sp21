package deque;

public class LinkedListDeque<T> implements Deque<T>{
    public class ItemNode<T> {
        ItemNode<T> pre;
        T item;
        ItemNode<T> next;

        public ItemNode(T t, ItemNode<T> p, ItemNode<T> n) {
            pre = p;
            next = n;
            item = t;
        }
    }

    private ItemNode<T> sentinel;
    private int size;
    public LinkedListDeque() {
        T t = null;
        sentinel = new ItemNode<T>(t, null, null);
        size = 0;
    }



    public void printDeque() {
        ItemNode<T> p = sentinel;
        int s = size;
        while (s-- > 0) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public String debugDeque() {
        String debug = "";
        int s = size;
        ItemNode<T> p = sentinel;
        while (s-- > 0) {
            debug += p.next.item + " ";
            p = p.next;
        }
        debug += "\n";
        return debug;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size)
            return null;

        return getRecursive(sentinel.next, index);
    }

    public T getRecursive(ItemNode<T> n, int i) {
        if (n == null)
            return null;

        if (i == 0)
            return n.item;
        return getRecursive(n.next, i-1);
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        ItemNode<T> p = sentinel;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.next.item;
    }

    public void addFirst(T item) {
        ItemNode<T> p = new ItemNode<>(item, null, null);
        if (sentinel.next != null) {
            sentinel.next.pre = p;
            p.next = sentinel.next;
        }
        sentinel.next = p;
        p.pre = sentinel;
        if (sentinel.pre == null) {
            sentinel.pre = p;
            p.next = sentinel;
        }
        size++;
    }

    public void addLast(T item) {
        ItemNode<T> p = new ItemNode<>(item, null, null);
        if (sentinel.pre != null) {
            sentinel.pre.next = p;
            p.pre = sentinel.pre;
        }
        p.next = sentinel;
        sentinel.pre = p;
        if (sentinel.next == null) {
            sentinel.next = p;
            p.pre = sentinel;
        }
        size++;
    }

    public T removeFirst() {
        if (sentinel.next == null || sentinel.next == sentinel) {
            sentinel.pre = sentinel.next = null;
            return null;
        }
        T t = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return t;
    }

    public T removeLast() {
        if (sentinel.pre == null || sentinel.next == sentinel) {
            sentinel.pre = sentinel.next = null;
            return null;
        }
        T t = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return t;
    }


}
