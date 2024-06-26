
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int sum = array[0];
        int j = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            while (sum < S && j < N - 1)  {
                sum += array[++j];
            }
            // j < N-1 이라서 while문 끝난 경우에는 sum < S 일 수 있음
            if (sum >= S) {
                ans = Math.min(ans, j - i + 1);    // 길이 최소값 계산
            }
            sum -= array[i];
        }

        // 부분합이 S 이상인 경우가 없다 == 원소 전체를 더해도 S보다 작다
        ans = ans == Integer.MAX_VALUE ? 0 : ans;

        System.out.println(ans);
        br.close();
    }




}
