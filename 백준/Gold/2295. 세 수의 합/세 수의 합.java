import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] array = new Integer[N];

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            array[i] = temp;
        }


        // A + B + C = X -> A + B = X - C
        // A + B의 집합 만들기
        int[] sums = new int[(N * (N+1)) / 2];
        int sumIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumIdx++] = array[i] + array[j];
            }
        }

        Arrays.sort(sums);

        // 모든 X - C가 A + B 집합(sums)에 있는지 확인
        // 있으면 그 중 X의 최댓값 구하기
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = array[i] - array[j];
                if (isExist(sums, target)) {
                    max = Math.max(max, array[i]);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    public static boolean isExist(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == x) return true;
            else if (array[m] < x) l = m + 1;
            else r = m - 1;
        }

        return false;
    }

}
