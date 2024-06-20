
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer[] budget = new Integer[N];
        for (int i = 0; i < N; i++) {
            budget[i] = sc.nextInt();
        }

        int totalBudget = sc.nextInt();
        Arrays.sort(budget);

        int ans = -1;
        int l = 1, r = totalBudget;
        while (l <= r) {
            int m = (l + r) / 2;

            // 해당 상한액(m)으로 예산 배정 가능하다면 -> 상한액 올려본다
            if (isPossible(budget, m, totalBudget)) {
                l = m + 1;
                ans = m;
            } else { // 상한액으로 예상 배정 불가능 -> 상한액 낮춰보기
                r = m - 1;
            }
        }
        ans = ans == totalBudget ? budget[N-1] : ans;
        System.out.println(ans);

    }

    private static boolean isPossible(Integer[] array, int m, int M) {
        for (Integer budget : array) {
            if (budget < m) {
                M -= budget;
            } else {
                M -= m;
            }
            if (M < 0) {
                return false;
            }
        }

        return true;
    }


}
