
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        Long[] length = new Long[K];
        for (int i = 0; i < K; i++) {
            length[i] = sc.nextLong();
        }

        long ans = findOptimalLength(length, 0L, Long.MAX_VALUE, N);

        System.out.println(ans);
    }

    public static long findOptimalLength(Long[] length, long l, long r, int x) {
        long ans = -1;

        while (l <= r) {
            // 임의의 랜선 길이
            long m = (l + r) / 2;

            // 만들 수 있는 랜선 개수
            long sum = 0;
            for (long len : length) {
                sum += (len / m);
            }

            // 원하는 개수보다 많으면 더 길게 짤라보자
            if (sum >= x) {
                ans = m;
                l = m + 1;
            } else {    // 원하는 만큼 못 가져가면 더 짧게 짤라보자
                r = m - 1;
            }
        }

        return ans;

    }

}
