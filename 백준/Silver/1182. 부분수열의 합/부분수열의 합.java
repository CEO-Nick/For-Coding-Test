import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n, s;
    public static int count;
    public static int sum;
    public static boolean[] check;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[n];
        count = 0;
        countPartialArray(0, 0);
        System.out.println(count);

    }

    public static void countPartialArray(int idx, int sum) {
        if (idx == n) return;
        if (sum + array[idx] == s) count ++;

        // 현재 값 포함안하는 경우
        countPartialArray(idx + 1, sum);
        // 현재 값 포함하는 경우
        countPartialArray(idx + 1, sum + array[idx]);
    }

}
