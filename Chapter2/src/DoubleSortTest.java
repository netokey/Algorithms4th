public class DoubleSortTest {

    public static void main(String[] args) {  // Print table of running times.
        String alg = args[0];
        double oldtime = 0;
        for (int N = 100; true; N += N) {  // Print time for problem size N.
            double time = SortCompare.timeRandomInput(alg, N, 1);
            StdOut.printf("%7d\t%5.10f\t%5.10f\n", N, time, time / oldtime);
            oldtime = time;
        }
    }
}
