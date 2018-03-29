/*
This is a bottom-up merge
 */
public class EX2_2_6_MergeBU {
    private static Comparable[] aux;
    private static int acessArrayTimes;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            acessArrayTimes += 2;
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
                acessArrayTimes += 2;
            } else if (j > hi) {
                a[k] = aux[i++];
                acessArrayTimes += 2;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                acessArrayTimes += 4;
            } else {
                a[k] = aux[i++];
                acessArrayTimes += 4;
            }
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
        int N = 512;
        int XMAX = N;
        int YMAX = (int) (Math.ceil(6 * XMAX * Math.log(XMAX) / Math.log(2)));
        int raito = 20;
        StdDraw.setXscale(-2 * XMAX / raito, XMAX + XMAX / raito);
        StdDraw.setYscale(-YMAX / raito, YMAX + YMAX / raito);
        StdDraw.setPenRadius(.001);
        StdDraw.line(-2 * XMAX / raito, 0, XMAX, 0);
        StdDraw.line(0, -YMAX / raito, 0, YMAX);
        for (int i = 0; i < XMAX; i += 50) {
            StdDraw.text(i, -YMAX / raito / 2, i + "");
        }
        for (int i = 0; i < YMAX; i += 3000) {
            StdDraw.text(-XMAX / raito, i, i + "");
        }
        StdDraw.setPenRadius(.005);
        for (int i = 1; i <= N; i++) {
            Integer[] a = new Integer[i];
            for (int j = 0; j < a.length; j++) {
                a[j] = j;
            }
            StdRandom.shuffle(a);
            sort(a);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, acessArrayTimes);
            acessArrayTimes = 0;
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.point(i, 6 * i * Math.log(i) / Math.log(2));
        }
    }
}
