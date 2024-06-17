
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

        int N = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (isExist(array, Integer.parseInt(st.nextToken()))) {
                bw.write("1" + '\n');
            } else {
                bw.write("0" + '\n');
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isExist(Integer[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        while(l <= r) {
            int middle = (l + r) / 2;
            if (array[middle] == x) return true;
            else if (array[middle] < x) l = middle + 1;
            else r = middle - 1;
        }

        return false;
    }
}
