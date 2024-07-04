import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연속한 1개 이상의 수 뽑았을 때, 모두 unique한 경우의 수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int j = 0;
        int[] unique = new int[100001];
        for (int i = 0; i < N; i++) {
            while (j < N) {
                if (unique[array[j]] == 1) {
                    break;
                } else {
                    unique[array[j]] = 1;
                    j++;
                }
            }
            count += j - i;
            unique[array[i]] = 0;
        }
        System.out.println(count);
        br.close();
    }
}
