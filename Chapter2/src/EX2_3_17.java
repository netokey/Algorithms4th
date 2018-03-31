/*
This is Quick Sort
 */
public class EX2_3_17 {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        int maxi = 0;
        for (int i = 0; i < a.length; i++) {
            if (less(a[maxi], a[i])) maxi = i;
        }
        exch(a, maxi, a.length - 1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo + 1, j = hi;
        Comparable v = a[lo];
        while (true) {
            while (!less(v, a[i])) i++;
            while (less(v, a[j])) j--;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
        String[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
