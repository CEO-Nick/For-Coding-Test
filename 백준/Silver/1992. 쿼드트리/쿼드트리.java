
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n;
  static int[][] grid;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    // 모두 0으로 이뤄짐 -> 압축 결과 0
    // 모두 1로 이뤄짐 -> 압축 결과 1
    // 그 외 -> 4개로 나눠 압축
    // (0(0111)01)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];

    String input;
    for (int i = 0; i < n; i++) {
      input = br.readLine();
      for (int j = 0; j < n; j++) {
        grid[i][j] = input.charAt(j) - '0';
      }
    }
    quadTree(0, 0, n);
    System.out.println(sb);
  }

  public static void quadTree(int x, int y, int n) {
    if (isPossible(x, y, n)) {
      sb.append(grid[x][y]);
      return;
    }

    sb.append("(");
    int nextN = n / 2;
    quadTree(x, y, nextN);
    quadTree(x, y + nextN, nextN);
    quadTree(x + nextN, y, nextN);
    quadTree(x + nextN, y + nextN, nextN);
    sb.append(")");
  }

  static boolean isPossible(int x, int y, int n) {
    int std = grid[x][y];
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (std != grid[i][j]) return false;
      }
    }
    return true;
  }

}
