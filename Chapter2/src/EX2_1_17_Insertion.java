/*
This is a template for sorting algorithms
 */
public class EX2_1_17_Insertion {
    private static int barWidth;
    private static int barHeight;

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    draw(a, j, i, j);
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        //show(a);
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static void setCanas(int N) {
        StdDraw.setCanvasSize(barWidth * N, barHeight);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(barWidth - barWidth / 5);
    }

    private static void draw(Comparable[] a, int from, int to, int min) {
        StdDraw.clear();
        for (int i = 0; i < a.length - 1; i++) {
            if (i < from || i > to) {
                StdDraw.setPenColor(StdDraw.GRAY);
            } else if (i == min) {
                StdDraw.setPenColor(StdDraw.RED);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            StdDraw.filledRectangle(i, 0, 0.4, (double) a[i]);
        }
        StdDraw.pause(1000);
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i + 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        barWidth = 15;
        barHeight = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        setCanas(N);
        sort(a);
        assert isSorted(a);
    }
}
