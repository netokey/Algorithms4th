public class EX2_1_32 {
    private static void setupCanvas(String figure, int NMAX, int TMAX) {
        StdDraw.setCanvasSize(640, 960);
        StdDraw.setPenRadius(.001);
        StdDraw.setPenColor(StdDraw.BLACK);
        double XMAX = NMAX * 1000;
        double YMAX = TMAX;

        int ratio = 20;
        if (figure == "Standard Plot") {
            StdDraw.setXscale(-XMAX / ratio, XMAX + XMAX / ratio);
            StdDraw.setYscale(-YMAX / ratio, YMAX + YMAX / ratio);

            StdDraw.line(-XMAX / ratio, 0, XMAX, 0);
            StdDraw.line(0, -YMAX / ratio, 0, YMAX);

            StdDraw.text(-XMAX / ratio / 2, -YMAX / ratio / 2, "0");
            for (int i = 1; i <= NMAX; i++) {
                StdDraw.text(i * 1000, -YMAX / ratio / 2, i + "K");
            }
            for (int i = 1; i <= TMAX; i++) {
                StdDraw.text(-XMAX / ratio / 2, i, i + "");
            }
        }
        if (figure == "Log-Log Plot") {
            XMAX = Math.log(XMAX) / Math.log(2);
            YMAX = Math.log(YMAX) / Math.log(2);
            double XMIN = Math.log(1000) / Math.log(2);
            double YMIN = Math.log(0.1) / Math.log(2);

            StdDraw.setXscale(XMIN - 2 * (XMAX - XMIN) / ratio, XMAX + (XMAX - XMIN) / ratio);
            StdDraw.setYscale(YMIN - 2 * (YMAX - YMIN) / ratio, YMAX + (YMAX - YMIN) / ratio);

            StdDraw.line(XMIN, YMIN - (YMAX - YMIN) / ratio, XMAX, YMIN - (YMAX - YMIN) / ratio);
            StdDraw.line(XMIN - (XMAX - XMIN) / ratio, YMIN, XMIN - (XMAX - XMIN) / ratio, YMAX);

            for (int i = 1; i <= NMAX; i *= 2) {
                StdDraw.text(Math.log(i * 1000) / Math.log(2), YMIN - 1.5 * (YMAX - YMIN) / ratio, i + "K");
            }
            for (int i = 1; i <= TMAX * 10; i *= 2) {
                StdDraw.text(XMIN - 1.5 * (XMAX - XMIN) / ratio, Math.log(i / 10.0) / Math.log(2), i / 10.0 + "");
            }
        }

    }

    public static void main(String[] args) {
        String alg = "Selection";
        alg = "Insertion";
        alg = "Shell";
        String figure = "Standard Plot";// Standard Plot or Log-Log Plot
        figure = "Log-Log Plot";

        if (figure != "Standard Plot" && figure != "Log-Log Plot") return;
        int NMAX = 32;//K items array
        int TMAX = 10;//seconds
        setupCanvas(figure, NMAX, TMAX);

        StdDraw.setPenRadius(.01);
        //for calculate the K
        double[] X = new double[NMAX];
        double[] Y = new double[NMAX];
        double[] K = new double[NMAX - 1];
        for (int i = 1; i <= NMAX; i++) {
            double t = SortCompare.timeRandomInput(alg, i * 1000, 100);
            double x = 0;
            double y = 0;
            double k = 0;
            if (figure == "Standard Plot") {
                x = i * 1000;
                y = t;
            }

            if (figure == "Log-Log Plot") {
                x = Math.log(i * 1000) / Math.log(2);
                y = Math.log(t) / Math.log(2);
                X[i - 1] = x;
                Y[i - 1] = y;
                if (i > 1) {
                    k = (Y[i - 1] - Y[i - 2]) / (X[i - 1] - X[i - 2]);
                    StdOut.println("k:" + k);
                    K[i - 2] = k;
                }
            }
            StdOut.println(i * 1000 + ":" + t);
            StdOut.println(x + "," + y);
            StdDraw.point(x, y);
        }
        if (figure == "Log-Log Plot") {
            double sum = 0;
            for (int i = 0; i < K.length; i++) {
                sum += K[i];
            }
            StdOut.println("Average k is " + sum / (NMAX - 1));
        }
    }
}
