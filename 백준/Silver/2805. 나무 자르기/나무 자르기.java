import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // H 높이 나무 모두 절단
        Integer[] height = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int ans = findOptimalHeight(height, 0, 1000000000, M);

        System.out.println(ans);

        br.close();
    }

    public static int findOptimalHeight(Integer[] height, int l, int r, int x) {
        int ans = -1;

        while (l <= r) {
            // 임의의 절단기 높이
            int m = (l + r) / 2;

            // 가져갈 수 있는 나무 길이 구하기
            long sum = 0;
            for (Integer integer : height) {
                if (integer > m) {
                    sum += integer - m;
                }
            }

            // 원하는 만큼 가져갈 수 있다면 높이 높여본다
            if (sum >= x) {
                l = m + 1;
                ans = m;
            } else {    // 원하는 만큼 못 가져가면 높이 낮춰본다
                r = m - 1;
            }
        }

        return ans;

    }

}
