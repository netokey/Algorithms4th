public class VisualNvsTime {
    private double[] times;
    private String alg;
    private int NMAX;
    private int T;
    private String figure;


    public VisualNvsTime(String algorithm, int NMAX, int trials, String figure) {
        this.alg = algorithm;
        this.NMAX = NMAX;
        this.T = trials;
        if (!figure.equals("Standard")) this.figure = "Log-Log Plot";
        else this.figure = "Standard Plot";
        this.times = calucateTimes();
    }

    public static void main(String[] args) {
        String alg = args[0];
        int NMAX = Integer.parseInt(args[1]);//K items
        int T = Integer.parseInt(args[2]);
        String figure = args[3];
        VisualNvsTime vs = new VisualNvsTime(alg, NMAX, T, figure);
        vs.drawCanvas(640, 960);

    }

    private double[] calucateTimes() {
        double[] t = new double[NMAX];
        for (int i = 0; i < NMAX; i++) {
            t[i] = SortCompare.timeRandomInput(alg, (i + 1) * 1000, T);
        }
        return t;
    }

    public void drawCanvas(int w, int h) {
        StdDraw.setCanvasSize(w, h);
        StdDraw.setPenRadius(.001);
        StdDraw.setPenColor(StdDraw.BLACK);


        double XMIN = 0, XMAX = 0, YMIN = 0, YMAX = 0;

        double mint, maxt;
        mint = times[0];
        maxt = times[0];
        for (int i = 1; i < times.length - 1; i++) {
            if (times[i] < mint) mint = times[i];
            else if (times[i] > maxt) maxt = times[i];
        }
        if (figure.equals("Log-Log Plot")) {
            XMIN = Math.log(1000) / Math.log(2);
            XMAX = Math.log(NMAX * 1000) / Math.log(2);
            YMIN = Math.log(mint) / Math.log(2);
            YMAX = Math.log(maxt) / Math.log(2);
        } else {
            XMIN = 0;
            XMAX = NMAX * 1000;
            YMIN = 0;
            YMAX = maxt;
        }
        int ratio = 20;
        StdDraw.setXscale(XMIN - 2 * (XMAX - XMIN) / ratio, XMAX + (XMAX - XMIN) / ratio);
        StdDraw.setYscale(YMIN - 2 * (YMAX - YMIN) / ratio, YMAX + (YMAX - YMIN) / ratio);


        if (figure.equals("Log-Log Plot")) {
            StdDraw.line(XMIN, YMIN - (YMAX - YMIN) / ratio, XMAX, YMIN - (YMAX - YMIN) / ratio);
            StdDraw.line(XMIN - (XMAX - XMIN) / ratio, YMIN, XMIN - (XMAX - XMIN) / ratio, YMAX);
            for (int i = 1; i <= NMAX; i *= 2) {
                StdDraw.text(Math.log(i * 1000) / Math.log(2), YMIN - 1.5 * (YMAX - YMIN) / ratio, i + "K");
            }
            double YDUR = (maxt - mint) / 10;
            for (double i = mint; i <= maxt; i += YDUR) {
                StdDraw.text(XMIN - 1.5 * (XMAX - XMIN) / ratio, Math.log(i) / Math.log(2), i + "");
            }
        } else {
            StdDraw.line(-XMAX / ratio, 0, XMAX, 0);
            StdDraw.line(0, -YMAX / ratio, 0, YMAX);
            StdDraw.text(-XMAX / ratio / 2, -YMAX / ratio / 2, "0");
            for (int i = 1; i <= NMAX; i++) {
                StdDraw.text(i * 1000, -YMAX / ratio / 2, i + "K");
            }
            double YDUR = maxt / 10;
            for (int i = 1; i <= 10; i++) {
                StdDraw.text(-XMAX / ratio / 2, i * YDUR, i * YDUR + "");
            }
        }
        StdDraw.setPenRadius(.01);
        for (int i = 0; i < times.length; i++) {
            if (figure.equals("Log-Log Plot"))
                StdDraw.point(Math.log((i + 1) * 1000) / Math.log(2), Math.log(times[i]) / Math.log(2));
            else StdDraw.point((i + 1) * 1000, times[i]);
        }
    }
}
