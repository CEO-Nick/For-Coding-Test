import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int l;
  static int r;
  static int c;

  static boolean[][][] visited;
  static char[][][] building;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // # : 지나갈 수 없음
    // . : 빈칸 => 지나갈 수 있음
    // S : 시작
    // E : 탈출구
    StringTokenizer st;
    while (true)
    {
      st = new StringTokenizer(br.readLine());
      l = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      if (l + r + c == 0) break;
      visited = new boolean[l][r][c];
      building = new char[l][r][c];

      String input;
      int sz = 0, sx = 0, sy = 0;
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < r; j++) {
          input = br.readLine();
          for (int k = 0; k < c; k++) {
            building[i][j][k] = input.charAt(k);
            if (building[i][j][k] == 'S') {
              sz = i;
              sx = j;
              sy = k;
            }
          }
        }
        br.readLine();
      }

      int res = bfs(sx, sy, sz);
      if (res == -1) {
        sb.append("Trapped!").append("\n");
      } else {
        sb.append("Escaped in ").append(res).append(" minute(s).").append("\n");
      }
    }
    System.out.println(sb);
  }

  static class Coordinate {
    int x;
    int y;
    int z;
    int time;

    Coordinate(int x, int y, int z, int time) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.time = time;
    }
  }

  static int[] dxs = new int[] {1, 0, -1, 0, 0, 0};
  static int[] dys = new int[] {0, 1, 0, -1, 0, 0};
  static int[] dzs = new int[] {0 ,0, 0, 0, 1, -1};

  static int bfs(int x, int y, int z) {
    Queue<Coordinate> q = new ArrayDeque<>();
    q.add(new Coordinate(x, y, z, 0));
    visited[z][x][y] = true;


    while (!q.isEmpty()) {
      Coordinate cur = q.poll();
      for (int i = 0; i < 6; i++) {
        int nx = cur.x + dxs[i];
        int ny = cur.y + dys[i];
        int nz = cur.z + dzs[i];

        if (canGo(nz, nx, ny)) {
          if (building[nz][nx][ny] == 'E') {
            return cur.time + 1;
          }
          q.add(new Coordinate(nx, ny, nz, cur.time + 1));
          visited[nz][nx][ny] = true;
        }


      }
    }
    return -1;
  }

  static boolean canGo(int nz, int nx, int ny) {
    // 범위 밖 or 방문한 적 있음 or 막혀 있음 -> 못 감
    if (!inRange(nz, nx, ny)) return false;
    if (visited[nz][nx][ny] || building[nz][nx][ny] == '#') return false;
    return true;
  }

  static boolean inRange(int nz, int nx, int ny) {
    return 0 <= nz && nz < l && 0 <= nx && nx < r && 0 <= ny && ny < c;
  }

}
