
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;

  static int[] woods;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    long maxHeight = Integer.MIN_VALUE;
    st = new StringTokenizer(br.readLine());

    woods = new int[n];
    for (int i = 0; i < n; i++) {
      woods[i] = Integer.parseInt(st.nextToken());
      maxHeight = Math.max(maxHeight, woods[i]);
    }

    long l = 0, r = maxHeight;
    long ans = -1;
    while (l <= r) {
      long mid = (l + r) / 2;

      long sum = 0;
      for (int i = 0; i < n; i++) {
        // 둘의 차이가 음수면 잘리는게 없음 -> 0 더하기
        sum += Math.max(woods[i] - mid, 0);
      }

      if (sum >= m) {
        ans = mid;
        l = mid + 1;
      }
      else {
        r = mid - 1;
      }

    }

    System.out.println(ans);
  }

}
