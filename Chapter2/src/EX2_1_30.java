/*
I get 3,5,6 for the solution
 */
public class EX2_1_30 {
    public static void sort(Comparable[] a, int t) {
        int N = a.length;
        int h = 1;
        while (h < N / t) h = t * h;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / t;
        }
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

    public static double time(Comparable[] a, int t) {
        Stopwatch timer = new Stopwatch();
        sort(a, t);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(int N, int T, int tTest) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(a, tTest);
        }
        return total;
    }

    public static void main(String[] args) {
        int N = 1000000;
        int T = 1;
        for (int i = 2; i < 20; i++) {
            double t = timeRandomInput(N, T, i);
            StdOut.println("t=" + i + "\ttime=" + t);
        }
    }
}
