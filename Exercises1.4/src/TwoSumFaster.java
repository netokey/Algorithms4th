import java.util.Arrays;

public class TwoSumFaster {
    public static int count(int[] a) {  // Count pairs that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        int posPositive = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] > 0) {
                posPositive = i;
                break;
            }
        }

        int j = N - 1;

        for (int i = 0; i < posPositive; i++) {
            while (a[i] + a[j] >= 0) {
                if (a[i] + a[j] == 0) cnt++;
                j--;
            }
            if (j < posPositive) break;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
