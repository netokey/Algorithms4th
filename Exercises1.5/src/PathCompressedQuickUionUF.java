public class PathCompressedQuickUionUF {
    private int[] id;
    private int count;

    public PathCompressedQuickUionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a[0];
        long start = System.currentTimeMillis();
        PathCompressedQuickUionUF uf = new PathCompressedQuickUionUF(N);
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
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
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
