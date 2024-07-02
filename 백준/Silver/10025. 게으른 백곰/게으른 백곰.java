import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxPoint = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) + 1;
            map.put(x, g);
            maxPoint = Math.max(maxPoint, x);
        }

        int[] sum = new int[maxPoint+2];
        for (int i = 1; i <= maxPoint; i++) {
            int temp = 0;
            if (map.containsKey(i)) temp = map.get(i);
            sum[i] = sum[i-1] + temp;
        }
        
        int ans = -1;
        for (int i = 1; i <= maxPoint; i++) {
            int leftIndex = Math.max(i - K - 1, 0);
            int rightIndex = Math.min(maxPoint, i + K);

            int partialSum = sum[rightIndex] - sum[leftIndex];
            ans = Math.max(ans, partialSum);
        }

        System.out.println(ans);
        br.close();
    }
}
