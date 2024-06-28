
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 원형으로 연결됨
        // 두 곳에 탑을 세움 -> 거리가 최대가 되도록
        // 원형 연결이기에 거리 잴 때, 시계 방향, 반시계 방향 거리 중 더 작은 값으로 판단

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] array = new Integer[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        int[] partialSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            partialSum[i] = partialSum[i-1] + array[i-1];
        }

        int ans = -1;
        for (int i = 1; i < N ; i++) {
            for (int j = i; j < N + 1; j++) {
                int a = partialSum[j]-partialSum[i-1];  // 반시계 거리
                int b = sum - a;                        // 시계 거리
                ans = Math.max(ans, Math.min(a, b));
            }
        }

        System.out.println(ans);
    }




}
