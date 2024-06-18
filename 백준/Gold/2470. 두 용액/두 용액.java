
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int ansAbs = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < N - 1; i++) {
            int pairValue = findPairValue(array, i + 1, N - 1, array[i]);
            int abs = Math.abs(array[i] + pairValue);
            if (abs < ansAbs) {
                ansAbs = abs;
                ans1 = array[i];
                ans2 = pairValue;
            }
        }

        System.out.println(ans1 + " " + ans2);
        br.close();
    }

    public static int findPairValue(Integer[] array, int start, int end, int std) {
        int l = start;
        int r = end;
        int min = Integer.MAX_VALUE;
        int min_idx = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            int sum = array[m] + std;
            if (sum == 0) {
                return array[m];
            } else if (sum < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                min_idx = m;
            }
        }

        return array[min_idx];
    }


}
