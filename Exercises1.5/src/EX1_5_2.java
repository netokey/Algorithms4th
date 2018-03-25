public class EX1_5_2 {
    private int[] id;
    private int count;
    private int accesscount;

    public EX1_5_2(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        accesscount = 0;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a[0];
        EX1_5_2 uf = new EX1_5_2(N);
        for (int i = 1; i < a.length - 1; i += 2) {
            int p = a[i];
            int q = a[i + 1];
            int acnt = uf.getAccesscount();
            if (!uf.connected(p, q)) uf.union(p, q);
            StdOut.println(p + " " + q + ":access array " + (uf.getAccesscount() - acnt) + " times");
            uf.printID();
        }
        StdOut.println(uf.count() + " components");
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        accesscount++;
        count--;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
            accesscount += 2;
        }
        accesscount++;
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public void printID() {
        String out = "" + id[0];
        for (int i = 1; i < id.length; i++) {
            out += " " + id[i];
        }
        StdOut.println(out);
    }

    public int getAccesscount() {
        return accesscount;
    }
}
