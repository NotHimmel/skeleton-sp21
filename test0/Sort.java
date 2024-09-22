public class Sort {
    public static void sort(String[] x, int start) {
        //Find the smallest item
        //Move to the front
        //Sort the rest(using recursion)
        if (start == x.length)
            return;
        int s = findSmallest(x, start);
        swap(x, s, start);
        sort(x, start+1);

    }

    public static int findSmallest(String[] x, int start){
        int smallest = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

}
