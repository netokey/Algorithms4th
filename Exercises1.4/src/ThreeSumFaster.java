import java.util.Arrays;

public class ThreeSumFaster {
    public static int count(int[] a) {  // Count triples that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        int pos = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[j] > -a[i] / 2) {
                    pos = j;
                    break;
                }
            }
            int k = N - 1;
            for (int j = i + 1; j < pos; j++) {
                while (a[j] + a[k] >= -a[i]) {
                    if (a[j] + a[k] == -a[i]) {
                        cnt++;
                    }
                    k--;
                }
                if (k < pos) break;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
