package deque;

// why named as SLList? Single -> DL means Double List
// [n, next] -> [ ]
public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;
    public SLList() {
        sentinel = new IntNode(0,null);
        size = 0;
    }
    public SLList(int x) {
        IntNode first = new IntNode(x, null);
        sentinel = new IntNode(0, first);
        size = 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
    public void addLast(int l) {
        size++;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(l, null);
    }

    public void addFirst(int l) {
        sentinel.next = new IntNode(l, sentinel.next);
        size++;
    }

    public int size() {
        return size;
    }

    public void Cout() {
        IntNode p = sentinel;
        while (p.next != null) {
            System.out.println(p.item + " ,");
            p = p.next;
        }
        System.out.println(p.item + "");
    }

    public static void main(String[] args) {
        SLList x = new SLList();
        x.addLast(5);
        x.addFirst(1);
        x.addFirst(2); // 2 1 5 10
        x.addLast(10);
        x.addLast(100);
        x.Cout();


    }
}
