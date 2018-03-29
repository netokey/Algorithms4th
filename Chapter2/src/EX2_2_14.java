public class EX2_2_14 {
    public static Comparable[] merge(Comparable[] a, Comparable[] b) {
        assert isSorted(a);
        assert isSorted(b);

        Comparable[] aux = new Comparable[a.length + b.length];
        if (less(a[a.length - 1], b[0])) {
            for (int i = 0; i < a.length; i++)
                aux[i] = a[i];
            for (int i = 0; i < b.length; i++)
                aux[a.length + i] = b[i];
            return aux;
        }
        if (less(b[b.length - 1], a[0])) {
            for (int i = 0; i < b.length; i++)
                aux[i] = b[i];
            for (int i = 0; i < a.length; i++)
                aux[b.length + i] = a[i];
            return aux;
        }
        int i = 0, j = 0;
        for (int k = 0; k < aux.length; k++) {
            if (i >= a.length) aux[k] = b[j++];
            else if (j >= b.length) aux[k] = a[i++];
            else if (less(a[i], b[j])) aux[k] = a[i++];
            else aux[k] = b[j++];
        }
        return aux;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i + 1])) return false;
        }
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int NMAX = 50; //NMAX?0
        Double[] a = new Double[StdRandom.uniform(100, NMAX * 100 + 1)];
        Double[] b = new Double[StdRandom.uniform(100, NMAX * 100 + 1)];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform();
        }
        Merge.sort(a);
        for (int i = 0; i < b.length; i++) {
            b[i] = StdRandom.uniform();
        }
        Merge.sort(b);
        Comparable[] out = merge(a, b);
        show(out);
    }
}
