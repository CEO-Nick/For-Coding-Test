
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Integer[] amount = new Integer[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            amount[i] = sc.nextInt();
            sum += amount[i];
        }


        int ans = -1;
        int l = 1, r = sum;
        while (l <= r) {
            int m = (l + r) / 2;

            if (isPossible(amount, m, M)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean isPossible(Integer[] array, int m, int M) {
        int count = 1;
        int m_copy = m;
        for (Integer amount : array) {
            if (amount > m) return false;

            if (amount > m_copy) {
                if (count == M) return false;   // 이미 M번 채웠을 때
                count++;
                m_copy = m;
            }
            m_copy -= amount;

        }

        return true;
    }


}
