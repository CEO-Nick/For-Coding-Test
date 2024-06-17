
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        Arrays.sort(array);

        int ans = 0;
        for (int i = 0; i < M; i++) {
            ans += isExist(array, br.readLine());
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int isExist(String[] array, String x) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m].equals(x)) return 1;
            else if (array[m].compareTo(x) < 0) l = m + 1;
            else r = m - 1;
        }

        return 0;
    }

}
