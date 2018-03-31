import java.util.Arrays;

/*
This is Quick Sort
 */
public class EX2_3_18 {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int clo = chooselo(a, lo, hi);
        Comparable v = a[clo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, clo, j);
        return j;
    }

    private static int chooselo(Comparable[] a, int lo, int hi) {
        int MAX = 3;
        int[] index = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            index[i] = StdRandom.uniform(lo, hi + 1);
        }
        Comparable[] b = new Comparable[MAX];
        for (int i = 0; i < MAX; i++) {
            b[i] = a[index[i]];
        }
        Arrays.sort(b);
        for (int i = 0; i < MAX; i++) {
            if (a[index[i]].equals(b[1])) return index[i];
        }
        return -1;
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
