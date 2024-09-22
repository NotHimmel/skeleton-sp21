import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expect = {"an", "egg", "have", "i"};

        Sort.sort(input, 0);

        assertArrayEquals(expect, input);

        /*for (int i = 0; i < input.length; i++) {
            if (!input[i].equals(expect[i])) {
                System.out.println("Mismatch in position " + i
                + ", expected: " + expect[i] + ", but got " + input[i]);
                return;
            }
        }*/
    }

    /*Test FindSmallest Func */
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};

        int expect = 2;
        int actual = Sort.findSmallest(input, 0);

        assertEquals(expect, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;

        int actual2 = Sort.findSmallest(input2, 0);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0, b = 2;
        String[] expect = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expect,input);
    }
}
