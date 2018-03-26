public class EX1_5_21 {
    public static void main(String[] args) {
        int MAX = 10000;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.001);
        StdDraw.setXscale(-MAX / 20, MAX + MAX / 20);
        int YMAX = (int) Math.ceil(0.5 * MAX * Math.log(MAX));
        StdDraw.setYscale(-YMAX / 20, YMAX + YMAX / 20);
        StdDraw.line(0, 0, MAX, 0);
        StdDraw.line(0, 0, 0, YMAX);
        for (int i = 0; i <= MAX; i+=1000) {
            StdDraw.text(i, -YMAX/40,i+"");
        }
        for (int i = 5000; i <= YMAX; i+=5000) {
            StdDraw.text(0, i,i+"");
        }
        for (int i = 1; i <= MAX; i++) {
            int cnt = ErdosRenyi.count(i);
            double rcnt = 0.5 * i * Math.log(i);
            StdDraw.setPenColor(StdDraw.ORANGE);
            StdDraw.point(i, cnt);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(i, rcnt);
        }
    }
}
