import sun.misc.Queue;

public class EX2_2_15 {
    public static void main(String[] args) {
        int N = 10000;
        Queue<Comparable[]> q = new Queue<Comparable[]>();
        for (int i = 0; i < N; i++) {
            Double[] suba = new Double[1];
            suba[0] = StdRandom.uniform();
            q.enqueue(suba);
        }
        Comparable[] out = new Comparable[0];
        try {
            while (true) {
                out = q.dequeue();
                Comparable[] b = q.dequeue();
                Comparable[] newi = EX2_2_14.merge(out, b);
                q.enqueue(newi);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            EX2_2_14.show(out);
        }
    }
}
