import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연속한 k개의 신호등이 존재하도록 신호등 수리
        // 이럴려면 최소 몇 개의 신호등을 수리해야 하는지
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        for (int i = 0; i < B; i++) {
            array[Integer.parseInt(br.readLine())-1] = 1;
        }

        int count = 0, ans = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            if (array[i] == 1) count++;
        }
        ans = Math.min(ans, count);
        if (array[0] == 1) count--;
        int j = K;
        for (int i = 1; i < N-K+1; i++) {
            if (array[j++] == 1) count++;
            ans = Math.min(ans, count);

            if (array[i] == 1) count--;
        }
        System.out.println(ans);
        br.close();
    }
}
