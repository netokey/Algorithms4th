public class EX2_1_31 {
    public static void main(String[] args) {
        int T = 1;
        String[] algs = new String[3];
        algs[0] = "Selection";
        algs[1] = "Insertion";
        algs[2] = "Shell";
        for (String alg : algs
                ) {
            StdOut.println(alg + ":");
            int N = 1000;
            double t = SortCompare.timeRandomInput(alg, N, T) / T;
            StdOut.println("The eslapsed time of sorting on " + N + " random Double array is " + t);
            int TMAX = 128;
            if (alg.equals("Shell")) TMAX = 4096;
            for (int i = 2; i <= TMAX; i *= 2) {
                double t1 = SortCompare.timeRandomInput(alg, N * i, T) / T;
                StdOut.println("The eslapsed time of sorting on " + N * i + " random Double array is " + t1);
                StdOut.println("\tThe ratio is " + t1 / t);
                t = t1;
            }
        }

    }
}

/*
 * After several tests, the conclusion is below:
 * The ratio of Selection is almost 4, it means Selection is quadratic.
 * The ratio of Insertion is almost 4, it means Insertion is quadratic.
 * the ratio of Shell is almost 2.5-3, it means Shell is subquadratic.
 * */