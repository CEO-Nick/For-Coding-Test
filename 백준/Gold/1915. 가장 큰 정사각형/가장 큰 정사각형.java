import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                grid[i][j] = charArray[j-1] - '0';
            }
        }

        int[][] sum = new int[n+1][m+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + grid[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i][j] == 1) {
                    int k = j;
                    while (k <= m && grid[i][k] == 1) {
                        int diff = k - j;
                        if (i + diff > n) break;

                        int rect =
                            sum[i + diff][j + diff] - sum[i + diff][j - 1] - sum[i - 1][j + diff]
                                + sum[i - 1][j - 1];
                        if (rect == (diff + 1) * (diff + 1)) {
                            max = Math.max(max, rect);
                        }
                        k++;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
