
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

        int[][] array = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arrSum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arrSum[i][j] = arrSum[i-1][j] + arrSum[i][j-1] - arrSum[i-1][j-1] + array[i][j];
            }
        }

        while (M-- > 0) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = arrSum[x2][y2] - arrSum[x1-1][y2] - arrSum[x2][y1-1] + arrSum[x1-1][y1-1];

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
