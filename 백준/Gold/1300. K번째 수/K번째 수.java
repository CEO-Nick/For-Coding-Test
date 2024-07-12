import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1, end = (long) N * N;
        long ans = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid/i, N);
            }
            if (count >= K) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
