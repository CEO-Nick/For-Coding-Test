import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] array;
    public static boolean[] check;
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        check = new boolean[n];
        solution(0, 0);

        System.out.println(ans);
        br.close();
    }

    public static void solution(int len, int index) {
        if (len == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            
            swap(index, i);
            solution(len+1, index + 1);
            swap(i, index);
        }
    }

    static void swap(int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    static void calculate() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(array[i]-array[i+1]);
        }
        ans = Math.max(sum, ans);
    }

}
