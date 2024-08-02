
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public  static int k;

    public static int[] array;
    public static int[] answer;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            answer = new int[6];
            check = new boolean[k];
            solution(0, bw);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solution (int length, BufferedWriter bw) throws IOException {
        if (length == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(answer[i]).append(" ");
            }
            bw.write(sb + "\n");
            return;
        }

        for (int i = 0; i < k; i++) {
            if (length > 0 && answer[length-1] > array[i]) continue;
            if (!check[i]) {
                check[i] = true;
                answer[length] = array[i];
                solution(length + 1, bw);
                check[i] = false;
            }
        }
    }

}
