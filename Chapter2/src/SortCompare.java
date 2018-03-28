public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        //if(alg.equals("Quick")) Quick.sort(a);
        //if(alg.equals("Heap")) Heap.sort(a);
        if (alg.equals("MySentinel")) EX2_1_24_MySolution.sort(a);
        if (alg.equals("OfficialSentinel")) EX2_1_24_MySolution.sort(a);
        if (alg.equals("HalfInsertion")) EX2_1_25.sort(a);
        if (alg.equals("NewIncrementShell")) EX2_1_29.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        StdOut.printf("After %d trials of %d random Doubles by %s, the total time is %.3f seconds.\n", T, N, alg1, t1);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("After %d trials of %d random Doubles by %s, the total time is %.3f seconds.\n", T, N, alg2, t2);
        StdOut.printf("For %d random Doubles\n%s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}

