import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        String input = br.readLine();
        int[][] tmp = new int[4][4];
        int[][] tmp2 = new int[4][4];


        if (input.equals("R")) {
            // 해당 방향으로 민 결과를 tmp 배열에 저장
            for (int i = 0; i < 4; i++) {
                int tmpIdx = 3;
                int j = 3;
                while (j >= 0) {
                    if (grid[i][j] != 0) {
                        tmp[i][tmpIdx--] = grid[i][j];
                    } 
                    j--;

                }
            }
            // 중력작용 적용하기
            for (int i = 0; i < 4; i++) {
                int tmp2Idx = 3;
                for (int j = 3; j >= 0; j--) {
                    if (j == 0) {
                        tmp2[i][tmp2Idx--] = tmp[i][j];
                        continue;
                    }
                    if (tmp[i][j] == tmp[i][j-1]) {
                        tmp2[i][tmp2Idx--] = 2 * tmp[i][j];
                        j--;
                    } else {
                        tmp2[i][tmp2Idx--] = tmp[i][j];
                    }
                }
            }
        } else if (input.equals("L")) {
            // 해당 방향으로 민 결과를 tmp 배열에 저장
            for (int i = 0; i < 4; i++) {
                int tmpIdx = 0;
                int j = 0;
                while (j < 4) {
                    if (grid[i][j] != 0) {
                        tmp[i][tmpIdx++] = grid[i][j];
                    } 
                    j++;

                }
            }
            // 중력작용 적용하기
            for (int i = 0; i < 4; i++) {
                int tmp2Idx = 0;
                for (int j = 0; j < 4; j++) {
                    if (j == 3) {
                        tmp2[i][tmp2Idx++] = tmp[i][j];
                        continue;
                    }
                    if (tmp[i][j] == tmp[i][j+1]) {
                        tmp2[i][tmp2Idx++] = 2 * tmp[i][j];
                        j++;
                    } else {
                        tmp2[i][tmp2Idx++] = tmp[i][j];
                    }
                }
            }
        } else if (input.equals("U")) {
            // 해당 방향으로 민 결과를 tmp 배열에 저장
            for (int j = 0; j < 4; j++) {
                int tmpIdx = 0;
                int i = 0;
                while (i < 4) {
                    if (grid[i][j] != 0) {
                        tmp[tmpIdx++][j] = grid[i][j];
                    } 
                    i++;
                }
            }
            // 중력작용 적용하기
            for (int j = 0; j < 4; j++) {
                int tmp2Idx = 0;
                for (int i = 0; i < 4; i++) {
                    if (i == 3) {
                        tmp2[tmp2Idx++][j] = tmp[i][j];
                        continue;
                    }
                    if (tmp[i][j] == tmp[i+1][j]) {
                        tmp2[tmp2Idx++][j] = 2 * tmp[i][j];
                        i++;
                    } else {
                        tmp2[tmp2Idx++][j] = tmp[i][j];
                    }
                }

            }
        } else {
            for (int j = 0; j < 4; j++) {
                int tmpIdx = 3;
                int i = 3;
                while (i >= 0) {
                    if (grid[i][j] != 0) {
                        tmp[tmpIdx--][j] = grid[i][j];
                    } 
                    i--;
                }
            }
            // 중력작용 적용하기
            for (int j = 0; j < 4; j++) {
                int tmp2Idx = 3;
                for (int i = 3; i >= 0; i--) {
                    if (i == 0) {
                        tmp2[tmp2Idx--][j] = tmp[i][j];
                        continue;
                    }
                    if (tmp[i][j] == tmp[i-1][j]) {
                        tmp2[tmp2Idx--][j] = 2 * tmp[i][j];
                        i--;
                    } else {
                        tmp2[tmp2Idx--][j] = tmp[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int a : tmp2[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        
    }
}