/*
This is Shell Sort
 */
public class EX2_1_12 {
    public static int compareTimes;

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
            StdOut.println("h = " + h + ":\t" + compareTimes + "\t" + (compareTimes + 0.0) / N);
            compareTimes = 0;
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
        int T = Integer.parseInt(args[0]);//Trials
        for (int i = 0; i < T; i++) {
            int N = (int) Math.pow(10, (i + 2));
            StdOut.println("N = " + N);
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            sort(a);
        }

    }
}
