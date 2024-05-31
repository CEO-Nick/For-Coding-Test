
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] castle = new char[N][M];
        for (int i = 0; i <N; i++) {
            castle[i] = sc.next().toCharArray();
        }

        int[] row = new int[N];
        int[] column = new int[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        int n = 0;
        for (int i = 0; i < N; i++) {
            if (row[i] == 0) n++;

        }
        int m = 0;
        for (int i = 0; i < M; i++) {
            if (column[i] == 0) m++;

        }

        int result = n > m ? n : m;
        System.out.println(result);

    }
}
