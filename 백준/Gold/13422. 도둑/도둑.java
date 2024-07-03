import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M개의 연속된 집에서 돈을 훔칠 것(각 집의 돈 전부 다 가져간다고 가정)
        // K원 이상의 돈 훔치면 바로 붙잡힘
        // M개 연속된 집에서 K원 미만의 돈을 홈치자 -> 가능한 경우의 수 리턴
        int T = Integer.parseInt(br.readLine());

        int[] answer = new int[T];
        int idx = 0;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken()),
                K = Integer.parseInt(st.nextToken());

            int[] amount = new int[N + M - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                amount[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = N; i < N + M - 1; i++) {
                amount[i] = amount[i-N];
            }

            int[] partialSum = new int[N + M];
            for (int i = 1; i < N + M; i++) {
                partialSum[i] = partialSum[i-1] + amount[i-1];
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                int sum = partialSum[i+M] - partialSum[i];
                if (sum < K) count++;
                if (N == M) break;  // 이 경우, 모든 집을 다 가는거니깐 하나의 경우의 수만 존재

            }

            answer[idx++] = count;
        }

        for (int ans : answer) {
            System.out.println(ans);
        }

        br.close();
    }
}
