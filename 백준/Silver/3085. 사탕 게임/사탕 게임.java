
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
                for (int d = 0; d < 2; d++) {
                    int nx = i + directions[d][0];
                    int ny = j + directions[d][1];
                    // board 범위 안에 있을 때
                    if (nx < N && ny < N) {
                        // 인접한 칸의 사탕이 다른 색이라면
                        if (board[i][j] != board[nx][ny]) {
                            // 교환
                            swap(board, i, j, nx, ny);

                            // 먹을 수 있는 사탕 개수 조사
                            int count = checkBoard(board, N);
                       
                            max = Math.max(count, max);
                            
                            // board 원상복구
                            swap(board, nx, ny, i, j);
                        }
                    }
                }
            }
        }

        System.out.println(max);

        // 1. (i, j)에서 오른쪽, 아래쪽에 색이 다른 사탕 있는지 확인
            // 1.1 다른 색 사탕 있으면 교환
                // 1.1.1 아래쪽이랑 교환 시 i, i+1 row, j column 먹을 수 있는지 체크
                // 1.1.2 오른쪽이랑 교환 시 i row, j, j+1 column 먹을 수 있는지 체크
                // 1.1.3 먹을 수 있다면 최대 개수 비교 후 저장
            // 1.2 다른 사탕 없으면 다음 칸으로 이동
    }
}


