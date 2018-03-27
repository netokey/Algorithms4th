/*
This is Shell Sort
 */
public class EX2_1_29 {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int n1 = 0;
        while (increment(n1) < N) {
            n1++;
        }
        int[] increments = new int[n1 + 1];
        for (int i = 0; i < increments.length - 1; i++) {
            increments[i] = increment(i);
        }
        for (int k = increments.length - 1; k >= 0; k--) {
            int h = increments[k];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }
    }

    public static int increment(int i) {
        int exp = 0;
        if (i % 2 == 0) {
            exp = (int) (9 * Math.pow(4, i / 2) - 9 * Math.pow(2, i / 2) + 1);
        } else {
            exp = (int) (Math.pow(4, (i - 1) / 2 + 2) - 3 * Math.pow(2, (i - 1) / 2 + 2) + 1);
        }
        return exp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        //show(a);
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
