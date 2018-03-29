/*
This is a bottom-up merge
 */
public class EX2_2_16 {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        int first = 0, second = 0;
        boolean hasFirst = false;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                first = i - 1;
                hasFirst = true;
                break;
            }
        }
        if (!hasFirst) return;
        while (second < N - 1) {
            boolean hasSecond = false;
            for (int i = first + 2; i < N; i++) {
                if (less(a[i], a[i - 1])) {
                    second = i - 1;
                    hasSecond = true;
                    break;
                }
            }
            if (!hasSecond) second = N - 1;
            merge(a, 0, first, second);
            first = second;
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
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
            a[i] = i;
        }
        StdRandom.shuffle(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
