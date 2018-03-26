public class HeightWeightedQuickUionUF {
    private int[] id;
    private int count;
    private int[] ht;

    public HeightWeightedQuickUionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        ht = new int[N];
        for (int i = 0; i < N; i++) {
            ht[i] = 1;
        }
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a[0];
        long start = System.currentTimeMillis();
        HeightWeightedQuickUionUF uf = new HeightWeightedQuickUionUF(N);
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
        if (ht[i]==ht[j]) {
            id[i]=j;
            ht[j]++;
        }else if (ht[i] < ht[j]) {
            id[i] = j;
        } else {
            id[j] = i;
        }
        count--;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
