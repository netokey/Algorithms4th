public class EX1_5_16_QuickUnion {
    private int[] id;
    private int count;
    private int accesscount;

    public EX1_5_16_QuickUnion(int N) {
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
        EX1_5_16_QuickUnion uf = new EX1_5_16_QuickUnion(N);
        StdDraw.setXscale(-200, (a.length - 1) / 2 + 200);
        StdDraw.setYscale(-100, 600);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.001);
        StdDraw.line(0, 0, (a.length - 1) / 2, 0);
        StdDraw.line(0, 0, 0, 500);
        for (int i = 0; i <= 500; i += 100) {
            StdDraw.text(-100, i, i + "");
        }
        for (int i = 0; i <= (a.length - 1) / 2; i += 100) {
            StdDraw.text(i, -50, i + "");
        }
        int tc = 0;//the total of times to access id[] by connected()
        int tu = 0;//the total of times to access id[] by union()
        for (int i = 1; i < a.length - 1; i += 2) {
            int p = a[i];
            int q = a[i + 1];
            int acnt = uf.getAccesscount();
            int xset = (i + 1) / 2;// set X
            boolean isConnected = uf.connected(p, q);
            int cc = uf.getAccesscount() - acnt;//calculate the cost of connected()
            acnt = uf.getAccesscount();
            tc += cc;//calculate the total cost of connected()
            //draw the points of connected() cost
            StdDraw.setPenColor(StdDraw.BLUE);//BLUE for the connected() cost of current pair
            StdDraw.point(xset,cc);
            StdDraw.setPenColor(StdDraw.ORANGE);//ORANGE for the average connected() cost
            StdDraw.point(xset,tc/xset);
            if (!isConnected) {
                uf.union(p, q);
                int cu = uf.getAccesscount() - acnt;//calculate the cost of union()
                tu += cu;//calculate the total cost of union()
                //draw the points of union() cost
                StdDraw.setPenColor(StdDraw.GRAY);//GRAY for the union() cost of current pair
                StdDraw.point(xset,cu);
                StdDraw.setPenColor(StdDraw.RED);//RED for the average union() cost
                StdDraw.point(xset,tu/xset);
            }
            //StdOut.println(p + " " + q + ":access array " + (uf.getAccesscount() - acnt) + " times");
            //uf.printID();
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
