
import java.util.Scanner;

public class Main {

    public static int checkBoard(char[][] board, int N) {
        int max = -1;

        // 각 행에서 최대 연속 사탕 개수
        for (int i = 0; i < N; i++) {
            int maxSequence = -1;
            int sequence = 1;
            for (int j = 0; j < N-1; j++) {
                if (board[i][j] == board[i][j+1]) {
                    sequence++;
                }
                else {
                    maxSequence = Math.max(maxSequence, sequence);
                    sequence = 1;
                }
            }
            maxSequence = Math.max(maxSequence, sequence);
            max = Math.max(max, maxSequence);
        }

        // 각 열에서 최대 연속 사탕 개수
        for (int j = 0; j < N; j ++) {
            int maxSequence = -1;
            int sequence = 1;
            for (int i = 0; i < N-1; i++) {
                if (board[i][j] == board[i+1][j]) {
                    sequence++;
                }
                else {
                    maxSequence = Math.max(maxSequence, sequence);
                    sequence = 1;
                }
            }
            maxSequence = Math.max(maxSequence, sequence);
            max = Math.max(max, maxSequence);
        }

        return max;
    }

    public static void swap(char[][] board, int i, int j, int nx, int ny) {
        char temp = board[i][j];
        board[i][j] = board[nx][ny];
        board[nx][ny] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        int[][] directions = new int[][]{{1, 0}, {0, 1}};

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 아래 칸과 교환 시도
                if (i + 1 < N && board[i][j] != board[i+1][j]) {
                    // 교환
                    swap(board, i, j, i+1, j);

                    // 먹을 수 있는 사탕 개수 조사
                    int count = checkBoard(board, N);

                    max = Math.max(count, max);

                    // board 원상복구
                    swap(board, i+1, j, i, j);
                }
                // 오른쪽 칸과 교환 시도
                if (j + 1 < N && board[i][j] != board[i][j+1]) {
                    // 교환
                    swap(board, i, j, i, j+1);

                    // 먹을 수 있는 사탕 개수 조사
                    int count = checkBoard(board, N);

                    max = Math.max(count, max);

                    // board 원상복구
                    swap(board, i, j+1, i, j);
                }
            }
        }

        System.out.println(max);
    }
}


