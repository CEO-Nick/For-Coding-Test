import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] lectures = new int[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = sc.nextInt();
        }

        long l = 0, r = Long.MAX_VALUE;
        long ans = -1;
        
        while (l <= r) {
            long m = (l + r) / 2;

            if (isPossible(lectures, m, M)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean isPossible(int[] array, long m, int M) {
        int count = 1;
        long current_m = m;
        for (int len : array) {
            if (len > m) return false;    // 강의 1개 길이가 m보다 크면 m에 못넣으니깐 m을 키워야함
            if (len > current_m) {
                if (count == M) return false;
                current_m = m;
                count++;
            }
            current_m -= len;
        }

        return true;
    }

}
