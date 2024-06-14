
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

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] array = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 1; j <= N; j++) {
                array[i][j] = array[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        while (M-- > 0) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = 0;
            while (x1 <= x2) {
                ans += (array[x1][y2] - array[x1][y1 - 1]);
                x1++;
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
