
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] jewels = new int[M];
        for (int i = 0; i < M; i++) {
            jewels[i] = sc.nextInt();
        }

        // 보석 못받는 학생 있어도 된다
        // 학생은 항상 같은 색의 보석만 가져감
        // 질투심 = 가장 많은 보석을 가져간 학생의 보석 개수 -> 전부 최소한의 보석 개수를 갖도록 하자
        
        int l = 0, r = Integer.MAX_VALUE;
        int ans = -1;

        while (l <= r) {
            // 질투심
            int m = (l + r) / 2;
            if (m == 0) {
                ans = 1;
                break;
            }
            if (isPossible(jewels, m, N)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean isPossible(int[] array, int m, int N) {
        int count = 0;
        for (int jewel : array) {
            count += jewel / m;
            if (jewel % m != 0) {
                count += 1;
            }
        }

        return count <= N;
    }

}
