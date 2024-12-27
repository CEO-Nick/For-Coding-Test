import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        t %= (2*n);

        while (t-- > 0) {
            pushLeft();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static void pushLeft() {
        int tmp = arr[0][0];
        for (int i = 1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == 1 & j == n-1) {
                    arr[0][0] = arr[i][j];
                } else if (i == 0 && j == n-1) {
                    arr[1][0] = arr[i][j];
                } else if (i == 0 && j == 0) { 
                    arr[0][1] = tmp;
                } else {
                    arr[i][j+1] = arr[i][j];
                }
            }
        }
    }
}