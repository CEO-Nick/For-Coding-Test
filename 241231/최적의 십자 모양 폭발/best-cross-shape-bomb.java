import java.util.*;

public class Main {
    static int n;
    static int arr[][];
    static int copy[][];

    static int[] dxs = new int[] {1, 0, -1, 0};
    static int[] dys = new int[] {0, 1, 0, -1};

    public static void copy() {
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
    }
    
    public static void bomb(int x, int y) {
        int m = copy[x][y];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < m; j++) {
                int nx = x + j * dxs[i];
                int ny = y + j * dys[i];
                
                if (inRange(nx, ny)) {
                    copy[nx][ny] = 0;
                }
            }
        }
    }

    public static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }

    public static void gravity() {
        int[][] tmp = new int[n][n];
        

        for (int j = 0; j < n; j++) {
            int tmpIdx = n-1;
            for (int i = n-1; i >= 0; i--) {
                if (copy[i][j] != 0) tmp[tmpIdx--][j] = copy[i][j];
            }
        }
        copy = tmp;
    }

    public static int countPair() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = copy[i][j];
                if (cur == 0) continue;

                for (int k = 0; k < 2; k++) {
                    int nx = i + dxs[k];
                    int ny = j + dys[k];
                    if (inRange(nx, ny)) {
                        if (cur == copy[nx][ny]) count++;
                    }
                }
            }
        }
        return count;
    }
    

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // 매 좌표마다 폭탄 터뜨려보고
        // 중력 작용
        // 쌍의 개수 세기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        arr = new int[n][n];
        copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy();
                bomb(i, j);
                gravity();
                int res = countPair();
                max = Math.max(max, res);
            }
        }

        System.out.println(max);
        
    }
}