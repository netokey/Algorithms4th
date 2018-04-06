/*
This is the solution for Exercise 2.3.5
 */
public class EX2_3_5 {
    public static void sort(Comparable[] a) {
        int lt = 0, gt = a.length - 1;
        int i = 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(a[lt]);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i + 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(2);
        }
        StdRandom.shuffle(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}