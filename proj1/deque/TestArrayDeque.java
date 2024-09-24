package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by hug.
 */
public class TestArrayDeque {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        ArrayDeque<Integer> b = new ArrayDeque<>();

        a.addLast(4);
        a.addLast(5);
        a.addLast(6);

        b.addLast(4);
        b.addLast(5);
        b.addLast(6);

        assertEquals(a.size(), b.size());

        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        ArrayDeque<Integer> BL = new ArrayDeque<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // getLast
                if (L.size() == 0) {
                    continue;
                }
                assertEquals(L.getLast(), BL.get(BL.size()-1));
            } else if (operationNumber == 2) {
                // removeLast
                if (L.size() == 0) {
                    continue;
                }
                assertEquals(L.removeLast(), BL.removeLast());
            }
        }
    }
}