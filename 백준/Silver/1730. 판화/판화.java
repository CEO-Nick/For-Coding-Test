
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] commands = br.readLine().toCharArray();
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = (char) 46;
            }
        }

        int x = 0;
        int y = 0;
        int d = 0;
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < commands.length; i++) {
            char trace = 0;
            if (commands[i] == 'D') {
                d = 0;
                trace = (char) 124;
            } else if (commands[i] == 'R') {
                d = 1;
                trace = (char) 45;
            } else if (commands[i] == 'U') {
                d = 2;
                trace = (char) 124;
            } else if (commands[i] == 'L') {
                d = 3;
                trace = (char) 45;
            }
            int nx = x + directions[d][0];
            int ny = y + directions[d][1];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (grid[x][y] == '.') {
                    grid[x][y] = trace;
                } else {
                    if (grid[x][y] != trace) {
                        grid[x][y] = '+';
                    }
                }
                if (grid[nx][ny] == '.') {
                    grid[nx][ny] = trace;
                } else {
                    if (grid[nx][ny] != trace) {
                        grid[nx][ny] = '+';
                    }
                }
                x = nx;
                y = ny;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(grid[i][j]);
            }
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


