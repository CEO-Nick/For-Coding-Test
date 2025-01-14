import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    static int meltSurround(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i], ny = y + dys[i];

            if (inRange(nx, ny)) {
                if (copyGlaciers[nx][ny] == 1) {
                    count++;
                    copyGlaciers[nx][ny] = 0;
                }
            }
        }

        return count;
    }

    static boolean checkSurround(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dxs[i], ny = y + dys[i];
            // 무조건 inRange라서 범위 체크안함
            if (glaciers[nx][ny] == 0) return false;
        }
        return true;
    }

    static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n+2 && 0 <= ny && ny < m+2;
    }



    static void copyOrigin() {
        for (int i = 0; i <= n; i++) {
            copyGlaciers[i] = glaciers[i].clone();
        }
    }

    static void copyCopy() {
        for (int i = 0; i <= n; i++) {
            glaciers[i] = copyGlaciers[i].clone();
        }
    }

    static int[][] copyGlaciers;

    static int n;
    static int m;
    static int[][] glaciers;
    static int curGlaciers = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 테두리도 물로 채워놓기
        glaciers = new int[n+2][m+2];
        copyGlaciers = new int[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                glaciers[i][j] = Integer.parseInt(st.nextToken());
                copyGlaciers[i][j] = glaciers[i][j];  // 초기 세팅 
                curGlaciers += glaciers[i][j] == 1 ? 1 : 0;
            }
        }
        // System.out.println("초기 빙하 개수 : " + curGlaciers);
        // for (int i = 0; i < n+2; i++) {
        //     System.out.println(Arrays.toString(glaciers[i]));
        // }
        
        int count;
        int time = 0;
        while (true) {
            count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (glaciers[i][j] == 0) {
                        // false : 빙하로 둘러쌓이지 않은 경우   true : 빙하로 둘러쌓인 경우
                        if (!checkSurround(i, j)) {
                            count += meltSurround(i, j);
                        }
                    }
                }
            }

            time++;
            curGlaciers -= count;
            // System.out.println("time : " + time + "\tcount : " + count);
            if (curGlaciers == 0) {
                System.out.println(time + " " + count);
                return;
            }

            copyCopy();
        }

    }
}
