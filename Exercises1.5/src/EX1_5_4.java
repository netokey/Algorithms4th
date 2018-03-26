public class EX1_5_4 {
    private int[] id;
    private int count;
    private int[] sz;
    private int accesscount;
    private int szcount;

    public EX1_5_4(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        accesscount = 0;
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
        szcount = 0;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int N = a[0];
        EX1_5_4 uf = new EX1_5_4(N);
        for (int i = 1; i < a.length - 1; i += 2) {
            int p = a[i];
            int q = a[i + 1];
            int acnt = uf.getAccesscount();
            int scnt = uf.getSzcount();
            if (!uf.connected(p, q)) uf.union(p, q);
            StdOut.println(p + " " + q + ":access id array " + (uf.getAccesscount() - acnt) + " times, access sz array " + (uf.getSzcount() - scnt) + " times");
            uf.printID();
        }
        StdOut.println(uf.count() + " components");
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
        szcount+=4;
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

    public int getSzcount() {
        return szcount;
    }
}
