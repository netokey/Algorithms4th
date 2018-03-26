/*
Exercise 1.5.17
 */
public class ErdosRenyi {
    public static int count(int N) {
        PathCompressedQuickUionUF uf = new PathCompressedQuickUionUF(N);
        int count = 0;
        while (uf.count() > 1) {
            int p = StdRandom.uniform(N);
            int q = StdRandom.uniform(N);
            if (!uf.connected(p, q)) uf.union(p, q);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(ErdosRenyi.count(N));
    }
}
