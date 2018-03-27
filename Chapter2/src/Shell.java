/*
This is Shell Sort
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;//1,4,13,40,121,364,1093...
        while (h >= 1) {
            //StdOut.println("h = " + h + ":\t0 1 2 3 4 5 6 7 8 9 A B C D E F");
            for (int i = h; i < N; i++) {
                // insert a[i] into a[i-h],a[i-2*h],a[i-3*h]
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    //StdOut.printf(j + "\t" + (j - h) + ":\t");
                }
            }
            h = h / 3;
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

    public static void main(String[] args) {
        String[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
