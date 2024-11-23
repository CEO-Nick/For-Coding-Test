
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static class Road {
    int start;
    int distance;
    
    Road(int s, int d) {
      this.start = s;
      this.distance = d;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[] dp = new int[d+1];

    HashMap<Integer, List<Road>> shortcuts = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());

      if (shortcuts.containsKey(e)) {
        List<Road> roads = shortcuts.get(e);
        roads.add(new Road(s, dist));
        shortcuts.put(e, roads);
      } else {
        ArrayList<Road> roads = new ArrayList<>();
        roads.add(new Road(s, dist));
        shortcuts.put(e, roads);
      }
    }

    for (int i = 1; i <= d; i++) {
      dp[i] = dp[i-1] + 1;

      if (shortcuts.containsKey(i)) {
        List<Road> roads = shortcuts.get(i);
        for (Road r : roads) {
          dp[i] = Math.min(dp[i], dp[r.start] + r.distance);
        }
      }
    }

    System.out.println(dp[d]);

  }
}