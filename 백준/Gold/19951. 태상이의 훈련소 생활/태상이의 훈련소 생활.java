import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N + 1];

        String line = br.readLine();
        st = new StringTokenizer(line);
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] delta = new int[N+2];
        while (M-- > 0) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delta[a] += k;
            delta[b+1] -= k;
        }

        int[] accDelta = new int[N+1];
        for (int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i-1] + delta[i];
        }

        for (int i = 1; i <= N; i++) {
            array[i] += accDelta[i];
            bw.write(array[i] + " ");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
