public class EX2_1_35 {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        //if(alg.equals("Merge")) Merge.sort(a);
        //if(alg.equals("Quick")) Quick.sort(a);
        //if(alg.equals("Heap")) Heap.sort(a);
        if (alg.equals("MySentinel")) EX2_1_24_MySolution.sort(a);
        if (alg.equals("OfficialSentinel")) EX2_1_24_MySolution.sort(a);
        if (alg.equals("HalfInsertion")) EX2_1_25.sort(a);
        if (alg.equals("NewIncrementShell")) EX2_1_29.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T, String Distribution) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                if (Distribution.equals("Gaussian")) a[i] = StdRandom.gaussian();
                if (Distribution.equals("Poisson")) a[i] = (double) StdRandom.poisson(2);
                if (Distribution.equals("Geometric")) a[i] = (double) StdRandom.geometric(0.5);
                if (Distribution.equals("Discrete")) {
                    double[] b = new double[2];
                    b[0] = 0.0;
                    b[1] = 1.0;
                    a[i] = (double) StdRandom.discrete(b);
                }
                if (Distribution.equals("Random")) a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        /*
         * arg[0] algorithm
         * arg[1] the size of array
         * arg[2] the trials
         * arg[3] the distribution1
         * arg[4] the distribution2
         */
        String alg = args[0];
        int N = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        String Distribution1 = args[3];
        String Distribution2 = args[4];
        double t1 = timeRandomInput(alg, N, T, Distribution1);
        StdOut.printf("After %d trials of %d %s Distribution Doubles by %s, the total time is %.3f seconds.\n", T, N, Distribution1, alg, t1);
        double t2 = timeRandomInput(alg, N, T, Distribution2);
        StdOut.printf("After %d trials of %d %s Distribution Doubles by %s, the total time is %.3f seconds.\n", T, N, Distribution2, alg, t2);
        StdOut.printf("For %d %s \n%s is", N, alg, Distribution1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, Distribution2);
    }
}

