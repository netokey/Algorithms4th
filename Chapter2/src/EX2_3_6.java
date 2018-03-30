/*
This is Quick Sort
The average of exact comparetimes is less than the approximation, but it is closer while N is increasing.
 */
public class EX2_3_6 {
    public static int compareTimes;

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
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        compareTimes++;
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
        int N = 100000;
        int T = 100;
        int sum = 0;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        for (int i = 0; i < T; i++) {
            StdRandom.shuffle(a);
            sort(a);
            StdOut.println(i + ":" + compareTimes);
            sum += compareTimes;
            compareTimes = 0;
        }
        StdOut.println("Average Comparetimes:" + sum / T);
        StdOut.println("Estimated Comparetimes:" + 2 * N * Math.log(N));
        StdOut.println("Ratio:" + sum / T / (2 * N * Math.log(N)));
    }
}
