/*
This is Shell Sort
 */
public class EX2_1_19 {
    private static int compareTimes;
    private static int exchangeTimes;

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;//1,4,13,40,121,364,1093...
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        compareTimes++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        exchangeTimes++;
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
            a[i] = i;
        }
        int T = 1000;
        for (int i = 0; i < T; i++) {
            sort(a);
            StdOut.println("Compare Times: " + compareTimes);
            StdOut.println("Exchange Times: " + exchangeTimes);
            compareTimes = 0;
            exchangeTimes = 0;
            StdRandom.shuffle(a);
        }
        //assert isSorted(a);
    }
}
