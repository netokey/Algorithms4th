public class PathCompressedWeightedQuickUionUF {
    private int[] id;
    private int count;
    private int[] sz;

    public PathCompressedWeightedQuickUionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a[0];
        long start = System.currentTimeMillis();
        PathCompressedWeightedQuickUionUF uf = new PathCompressedWeightedQuickUionUF(N);
        for (int i = 1; i < a.length - 1; i += 2) {
            int p = a[i];
            int q = a[i + 1];
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println("Cost time: " + (System.currentTimeMillis() - start) / 1000.0);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int find(int p) {
        int orgp = p;
        while (p != id[p]) p = id[p];
        int rootP = p;
        while (orgp != id[orgp]) {
            int curp = orgp;
            orgp = id[orgp];
            id[curp] = rootP;
        }
        return rootP;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
